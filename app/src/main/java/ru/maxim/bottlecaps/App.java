package ru.maxim.bottlecaps;

import android.app.Application;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.CapRepository;
import ru.maxim.bottlecaps.database.StatisticsRepository;
import ru.maxim.bottlecaps.database.WishlistRepository;

/**
 * Главный класс приложения.
 * Наследуется от Application и инициализирует базу данных при запуске.
 * Предоставляет глобальный доступ к репозиториям.
 */
public class App extends Application {

    private static App instance;
    private CapRepository capRepository;
    private WishlistRepository wishlistRepository;
    private StatisticsRepository statisticsRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        
        // Инициализация базы данных
        AppDatabase.getInstance(this);
        
        // Инициализация репозиториев
        capRepository = new CapRepository(this);
        wishlistRepository = new WishlistRepository(this);
        statisticsRepository = new StatisticsRepository(this);
        
        // Сохранение времени запуска приложения
        AppDatabase.saveLastUsage(this);
    }

    /**
     * Получение экземпляра приложения (Singleton).
     *
     * @return экземпляр App
     */
    public static App getInstance() {
        return instance;
    }

    //region Getter'ы для репозиториев

    public CapRepository getCapRepository() {
        return capRepository;
    }

    public WishlistRepository getWishlistRepository() {
        return wishlistRepository;
    }

    public StatisticsRepository getStatisticsRepository() {
        return statisticsRepository;
    }

    //endregion
}
