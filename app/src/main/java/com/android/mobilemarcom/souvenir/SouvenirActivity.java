package com.android.mobilemarcom.souvenir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_souvenir,container,false);
        recyclerList = (RecyclerView) view.findViewById(R.id.recycler_souvenir);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(layoutManager);
        addDummyList();
        tampilkanListSouvenir();
        return view;

    }

    private void addDummyList() {
        int index = 1;
        for (int i = 0; i < 5; i++) {
            ModelSouvenir data = new ModelSouvenir();
            data.setCode_souvenir("S000" + index);
            data.setName_souvenir("Dummy Major");
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
