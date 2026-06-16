package ru.maxim.bottlecaps.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "statistics", indices = {@Index(value = {"last_update"})})
public class StatisticsEntity {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "total_caps")
    private Integer totalCaps;

    @ColumnInfo(name = "total_pivnye")
    private Integer totalPivnye;

    @ColumnInfo(name = "total_limonye")
    private Integer totalLimonye;

    @ColumnInfo(name = "total_energeticheskie")
    private Integer totalEnergeticheskie;

    @ColumnInfo(name = "total_chainye")
    private Integer totalChainye;

    @ColumnInfo(name = "total_drugie")
    private Integer totalDrugie;

    @ColumnInfo(name = "total_rare")
    private Integer totalRare;

    @ColumnInfo(name = "total_unique")
    private Integer totalUnique;

    @ColumnInfo(name = "streak_days")
    private Integer streakDays;

    @ColumnInfo(name = "last_update")
    private Long lastUpdate;

    public StatisticsEntity(Integer totalCaps, Integer totalPivnye, Integer totalLimonye,
                            Integer totalEnergeticheskie, Integer totalChainye, Integer totalDrugie,
                            Integer totalRare, Integer totalUnique, Integer streakDays, Long lastUpdate) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
