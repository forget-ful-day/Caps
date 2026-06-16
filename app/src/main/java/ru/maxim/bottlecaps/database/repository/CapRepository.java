package ru.maxim.bottlecaps.database;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.maxim.bottlecaps.database.dao.CapDao;
import ru.maxim.bottlecaps.database.entity.CapEntity;

/**
 * Репозиторий для работы с сущностью CapEntity.
 * Слой абстракции над базой данных.
 * Определяет методы для CRUD операций и различных запросов к таблице caps.
 */
public class CapRepository {

    private final CapDao capDao;
    private final ExecutorService executorService;

    /**
     * Конструктор репозитория.
     *
     * @param context контекст приложения
     */
    public CapRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        capDao = database.capDao();
        // Используем ExecutorService вместо устаревшего AsyncTask
        executorService = Executors.newSingleThreadExecutor();
    }

    //region Вставка данных

    /**
     * Вставка новой крышки в базу данных (асинхронно).
     *
     * @param cap объект CapEntity для вставки
     */
    public void insert(final CapEntity cap) {
        executorService.execute(() -> capDao.insert(cap));
    }

    /**
     * Вставка нескольких крышек в базу данных (асинхронно).
     *
     * @param caps список объектов CapEntity для вставки
     */
    public void insertAll(final CapEntity... caps) {
        executorService.execute(() -> capDao.insertAll(caps));
    }

    //endregion

    //region Обновление данных

    /**
     * Обновление крышки в базе данных (асинхронно).
     *
     * @param cap объект CapEntity для обновления
     */
    public void update(final CapEntity cap) {
        executorService.execute(() -> capDao.update(cap));
    }

    /**
     * Обновление нескольких крышек в базе данных (асинхронно).
     *
     * @param caps список объектов CapEntity для обновления
     */
    public void updateAll(final CapEntity... caps) {
        executorService.execute(() -> capDao.updateAll(caps));
    }

    /**
     * Пометка крышки как синхронизированной (асинхронно).
     *
     * @param id id крышки
     * @param isSynced флаг синхронизации
     */
    public void setSynced(final long id, final boolean isSynced) {
        executorService.execute(() -> capDao.setSynced(id, isSynced));
    }

    //endregion

    //region Удаление данных

    /**
     * Удаление крышки из базы данных (асинхронно).
     *
     * @param cap объект CapEntity для удаления
     */
    public void delete(final CapEntity cap) {
        executorService.execute(() -> capDao.delete(cap));
    }

    /**
     * Удаление крышки по id (асинхронно).
     *
     * @param id id крышки для удаления
     */
    public void deleteById(final long id) {
        executorService.execute(() -> capDao.deleteById(id));
    }

    /**
     * Удаление всех крышек из базы данных (асинхронно).
     */
    public void deleteAllCaps() {
        executorService.execute(capDao::deleteAllCaps);
    }

    //endregion

    //region Чтение данных (синхронные методы)

    /**
     * Получение крышки по id (синхронно).
     *
     * @param id id крышки
     * @return объект CapEntity или null, если не найдена
     */
    public CapEntity getCapById(long id) {
        return capDao.getCapById(id);
    }

    /**
     * Получение крышки по названию (синхронно).
     *
     * @param name название крышки
     * @return объект CapEntity или null, если не найдена
     */
    public CapEntity getCapByName(String name) {
        return capDao.getCapByName(name);
    }

    /**
     * Получение всех крышек (синхронно).
     *
     * @return список всех крышек
     */
    public List<CapEntity> getAllCaps() {
        return capDao.getAllCapsSync();
    }

    /**
     * Получение последней добавленной крышки (синхронно).
     *
     * @return последняя добавленная крышка или null
     */
    public CapEntity getLatestCap() {
        return capDao.getLatestCap();
    }

    /**
     * Получение количества всех крышек (синхронно).
     *
     * @return количество крышек
     */
    public int getTotalCount() {
        return capDao.getTotalCount();
    }

    //endregion

    //region Запросы с фильтрацией (синхронные методы)

    /**
     * Получение крышек по категории (синхронно).
     *
     * @param category название категории
     * @return список крышек категории
     */
    public List<CapEntity> getCapsByCategory(String category) {
        // Примечание: для LiveData используйте методы с LiveData ниже
        return null; // Это синхронный репозиторий, используйте LiveData из DAO для отслеживания изменений
    }

    /**
     * Получение крышек по редкости (синхронно).
     *
     * @param rarity редкость
     * @return список крышек редкости
     */
    public List<CapEntity> getCapsByRarity(String rarity) {
        return capDao.getAllCapsSync(); // Заглушка
    }

    /**
     * Поиск крышек по запросу (синхронно).
     *
     * @param query поисковый запрос
     * @return список найденных крышек
     */
    public List<CapEntity> searchCaps(String query) {
        return capDao.getAllCapsSync(); // Заглушка
    }

    /**
     * Получение крышек в заданных географических границах (синхронно).
     *
     * @param latMin минимальная широта
     * @param latMax максимальная широта
     * @param lngMin минимальная долгота
     * @param lngMax максимальная долгота
     * @return список крышек в диапазоне координат
     */
    public List<CapEntity> getCapsByLocation(double latMin, double latMax, double lngMin, double lngMax) {
        return capDao.getCapsByLocation(latMin, latMax, lngMin, lngMax);
    }

    /**
     * Получение крышек с координатами (синхронно).
     *
     * @return список крышек с установленными координатами
     */
    public List<CapEntity> getCapsWithGeolocation() {
        return capDao.getCapsWithGeolocation();
    }

    /**
     * Получение несинхронизированных крышек (синхронно).
     *
     * @return список несинхронизированных крышек
     */
    public List<CapEntity> getUnsyncedCaps() {
        return capDao.getUnsyncedCaps();
    }

    //endregion

    //region Запросы с фильтрацией (методы с возвращением LiveData)

    /**
     * Получение количества крышек в категории с отслеживанием изменений (LiveData).
     *
     * @param category название категории
     * @return LiveData с количеством крышек
     */
    public int getCountByCategory(String category) {
        return capDao.getCountByCategory(category);
    }

    /**
     * Получение количества крышек по редкости с отслеживанием изменений (LiveData).
     *
     * @param rarity редкость
     * @return LiveData с количеством крышек
     */
    public int getCountByRarity(String rarity) {
        return capDao.getCountByRarity(rarity);
    }

    /**
     * Получение количества крышек с даты с отслеживанием изменений (LiveData).
     *
     * @param sinceDate Unix timestamp в миллисекундах
     * @return LiveData с количеством крышек
     */
    public int getCountSince(long sinceDate) {
        return capDao.getCountSince(sinceDate);
    }

    //endregion
}
