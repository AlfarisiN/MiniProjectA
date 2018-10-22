package com.android.mobilemarcom.user;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.UsersAdapter;

public class UserActivity extends Fragment {
    private RecyclerView recyclerUser;
    private UsersAdapter userListAdapter;
    private EditText nameSearch;
    private TableRow rowlay;
    private String[] EMP_NAMES = {
            "Isti Wiska",
            "Isti Wiska",
            "Isti Wiska"
    };
    private String[] USERNAME = {
            "IstiWiska",
            "IstiWiska",
            "IstiWiska"
    };
    private String[] ROLE = {
            "Admin",
            "Staff",
            "Staff"
    };
    private String[] STATUS = {
            "Aktif",
            "Inaktif",
            "Aktif"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user,container,false);
        recyclerUser = (RecyclerView) view.findViewById(R.id.recyclerUser);
        nameSearch = (EditText) view.findViewById(R.id.nameSearchUser);
        rowlay = (TableRow) view.findViewById(R.id.rowlay);

        rowlay.setVisibility(View.GONE);
        nameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowlay.setVisibility(View.VISIBLE);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                        LinearLayout.VERTICAL, false);
                recyclerUser.setLayoutManager(layoutManager);
                tampilkanListUser();
            }
        });



        return view;
    }


    private void tampilkanListUser(){
        if(userListAdapter == null){
            userListAdapter = new UsersAdapter(getContext(),EMP_NAMES,USERNAME,ROLE,STATUS);
            recyclerUser.setAdapter(userListAdapter);
        }

        userListAdapter.notifyDataSetChanged();
    }



}
