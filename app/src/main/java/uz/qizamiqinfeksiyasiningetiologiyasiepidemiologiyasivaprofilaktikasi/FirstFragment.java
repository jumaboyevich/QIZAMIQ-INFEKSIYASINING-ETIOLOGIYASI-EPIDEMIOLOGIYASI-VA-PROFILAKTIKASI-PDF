package uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class FirstFragment extends Fragment {

  TextView btn_kirish;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_kirish=view.findViewById(R.id.btn_kirish);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        btn_kirish.setOnClickListener(v -> navController.navigate(R.id.action_firstFragment_to_mainFragment));
    }
}