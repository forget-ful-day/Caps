package ru.maxim.bottlecaps.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Сущность для кеширования статистики по крышкам.
 * Хранит агрегированные данные для быстрого доступа без пересчета.
 * Использует фиксированный id = 1 для хранения одной записи статистики.
 */
@Entity(tableName = "statistics",
        indices = {
            @Index(value = {"last_update"})
        })
public class StatisticsEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "total_caps", defaultValue = "0")
    private Integer totalCaps;

    @ColumnInfo(name = "total_pivnye", defaultValue = "0")
    private Integer totalPivnye;

    @ColumnInfo(name = "total_limonye", defaultValue = "0")
    private Integer totalLimonye;

    @ColumnInfo(name = "total_energeticheskie", defaultValue = "0")
    private Integer totalEnergeticheskie;

    @ColumnInfo(name = "total_chainye", defaultValue = "0")
    private Integer totalChainye;

    @ColumnInfo(name = "total_drugie", defaultValue = "0")
    private Integer totalDrugie;

    @ColumnInfo(name = "total_rare", defaultValue = "0")
    private Integer totalRare;

    @ColumnInfo(name = "total_unique", defaultValue = "0")
    private Integer totalUnique;

    @ColumnInfo(name = "streak_days", defaultValue = "0")
    private Integer streakDays;

    @ColumnInfo(name = "last_update")
    private Long lastUpdate;

    /**
     * Пустой конструктор для Room
     */
    public StatisticsEntity() {
        this.id = 1;
        this.totalCaps = 0;
        this.totalPivnye = 0;
        this.totalLimonye = 0;
        this.totalEnergeticheskie = 0;
        this.totalChainye = 0;
        this.totalDrugie = 0;
        this.totalRare = 0;
        this.totalUnique = 0;
        this.streakDays = 0;
        this.lastUpdate = System.currentTimeMillis();
    }

    /**
     * Конструктор со всеми полями
     */
    public StatisticsEntity(Integer totalCaps, Integer totalPivnye, Integer totalLimonye,
                            Integer totalEnergeticheskie, Integer totalChainye, Integer totalDrugie,
                            Integer totalRare, Integer totalUnique, Integer streakDays, Long lastUpdate) {
        this.id = 1;
        this.totalCaps = totalCaps;
        this.totalPivnye = totalPivnye;
        this.totalLimonye = totalLimonye;
        this.totalEnergeticheskie = totalEnergeticheskie;
        this.totalChainye = totalChainye;
        this.totalDrugie = totalDrugie;
        this.totalRare = totalRare;
        this.totalUnique = totalUnique;
        this.streakDays = streakDays;
        this.lastUpdate = lastUpdate;
    }

    //region Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalCaps() {
        return totalCaps;
    }

    public void setTotalCaps(Integer totalCaps) {
        this.totalCaps = totalCaps;
    }

    public Integer getTotalPivnye() {
        return totalPivnye;
    }

    public void setTotalPivnye(Integer totalPivnye) {
        this.totalPivnye = totalPivnye;
    }

    public Integer getTotalLimonye() {
        return totalLimonye;
    }

    public void setTotalLimonye(Integer totalLimonye) {
        this.totalLimonye = totalLimonye;
    }

    public Integer getTotalEnergeticheskie() {
        return totalEnergeticheskie;
    }

    public void setTotalEnergeticheskie(Integer totalEnergeticheskie) {
        this.totalEnergeticheskie = totalEnergeticheskie;
    }

    public Integer getTotalChainye() {
        return totalChainye;
    }

    public void setTotalChainye(Integer totalChainye) {
        this.totalChainye = totalChainye;
    }

    public Integer getTotalDrugie() {
        return totalDrugie;
    }

    public void setTotalDrugie(Integer totalDrugie) {
        this.totalDrugie = totalDrugie;
    }

    public Integer getTotalRare() {
        return totalRare;
    }

    public void setTotalRare(Integer totalRare) {
        this.totalRare = totalRare;
    }

    public Integer getTotalUnique() {
        return totalUnique;
    }

    public void setTotalUnique(Integer totalUnique) {
        this.totalUnique = totalUnique;
    }

    public Integer getStreakDays() {
        return streakDays;
    }

    public void setStreakDays(Integer streakDays) {
        this.streakDays = streakDays;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    //endregion
}
