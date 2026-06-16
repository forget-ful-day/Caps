package ru.maxim.bottlecaps;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ru.maxim.bottlecaps.database.CapRepository;
import ru.maxim.bottlecaps.database.DatabaseConstants;
import ru.maxim.bottlecaps.database.entity.CapEntity;
import ru.maxim.bottlecaps.viewmodel.CapViewModel;

/**
 * Главная активность приложения BottleCaps.
 * Предоставляет интерфейс для добавления и просмотра крышек.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private CapViewModel capViewModel;
    private CapRepository capRepository;

    private EditText editName;
    private Spinner spinnerCategory;
    private Spinner spinnerRarity;
    private EditText editTags;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация ViewModel и Repository
        capViewModel = new CapViewModel(getApplication());
        capRepository = new CapRepository(this);

        // Инициализация UI элементов
        editName = findViewById(R.id.editName);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerRarity = findViewById(R.id.spinnerRarity);
        editTags = findViewById(R.id.editTags);
        buttonSave = findViewById(R.id.buttonSave);

        // Заполнение Spinner'ов значениями из констант
        initSpinners();

        // Настройка обработчика нажатия кнопки сохранения
        buttonSave.setOnClickListener(v -> onSaveClick());
    }

    /**
     * Инициализация Spinner'ов значениями из констант.
     */
    private void initSpinners() {
        // Для Spinner'ов в Android нужно создать ArrayAdapter
        // Это упрощенный пример - в реальном приложении используйте ArrayAdapter
        Log.d(TAG, "Categories: " + DatabaseConstants.CATEGORY_PIVNAYA + ", " + DatabaseConstants.CATEGORY_LEMONADNAYA);
        Log.d(TAG, "Rarities: " + DatabaseConstants.RARITY_OBYCHNAYA + ", " + DatabaseConstants.RARITY_REDKAYA);
    }

    /**
     * Обработчик нажатия кнопки сохранения.
     * Вставляет новую крышку в базу данных.
     */
    private void onSaveClick() {
        // Получение значений из UI элементов
        String name = editName.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();
        String rarity = spinnerRarity.getSelectedItem().toString();
        String tags = editTags.getText().toString().trim();

        // Валидация входных данных
        if (name.isEmpty()) {
            Toast.makeText(this, "Введите название крышки", Toast.LENGTH_SHORT).show();
            return;
        }

        if (category.isEmpty() || !isCategoryValid(category)) {
            Toast.makeText(this, "Выберите категорию", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rarity.isEmpty() || !isRarityValid(rarity)) {
            Toast.makeText(this, "Выберите редкость", Toast.LENGTH_SHORT).show();
            return;
        }

        // Создание объекта CapEntity
        CapEntity cap = new CapEntity(
                name,
                null, // photoPath (можно добавить позже)
                category,
                null, // country
                null, // city
                rarity,
                tags,
                null, // latitude
                null, // longitude
                System.currentTimeMillis(), // foundDate
                System.currentTimeMillis(), // addedDate
                false // isSynced
        );

        // Вставка крышки в базу данных через ViewModel (асинхронно)
        capViewModel.insert(cap);

        // Очистка UI элементов
        editName.getText().clear();
        editTags.getText().clear();

        // Отображение сообщения об успешном добавлении
        Toast.makeText(this, "Крышка добавлена!", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "Cap inserted: " + name);
    }

    /**
     * Проверка валидности категории.
     *
     * @param category название категории
     * @return true если категория валидна, false иначе
     */
    private boolean isCategoryValid(String category) {
        for (String validCategory : DatabaseConstants.ALL_CATEGORIES) {
            if (validCategory.equals(category)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка валидности редкости.
     *
     * @param rarity название редкости
     * @return true если редкость валидна, false иначе
     */
    private boolean isRarityValid(String rarity) {
        for (String validRarity : DatabaseConstants.ALL_RARITIES) {
            if (validRarity.equals(rarity)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Получение всех крышек из базы данных.
     * Этот метод используется для демонстрации работы с репозиторием.
     */
    private void loadCaps() {
        new Thread(() -> {
            List<CapEntity> caps = capRepository.getAllCaps();
            Log.d(TAG, "Total caps: " + caps.size());
            
            runOnUiThread(() -> {
                Toast.makeText(this, "Загружено крышек: " + caps.size(), Toast.LENGTH_SHORT).show();
            });
        }).start();
    }
}
