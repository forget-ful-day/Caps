package ru.maxim.bottlecaps.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

/**
 * Data Access Object (DAO) для работы с сущностью StatisticsEntity.
 * Предоставляет методы для работы с таблицей statistics.
 */
@Dao
public interface StatisticsDao {

    /**
     * Вставка или замена статистики в базе данных.
     * Используется стратегия REPLACE, так как у нас всегда одна запись с id = 1.
     *
     * @param stats объект StatisticsEntity для вставки
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(StatisticsEntity stats);

    /**
     * Обновление существующей статистики в базе данных.
     *
     * @param stats объект StatisticsEntity для обновления
     */
    @Update
    void update(StatisticsEntity stats);

    /**
     * Получение текущей статистики.
     * В таблице statistics всегда только одна запись с id = 1.
     *
     * @return объект StatisticsEntity
     */
    @Query("SELECT * FROM statistics WHERE id = 1")
    StatisticsEntity getStatistics();

    /**
     * Обновление общего количества крышек.
     *
     * @param total общее количество крышек
     */
    @Query("UPDATE statistics SET total_caps = :total, last_update = :timestamp WHERE id = 1")
    void updateTotalCaps(int total, long timestamp);

    /**
     * Обновление количества пивных крышек.
     *
     * @param total количество пивных крышек
     */
    @Query("UPDATE statistics SET total_pivnye = :total WHERE id = 1")
    void updateTotalPivnye(int total);

    /**
     * Обновление количества лимонадных крышек.
     *
     * @param total количество лимонадных крышек
     */
    @Query("UPDATE statistics SET total_limonye = :total WHERE id = 1")
    void updateTotalLimonye(int total);

    /**
     * Обновление количества энергетических крышек.
     *
     * @param total количество энергетических крышек
     */
    @Query("UPDATE statistics SET total_energeticheskie = :total WHERE id = 1")
    void updateTotalEnergeticheskie(int total);

    /**
     * Обновление количества чайных крышек.
     *
     * @param total количество чайных крышек
     */
    @Query("UPDATE statistics SET total_chainye = :total WHERE id = 1")
    void updateTotalChainye(int total);

    /**
     * Обновление количества прочих крышек.
     *
     * @param total количество прочих крышек
     */
    @Query("UPDATE statistics SET total_drugie = :total WHERE id = 1")
    void updateTotalDrugie(int total);

    /**
     * Обновление количества редких крышек.
     *
     * @param total количество редких крышек
     */
    @Query("UPDATE statistics SET total_rare = :total WHERE id = 1")
    void updateTotalRare(int total);

    /**
     * Обновление количества уникальных крышек.
     *
     * @param total количество уникальных крышек
     */
    @Query("UPDATE statistics SET total_unique = :total WHERE id = 1")
    void updateTotalUnique(int total);

    /**
     * Обновление количества дней подряд (streak).
     *
     * @param streak количество дней подряд
     */
    @Query("UPDATE statistics SET streak_days = :streak WHERE id = 1")
    void updateStreakDays(int streak);

    /**
     * Обновление даты последнего обновления.
     *
     * @param timestamp Unix timestamp в миллисекундах
     */
    @Query("UPDATE statistics SET last_update = :timestamp WHERE id = 1")
    void updateLastUpdate(long timestamp);
}
