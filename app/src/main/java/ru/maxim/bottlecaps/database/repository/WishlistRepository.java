package ru.maxim.bottlecaps.database.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.dao.WishlistDao;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;

public class WishlistRepository {

    private final WishlistDao wishlistDao;
    private final ExecutorService executorService;

    public WishlistRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        wishlistDao = database.wishlistDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertWishlist(WishlistEntity wish) {
        executorService.execute(() -> wishlistDao.insert(wish));
    }

    public void insertWishlists(List<WishlistEntity> wishes) {
        executorService.execute(() -> wishlistDao.insertAll(wishes));
    }

    public void updateWishlist(WishlistEntity wish) {
        executorService.execute(() -> wishlistDao.update(wish));
    }

    public void updateWishlists(List<WishlistEntity> wishes) {
        executorService.execute(() -> wishlistDao.updateAll(wishes));
    }

    public void deleteWishlist(WishlistEntity wish) {
        executorService.execute(() -> wishlistDao.delete(wish));
    }

    public void deleteWishlists(List<WishlistEntity> wishes) {
        executorService.execute(() -> wishlistDao.deleteAll(wishes));
    }

    public WishlistEntity getWishlistById(Long wishId) {
        return wishlistDao.getWishlistById(wishId);
    }

    public LiveData<List<WishlistEntity>> getAllWishlists() {
        return wishlistDao.getAllWishlists();
    }

    public List<WishlistEntity> getAllWishlistsSync() {
        return wishlistDao.getAllWishlistsSync();
    }

    public LiveData<List<WishlistEntity>> getWishlistsByPriority(int priority) {
        return wishlistDao.getWishlistsByPriority(priority);
    }

    public LiveData<List<WishlistEntity>> searchWishlists(String searchQuery) {
        return wishlistDao.searchWishlists(searchQuery);
    }

    public LiveData<List<WishlistEntity>> getWishlistsByDateRange(long startTime, long endTime) {
        return wishlistDao.getWishlistsByDateRange(startTime, endTime);
    }

    public LiveData<Integer> getTotalWishlistsCount() {
        return wishlistDao.getTotalWishlistsCount();
    }

    public LiveData<Integer> getWishlistsCountByPriority(int priority) {
        return wishlistDao.getWishlistsCountByPriority(priority);
    }

    public WishlistEntity getLatestWishlist() {
        return wishlistDao.getLatestWishlist();
    }

    public void deleteAllWishlists() {
        executorService.execute(() -> wishlistDao.deleteAllWishlists());
    }

    public int getWishlistsCountSince(long sinceDate) {
        return wishlistDao.getWishlistsCountSince(sinceDate);
    }
}
