package ru.maxim.bottlecaps.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import ru.maxim.bottlecaps.database.entity.CapEntity;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CapDao_Impl implements CapDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CapEntity> __insertionAdapterOfCapEntity;

  private final EntityDeletionOrUpdateAdapter<CapEntity> __deletionAdapterOfCapEntity;

  private final EntityDeletionOrUpdateAdapter<CapEntity> __updateAdapterOfCapEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfSetSyncedFlag;

  public CapDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCapEntity = new EntityInsertionAdapter<CapEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `caps` (`id`,`name`,`photo_path`,`category`,`country`,`city`,`rarity`,`tags`,`latitude`,`longitude`,`found_date`,`added_date`,`is_synced`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final CapEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPhotoPath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhotoPath());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCountry());
        }
        if (entity.getCity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCity());
        }
        if (entity.getRarity() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getRarity());
        }
        if (entity.getTags() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTags());
        }
        if (entity.getLatitude() == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getLongitude());
        }
        statement.bindLong(11, entity.getFoundDate());
        statement.bindLong(12, entity.getAddedDate());
        final int _tmp = entity.isSynced() ? 1 : 0;
        statement.bindLong(13, _tmp);
      }
    };
    this.__deletionAdapterOfCapEntity = new EntityDeletionOrUpdateAdapter<CapEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `caps` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final CapEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCapEntity = new EntityDeletionOrUpdateAdapter<CapEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `caps` SET `id` = ?,`name` = ?,`photo_path` = ?,`category` = ?,`country` = ?,`city` = ?,`rarity` = ?,`tags` = ?,`latitude` = ?,`longitude` = ?,`found_date` = ?,`added_date` = ?,`is_synced` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final CapEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPhotoPath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhotoPath());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCountry());
        }
        if (entity.getCity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCity());
        }
        if (entity.getRarity() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getRarity());
        }
        if (entity.getTags() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTags());
        }
        if (entity.getLatitude() == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getLongitude());
        }
        statement.bindLong(11, entity.getFoundDate());
        statement.bindLong(12, entity.getAddedDate());
        final int _tmp = entity.isSynced() ? 1 : 0;
        statement.bindLong(13, _tmp);
        statement.bindLong(14, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM caps WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetSyncedFlag = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE caps SET is_synced = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final CapEntity cap) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfCapEntity.insertAndReturnId(cap);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CapEntity cap) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCapEntity.handle(cap);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final CapEntity cap) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCapEntity.handle(cap);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public void setSyncedFlag(final long id, final boolean isSynced) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetSyncedFlag.acquire();
    int _argIndex = 1;
    final int _tmp = isSynced ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfSetSyncedFlag.release(_stmt);
    }
  }

  @Override
  public LiveData<List<CapEntity>> getAllCaps() {
    final String _sql = "SELECT * FROM caps ORDER BY addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"caps"}, false, new Callable<List<CapEntity>>() {
      @Override
      @Nullable
      public List<CapEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CapEntity>> getCapsByCategory(final String category) {
    final String _sql = "SELECT * FROM caps WHERE category = ? ORDER BY addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"caps"}, false, new Callable<List<CapEntity>>() {
      @Override
      @Nullable
      public List<CapEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CapEntity>> getCapsByRarity(final String rarity) {
    final String _sql = "SELECT * FROM caps WHERE rarity = ? ORDER BY addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rarity == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rarity);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"caps"}, false, new Callable<List<CapEntity>>() {
      @Override
      @Nullable
      public List<CapEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CapEntity>> searchCaps(final String query) {
    final String _sql = "SELECT * FROM caps WHERE name LIKE '%' || ? || '%' OR tags LIKE '%' || ? || '%' ORDER BY addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"caps"}, false, new Callable<List<CapEntity>>() {
      @Override
      @Nullable
      public List<CapEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public CapEntity getCapById(final long id) {
    final String _sql = "SELECT * FROM caps WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_path");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfFoundDate = CursorUtil.getColumnIndexOrThrow(_cursor, "found_date");
      final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_date");
      final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
      final CapEntity _result;
      if (_cursor.moveToFirst()) {
        _result = new CapEntity();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpPhotoPath;
        if (_cursor.isNull(_cursorIndexOfPhotoPath)) {
          _tmpPhotoPath = null;
        } else {
          _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        }
        _result.setPhotoPath(_tmpPhotoPath);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _result.setCategory(_tmpCategory);
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        _result.setCountry(_tmpCountry);
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _result.setCity(_tmpCity);
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        _result.setRarity(_tmpRarity);
        final String _tmpTags;
        if (_cursor.isNull(_cursorIndexOfTags)) {
          _tmpTags = null;
        } else {
          _tmpTags = _cursor.getString(_cursorIndexOfTags);
        }
        _result.setTags(_tmpTags);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final Double _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        }
        _result.setLongitude(_tmpLongitude);
        final long _tmpFoundDate;
        _tmpFoundDate = _cursor.getLong(_cursorIndexOfFoundDate);
        _result.setFoundDate(_tmpFoundDate);
        final long _tmpAddedDate;
        _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
        _result.setAddedDate(_tmpAddedDate);
        final boolean _tmpIsSynced;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSynced);
        _tmpIsSynced = _tmp != 0;
        _result.setSynced(_tmpIsSynced);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CapEntity getCapByName(final String name) {
    final String _sql = "SELECT * FROM caps WHERE name = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_path");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfFoundDate = CursorUtil.getColumnIndexOrThrow(_cursor, "found_date");
      final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_date");
      final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
      final CapEntity _result;
      if (_cursor.moveToFirst()) {
        _result = new CapEntity();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpPhotoPath;
        if (_cursor.isNull(_cursorIndexOfPhotoPath)) {
          _tmpPhotoPath = null;
        } else {
          _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        }
        _result.setPhotoPath(_tmpPhotoPath);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _result.setCategory(_tmpCategory);
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        _result.setCountry(_tmpCountry);
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _result.setCity(_tmpCity);
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        _result.setRarity(_tmpRarity);
        final String _tmpTags;
        if (_cursor.isNull(_cursorIndexOfTags)) {
          _tmpTags = null;
        } else {
          _tmpTags = _cursor.getString(_cursorIndexOfTags);
        }
        _result.setTags(_tmpTags);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final Double _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        }
        _result.setLongitude(_tmpLongitude);
        final long _tmpFoundDate;
        _tmpFoundDate = _cursor.getLong(_cursorIndexOfFoundDate);
        _result.setFoundDate(_tmpFoundDate);
        final long _tmpAddedDate;
        _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
        _result.setAddedDate(_tmpAddedDate);
        final boolean _tmpIsSynced;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSynced);
        _tmpIsSynced = _tmp != 0;
        _result.setSynced(_tmpIsSynced);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CapEntity> getCapsByLocation(final double latMin, final double latMax,
      final double lngMin, final double lngMax) {
    final String _sql = "SELECT * FROM caps WHERE latitude BETWEEN ? AND ? AND longitude BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, latMin);
    _argIndex = 2;
    _statement.bindDouble(_argIndex, latMax);
    _argIndex = 3;
    _statement.bindDouble(_argIndex, lngMin);
    _argIndex = 4;
    _statement.bindDouble(_argIndex, lngMax);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_path");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfFoundDate = CursorUtil.getColumnIndexOrThrow(_cursor, "found_date");
      final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_date");
      final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
      final List<CapEntity> _result = new ArrayList<CapEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final CapEntity _item;
        _item = new CapEntity();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpPhotoPath;
        if (_cursor.isNull(_cursorIndexOfPhotoPath)) {
          _tmpPhotoPath = null;
        } else {
          _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        }
        _item.setPhotoPath(_tmpPhotoPath);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.setCategory(_tmpCategory);
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        _item.setCountry(_tmpCountry);
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _item.setCity(_tmpCity);
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        _item.setRarity(_tmpRarity);
        final String _tmpTags;
        if (_cursor.isNull(_cursorIndexOfTags)) {
          _tmpTags = null;
        } else {
          _tmpTags = _cursor.getString(_cursorIndexOfTags);
        }
        _item.setTags(_tmpTags);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final Double _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        }
        _item.setLongitude(_tmpLongitude);
        final long _tmpFoundDate;
        _tmpFoundDate = _cursor.getLong(_cursorIndexOfFoundDate);
        _item.setFoundDate(_tmpFoundDate);
        final long _tmpAddedDate;
        _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
        _item.setAddedDate(_tmpAddedDate);
        final boolean _tmpIsSynced;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSynced);
        _tmpIsSynced = _tmp != 0;
        _item.setSynced(_tmpIsSynced);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getTotalCount() {
    final String _sql = "SELECT COUNT(*) FROM caps";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCountByCategory(final String category) {
    final String _sql = "SELECT COUNT(*) FROM caps WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCountByRarity(final String rarity) {
    final String _sql = "SELECT COUNT(*) FROM caps WHERE rarity = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rarity == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rarity);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getCategories() {
    final String _sql = "SELECT DISTINCT category FROM caps";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getRarities() {
    final String _sql = "SELECT DISTINCT rarity FROM caps";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CapEntity> getUnsyncedCaps() {
    final String _sql = "SELECT * FROM caps WHERE is_synced = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_path");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfFoundDate = CursorUtil.getColumnIndexOrThrow(_cursor, "found_date");
      final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_date");
      final int _cursorIndexOfIsSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "is_synced");
      final List<CapEntity> _result = new ArrayList<CapEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final CapEntity _item;
        _item = new CapEntity();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpPhotoPath;
        if (_cursor.isNull(_cursorIndexOfPhotoPath)) {
          _tmpPhotoPath = null;
        } else {
          _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        }
        _item.setPhotoPath(_tmpPhotoPath);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.setCategory(_tmpCategory);
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        _item.setCountry(_tmpCountry);
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _item.setCity(_tmpCity);
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        _item.setRarity(_tmpRarity);
        final String _tmpTags;
        if (_cursor.isNull(_cursorIndexOfTags)) {
          _tmpTags = null;
        } else {
          _tmpTags = _cursor.getString(_cursorIndexOfTags);
        }
        _item.setTags(_tmpTags);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final Double _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        }
        _item.setLongitude(_tmpLongitude);
        final long _tmpFoundDate;
        _tmpFoundDate = _cursor.getLong(_cursorIndexOfFoundDate);
        _item.setFoundDate(_tmpFoundDate);
        final long _tmpAddedDate;
        _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
        _item.setAddedDate(_tmpAddedDate);
        final boolean _tmpIsSynced;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSynced);
        _tmpIsSynced = _tmp != 0;
        _item.setSynced(_tmpIsSynced);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
