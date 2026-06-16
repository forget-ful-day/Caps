package ru.maxim.bottlecaps.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.dao.CapDao;
import ru.maxim.bottlecaps.database.entity.CapEntity;

public class CapRepository {

    private final CapDao capDao;
    private final ExecutorService executorService;

    public CapRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        capDao = database.capDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertCap(CapEntity cap) {
        executorService.execute(() -> capDao.insert(cap));
    }

    public void insertCaps(List<CapEntity> caps) {
        executorService.execute(() -> capDao.insertAll(caps));
    }

    public void updateCap(CapEntity cap) {
        executorService.execute(() -> capDao.update(cap));
    }

    public void updateCaps(List<CapEntity> caps) {
        executorService.execute(() -> capDao.updateAll(caps));
    }

    public void deleteCap(CapEntity cap) {
        executorService.execute(() -> capDao.delete(cap));
    }

    public void deleteCaps(List<CapEntity> caps) {
        executorService.execute(() -> capDao.deleteAll(caps));
    }

    public CapEntity getCapById(Long capId) {
        return capDao.getCapById(capId);
    }

    public LiveData<List<CapEntity>> getAllCaps() {
        return capDao.getAllCaps();
    }

    public List<CapEntity> getAllCapsSync() {
        return capDao.getAllCapsSync();
    }

    public LiveData<List<CapEntity>> getCapsByCategory(String category) {
        return capDao.getCapsByCategory(category);
    }

    public LiveData<List<CapEntity>> getCapsByRarity(String rarity) {
        return capDao.getCapsByRarity(rarity);
    }

    public LiveData<List<CapEntity>> getCapsByCountry(String country) {
        return capDao.getCapsByCountry(country);
    }

    public LiveData<List<CapEntity>> getCapsByCity(String city) {
        return capDao.getCapsByCity(city);
    }

    public LiveData<List<CapEntity>> searchCaps(String searchQuery) {
        return capDao.searchCaps(searchQuery);
    }

    public LiveData<List<CapEntity>> getCapsByDateRange(long startTime, long endTime) {
        return capDao.getCapsByDateRange(startTime, endTime);
    }

    public LiveData<List<CapEntity>> getCapsWithGeolocation() {
        return capDao.getCapsWithGeolocation();
    }

    public LiveData<List<CapEntity>> getCapsInBounds(double minLat, double maxLat, double minLng, double maxLng) {
        return capDao.getCapsInBounds(minLat, maxLat, minLng, maxLng);
    }

    public LiveData<Integer> getTotalCapsCount() {
        return capDao.getTotalCapsCount();
    }

    public LiveData<Integer> getCapsCountByCategory(String category) {
        return capDao.getCapsCountByCategory(category);
    }

    public LiveData<Integer> getCapsCountByRarity(String rarity) {
        return capDao.getCapsCountByRarity(rarity);
    }

    public CapEntity getLatestCap() {
        return capDao.getLatestCap();
    }

    public List<CapEntity> getUnsyncedCaps() {
        return capDao.getUnsyncedCaps();
    }

    public void setCapSynced(Long capId) {
        executorService.execute(() -> capDao.setCapSynced(capId));
    }

    public void deleteAllCaps() {
        executorService.execute(() -> capDao.deleteAllCaps());
    }

    public int getCapsCountSince(long sinceDate) {
        return capDao.getCapsCountSince(sinceDate);
    }
}
