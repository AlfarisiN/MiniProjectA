package com.android.mobilemarcom.employee;

<<<<<<< HEAD
=======
import android.app.ProgressDialog;
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
=======
import android.support.v7.widget.LinearLayoutManager;
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
<<<<<<< HEAD

import com.android.mobilemarcom.R;
=======
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.utility.LoadingClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d

public class EmployeeActivity extends Fragment {
    private RecyclerView recyclerEmployee;
    private EditText nameSearch;
    private Button buttonSearchName;
    private ImageView option;
<<<<<<< HEAD
=======
    private List<String> stringList = new ArrayList<>();
    private RequestAPIServices2 apiServices2;
    private boolean isStillLoading = false;
    private int pageCount = 1;
    private int totalPageCount = 1;
    private List<Datum> listUser = new ArrayList<>();

>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d

    public EmployeeActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_employee, container, false);

<<<<<<< HEAD
=======
        recyclerEmployee = (RecyclerView) view.findViewById(R.id.recyclerEmployee);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerEmployee.setLayoutManager(layoutManager);
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d
        nameSearch = (EditText) view.findViewById(R.id.nameSearch);
        buttonSearchName = (Button) view.findViewById(R.id.buttonSearchName);
        buttonSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD

=======
                cariData(pageCount);
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d
            }
        });
        return view;
    }
<<<<<<< HEAD
=======
    public void cariData(int page){
        final ProgressDialog loading = LoadingClass.loadingAnimationAndText(getContext(), "Sedang Memuat... " + page);
        loading.show();
        isStillLoading =true;
        apiServices2 = EmployeeAPI.getAPIServices2();
        apiServices2.getListUser(page).enqueue(new Callback<ModelEmployee>() {
            @Override
            public void onResponse(Call<ModelEmployee> call, Response<ModelEmployee> response) {
                loading.dismiss();
                isStillLoading =false;
                if (response.code() == 200) {
                    if (listUser.size() == 0) {
                        //listUser = response.body().getData();
                        List<Datum> tmp = response.body().getData();
                        for (int n = 0; n < tmp.size(); n++) {
                            Datum data = tmp.get(n);
                            listUser.add(data);
                        }
                        totalPageCount = response.body().getTotalPages();
                    } else {
                        List<Datum> tmp = response.body().getData();
                        for (int n = 0; n < tmp.size(); n++) {
                            Datum data = tmp.get(n);
                            listUser.add(data);
                        }
                    }
                    if (listUser.size() > 0) {
                        tampilkanListUser();
                    } else {

                    }


                } else {
                    Toast.makeText(getContext(), "List User Gagal: " + response.code() + " msg: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelEmployee> call, Throwable t) {
                loading.dismiss();
                isStillLoading =false;
                Toast.makeText(getContext(), "List User onFailure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void tampilkanListUser() {
//        if (userListAdapter == null) {
//            userListAdapter = new UserListAdapter(getContext(), listUser);
//            recyclerList.setAdapter(userListAdapter);
//
//            loadMorePaging();
//        }
//
//        userListAdapter.notifyDataSetChanged();
    }
//    public void isiListData(){
//
//    }
>>>>>>> 979e8dbddc9d12be883b951ed18a31dbf3996a4d
}

