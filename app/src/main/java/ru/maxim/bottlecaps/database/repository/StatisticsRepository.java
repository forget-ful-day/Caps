package ru.maxim.bottlecaps.database.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.dao.StatisticsDao;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

public class StatisticsRepository {

    private final StatisticsDao statisticsDao;
    private final ExecutorService executorService;

    public StatisticsRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        statisticsDao = database.statisticsDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertStatistics(StatisticsEntity statistics) {
        executorService.execute(() -> statisticsDao.insert(statistics));
    }

    public void insertStatisticsList(List<StatisticsEntity> statisticsList) {
        executorService.execute(() -> statisticsDao.insertAll(statisticsList));
    }

    public void updateStatistics(StatisticsEntity statistics) {
        executorService.execute(() -> statisticsDao.update(statistics));
    }

    public void updateStatisticsList(List<StatisticsEntity> statisticsList) {
        executorService.execute(() -> statisticsDao.updateAll(statisticsList));
    }

    public void deleteStatistics(StatisticsEntity statistics) {
        executorService.execute(() -> statisticsDao.delete(statistics));
    }

    public void deleteStatisticsList(List<StatisticsEntity> statisticsList) {
        executorService.execute(() -> statisticsDao.deleteAll(statisticsList));
    }

    public StatisticsEntity getStatisticsById(Long statisticsId) {
        return statisticsDao.getStatisticsById(statisticsId);
    }

    public LiveData<StatisticsEntity> getCurrentStatistics() {
        return statisticsDao.getCurrentStatistics();
    }

    public StatisticsEntity getCurrentStatisticsSync() {
        return statisticsDao.getCurrentStatisticsSync();
    }

    public LiveData<List<StatisticsEntity>> getAllStatistics() {
        return statisticsDao.getAllStatistics();
    }

    public LiveData<List<StatisticsEntity>> getStatisticsByDateRange(long startTime, long endTime) {
        return statisticsDao.getStatisticsByDateRange(startTime, endTime);
    }

    public void deleteAllStatistics() {
        executorService.execute(() -> statisticsDao.deleteAllStatistics());
    }

    public void updateStatisticsRecord(Long statisticsId, int totalCaps, int totalPivnye, int totalLimonye,
                                       int totalEnergeticheskie, int totalChainye, int totalDrugie,
                                       int totalRare, int totalUnique, int streakDays, long lastUpdate) {
        executorService.execute(() -> statisticsDao.updateStatistics(statisticsId, totalCaps, totalPivnye, totalLimonye,
                totalEnergeticheskie, totalChainye, totalDrugie, totalRare, totalUnique, streakDays, lastUpdate));
    }

    public LiveData<Integer> getTotalCapsCount() {
        return statisticsDao.getTotalCapsCount();
    }

    public LiveData<Integer> getTotalRareCount() {
        return statisticsDao.getTotalRareCount();
    }

    public LiveData<Integer> getTotalUniqueCount() {
        return statisticsDao.getTotalUniqueCount();
    }

    public LiveData<Integer> getStreakDays() {
        return statisticsDao.getStreakDays();
    }
}
