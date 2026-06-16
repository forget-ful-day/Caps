package ru.maxim.bottlecaps.database;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.dao.StatisticsDao;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

/**
 * Репозиторий для работы с сущностью StatisticsEntity.
 * Слой абстракции над базой данных для статистики.
 * Предоставляет методы для работы с таблицей statistics.
 */
public class StatisticsRepository {

    private final StatisticsDao statisticsDao;
    private final ExecutorService executorService;

    /**
     * Конструктор репозитория.
     *
     * @param context контекст приложения
     */
    public StatisticsRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        statisticsDao = database.statisticsDao();
        // Используем ExecutorService вместо устаревшего AsyncTask
        executorService = Executors.newSingleThreadExecutor();
    }

    //region Вставка и обновление данных

    /**
     * Вставка или обновление статистики (асинхронно).
     *
     * @param stats объект StatisticsEntity для вставки/обновления
     */
    public void save(final StatisticsEntity stats) {
        executorService.execute(() -> statisticsDao.insert(stats));
    }

    /**
     * Обновление статистики (асинхронно).
     *
     * @param stats объект StatisticsEntity для обновления
     */
    public void update(final StatisticsEntity stats) {
        executorService.execute(() -> statisticsDao.update(stats));
    }

    //endregion

    //region Чтение данных (синхронные методы)

    /**
     * Получение текущей статистики (синхронно).
     *
     * @return объект StatisticsEntity
     */
    public StatisticsEntity getStatistics() {
        return statisticsDao.getStatistics();
    }

    /**
     * Получение общего количества крышек (синхронно).
     *
     * @return общее количество крышек
     */
    public int getTotalCaps() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalCaps() : 0;
    }

    /**
     * Получение количества пивных крышек (синхронно).
     *
     * @return количество пивных крышек
     */
    public int getTotalPivnye() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalPivnye() : 0;
    }

    /**
     * Получение количества лимонадных крышек (синхронно).
     *
     * @return количество лимонадных крышек
     */
    public int getTotalLimonye() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalLimonye() : 0;
    }

    /**
     * Получение количества энергетических крышек (синхронно).
     *
     * @return количество энергетических крышек
     */
    public int getTotalEnergeticheskie() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalEnergeticheskie() : 0;
    }

    /**
     * Получение количества чайных крышек (синхронно).
     *
     * @return количество чайных крышек
     */
    public int getTotalChainye() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalChainye() : 0;
    }

    /**
     * Получение количества прочих крышек (синхронно).
     *
     * @return количество прочих крышек
     */
    public int getTotalDrugie() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalDrugie() : 0;
    }

    /**
     * Получение количества редких крышек (синхронно).
     *
     * @return количество редких крышек
     */
    public int getTotalRare() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalRare() : 0;
    }

    /**
     * Получение количества уникальных крышек (синхронно).
     *
     * @return количество уникальных крышек
     */
    public int getTotalUnique() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getTotalUnique() : 0;
    }

    /**
     * Получение количества дней подряд (streak) (синхронно).
     *
     * @return количество дней подряд
     */
    public int getStreakDays() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getStreakDays() : 0;
    }

    /**
     * Получение даты последнего обновления (синхронно).
     *
     * @return Unix timestamp в миллисекундах
     */
    public long getLastUpdate() {
        StatisticsEntity stats = statisticsDao.getStatistics();
        return stats != null ? stats.getLastUpdate() : 0;
    }

    //endregion

    //region Методы обновления статистики

    /**
     * Обновление общего количества крышек (асинхронно).
     *
     * @param total общее количество крышек
     */
    public void updateTotalCaps(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalCaps(total, System.currentTimeMillis()));
    }

    /**
     * Обновление количества пивных крышек (асинхронно).
     *
     * @param total количество пивных крышек
     */
    public void updateTotalPivnye(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalPivnye(total));
    }

    /**
     * Обновление количества лимонадных крышек (асинхронно).
     *
     * @param total количество лимонадных крышек
     */
    public void updateTotalLimonye(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalLimonye(total));
    }

    /**
     * Обновление количества энергетических крышек (асинхронно).
     *
     * @param total количество энергетических крышек
     */
    public void updateTotalEnergeticheskie(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalEnergeticheskie(total));
    }

    /**
     * Обновление количества чайных крышек (асинхронно).
     *
     * @param total количество чайных крышек
     */
    public void updateTotalChainye(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalChainye(total));
    }

    /**
     * Обновление количества прочих крышек (асинхронно).
     *
     * @param total количество прочих крышек
     */
    public void updateTotalDrugie(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalDrugie(total));
    }

    /**
     * Обновление количества редких крышек (асинхронно).
     *
     * @param total количество редких крышек
     */
    public void updateTotalRare(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalRare(total));
    }

    /**
     * Обновление количества уникальных крышек (асинхронно).
     *
     * @param total количество уникальных крышек
     */
    public void updateTotalUnique(final int total) {
        executorService.execute(() -> statisticsDao.updateTotalUnique(total));
    }

    /**
     * Обновление количества дней подряд (streak) (асинхронно).
     *
     * @param streak количество дней подряд
     */
    public void updateStreakDays(final int streak) {
        executorService.execute(() -> statisticsDao.updateStreakDays(streak));
    }

    /**
     * Обновление даты последнего обновления (асинхронно).
     */
    public void updateLastUpdate() {
        executorService.execute(() -> statisticsDao.updateLastUpdate(System.currentTimeMillis()));
    }

    /**
     * Обновление всех полей статистики одновременно (асинхронно).
     *
     * @param totalCaps общее количество крышек
     * @param totalPivnye количество пивных крышек
     * @param totalLimonye количество лимонадных крышек
     * @param totalEnergeticheskie количество энергетических крышек
     * @param totalChainye количество чайных крышек
     * @param totalDrugie количество прочих крышек
     * @param totalRare количество редких крышек
     * @param totalUnique количество уникальных крышек
     * @param streakDays количество дней подряд
     */
    public void updateAll(final int totalCaps, final int totalPivnye, final int totalLimonye,
                          final int totalEnergeticheskie, final int totalChainye, final int totalDrugie,
                          final int totalRare, final int totalUnique, final int streakDays) {
        executorService.execute(() -> {
            StatisticsEntity stats = new StatisticsEntity();
            stats.setTotalCaps(totalCaps);
            stats.setTotalPivnye(totalPivnye);
            stats.setTotalLimonye(totalLimonye);
            stats.setTotalEnergeticheskie(totalEnergeticheskie);
            stats.setTotalChainye(totalChainye);
            stats.setTotalDrugie(totalDrugie);
            stats.setTotalRare(totalRare);
            stats.setTotalUnique(totalUnique);
            stats.setStreakDays(streakDays);
            stats.setLastUpdate(System.currentTimeMillis());
            statisticsDao.insert(stats);
        });
    }

    //endregion
}
