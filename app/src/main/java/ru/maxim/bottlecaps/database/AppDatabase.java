package ru.maxim.bottlecaps.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.maxim.bottlecaps.database.dao.CapDao;
import ru.maxim.bottlecaps.database.dao.StatisticsDao;
import ru.maxim.bottlecaps.database.dao.WishlistDao;
import ru.maxim.bottlecaps.database.entity.CapEntity;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;

/**
 * Главный класс базы данных для приложения BottleCaps.
 * Использует Room Persistence Library для работы с SQLite.
 * Реализует паттерн Singleton для глобального доступа к базе данных.
 */
@Database(entities = {CapEntity.class, WishlistEntity.class, StatisticsEntity.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "bottlecaps_database";

    // Синглтон экземпляр базы данных
    private static volatile AppDatabase INSTANCE;

    /**
     * Получение экземпляра базы данных (синхронный доступ).
     * Использует паттерн Singleton с двойной проверкой блокировки.
     *
     * @param context контекст приложения
     * @return экземпляр AppDatabase
     */
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries() // Для простоты, в продакшене использовать executor
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration() // Для разработки
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Методы для получения DAO
     */
    public abstract CapDao capDao();
    public abstract WishlistDao wishlistDao();
    public abstract StatisticsDao statisticsDao();

    /**
     * Callback для базы данных.
     * Используется для предзаполнения данных при создании базы.
     */
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.d(TAG, "Database created");
            
            // Здесь можно добавить предзаполнение данных, если нужно
            // Для примера - создадим начальную статистику
            new Thread(() -> {
                if (INSTANCE != null) {
                    StatisticsEntity stats = new StatisticsEntity();
                    INSTANCE.statisticsDao().insert(stats);
                    Log.d(TAG, "Initial statistics inserted");
                }
            }).start();
        }

        @Override
        public void onOpen(SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.d(TAG, "Database opened");
        }
    };

    /**
     * Удаление экземпляра базы данных (для тестирования).
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Сохранение последнего использования (для статистики).
     *
     * @param context контекст приложения
     */
    public static void saveLastUsage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        prefs.edit().putLong("last_usage", System.currentTimeMillis()).apply();
    }

    /**
     * Получение времени последнего использования.
     *
     * @param context контекст приложения
     * @return Unix timestamp в миллисекундах
     */
    public static long getLastUsage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        return prefs.getLong("last_usage", 0);
    }
}
