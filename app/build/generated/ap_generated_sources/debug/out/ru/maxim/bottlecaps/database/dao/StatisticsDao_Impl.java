package ru.maxim.bottlecaps.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import ru.maxim.bottlecaps.database.entity.StatisticsEntity;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StatisticsDao_Impl implements StatisticsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StatisticsEntity> __insertionAdapterOfStatisticsEntity;

  private final EntityDeletionOrUpdateAdapter<StatisticsEntity> __updateAdapterOfStatisticsEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTotalCaps;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCategoryCounts;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRareAndUniqueCounts;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStreak;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastUpdate;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFullStatistics;

  public StatisticsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStatisticsEntity = new EntityInsertionAdapter<StatisticsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `statistics` (`id`,`total_caps`,`total_pivnye`,`total_limonye`,`total_energeticheskie`,`total_chainye`,`total_drugie`,`total_rare`,`total_unique`,`streak_days`,`last_update`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final StatisticsEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTotalCaps());
        statement.bindLong(3, entity.getTotalPivnye());
        statement.bindLong(4, entity.getTotalLimonye());
        statement.bindLong(5, entity.getTotalEnergeticheskie());
        statement.bindLong(6, entity.getTotalChainye());
        statement.bindLong(7, entity.getTotalDrugie());
        statement.bindLong(8, entity.getTotalRare());
        statement.bindLong(9, entity.getTotalUnique());
        statement.bindLong(10, entity.getStreakDays());
        statement.bindLong(11, entity.getLastUpdate());
      }
    };
    this.__updateAdapterOfStatisticsEntity = new EntityDeletionOrUpdateAdapter<StatisticsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `statistics` SET `id` = ?,`total_caps` = ?,`total_pivnye` = ?,`total_limonye` = ?,`total_energeticheskie` = ?,`total_chainye` = ?,`total_drugie` = ?,`total_rare` = ?,`total_unique` = ?,`streak_days` = ?,`last_update` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final StatisticsEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTotalCaps());
        statement.bindLong(3, entity.getTotalPivnye());
        statement.bindLong(4, entity.getTotalLimonye());
        statement.bindLong(5, entity.getTotalEnergeticheskie());
        statement.bindLong(6, entity.getTotalChainye());
        statement.bindLong(7, entity.getTotalDrugie());
        statement.bindLong(8, entity.getTotalRare());
        statement.bindLong(9, entity.getTotalUnique());
        statement.bindLong(10, entity.getStreakDays());
        statement.bindLong(11, entity.getLastUpdate());
        statement.bindLong(12, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateTotalCaps = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET totalCaps = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCategoryCounts = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET totalPivnye = ?, totalLimonye = ?, totalEnergeticheskie = ?, totalChainye = ?, totalDrugie = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRareAndUniqueCounts = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET totalRare = ?, totalUnique = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStreak = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET streakDays = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastUpdate = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET lastUpdate = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFullStatistics = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE statistics SET totalCaps = ?, totalPivnye = ?, totalLimonye = ?, totalEnergeticheskie = ?, totalChainye = ?, totalDrugie = ?, totalRare = ?, totalUnique = ?, streakDays = ?, lastUpdate = ? WHERE id = 1";
        return _query;
      }
    };
  }

  @Override
  public void insert(final StatisticsEntity stats) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStatisticsEntity.insert(stats);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final StatisticsEntity stats) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfStatisticsEntity.handle(stats);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTotalCaps(final int total) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTotalCaps.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, total);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateTotalCaps.release(_stmt);
    }
  }

  @Override
  public void updateCategoryCounts(final int countPivnye, final int countLimonye,
      final int countEnergeticheskie, final int countChainye, final int countDrugie) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCategoryCounts.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, countPivnye);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, countLimonye);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, countEnergeticheskie);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, countChainye);
    _argIndex = 5;
    _stmt.bindLong(_argIndex, countDrugie);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateCategoryCounts.release(_stmt);
    }
  }

  @Override
  public void updateRareAndUniqueCounts(final int rare, final int unique) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRareAndUniqueCounts.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, rare);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, unique);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateRareAndUniqueCounts.release(_stmt);
    }
  }

  @Override
  public void updateStreak(final int streak) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStreak.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, streak);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateStreak.release(_stmt);
    }
  }

  @Override
  public void updateLastUpdate(final long lastUpdate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastUpdate.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, lastUpdate);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateLastUpdate.release(_stmt);
    }
  }

  @Override
  public void updateFullStatistics(final int totalCaps, final int totalPivnye,
      final int totalLimonye, final int totalEnergeticheskie, final int totalChainye,
      final int totalDrugie, final int totalRare, final int totalUnique, final int streakDays,
      final long lastUpdate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFullStatistics.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, totalCaps);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, totalPivnye);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, totalLimonye);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, totalEnergeticheskie);
    _argIndex = 5;
    _stmt.bindLong(_argIndex, totalChainye);
    _argIndex = 6;
    _stmt.bindLong(_argIndex, totalDrugie);
    _argIndex = 7;
    _stmt.bindLong(_argIndex, totalRare);
    _argIndex = 8;
    _stmt.bindLong(_argIndex, totalUnique);
    _argIndex = 9;
    _stmt.bindLong(_argIndex, streakDays);
    _argIndex = 10;
    _stmt.bindLong(_argIndex, lastUpdate);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateFullStatistics.release(_stmt);
    }
  }

  @Override
  public StatisticsEntity getStatistics() {
    final String _sql = "SELECT * FROM statistics WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTotalCaps = CursorUtil.getColumnIndexOrThrow(_cursor, "total_caps");
      final int _cursorIndexOfTotalPivnye = CursorUtil.getColumnIndexOrThrow(_cursor, "total_pivnye");
      final int _cursorIndexOfTotalLimonye = CursorUtil.getColumnIndexOrThrow(_cursor, "total_limonye");
      final int _cursorIndexOfTotalEnergeticheskie = CursorUtil.getColumnIndexOrThrow(_cursor, "total_energeticheskie");
      final int _cursorIndexOfTotalChainye = CursorUtil.getColumnIndexOrThrow(_cursor, "total_chainye");
      final int _cursorIndexOfTotalDrugie = CursorUtil.getColumnIndexOrThrow(_cursor, "total_drugie");
      final int _cursorIndexOfTotalRare = CursorUtil.getColumnIndexOrThrow(_cursor, "total_rare");
      final int _cursorIndexOfTotalUnique = CursorUtil.getColumnIndexOrThrow(_cursor, "total_unique");
      final int _cursorIndexOfStreakDays = CursorUtil.getColumnIndexOrThrow(_cursor, "streak_days");
      final int _cursorIndexOfLastUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_update");
      final StatisticsEntity _result;
      if (_cursor.moveToFirst()) {
        _result = new StatisticsEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final int _tmpTotalCaps;
        _tmpTotalCaps = _cursor.getInt(_cursorIndexOfTotalCaps);
        _result.setTotalCaps(_tmpTotalCaps);
        final int _tmpTotalPivnye;
        _tmpTotalPivnye = _cursor.getInt(_cursorIndexOfTotalPivnye);
        _result.setTotalPivnye(_tmpTotalPivnye);
        final int _tmpTotalLimonye;
        _tmpTotalLimonye = _cursor.getInt(_cursorIndexOfTotalLimonye);
        _result.setTotalLimonye(_tmpTotalLimonye);
        final int _tmpTotalEnergeticheskie;
        _tmpTotalEnergeticheskie = _cursor.getInt(_cursorIndexOfTotalEnergeticheskie);
        _result.setTotalEnergeticheskie(_tmpTotalEnergeticheskie);
        final int _tmpTotalChainye;
        _tmpTotalChainye = _cursor.getInt(_cursorIndexOfTotalChainye);
        _result.setTotalChainye(_tmpTotalChainye);
        final int _tmpTotalDrugie;
        _tmpTotalDrugie = _cursor.getInt(_cursorIndexOfTotalDrugie);
        _result.setTotalDrugie(_tmpTotalDrugie);
        final int _tmpTotalRare;
        _tmpTotalRare = _cursor.getInt(_cursorIndexOfTotalRare);
        _result.setTotalRare(_tmpTotalRare);
        final int _tmpTotalUnique;
        _tmpTotalUnique = _cursor.getInt(_cursorIndexOfTotalUnique);
        _result.setTotalUnique(_tmpTotalUnique);
        final int _tmpStreakDays;
        _tmpStreakDays = _cursor.getInt(_cursorIndexOfStreakDays);
        _result.setStreakDays(_tmpStreakDays);
        final long _tmpLastUpdate;
        _tmpLastUpdate = _cursor.getLong(_cursorIndexOfLastUpdate);
        _result.setLastUpdate(_tmpLastUpdate);
      } else {
        _result = null;
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
