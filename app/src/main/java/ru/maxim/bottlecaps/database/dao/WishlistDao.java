package ru.maxim.bottlecaps.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.maxim.bottlecaps.database.entity.WishlistEntity;

@Dao
public interface WishlistDao {

    @Insert
    void insert(WishlistEntity wish);

    @Insert
    void insertAll(List<WishlistEntity> wishes);

    @Update
    void update(WishlistEntity wish);

    @Update
    void updateAll(List<WishlistEntity> wishes);

    @Delete
    void delete(WishlistEntity wish);

    @Delete
    void deleteAll(List<WishlistEntity> wishes);

    @Query("SELECT * FROM wishlists WHERE id = :wishId")
    WishlistEntity getWishlistById(Long wishId);

    @Query("SELECT * FROM wishlists ORDER BY priority DESC, added_date DESC")
    LiveData<List<WishlistEntity>> getAllWishlists();

    @Query("SELECT * FROM wishlists ORDER BY priority DESC, added_date DESC")
    List<WishlistEntity> getAllWishlistsSync();

    @Query("SELECT * FROM wishlists WHERE priority = :priority ORDER BY added_date DESC")
    LiveData<List<WishlistEntity>> getWishlistsByPriority(int priority);

    @Query("SELECT * FROM wishlists WHERE name LIKE '%' || :searchQuery || '%' ORDER BY added_date DESC")
    LiveData<List<WishlistEntity>> searchWishlists(String searchQuery);

    @Query("SELECT * FROM wishlists WHERE added_date BETWEEN :startTime AND :endTime ORDER BY added_date DESC")
    LiveData<List<WishlistEntity>> getWishlistsByDateRange(long startTime, long endTime);

    @Query("SELECT COUNT(*) FROM wishlists")
    LiveData<Integer> getTotalWishlistsCount();

    @Query("SELECT COUNT(*) FROM wishlists WHERE priority = :priority")
    LiveData<Integer> getWishlistsCountByPriority(int priority);

    @Query("SELECT * FROM wishlists ORDER BY added_date DESC LIMIT 1")
    WishlistEntity getLatestWishlist();

    @Query("DELETE FROM wishlists")
    void deleteAllWishlists();

    @Query("SELECT COUNT(*) FROM wishlists WHERE added_date > :sinceDate")
    int getWishlistsCountSince(long sinceDate);
}
