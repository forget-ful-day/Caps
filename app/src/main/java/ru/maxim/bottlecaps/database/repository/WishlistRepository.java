package ru.maxim.bottlecaps.database;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.dao.WishlistDao;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;

/**
 * Репозиторий для работы с сущностью WishlistEntity.
 * Слой абстракции над базой данных для желаемых крышек.
 * Определяет методы для CRUD операций и различных запросов к таблице wishlists.
 */
public class WishlistRepository {

    private final WishlistDao wishlistDao;
    private final ExecutorService executorService;

    /**
     * Конструктор репозитория.
     *
     * @param context контекст приложения
     */
    public WishlistRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        wishlistDao = database.wishlistDao();
        // Используем ExecutorService вместо устаревшего AsyncTask
        executorService = Executors.newSingleThreadExecutor();
    }

    //region Вставка данных

    /**
     * Вставка новой желаемой крышки в базу данных (асинхронно).
     *
     * @param item объект WishlistEntity для вставки
     */
    public void insert(final WishlistEntity item) {
        executorService.execute(() -> wishlistDao.insert(item));
    }

    /**
     * Вставка нескольких желаемых крышек в базу данных (асинхронно).
     *
     * @param items список объектов WishlistEntity для вставки
     */
    public void insertAll(final WishlistEntity... items) {
        executorService.execute(() -> wishlistDao.insertAll(items));
    }

    //endregion

    //region Обновление данных

    /**
     * Обновление желаемой крышки в базе данных (асинхронно).
     *
     * @param item объект WishlistEntity для обновления
     */
    public void update(final WishlistEntity item) {
        executorService.execute(() -> wishlistDao.update(item));
    }

    /**
     * Обновление нескольких желаемых крышек в базе данных (асинхронно).
     *
     * @param items список объектов WishlistEntity для обновления
     */
    public void updateAll(final WishlistEntity... items) {
        executorService.execute(() -> wishlistDao.updateAll(items));
    }

    //endregion

    //region Удаление данных

    /**
     * Удаление желаемой крышки из базы данных (асинхронно).
     *
     * @param item объект WishlistEntity для удаления
     */
    public void delete(final WishlistEntity item) {
        executorService.execute(() -> wishlistDao.delete(item));
    }

    /**
     * Удаление желаемой крышки по id (асинхронно).
     *
     * @param id id желаемой крышки для удаления
     */
    public void deleteById(final long id) {
        executorService.execute(() -> wishlistDao.deleteById(id));
    }

    /**
     * Удаление всех желаемых крышек из базы данных (асинхронно).
     */
    public void clearAll() {
        executorService.execute(wishlistDao::clearAll);
    }

    //endregion

    //region Чтение данных (синхронные методы)

    /**
     * Получение желаемой крышки по id (синхронно).
     *
     * @param id id желаемой крышки
     * @return объект WishlistEntity или null, если не найдена
     */
    public WishlistEntity getById(long id) {
        return wishlistDao.getById(id);
    }

    /**
     * Получение всех желаемых крышек (синхронно).
     *
     * @return список всех желаемых крышек
     */
    public List<WishlistEntity> getAll() {
        return wishlistDao.getAllWishlistSync();
    }

    /**
     * Поиск желаемой крышки по названию (синхронно).
     *
     * @param name название желаемой крышки
     * @return список найденных желаемых крышек
     */
    public List<WishlistEntity> findByName(String name) {
        return wishlistDao.findByName(name);
    }

    /**
     * Проверка наличия желаемой крышки с указанным названием (синхронно).
     *
     * @param name название желаемой крышки
     * @return 1 если найдена, 0 если не найдена
     */
    public int checkIfExists(String name) {
        return wishlistDao.checkIfExists(name);
    }

    /**
     * Получение последней добавленной желаемой крышки (синхронно).
     *
     * @return последняя добавленная желаемая крышка или null
     */
    public WishlistEntity getLatest() {
        return wishlistDao.getLatest();
    }

    /**
     * Получение количества всех желаемых крышек (синхронно).
     *
     * @return количество желаемых крышек
     */
    public int getCount() {
        return wishlistDao.getCount();
    }

    //endregion

    //region Запросы с фильтрацией (синхронные методы)

    /**
     * Получение желаемых крышек по приоритету (синхронно).
     *
     * @param priority приоритет (1-3)
     * @return список желаемых крышек приоритета
     */
    public List<WishlistEntity> getByPriority(int priority) {
        return null; // Заглушка
    }

    /**
     * Получение количества желаемых крышек по приоритету (синхронно).
     *
     * @param priority приоритет (1-3)
     * @return количество желаемых крышек приоритета
     */
    public int getCountByPriority(int priority) {
        return wishlistDao.getCountByPriority(priority);
    }

    //endregion
}
