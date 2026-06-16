# BottleCaps Database Repository

Это репозиторий базы данных для приложения "BottleCaps" - сбор и хранение данных о найденных крышках.

## Структура

```
app/src/main/java/ru/maxim/bottlecaps/database/
├── AppDatabase.java          # Главный класс БД с singleton
├── DatabaseConstants.java    # Константы категорий и редкостей
├── dao/
│   ├── CapDao.java           # DAO для крышек (15+ методов)
│   ├── WishlistDao.java      # DAO для вишлиста (10+ методов)
│   └── StatisticsDao.java    # DAO для статистики (10+ методов)
├── entity/
│   ├── CapEntity.java        # Сущность крышки
│   ├── WishlistEntity.java   # Сущность вишлиста
│   └── StatisticsEntity.java # Сущность статистики
└── repository/
    ├── CapRepository.java         # Репозиторий крышек
    ├── WishlistRepository.java    # Репозиторий вишлиста
    └── StatisticsRepository.java  # Репозиторий статистики
```

## Сущности

### CapEntity
```java
- id: Long
- name: String
- photoPath: String
- category: String (Пивная, Лимонадная, Энергетическая, Чайная, Другое)
- country: String
- city: String
- rarity: String (Обычная, Редкая, Уникальная)
- tags: String
- latitude: Double
- longitude: Double
- foundDate: Long (Unix timestamp)
- addedDate: Long (Unix timestamp)
- isSynced: Boolean
```

### WishlistEntity
```java
- id: Long
- name: String
- description: String
- priority: Int
- addedDate: Long (Unix timestamp)
```

### StatisticsEntity
```java
- id: Long
- totalCaps: Int
- totalPivnye: Int
- totalLimonye: Int
- totalEnergeticheskie: Int
- totalChainye: Int
- totalDrugie: Int
- totalRare: Int
- totalUnique: Int
- streakDays: Int
- lastUpdate: Long (Unix timestamp)
```

## Использование

```java
// Получение экземпляра БД
AppDatabase db = AppDatabase.getInstance(context);

// Работа с крышекми
CapEntity cap = new CapEntity(...);
db.capDao().insert(cap);

// Работа с вишлистом
WishlistEntity wish = new WishlistEntity(...);
db.wishlistDao().insert(wish);

// Работа со статистикой
StatisticsEntity stats = new StatisticsEntity(...);
db.statisticsDao().insert(stats);
```

## Особенности

- Room Persistence Library версия 2.6.1
- Использование Java (не Kotlin)
- Стандартные категории: "Пивная", "Лимонадная", "Энергетическая", "Чайная", "Другое"
- Стандартные редкости: "Обычная", "Редкая", "Уникальная"
- Все даты хранятся как Unix timestamp в миллисекундах
- Synchronized singleton паттерн для доступа к БД

## Лицензия

MIT
