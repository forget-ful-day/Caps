package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import ru.maxim.bottlecaps.App;
import ru.maxim.bottlecaps.database.StatisticsRepository;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

/**
 * ViewModel для работы с сущностью StatisticsEntity.
 * Слой между View (Activity/Fragment) и Model (Repository).
 * Использует AndroidViewModel для доступа к Application контексту.
 */
public class StatisticsViewModel extends AndroidViewModel {

    private final StatisticsRepository statisticsRepository;

    /**
     * Конструктор ViewModel.
     *
     * @param application контекст приложения
     */
    public StatisticsViewModel(@NonNull Application application) {
        super(application);
        statisticsRepository = App.getInstance().getStatisticsRepository();
    }

    //region Методы для работы с данными

    /**
     * Сохранение или обновление статистики.
     *
     * @param stats объект StatisticsEntity для сохранения
     */
    public void save(StatisticsEntity stats) {
        statisticsRepository.save(stats);
    }

    /**
     * Обновление статистики.
     *
     * @param stats объект StatisticsEntity для обновления
     */
    public void update(StatisticsEntity stats) {
        statisticsRepository.update(stats);
    }

    /**
     * Обновление общего количества крышек.
     *
     * @param total общее количество крышек
     */
    public void updateTotalCaps(int total) {
        statisticsRepository.updateTotalCaps(total);
    }

    /**
     * Обновление количества пивных крышек.
     *
     * @param total количество пивных крышек
     */
    public void updateTotalPivnye(int total) {
        statisticsRepository.updateTotalPivnye(total);
    }

    /**
     * Обновление количества лимонадных крышек.
     *
     * @param total количество лимонадных крышек
     */
    public void updateTotalLimonye(int total) {
        statisticsRepository.updateTotalLimonye(total);
    }

    /**
     * Обновление количества энергетических крышек.
     *
     * @param total количество энергетических крышек
     */
    public void updateTotalEnergeticheskie(int total) {
        statisticsRepository.updateTotalEnergeticheskie(total);
    }

    /**
     * Обновление количества чайных крышек.
     *
     * @param total количество чайных крышек
     */
    public void updateTotalChainye(int total) {
        statisticsRepository.updateTotalChainye(total);
    }

    /**
     * Обновление количества прочих крышек.
     *
     * @param total количество прочих крышек
     */
    public void updateTotalDrugie(int total) {
        statisticsRepository.updateTotalDrugie(total);
    }

    /**
     * Обновление количества редких крышек.
     *
     * @param total количество редких крышек
     */
    public void updateTotalRare(int total) {
        statisticsRepository.updateTotalRare(total);
    }

    /**
     * Обновление количества уникальных крышек.
     *
     * @param total количество уникальных крышек
     */
    public void updateTotalUnique(int total) {
        statisticsRepository.updateTotalUnique(total);
    }

    /**
     * Обновление количества дней подряд (streak).
     *
     * @param streak количество дней подряд
     */
    public void updateStreakDays(int streak) {
        statisticsRepository.updateStreakDays(streak);
    }

    /**
     * Обновление всех полей статистики одновременно.
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
    public void updateAll(int totalCaps, int totalPivnye, int totalLimonye,
                          int totalEnergeticheskie, int totalChainye, int totalDrugie,
                          int totalRare, int totalUnique, int streakDays) {
        statisticsRepository.updateAll(totalCaps, totalPivnye, totalLimonye,
                totalEnergeticheskie, totalChainye, totalDrugie, totalRare, totalUnique, streakDays);
    }

    //endregion

    //region Методы для чтения данных

    /**
     * Получение текущей статистики (синхронно).
     *
     * @return объект StatisticsEntity
     */
    public StatisticsEntity getStatistics() {
        return statisticsRepository.getStatistics();
    }

    /**
     * Получение общего количества крышек (синхронно).
     *
     * @return общее количество крышек
     */
    public int getTotalCaps() {
        return statisticsRepository.getTotalCaps();
    }

    /**
     * Получение количества пивных крышек (синхронно).
     *
     * @return количество пивных крышек
     */
    public int getTotalPivnye() {
        return statisticsRepository.getTotalPivnye();
    }

    /**
     * Получение количества лимонадных крышек (синхронно).
     *
     * @return количество лимонадных крышек
     */
    public int getTotalLimonye() {
        return statisticsRepository.getTotalLimonye();
    }

    /**
     * Получение количества энергетических крышек (синхронно).
     *
     * @return количество энергетических крышек
     */
    public int getTotalEnergeticheskie() {
        return statisticsRepository.getTotalEnergeticheskie();
    }

    /**
     * Получение количества чайных крышек (синхронно).
     *
     * @return количество чайных крышек
     */
    public int getTotalChainye() {
        return statisticsRepository.getTotalChainye();
    }

    /**
     * Получение количества прочих крышек (синхронно).
     *
     * @return количество прочих крышек
     */
    public int getTotalDrugie() {
        return statisticsRepository.getTotalDrugie();
    }

    /**
     * Получение количества редких крышек (синхронно).
     *
     * @return количество редких крышек
     */
    public int getTotalRare() {
        return statisticsRepository.getTotalRare();
    }

    /**
     * Получение количества уникальных крышек (синхронно).
     *
     * @return количество уникальных крышек
     */
    public int getTotalUnique() {
        return statisticsRepository.getTotalUnique();
    }

    /**
     * Получение количества дней подряд (streak) (синхронно).
     *
     * @return количество дней подряд
     */
    public int getStreakDays() {
        return statisticsRepository.getStreakDays();
    }

    /**
     * Получение даты последнего обновления (синхронно).
     *
     * @return Unix timestamp в миллисекундах
     */
    public long getLastUpdate() {
        return statisticsRepository.getLastUpdate();
    }

    //endregion
}
