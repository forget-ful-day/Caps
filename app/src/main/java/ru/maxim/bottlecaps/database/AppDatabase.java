package ru.maxim.bottlecaps.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.maxim.bottlecaps.database.dao.CapDao;
import ru.maxim.bottlecaps.database.dao.StatisticsDao;
import ru.maxim.bottlecaps.database.dao.WishlistDao;
import ru.maxim.bottlecaps.database.entity.CapEntity;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;

@Database(entities = {CapEntity.class, WishlistEntity.class, StatisticsEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "bottlecaps_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract CapDao capDao();
    public abstract WishlistDao wishlistDao();
    public abstract StatisticsDao statisticsDao();
}
