package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import ru.maxim.bottlecaps.App;
import ru.maxim.bottlecaps.database.WishlistRepository;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;

/**
 * ViewModel для работы с сущностью WishlistEntity.
 * Слой между View (Activity/Fragment) и Model (Repository).
 * Использует AndroidViewModel для доступа к Application контексту.
 */
public class WishlistViewModel extends AndroidViewModel {

    private final WishlistRepository wishlistRepository;

    /**
     * Конструктор ViewModel.
     *
     * @param application контекст приложения
     */
    public WishlistViewModel(@NonNull Application application) {
        super(application);
        wishlistRepository = App.getInstance().getWishlistRepository();
    }

    //region Методы для работы с данными

    /**
     * Вставка новой желаемой крышки.
     *
     * @param item объект WishlistEntity для вставки
     */
    public void insert(WishlistEntity item) {
        wishlistRepository.insert(item);
    }

    /**
     * Обновление желаемой крышки.
     *
     * @param item объект WishlistEntity для обновления
     */
    public void update(WishlistEntity item) {
        wishlistRepository.update(item);
    }

    /**
     * Удаление желаемой крышки.
     *
     * @param item объект WishlistEntity для удаления
     */
    public void delete(WishlistEntity item) {
        wishlistRepository.delete(item);
    }

    /**
     * Удаление желаемой крышки по id.
     *
     * @param id id желаемой крышки для удаления
     */
    public void deleteById(long id) {
        wishlistRepository.deleteById(id);
    }

    /**
     * Удаление всех желаемых крышек.
     */
    public void clearAll() {
        wishlistRepository.clearAll();
    }

    //endregion

    //region Методы для чтения данных

    /**
     * Получение всех желаемых крышек (синхронно).
     *
     * @return список всех желаемых крышек
     */
    public List<WishlistEntity> getAll() {
        return wishlistRepository.getAll();
    }

    /**
     * Получение желаемой крышки по id (синхронно).
     *
     * @param id id желаемой крышки
     * @return объект WishlistEntity или null, если не найдена
     */
    public WishlistEntity getById(long id) {
        return wishlistRepository.getById(id);
    }

    /**
     * Поиск желаемой крышки по названию (синхронно).
     *
     * @param name название желаемой крышки
     * @return список найденных желаемых крышек
     */
    public List<WishlistEntity> findByName(String name) {
        return wishlistRepository.findByName(name);
    }

    /**
     * Проверка наличия желаемой крышки с указанным названием (синхронно).
     *
     * @param name название желаемой крышки
     * @return 1 если найдена, 0 если не найдена
     */
    public int checkIfExists(String name) {
        return wishlistRepository.checkIfExists(name);
    }

    /**
     * Получение последней добавленной желаемой крышки (синхронно).
     *
     * @return последняя добавленная желаемая крышка или null
     */
    public WishlistEntity getLatest() {
        return wishlistRepository.getLatest();
    }

    /**
     * Получение количества всех желаемых крышек (синхронно).
     *
     * @return количество желаемых крышек
     */
    public int getCount() {
        return wishlistRepository.getCount();
    }

    /**
     * Получение количества желаемых крышек по приоритету (синхронно).
     *
     * @param priority приоритет (1-3)
     * @return количество желаемых крышек приоритета
     */
    public int getCountByPriority(int priority) {
        return wishlistRepository.getCountByPriority(priority);
    }

    //endregion
}
