package ru.maxim.bottlecaps.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.maxim.bottlecaps.database.entity.CapEntity;

@Dao
public interface CapDao {

    @Insert
    void insert(CapEntity cap);

    @Insert
    void insertAll(List<CapEntity> caps);

    @Update
    void update(CapEntity cap);

    @Update
    void updateAll(List<CapEntity> caps);

    @Delete
    void delete(CapEntity cap);

    @Delete
    void deleteAll(List<CapEntity> caps);

    @Query("SELECT * FROM caps WHERE id = :capId")
    CapEntity getCapById(Long capId);

    @Query("SELECT * FROM caps ORDER BY added_date DESC")
    LiveData<List<CapEntity>> getAllCaps();

    @Query("SELECT * FROM caps ORDER BY added_date DESC")
    List<CapEntity> getAllCapsSync();

    @Query("SELECT * FROM caps WHERE category = :category ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsByCategory(String category);

    @Query("SELECT * FROM caps WHERE rarity = :rarity ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsByRarity(String rarity);

    @Query("SELECT * FROM caps WHERE country = :country ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsByCountry(String country);

    @Query("SELECT * FROM caps WHERE city = :city ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsByCity(String city);

    @Query("SELECT * FROM caps WHERE name LIKE '%' || :searchQuery || '%' OR tags LIKE '%' || :searchQuery || '%' ORDER BY found_date DESC")
    LiveData<List<CapEntity>> searchCaps(String searchQuery);

    @Query("SELECT * FROM caps WHERE found_date BETWEEN :startTime AND :endTime ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsByDateRange(long startTime, long endTime);

    @Query("SELECT * FROM caps WHERE latitude IS NOT NULL AND longitude IS NOT NULL ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsWithGeolocation();

    @Query("SELECT * FROM caps WHERE latitude BETWEEN :minLat AND :maxLat AND longitude BETWEEN :minLng AND :maxLng ORDER BY found_date DESC")
    LiveData<List<CapEntity>> getCapsInBounds(double minLat, double maxLat, double minLng, double maxLng);

    @Query("SELECT COUNT(*) FROM caps")
    LiveData<Integer> getTotalCapsCount();

    @Query("SELECT COUNT(*) FROM caps WHERE category = :category")
    LiveData<Integer> getCapsCountByCategory(String category);

    @Query("SELECT COUNT(*) FROM caps WHERE rarity = :rarity")
    LiveData<Integer> getCapsCountByRarity(String rarity);

    @Query("SELECT * FROM caps ORDER BY found_date DESC LIMIT 1")
    CapEntity getLatestCap();

    @Query("SELECT * FROM caps WHERE is_synced = 0 ORDER BY added_date ASC")
    List<CapEntity> getUnsyncedCaps();

    @Query("UPDATE caps SET is_synced = 1 WHERE id = :capId")
    void setCapSynced(Long capId);

    @Query("DELETE FROM caps")
    void deleteAllCaps();

    @Query("SELECT COUNT(*) FROM caps WHERE found_date > :sinceDate")
    int getCapsCountSince(long sinceDate);
}
