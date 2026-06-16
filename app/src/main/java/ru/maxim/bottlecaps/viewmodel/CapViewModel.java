package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.entity.CapEntity;
import ru.maxim.bottlecaps.database.repository.CapRepository;

public class CapViewModel extends AndroidViewModel {

    private final CapRepository capRepository;
    private final LiveData<List<CapEntity>> allCaps;

    public CapViewModel(@NonNull Application application) {
        super(application);
        capRepository = new CapRepository(application);
        allCaps = capRepository.getAllCaps();
    }

    public void insertCap(CapEntity cap) {
        capRepository.insertCap(cap);
    }

    public void updateCap(CapEntity cap) {
        capRepository.updateCap(cap);
    }

    public void deleteCap(CapEntity cap) {
        capRepository.deleteCap(cap);
    }

    public LiveData<List<CapEntity>> getAllCaps() {
        return allCaps;
    }

    public CapEntity getCapById(Long capId) {
        return capRepository.getCapById(capId);
    }

    public LiveData<Integer> getTotalCapsCount() {
        return capRepository.getTotalCapsCount();
    }

    public CapEntity getLatestCap() {
        return capRepository.getLatestCap();
    }
}
