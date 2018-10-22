package com.android.mobilemarcom.souvenir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.SouvenirListAdapter;
import com.android.mobilemarcom.model.ModelSouvenir;

import java.util.ArrayList;
import java.util.List;



public class SouvenirActivity extends Fragment {
    private RecyclerView recyclerList;
    private SouvenirListAdapter adapterSouvenir;
    private List<ModelSouvenir> listSouvenir = new ArrayList<>();

    //AutoComplete Search
    public EditText searchSouvenir;

    // ListArray of Sugesstion need to Load data from API
    private static final Integer[] employees = new Integer[] {1,2,3,4,5};
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_souvenir,container,false);
        recyclerList = (RecyclerView) view.findViewById(R.id.recycler_souvenir);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(layoutManager);
        searchSouvenir = (EditText) view.findViewById(R.id.search_souvenir);
        recyclerList.setVisibility(View.INVISIBLE);
        searchSouvenir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (searchSouvenir.getText().toString().trim().length() == 0){
                    recyclerList.setVisibility(View.INVISIBLE);
                } else {
                    recyclerList.setVisibility(View.VISIBLE);
                    filter(toString());
                }
            }
        });

        addDummyList();
        tampilkanListSouvenir();
        return view;

    }

    private void filter(String text){
        ArrayList<ModelSouvenir> filteredList = new ArrayList<>();
        for (ModelSouvenir item : listSouvenir){
            if (item.getName_souvenir().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapterSouvenir.filterList(filteredList);
    }

    private void addDummyList() {
        int index = 1;
        for (int i = 0; i < 20; i++) {
            ModelSouvenir data = new ModelSouvenir();
            data.setCode_souvenir("S000" + index);
            data.setName_souvenir("Dummy Major" + index);
            data.setQuantity("Dummy Quantity");
            data.setStatus("Dummy Aktif");
            listSouvenir.add(data);
            index++;
        }
    }
    private void tampilkanListSouvenir(){
        if(adapterSouvenir == null){
            adapterSouvenir = new SouvenirListAdapter(getContext(), listSouvenir);
            recyclerList.setAdapter(adapterSouvenir);
        }
        adapterSouvenir.notifyDataSetChanged();
    }

}
