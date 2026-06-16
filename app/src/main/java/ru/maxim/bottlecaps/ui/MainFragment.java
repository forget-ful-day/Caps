package ru.maxim.bottlecaps.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.maxim.bottlecaps.databinding.FragmentMainBinding;
import ru.maxim.bottlecaps.viewmodel.CapViewModel;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private CapViewModel capViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        capViewModel = new androidx.lifecycle.ViewModelProvider(this).get(CapViewModel.class);

        binding.recyclerViewCaps.setLayoutManager(new LinearLayoutManager(requireContext()));
        
        capViewModel.getAllCaps().observe(getViewLifecycleOwner(), this::updateCaps);
    }

    private void updateCaps(List<CapEntity> caps) {
        // Update UI with caps
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
