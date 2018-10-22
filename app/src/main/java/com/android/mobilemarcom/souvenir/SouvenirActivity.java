package com.android.mobilemarcom.souvenir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.SouvenirListAdapter;
import com.android.mobilemarcom.model.ModelSouvenir;

import java.util.ArrayList;
import java.util.List;

public class SouvenirActivity extends Activity {
    private Context context = this;
    private RecyclerView recyclerList;
    private SouvenirListAdapter adapterSouvenir;
    private List<ModelSouvenir> listSouvenir = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir);

        recyclerList = (RecyclerView) findViewById(R.id.recycler_souvenir);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(layoutManager);
        tampilkanListSouvenir();
        addDummyList();
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
            adapterSouvenir = new SouvenirListAdapter(context, listSouvenir);
            recyclerList.setAdapter(adapterSouvenir);
        }
        adapterSouvenir.notifyDataSetChanged();
    }

}
