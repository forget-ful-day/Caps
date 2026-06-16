package ru.maxim.bottlecaps.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import ru.maxim.bottlecaps.database.dao.CapDao;
import ru.maxim.bottlecaps.database.dao.CapDao_Impl;
import ru.maxim.bottlecaps.database.dao.StatisticsDao;
import ru.maxim.bottlecaps.database.dao.StatisticsDao_Impl;
import ru.maxim.bottlecaps.database.dao.WishlistDao;
import ru.maxim.bottlecaps.database.dao.WishlistDao_Impl;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CapDao _capDao;

  private volatile WishlistDao _wishlistDao;

  private volatile StatisticsDao _statisticsDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `caps` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `photo_path` TEXT, `category` TEXT, `country` TEXT, `city` TEXT, `rarity` TEXT, `tags` TEXT, `latitude` REAL, `longitude` REAL, `found_date` INTEGER NOT NULL, `added_date` INTEGER NOT NULL, `is_synced` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_caps_name` ON `caps` (`name`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_caps_category` ON `caps` (`category`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_caps_rarity` ON `caps` (`rarity`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `wishlist` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `priority` INTEGER NOT NULL, `added_date` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_wishlist_name` ON `wishlist` (`name`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_wishlist_priority` ON `wishlist` (`priority`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `statistics` (`id` INTEGER NOT NULL, `total_caps` INTEGER NOT NULL, `total_pivnye` INTEGER NOT NULL, `total_limonye` INTEGER NOT NULL, `total_energeticheskie` INTEGER NOT NULL, `total_chainye` INTEGER NOT NULL, `total_drugie` INTEGER NOT NULL, `total_rare` INTEGER NOT NULL, `total_unique` INTEGER NOT NULL, `streak_days` INTEGER NOT NULL, `last_update` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f299467723656117c06245d57fab504f')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `caps`");
        db.execSQL("DROP TABLE IF EXISTS `wishlist`");
        db.execSQL("DROP TABLE IF EXISTS `statistics`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCaps = new HashMap<String, TableInfo.Column>(13);
        _columnsCaps.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("photo_path", new TableInfo.Column("photo_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("city", new TableInfo.Column("city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("rarity", new TableInfo.Column("rarity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("tags", new TableInfo.Column("tags", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("found_date", new TableInfo.Column("found_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("added_date", new TableInfo.Column("added_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCaps.put("is_synced", new TableInfo.Column("is_synced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCaps = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCaps = new HashSet<TableInfo.Index>(3);
        _indicesCaps.add(new TableInfo.Index("index_caps_name", true, Arrays.asList("name"), Arrays.asList("ASC")));
        _indicesCaps.add(new TableInfo.Index("index_caps_category", false, Arrays.asList("category"), Arrays.asList("ASC")));
        _indicesCaps.add(new TableInfo.Index("index_caps_rarity", false, Arrays.asList("rarity"), Arrays.asList("ASC")));
        final TableInfo _infoCaps = new TableInfo("caps", _columnsCaps, _foreignKeysCaps, _indicesCaps);
        final TableInfo _existingCaps = TableInfo.read(db, "caps");
        if (!_infoCaps.equals(_existingCaps)) {
          return new RoomOpenHelper.ValidationResult(false, "caps(ru.maxim.bottlecaps.database.entity.CapEntity).\n"
                  + " Expected:\n" + _infoCaps + "\n"
                  + " Found:\n" + _existingCaps);
        }
        final HashMap<String, TableInfo.Column> _columnsWishlist = new HashMap<String, TableInfo.Column>(5);
        _columnsWishlist.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWishlist.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWishlist.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWishlist.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWishlist.put("added_date", new TableInfo.Column("added_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWishlist = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWishlist = new HashSet<TableInfo.Index>(2);
        _indicesWishlist.add(new TableInfo.Index("index_wishlist_name", true, Arrays.asList("name"), Arrays.asList("ASC")));
        _indicesWishlist.add(new TableInfo.Index("index_wishlist_priority", false, Arrays.asList("priority"), Arrays.asList("ASC")));
        final TableInfo _infoWishlist = new TableInfo("wishlist", _columnsWishlist, _foreignKeysWishlist, _indicesWishlist);
        final TableInfo _existingWishlist = TableInfo.read(db, "wishlist");
        if (!_infoWishlist.equals(_existingWishlist)) {
          return new RoomOpenHelper.ValidationResult(false, "wishlist(ru.maxim.bottlecaps.database.entity.WishlistEntity).\n"
                  + " Expected:\n" + _infoWishlist + "\n"
                  + " Found:\n" + _existingWishlist);
        }
        final HashMap<String, TableInfo.Column> _columnsStatistics = new HashMap<String, TableInfo.Column>(11);
        _columnsStatistics.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_caps", new TableInfo.Column("total_caps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_pivnye", new TableInfo.Column("total_pivnye", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_limonye", new TableInfo.Column("total_limonye", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_energeticheskie", new TableInfo.Column("total_energeticheskie", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_chainye", new TableInfo.Column("total_chainye", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_drugie", new TableInfo.Column("total_drugie", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_rare", new TableInfo.Column("total_rare", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("total_unique", new TableInfo.Column("total_unique", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("streak_days", new TableInfo.Column("streak_days", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("last_update", new TableInfo.Column("last_update", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStatistics = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStatistics = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStatistics = new TableInfo("statistics", _columnsStatistics, _foreignKeysStatistics, _indicesStatistics);
        final TableInfo _existingStatistics = TableInfo.read(db, "statistics");
        if (!_infoStatistics.equals(_existingStatistics)) {
          return new RoomOpenHelper.ValidationResult(false, "statistics(ru.maxim.bottlecaps.database.entity.StatisticsEntity).\n"
                  + " Expected:\n" + _infoStatistics + "\n"
                  + " Found:\n" + _existingStatistics);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f299467723656117c06245d57fab504f", "2d70a79c54af8f561c45ec173d834810");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "caps","wishlist","statistics");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `caps`");
      _db.execSQL("DELETE FROM `wishlist`");
      _db.execSQL("DELETE FROM `statistics`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CapDao.class, CapDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WishlistDao.class, WishlistDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StatisticsDao.class, StatisticsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CapDao capDao() {
    if (_capDao != null) {
      return _capDao;
    } else {
      synchronized(this) {
        if(_capDao == null) {
          _capDao = new CapDao_Impl(this);
        }
        return _capDao;
      }
    }
  }

  @Override
  public WishlistDao wishlistDao() {
    if (_wishlistDao != null) {
      return _wishlistDao;
    } else {
      synchronized(this) {
        if(_wishlistDao == null) {
          _wishlistDao = new WishlistDao_Impl(this);
        }
        return _wishlistDao;
      }
    }
  }

  @Override
  public StatisticsDao statisticsDao() {
    if (_statisticsDao != null) {
      return _statisticsDao;
    } else {
      synchronized(this) {
        if(_statisticsDao == null) {
          _statisticsDao = new StatisticsDao_Impl(this);
        }
        return _statisticsDao;
      }
    }
  }
}
