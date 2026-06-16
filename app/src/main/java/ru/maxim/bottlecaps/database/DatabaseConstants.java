package ru.maxim.bottlecaps.database;

public class DatabaseConstants {

    // Категории крышек
    public static final String CATEGORY_PIVNAYA = "Пивная";
    public static final String CATEGORY_LEMONADNAYA = "Лимонадная";
    public static final String CATEGORY_ENERGETICHESKAYA = "Энергетическая";
    public static final String CATEGORY_CHAINAYA = "Чайная";
    public static final String CATEGORY_DRUGOE = "Другое";

    public static final String[] ALL_CATEGORIES = {
            CATEGORY_PIVNAYA,
            CATEGORY_LEMONADNAYA,
            CATEGORY_ENERGETICHESKAYA,
            CATEGORY_CHAINAYA,
            CATEGORY_DRUGOE
    };

    // Редкости крышек
    public static final String RARITY_OBYCHNAYA = "Обычная";
    public static final String RARITY_REDKAYA = "Редкая";
    public static final String RARITY_UNIKALNAYA = "Уникальная";

    public static final String[] ALL_RARITIES = {
            RARITY_OBYCHNAYA,
            RARITY_REDKAYA,
            RARITY_UNIKALNAYA
    };
}
