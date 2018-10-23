package com.android.mobilemarcom.t_souvenir;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.SouvenirStokAdapter;
import com.android.mobilemarcom.model.ModelSouvenir.SouvenirList;
import com.android.mobilemarcom.model.ModelSouvenirStok.SouvenirStokList;

import java.util.ArrayList;
import java.util.List;

public class SouvenirStokFragment extends android.support.v4.app.Fragment {
    private RecyclerView recycler_t_souvenir_stok;
    private EditText search_t_souvenir;
    private SouvenirStokAdapter adapterSouvenirStok;
    private List<SouvenirStokList> listSouvenirStok = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_t_souvenir_stok
                ,container,false);
        recycler_t_souvenir_stok = (RecyclerView) view.findViewById(R.id.recycler_t_souvenir_stok);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recycler_t_souvenir_stok.setLayoutManager(layoutManager);

        search_t_souvenir = (EditText) view.findViewById(R.id.search_t_souvenir);
        recycler_t_souvenir_stok.setVisibility(View.INVISIBLE);
        search_t_souvenir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(search_t_souvenir.getText().toString().trim().length() == 0){
                    recycler_t_souvenir_stok.setVisibility(View.INVISIBLE);
                } else {
                    recycler_t_souvenir_stok.setVisibility(View.VISIBLE);

                }
            }
        });

        return view;
    }

    private void filter(String text){
        ArrayList<SouvenirStokList> filteredList = new ArrayList<>();
        for (SouvenirStokList item : listSouvenirStok){
            if (item.getReceived_by().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapterSouvenirStok.filterList(filteredList);
    }

    public void tampilkanListSouvenirStok(){

    }
    private void addDummyList() {
        int index = 1;
        for (int i = 0; i < 10; i++) {
            SouvenirStokList data = new SouvenirStokList();
            data.setCode("S000" + index);
            data.setReceived_date("01"+ index + "2005" );
            data.setReceived_by("01"+ index + "2005" );
            data.setNotes("Dummy Aktif");
            listSouvenirStok.add(data);
            index++;
        }
    }
}
