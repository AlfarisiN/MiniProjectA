package com.android.mobilemarcom.employee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.mobilemarcom.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends Fragment {
    private RecyclerView recyclerEmployee;
    private EditText nameSearch;
    private Button buttonSearchName;
    private ImageView option;
    private List<String> stringList = new ArrayList<>();

    public EmployeeActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_employee, container, false);

        recyclerEmployee = (RecyclerView) view.findViewById(R.id.recyclerEmployee);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerEmployee.setLayoutManager(layoutManager);
        nameSearch = (EditText) view.findViewById(R.id.nameSearch);
        buttonSearchName = (Button) view.findViewById(R.id.buttonSearchName);
        buttonSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cariData();
            }
        });
        return view;
    }
    public void cariData(){
        isiListData();
    }
    public void isiListData(){

    }
}

