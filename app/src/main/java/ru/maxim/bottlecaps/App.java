package ru.maxim.bottlecaps;

import android.app.Application;

import ru.maxim.bottlecaps.database.AppDatabase;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.getInstance(this);
    }
}
