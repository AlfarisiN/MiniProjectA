package com.android.mobilemarcom.employee;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends Fragment {
    private RecyclerView recyclerUser;
    private UsersAdapter userListAdapter;
    private List<String> stringList = new ArrayList<>();
    private DialogAutoComplete dialogChooseCompany;
    private EditText nameSearch;
    private Button buttonSearchName;
    private ImageView addData;
    private TableRow rowlay;
    private String[] ID = {
            "10.10.10",
            "20.20.20",
            "30.30.30"
    };
    private String[] FULLNAME = {
            "dfsf",
            "sdfdf",
            "dsfsdf"
    };
    private String[] COMPANY = {
            "pt abc",
            "pt abc",
            "pt abc"
    };
    private String[] STATUS = {
            "Aktif",
            "Inaktif",
            "Aktif"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_employee2,container,false);
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
        buttonSearchName = (Button) view.findViewById(R.id.buttonSearchName);
        buttonSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        addData = (ImageView) view.findViewById(R.id.addData);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInputCreateUser();
            }
        });

        return view;
    }

    private void tampilkanListUser(){
        if(userListAdapter == null){
            userListAdapter = new UsersAdapter(getContext(),ID,FULLNAME,COMPANY,STATUS);
            recyclerUser.setAdapter(userListAdapter);
        }

        userListAdapter.notifyDataSetChanged();
    }
    private void showInputCreateUser() {
        isiListCompany();
        final EditText id = new EditText(getContext());
        id.setHint("Id");
        final EditText fullname = new EditText(getContext());
        fullname.setHint("Fullname");
        final EditText company = new EditText(getContext());
        company.setHint("Company");
        company.setFocusable(false);
        company.setClickable(true);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stringList != null) {
                    dialogChooseCompany = new DialogAutoComplete(getContext(), stringList);
                    dialogChooseCompany.setDialogResult(new DialogAutoComplete.OnAutoCompleteResult() {
                        @Override
                        public void finish(String result) {
                            if (result != null) {
                                company.setText(result);
                            }
                        }
                    });
                }
            }
        });
        final EditText status = new EditText(getContext());
        status.setHint("Status");

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(id);
        layout.addView(fullname);
        layout.addView(company);
        layout.addView(status);
        layout.setPadding(10, 10, 10, 10);

        new AlertDialog.Builder(getContext())
                .setTitle("Input Data")
                .setMessage("Lengkapi Form Berikut")
                .setView(layout)
                .setPositiveButton("SEND", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Aksi jika SEND ditekan
                        Toast.makeText(getContext(), "tambah data sukses", Toast.LENGTH_SHORT).show();
//                        String tokenInput = token.getText().toString().trim();
//                        String clientIdInput = clientId.getText().toString().trim();
//                        String nameInput = name.getText().toString().trim();
//                        String jobInput = job.getText().toString().trim();

//                        panggilAPICreateNewUser(tokenInput, clientIdInput, nameInput, jobInput);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //Aksi jika CANCEL ditekan
                    }
                })
                .show();
    }
    private void isiListCompany(){
        stringList.add("PT ABC");
        stringList.add("PT ADAD");
        stringList.add("PT PT");
        stringList.add("PT AAA");
        stringList.add("PA TGB");
    }

}


