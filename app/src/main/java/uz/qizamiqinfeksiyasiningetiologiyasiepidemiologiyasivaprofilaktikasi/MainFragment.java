package uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi.adapters.ListAdapter;
import uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi.adapters.ThemeAdapter;
import uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi.notes.ListNote;
import uz.qizamiqinfeksiyasiningetiologiyasiepidemiologiyasivaprofilaktikasi.notes.ThemeNote;


public class MainFragment extends Fragment implements ThemeAdapter.ItemClickListener {


    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);


        List<ListNote> listNoteList = new ArrayList<>();
        List<ThemeNote> themeNoteList = new ArrayList<>();
        themeNoteList.add(new ThemeNote("Qizamiq,   Qizamiqning tarqalganligi", new int[]{4,5,6,7,8}));
        themeNoteList.add(new ThemeNote("Epidemiologiyasi", new int[]{8,9,10}));
        themeNoteList.add(new ThemeNote("Patogenezi", new int[]{11}));
        themeNoteList.add(new ThemeNote("Kasallanish holatining standart ta’rifi", new int[]{11,12}));
        themeNoteList.add(new ThemeNote("Klinikasi", new int[]{12,13,14,15,16,17}));
        themeNoteList.add(new ThemeNote("Asoratlari", new int[]{17,18}));
        themeNoteList.add(new ThemeNote("Diagnostikasi", new int[]{18,19}));
        themeNoteList.add(new ThemeNote("Profilaktikasi", new int[]{19,20,21,22}));
        themeNoteList.add(new ThemeNote("Epidemiologik  nazorati", new int[]{22, 23}));
        themeNoteList.add(new ThemeNote("Laboratoriya diagnostikasi uchun namunalarni olish, saqlash va yetkazish tartibi", new int[]{23, 24,25,26}));
        themeNoteList.add(new ThemeNote("\"Qizamiq infektsiyasi\" mavzusidagi testlar", new int[]{26,27, 28,29,30,31,32,33,34}));
        themeNoteList.add(new ThemeNote("Foydalanilgan adabiyotlar", new int[]{35,36}));
        listNoteList.add(new ListNote("Mundarija", themeNoteList));


        RecyclerView recyclerView = view.findViewById(R.id.list_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ListAdapter adapter = new ListAdapter(requireActivity(), listNoteList, this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(ThemeNote themeNote) {
        Bundle bundle = new Bundle();
        bundle.putString("title", themeNote.getTitle());
        bundle.putString("data", Arrays.toString(themeNote.getPages()));


        navController.navigate(R.id.action_mainFragment_to_pdfFragment, bundle);
    }

}