package ru.maxim.bottlecaps.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.maxim.bottlecaps.database.entity.CapEntity;

/**
 * Data Access Object (DAO) для работы с сущностью CapEntity.
 * Предоставляет методы для CRUD операций и различных запросов к таблице caps.
 */
@Dao
public interface CapDao {

    /**
     * Вставка новой крышки в базу данных.
     *
     * @param cap объект CapEntity для вставки
     * @return id вставленной записи
     */
    @Insert
    long insert(CapEntity cap);

    /**
     * Вставка нескольких крышек в базу данных.
     *
     * @param caps список объектов CapEntity для вставки
     */
    @Insert
    void insertAll(CapEntity... caps);

    /**
     * Обновление существующей крышки в базе данных.
     *
     * @param cap объект CapEntity для обновления
     */
    @Update
    void update(CapEntity cap);

    /**
     * Обновление нескольких крышек в базе данных.
     *
     * @param caps список объектов CapEntity для обновления
     */
    @Update
    void updateAll(CapEntity... caps);

    /**
     * Удаление крышки из базы данных.
     *
     * @param cap объект CapEntity для удаления
     */
    @Delete
    void delete(CapEntity cap);

    /**
     * Удаление крышки по id.
     *
     * @param id id крышки для удаления
     */
    @Query("DELETE FROM caps WHERE id = :id")
    void deleteById(long id);

    /**
     * Получение всех крышек, отсортированных по дате добавления (от новых к старым).
     *
     * @return LiveData со списком всех крышек
     */
    @Query("SELECT * FROM caps ORDER BY added_date DESC")
    LiveData<List<CapEntity>> getAllCaps();

    /**
     * Получение всех крышек синхронно (без LiveData).
     *
     * @return список всех крышек
     */
    @Query("SELECT * FROM caps ORDER BY added_date DESC")
    List<CapEntity> getAllCapsSync();

    /**
     * Получение крышек по категории.
     *
     * @param category название категории (Пивная, Лимонадная, Энергетическая, Чайная, Другое)
     * @return LiveData со списком крышек выбранной категории
     */
    @Query("SELECT * FROM caps WHERE category = :category ORDER BY added_date DESC")
    LiveData<List<CapEntity>> getCapsByCategory(String category);

    /**
     * Получение крышек по редкости.
     *
     * @param rarity редкость (Обычная, Редкая, Уникальная)
     * @return LiveData со списком крышек выбранной редкости
     */
    @Query("SELECT * FROM caps WHERE rarity = :rarity ORDER BY added_date DESC")
    LiveData<List<CapEntity>> getCapsByRarity(String rarity);

    /**
     * Поиск крышек по названию или тегам.
     *
     * @param query поисковый запрос
     * @return LiveData со списком найденных крышек
     */
    @Query("SELECT * FROM caps WHERE name LIKE '%' || :query || '%' OR tags LIKE '%' || :query || '%' ORDER BY added_date DESC")
    LiveData<List<CapEntity>> searchCaps(String query);

    /**
     * Получение крышки по id.
     *
     * @param id id крышки
     * @return объект CapEntity или null, если не найдена
     */
    @Query("SELECT * FROM caps WHERE id = :id")
    CapEntity getCapById(long id);

    /**
     * Получение крышки по названию.
     *
     * @param name название крышки
     * @return объект CapEntity или null, если не найдена
     */
    @Query("SELECT * FROM caps WHERE name = :name LIMIT 1")
    CapEntity getCapByName(String name);

    /**
     * Получение крышек в заданных географических границах.
     *
     * @param latMin минимальная широта
     * @param latMax максимальная широта
     * @param lngMin минимальная долгота
     * @param lngMax максимальная долгота
     * @return список крышек в заданном диапазоне координат
     */
    @Query("SELECT * FROM caps WHERE latitude BETWEEN :latMin AND :latMax AND longitude BETWEEN :lngMin AND :lngMax")
    List<CapEntity> getCapsByLocation(double latMin, double latMax, double lngMin, double lngMax);

    /**
     * Получение количества всех крышек в базе данных.
     *
     * @return количество крышек
     */
    @Query("SELECT COUNT(*) FROM caps")
    int getTotalCount();

    /**
     * Получение количества крышек по категории.
     *
     * @param category название категории
     * @return количество крышек в категории
     */
    @Query("SELECT COUNT(*) FROM caps WHERE category = :category")
    int getCountByCategory(String category);

    /**
     * Получение количества крышек по редкости.
     *
     * @param rarity редкость
     * @return количество крышек выбранной редкости
     */
    @Query("SELECT COUNT(*) FROM caps WHERE rarity = :rarity")
    int getCountByRarity(String rarity);

    /**
     * Получение последней добавленной крышки.
     *
     * @return последняя добавленная крышка или null
     */
    @Query("SELECT * FROM caps ORDER BY added_date DESC LIMIT 1")
    CapEntity getLatestCap();

    /**
     * Получение всех крышек с координатами (geolocation).
     *
     * @return список крышек с установленными координатами
     */
    @Query("SELECT * FROM caps WHERE latitude IS NOT NULL AND longitude IS NOT NULL")
    List<CapEntity> getCapsWithGeolocation();

    /**
     * Получение несинхронизированных крышек.
     *
     * @return список крышек, которые еще не синхронизированы
     */
    @Query("SELECT * FROM caps WHERE is_synced = 0 ORDER BY added_date ASC")
    List<CapEntity> getUnsyncedCaps();

    /**
     * Пометка крышки как синхронизированной.
     *
     * @param id id крышки
     * @param isSynced флаг синхронизации
     */
    @Query("UPDATE caps SET is_synced = :isSynced WHERE id = :id")
    void setSynced(long id, boolean isSynced);

    /**
     * Удаление всех крышек из базы данных.
     */
    @Query("DELETE FROM caps")
    void deleteAllCaps();

    /**
     * Получение количества крышек с даты.
     *
     * @param sinceDate Unix timestamp в миллисекундах
     * @return количество крышек, добавленных с указанной даты
     */
    @Query("SELECT COUNT(*) FROM caps WHERE added_date > :sinceDate")
    int getCountSince(long sinceDate);
}
