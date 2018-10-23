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
import android.widget.SearchView;
import android.widget.TableRow;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.UsersAdapter;
import com.android.mobilemarcom.model.User;

import java.util.ArrayList;

public class UserActivity extends Fragment {
    private RecyclerView recyclerUser;
    private SearchView nameSearchUser;
    private TableRow rowlay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user,container,false);
        recyclerUser = (RecyclerView) view.findViewById(R.id.recyclerUser);
        nameSearchUser = (SearchView) view.findViewById(R.id.nameSearchUser);
        rowlay = (TableRow) view.findViewById(R.id.rowlay);

        rowlay.setVisibility(View.GONE);


        nameSearchUser.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(nameSearchUser.getQuery().length()==0){
                    rowlay.setVisibility(View.GONE);
                    recyclerUser.setVisibility(View.GONE);
                }else{
                    final UsersAdapter adapter=new UsersAdapter(getContext(),getUsers());
                    recyclerUser.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                            LinearLayout.VERTICAL, false);
                    recyclerUser.setLayoutManager(layoutManager);
                    adapter.getFilter().filter(newText);
                    rowlay.setVisibility(View.VISIBLE);
                    recyclerUser.setVisibility(View.VISIBLE);
                }
                return false;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });

        return view;
    }

    private ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setEmp_name("Isti Wiska");
        user.setUsername("istiwiska");
        user.setRole("Admin");
        user.setStatus("Aktif");
        users.add(user);

        user = new User();
        user.setId(2);
        user.setEmp_name("Bagus Sujiwo");
        user.setUsername("bagussujiwo");
        user.setRole("Secretaris");
        user.setStatus("Aktif");
        users.add(user);

        user = new User();
        user.setId(3);
        user.setEmp_name("Muhammad Ghozi");
        user.setUsername("muhammadghozi");
        user.setRole("Bendahara");
        user.setStatus("InAktif");
        users.add(user);

        user = new User();
        user.setId(4);
        user.setEmp_name("Bagus Sujiwo");
        user.setUsername("bagussujiwo");
        user.setRole("Secretaris");
        user.setStatus("Aktif");
        users.add(user);

        return users;


    }




}
