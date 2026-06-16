package ru.maxim.bottlecaps.database;

/**
 * Класс констант для базы данных.
 * Содержит стандартные значения категорий и редкостей крышек.
 */
public class DatabaseConstants {

    // Константы категорий крышек
    public static final String CATEGORY_PIVNAYA = "Пивная";
    public static final String CATEGORY_LEMONADNAYA = "Лимонадная";
    public static final String CATEGORY_ENERGETICHESKAYA = "Энергетическая";
    public static final String CATEGORY_CHAINAYA = "Чайная";
    public static final String CATEGORY_DRUGOE = "Другое";

    // Массив всех категорий для использования в UI (Spinner, etc.)
    public static final String[] ALL_CATEGORIES = {
            CATEGORY_PIVNAYA,
            CATEGORY_LEMONADNAYA,
            CATEGORY_ENERGETICHESKAYA,
            CATEGORY_CHAINAYA,
            CATEGORY_DRUGOE
    };

    // Константы редкостей крышек
    public static final String RARITY_OBYCHNAYA = "Обычная";
    public static final String RARITY_REDKAYA = "Редкая";
    public static final String RARITY_UNIKALNAYA = "Уникальная";

    // Массив всех редкостей для использования в UI (Spinner, etc.)
    public static final String[] ALL_RARITIES = {
            RARITY_OBYCHNAYA,
            RARITY_REDKAYA,
            RARITY_UNIKALNAYA
    };

    // Константы приоритетов для Wishlist
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_HIGH = 3;

    // Массив приоритетов
    public static final int[] ALL_PRIORITIES = {
            PRIORITY_LOW,
            PRIORITY_MEDIUM,
            PRIORITY_HIGH
    };
}
