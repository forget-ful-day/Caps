package ru.maxim.bottlecaps.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

@Dao
public interface StatisticsDao {

    @Insert
    void insert(StatisticsEntity statistics);

    @Insert
    void insertAll(List<StatisticsEntity> statisticsList);

    @Update
    void update(StatisticsEntity statistics);

    @Update
    void updateAll(List<StatisticsEntity> statisticsList);

    @Delete
    void delete(StatisticsEntity statistics);

    @Delete
    void deleteAll(List<StatisticsEntity> statisticsList);

    @Query("SELECT * FROM statistics WHERE id = :statisticsId")
    StatisticsEntity getStatisticsById(Long statisticsId);

    @Query("SELECT * FROM statistics ORDER BY last_update DESC LIMIT 1")
    LiveData<StatisticsEntity> getCurrentStatistics();

    @Query("SELECT * FROM statistics ORDER BY last_update DESC LIMIT 1")
    StatisticsEntity getCurrentStatisticsSync();

    @Query("SELECT * FROM statistics ORDER BY last_update DESC")
    LiveData<List<StatisticsEntity>> getAllStatistics();

    @Query("SELECT * FROM statistics WHERE last_update BETWEEN :startTime AND :endTime ORDER BY last_update DESC")
    LiveData<List<StatisticsEntity>> getStatisticsByDateRange(long startTime, long endTime);

    @Query("DELETE FROM statistics")
    void deleteAllStatistics();

    @Query("UPDATE statistics SET total_caps = :totalCaps, total_pivnye = :totalPivnye, total_limonye = :totalLimonye, total_energeticheskie = :totalEnergeticheskie, total_chainye = :totalChainye, total_drugie = :totalDrugie, total_rare = :totalRare, total_unique = :totalUnique, streak_days = :streakDays, last_update = :lastUpdate WHERE id = :statisticsId")
    void updateStatistics(Long statisticsId, int totalCaps, int totalPivnye, int totalLimonye, int totalEnergeticheskie, int totalChainye, int totalDrugie, int totalRare, int totalUnique, int streakDays, long lastUpdate);

    @Query("SELECT total_caps FROM statistics ORDER BY last_update DESC LIMIT 1")
    LiveData<Integer> getTotalCapsCount();

    @Query("SELECT total_rare FROM statistics ORDER BY last_update DESC LIMIT 1")
    LiveData<Integer> getTotalRareCount();

    @Query("SELECT total_unique FROM statistics ORDER BY last_update DESC LIMIT 1")
    LiveData<Integer> getTotalUniqueCount();

    @Query("SELECT streak_days FROM statistics ORDER BY last_update DESC LIMIT 1")
    LiveData<Integer> getStreakDays();
}
