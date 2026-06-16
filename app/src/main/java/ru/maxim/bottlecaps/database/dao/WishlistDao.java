package ru.maxim.bottlecaps.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.maxim.bottlecaps.database.entity.WishlistEntity;

/**
 * Data Access Object (DAO) для работы с сущностью WishlistEntity.
 * Предоставляет методы для CRUD операций и различных запросов к таблице wishlists.
 */
@Dao
public interface WishlistDao {

    /**
     * Вставка новой желаемой крышки в базу данных.
     *
     * @param item объект WishlistEntity для вставки
     * @return id вставленной записи
     */
    @Insert
    long insert(WishlistEntity item);

    /**
     * Вставка нескольких желаемых крышек в базу данных.
     *
     * @param items список объектов WishlistEntity для вставки
     */
    @Insert
    void insertAll(WishlistEntity... items);

    /**
     * Обновление существующей желаемой крышки в базе данных.
     *
     * @param item объект WishlistEntity для обновления
     */
    @Update
    void update(WishlistEntity item);

    /**
     * Обновление нескольких желаемых крышек в базе данных.
     *
     * @param items список объектов WishlistEntity для обновления
     */
    @Update
    void updateAll(WishlistEntity... items);

    /**
     * Удаление желаемой крышки из базы данных.
     *
     * @param item объект WishlistEntity для удаления
     */
    @Delete
    void delete(WishlistEntity item);

    /**
     * Удаление желаемой крышки по id.
     *
     * @param id id желаемой крышки для удаления
     */
    @Query("DELETE FROM wishlists WHERE id = :id")
    void deleteById(long id);

    /**
     * Получение всех желаемых крышек, отсортированных по приоритету и дате добавления.
     *
     * @return LiveData со списком всех желаемых крышек
     */
    @Query("SELECT * FROM wishlists ORDER BY priority DESC, added_date DESC")
    LiveData<List<WishlistEntity>> getAllWishlist();

    /**
     * Получение желаемых крышек синхронно (без LiveData).
     *
     * @return список всех желаемых крышек
     */
    @Query("SELECT * FROM wishlists ORDER BY priority DESC, added_date DESC")
    List<WishlistEntity> getAllWishlistSync();

    /**
     * Получение желаемых крышек по приоритету.
     *
     * @param priority приоритет (1-3)
     * @return LiveData со списком желаемых крышек выбранного приоритета
     */
    @Query("SELECT * FROM wishlists WHERE priority = :priority ORDER BY added_date DESC")
    LiveData<List<WishlistEntity>> getWishlistByPriority(int priority);

    /**
     * Поиск желаемой крышки по названию.
     *
     * @param name название желаемой крышки
     * @return объект WishlistEntity или null, если не найдена
     */
    @Query("SELECT * FROM wishlists WHERE name LIKE '%' || :name || '%' ORDER BY added_date DESC")
    List<WishlistEntity> findByName(String name);

    /**
     * Проверка наличия желаемой крышки с указанным названием.
     *
     * @param name название желаемой крышки
     * @return 1 если найдена, 0 если не найдена
     */
    @Query("SELECT COUNT(*) FROM wishlists WHERE name = :name")
    int checkIfExists(String name);

    /**
     * Удаление всех желаемых крышек из базы данных.
     */
    @Query("DELETE FROM wishlists")
    void clearAll();

    /**
     * Получение желаемой крышки по id.
     *
     * @param id id желаемой крышки
     * @return объект WishlistEntity или null, если не найдена
     */
    @Query("SELECT * FROM wishlists WHERE id = :id")
    WishlistEntity getById(long id);

    /**
     * Получение количества всех желаемых крышек.
     *
     * @return количество желаемых крышек
     */
    @Query("SELECT COUNT(*) FROM wishlists")
    int getCount();

    /**
     * Получение количества желаемых крышек по приоритету.
     *
     * @param priority приоритет (1-3)
     * @return количество желаемых крышек выбранного приоритета
     */
    @Query("SELECT COUNT(*) FROM wishlists WHERE priority = :priority")
    int getCountByPriority(int priority);

    /**
     * Получение последней добавленной желаемой крышки.
     *
     * @return последняя добавленная желаемая крышка или null
     */
    @Query("SELECT * FROM wishlists ORDER BY added_date DESC LIMIT 1")
    WishlistEntity getLatest();
}
