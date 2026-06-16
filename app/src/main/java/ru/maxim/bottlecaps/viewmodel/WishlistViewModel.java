package ru.maxim.bottlecaps.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.maxim.bottlecaps.database.AppDatabase;
import ru.maxim.bottlecaps.database.entity.WishlistEntity;
import ru.maxim.bottlecaps.database.repository.WishlistRepository;

public class WishlistViewModel extends AndroidViewModel {

    private final WishlistRepository wishlistRepository;
    private final LiveData<List<WishlistEntity>> allWishlists;

    public WishlistViewModel(@NonNull Application application) {
        super(application);
        wishlistRepository = new WishlistRepository(application);
        allWishlists = wishlistRepository.getAllWishlists();
    }

    public void insertWishlist(WishlistEntity wish) {
        wishlistRepository.insertWishlist(wish);
    }

    public void updateWishlist(WishlistEntity wish) {
        wishlistRepository.updateWishlist(wish);
    }

    public void deleteWishlist(WishlistEntity wish) {
        wishlistRepository.deleteWishlist(wish);
    }

    public LiveData<List<WishlistEntity>> getAllWishlists() {
        return allWishlists;
    }

    public WishlistEntity getWishlistById(Long wishId) {
        return wishlistRepository.getWishlistById(wishId);
    }

    public LiveData<Integer> getTotalWishlistsCount() {
        return wishlistRepository.getTotalWishlistsCount();
    }

    public WishlistEntity getLatestWishlist() {
        return wishlistRepository.getLatestWishlist();
    }
}
