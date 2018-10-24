package com.android.mobilemarcom.souvenir;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.SouvenirAdapter;
<<<<<<< HEAD:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirActivity.java
import com.android.mobilemarcom.model.ModelSouvenir;
=======
import com.android.mobilemarcom.model.ModelSouvenir.SouvenirList;
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirFragment.java

import java.util.ArrayList;
import java.util.List;



public class SouvenirFragment extends Fragment {

    private RecyclerView recyclerList;
    private SouvenirAdapter adapterSouvenir;
<<<<<<< HEAD:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirActivity.java
    private List<ModelSouvenir> listSouvenir = new ArrayList<>();
=======
    private List<SouvenirList> listSouvenir = new ArrayList<>();
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirFragment.java
    private Button btn_add_souvenir;

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
                    filter(editable.toString());
                }
            }
        });

        btn_add_souvenir = (Button)view.findViewById(R.id.btn_add_souvenir);
        btn_add_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SouvenirDaftarActivity.class);
                startActivity(intent);
            }
        });

        tampilkanListSouvenir();
        return view;

    }

    private void filter(String text){
        ArrayList<SouvenirList> filteredList = new ArrayList<>();
        for (SouvenirList item : listSouvenir){
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapterSouvenir.filterList(filteredList);
    }


    private void tampilkanListSouvenir(){
        addDummyList();
        if(adapterSouvenir == null){
            adapterSouvenir = new SouvenirAdapter(getContext(), listSouvenir);
            recyclerList.setAdapter(adapterSouvenir);
        }
    }

    private void addDummyList() {
        int index = 1;
        for (int i = 0; i < 10; i++) {
<<<<<<< HEAD:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirActivity.java
            ModelSouvenir data = new ModelSouvenir();
            data.setCode_souvenir("S000" + index);
            data.setName_souvenir("Dummy Major" + index);
=======
            SouvenirList data = new SouvenirList();
            data.setCode("S000" + index);
            data.setName("Dummy Major" + index);
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07:app/src/main/java/com/android/mobilemarcom/souvenir/SouvenirFragment.java
            data.setQuantity("Dummy Quantity");
            data.setDescription("Dummy Aktif");
            listSouvenir.add(data);
            index++;
        }
    }

}
