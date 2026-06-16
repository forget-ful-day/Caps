# BottleCaps Database

База данных для приложения "BottleCaps" - сбор и хранение крышек.

## Структура проекта

- `app/src/main/java/ru/maxim/bottlecaps/database/` - сущности, DAO и база данных
- `app/src/main/java/ru/maxim/bottlecaps/repository/` - репозитории
- `app/src/main/java/ru/maxim/bottlecaps/viewmodel/` - ViewModel

## Сущности базы данных

### CapEntity
- id, name, photoPath, category, country, city, rarity, tags, latitude, longitude, foundDate, addedDate, isSynced

### WishlistEntity  
- id, name, description, priority, addedDate

### StatisticsEntity
- id, totalCaps, totalPivnye, totalLimonye, totalEnergeticheskie, totalChainye, totalDrugie, totalRare, totalUnique, streakDays, lastUpdate

## Доступ к базе данных

Используйте `AppDatabase.getInstance()` для доступа к базе данных.

## Лицензия

MIT
