package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;
import ru.maxim.bottlecaps.database.repository.StatisticsRepository;

public class StatisticsViewModel extends AndroidViewModel {

    private final StatisticsRepository statisticsRepository;
    private final LiveData<StatisticsEntity> currentStatistics;

    public StatisticsViewModel(@NonNull Application application) {
        super(application);
        statisticsRepository = new StatisticsRepository(application);
        currentStatistics = statisticsRepository.getCurrentStatistics();
    }

    public void insertStatistics(StatisticsEntity statistics) {
        statisticsRepository.insertStatistics(statistics);
    }

    public void updateStatistics(StatisticsEntity statistics) {
        statisticsRepository.updateStatistics(statistics);
    }

    public void deleteStatistics(StatisticsEntity statistics) {
        statisticsRepository.deleteStatistics(statistics);
    }

    public LiveData<StatisticsEntity> getCurrentStatistics() {
        return currentStatistics;
    }

    public LiveData<Integer> getTotalCapsCount() {
        return statisticsRepository.getTotalCapsCount();
    }

    public LiveData<Integer> getTotalRareCount() {
        return statisticsRepository.getTotalRareCount();
    }

    public LiveData<Integer> getTotalUniqueCount() {
        return statisticsRepository.getTotalUniqueCount();
    }

    public LiveData<Integer> getStreakDays() {
        return statisticsRepository.getStreakDays();
    }
}
