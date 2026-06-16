package ru.maxim.bottlecaps.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Сущность для хранения списка желаемых крышек.
 * Используется для планирования поиска новых крышек.
 */
@Entity(tableName = "wishlists",
        indices = {
            @Index(value = {"name"}, unique = true),
            @Index(value = {"priority"}),
            @Index(value = {"added_date"})
        })
public class WishlistEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "name", nullable = false)
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "priority", defaultValue = "1")
    private Integer priority;

    @ColumnInfo(name = "added_date")
    private Long addedDate;

    /**
     * Пустой конструктор для Room
     */
    public WishlistEntity() {
    }

    /**
     * Конструктор со всеми полями
     */
    public WishlistEntity(String name, String description, Integer priority, Long addedDate) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.addedDate = addedDate;
    }

    /**
     * Конструктор для простого добавления без description
     */
    public WishlistEntity(String name) {
        this(name, null, 1, System.currentTimeMillis());
    }

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Long addedDate) {
        this.addedDate = addedDate;
    }

    //endregion
}
