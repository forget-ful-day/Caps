package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.maxim.bottlecaps.App;
import ru.maxim.bottlecaps.database.CapRepository;
import ru.maxim.bottlecaps.database.entity.CapEntity;

/**
 * ViewModel для работы с сущностью CapEntity.
 * Слой между View (Activity/Fragment) и Model (Repository).
 * Использует AndroidViewModel для доступа к Application контексту.
 */
public class CapViewModel extends AndroidViewModel {

    private final CapRepository capRepository;
    private final LiveData<List<CapEntity>> allCaps;

    /**
     * Конструктор ViewModel.
     *
     * @param application контекст приложения
     */
    public CapViewModel(@NonNull Application application) {
        super(application);
        capRepository = App.getInstance().getCapRepository();
        // Получаем LiveData для отслеживания изменений в базе данных
        allCaps = null; // В репозитории пока нет метода с LiveData
    }

    //region Методы для работы с данными

    /**
     * Вставка новой крышки.
     *
     * @param cap объект CapEntity для вставки
     */
    public void insert(CapEntity cap) {
        capRepository.insert(cap);
    }

    /**
     * Обновление крышки.
     *
     * @param cap объект CapEntity для обновления
     */
    public void update(CapEntity cap) {
        capRepository.update(cap);
    }

    /**
     * Удаление крышки.
     *
     * @param cap объект CapEntity для удаления
     */
    public void delete(CapEntity cap) {
        capRepository.delete(cap);
    }

    /**
     * Удаление крышки по id.
     *
     * @param id id крышки для удаления
     */
    public void deleteById(long id) {
        capRepository.deleteById(id);
    }

    //endregion

    //region Методы для чтения данных

    /**
     * Получение всех крышек (синхронно).
     * Для отслеживания изменений используйтеLiveData из DAO напрямую.
     *
     * @return список всех крышек
     */
    public List<CapEntity> getAllCaps() {
        return capRepository.getAllCaps();
    }

    /**
     * Получение крышки по id (синхронно).
     *
     * @param id id крышки
     * @return объект CapEntity или null, если не найдена
     */
    public CapEntity getCapById(long id) {
        return capRepository.getCapById(id);
    }

    /**
     * Получение крышки по названию (синхронно).
     *
     * @param name название крышки
     * @return объект CapEntity или null, если не найдена
     */
    public CapEntity getCapByName(String name) {
        return capRepository.getCapByName(name);
    }

    /**
     * Получение последней добавленной крышки (синхронно).
     *
     * @return последняя добавленная крышка или null
     */
    public CapEntity getLatestCap() {
        return capRepository.getLatestCap();
    }

    /**
     * Получение количества всех крышек (синхронно).
     *
     * @return количество крышек
     */
    public int getTotalCount() {
        return capRepository.getTotalCount();
    }

    /**
     * Получение количества крышек по категории (синхронно).
     *
     * @param category название категории
     * @return количество крышек в категории
     */
    public int getCountByCategory(String category) {
        return capRepository.getCountByCategory(category);
    }

    /**
     * Получение количества крышек по редкости (синхронно).
     *
     * @param rarity редкость
     * @return количество крышек выбранной редкости
     */
    public int getCountByRarity(String rarity) {
        return capRepository.getCountByRarity(rarity);
    }

    /**
     * Получение количества крышек с даты (синхронно).
     *
     * @param sinceDate Unix timestamp в миллисекундах
     * @return количество крышек, добавленных с указанной даты
     */
    public int getCountSince(long sinceDate) {
        return capRepository.getCountSince(sinceDate);
    }

    //endregion
}
