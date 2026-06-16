package ru.maxim.bottlecaps.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Сущность для хранения информации о найденной крышке.
 * Главная таблица базы данных приложения BottleCaps.
 */
@Entity(tableName = "caps",
        indices = {
            @Index(value = {"name"}, unique = true),
            @Index(value = {"category"}),
            @Index(value = {"rarity"}),
            @Index(value = {"country"}),
            @Index(value = {"city"}),
            @Index(value = {"found_date"}),
            @Index(value = {"added_date"}),
            @Index(value = {"is_synced"})
        })
public class CapEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "name", nullable = false)
    private String name;

    @ColumnInfo(name = "photo_path")
    private String photoPath;

    @ColumnInfo(name = "category", nullable = false)
    private String category;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "rarity", nullable = false)
    private String rarity;

    @ColumnInfo(name = "tags")
    private String tags;

    @ColumnInfo(name = "latitude")
    private Double latitude;

    @ColumnInfo(name = "longitude")
    private Double longitude;

    @ColumnInfo(name = "found_date")
    private Long foundDate;

    @ColumnInfo(name = "added_date")
    private Long addedDate;

    @ColumnInfo(name = "is_synced", defaultValue = "0")
    private Boolean isSynced;

    /**
     * Пустой конструктор для Room
     */
    public CapEntity() {
    }

    /**
     * Конструктор со всеми полями
     */
    public CapEntity(String name, String photoPath, String category, String country, String city,
                     String rarity, String tags, Double latitude, Double longitude,
                     Long foundDate, Long addedDate, Boolean isSynced) {
        this.name = name;
        this.photoPath = photoPath;
        this.category = category;
        this.country = country;
        this.city = city;
        this.rarity = rarity;
        this.tags = tags;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foundDate = foundDate;
        this.addedDate = addedDate;
        this.isSynced = isSynced;
    }

    /**
     * Конструктор для Room с игнорированием одного поля
     */
    @Ignore
    public CapEntity(String name, String photoPath, String category, String country, String city,
                     String rarity, String tags, Double latitude, Double longitude,
                     Long foundDate, Long addedDate) {
        this(name, photoPath, category, country, city, rarity, tags, latitude, longitude,
                foundDate, addedDate, false);
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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Long foundDate) {
        this.foundDate = foundDate;
    }

    public Long getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Long addedDate) {
        this.addedDate = addedDate;
    }

    public Boolean getIsSynced() {
        return isSynced;
    }

    public void setIsSynced(Boolean isSynced) {
        this.isSynced = isSynced;
    }

    //endregion
}
