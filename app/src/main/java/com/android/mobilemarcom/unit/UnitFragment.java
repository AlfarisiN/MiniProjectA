package com.android.mobilemarcom.unit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.UnitAdapter;
import com.android.mobilemarcom.model.ModelUnit;
import com.android.mobilemarcom.retrofit.APIUtilities;
import com.android.mobilemarcom.retrofit.RequestAPIServices;
import com.android.mobilemarcom.unit.modelunit.DataList;
import com.android.mobilemarcom.unit.modelunit.ModelUnitRetrofit;
import com.android.mobilemarcom.utility.LoadingClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitFragment extends Fragment {

    public static RecyclerView recyclerList;
    private static UnitAdapter adapterUnit;
    public List<DataList> listUnit = new ArrayList<>();

    private EditText searchUnit;
    private Button buttonUnitAdd;
    public static EditText unitAddName;
    public static EditText unitNotes;
    static Context context;

    static RequestAPIServices apiServices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit, container, false);

        final View dialogView = inflater.inflate(R.layout.dialog_add_unit,null,false);

        context=view.getContext();
        searchUnit = (EditText)view.findViewById(R.id.unitSearch);
        recyclerList = (RecyclerView)view.findViewById(R.id.recyclerUnit);
        buttonUnitAdd = (Button)view.findViewById(R.id.buttonAddUnit);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(layoutManager);

        buttonUnitAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                alertDialogAdd(dialogView);
            }
        });

        recyclerList.setVisibility(View.INVISIBLE);

        adapterUnit = new UnitAdapter(context,listUnit);
        recyclerList.setAdapter(adapterUnit);

        searchUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(searchUnit.getText().toString().isEmpty()){
                    recyclerList.setVisibility(View.INVISIBLE);
                }
                else{
                    recyclerList.setVisibility(View.VISIBLE);
                    filterUnit(s.toString());
                }

            }
        });

        return view;
    }

    public void filterUnit(String text){
        ArrayList<DataList> filterList = new ArrayList<>();

        for(DataList temp : listUnit){
            if(temp.getCode().toString().toLowerCase().contains(text.toLowerCase())){
                filterList.add(temp);
            }
        }

        searcUnit();
        adapterUnit.filterList(filterList);
    }

    public void alertDialogAdd(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View tempView = inflater.inflate(R.layout.dialog_add_unit,null);

        unitAddName = (EditText)tempView.findViewById(R.id.unitNameInput);
        unitNotes = (EditText)tempView.findViewById(R.id.unitInputNote);

        final DataList tempData = new DataList();
        String tempName = unitAddName.getText().toString();
        String tempStat = unitNotes.getText().toString();

        Random random = new Random();
        int tempRandomCode = random.nextInt(999)+1;
        int tempRandomID = random.nextInt(20)+1;

        tempData.setId(tempRandomID);
        tempData.setCode("UN"+tempRandomCode);
        tempData.setName(tempName);
        tempData.setDescription(tempStat);
        tempData.setIsDelete(false);

        builder.setCancelable(false);
        builder.setTitle("Masukkan Data Unit")
                .setView(tempView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listUnit.add(tempData);
                        addUnit(tempData);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Cancel",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                }).show();

        adapterUnit.notifyDataSetChanged();
    }

    public static void alertDialogUnitEdit(final DataList data){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
//        final DataList tempDataUnit = data;

        View tempView = inflater.inflate(R.layout.dialog_add_unit,null);

        unitAddName = (EditText)tempView.findViewById(R.id.unitNameInput);
        unitNotes = (EditText)tempView.findViewById(R.id.unitInputNote);

        unitAddName.setText("Null :(");
        unitNotes.setText(data.getDescription());

        builder.setCancelable(false);
        builder.setTitle("Masukkan Data Unit")
                .setView(tempView)
                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UnitAdapter.unitList.get(data.getId()-1).setName(unitAddName.getText().toString());
                        UnitAdapter.unitList.get(data.getId()-1).setDescription(unitNotes.getText().toString());
                        adapterUnit.notifyDataSetChanged();
                        Toast.makeText(context,"Data successfully updated",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Cancel",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                }).show();

        adapterUnit.notifyDataSetChanged();
    }

    public void addUnit(DataList dataList){
        apiServices = APIUtilities.getApiServeices();

        apiServices.createUnit("application/json",dataList)
                .enqueue(new Callback<ModelUnitRetrofit>() {
                    @Override
                    public void onResponse(Call<ModelUnitRetrofit> call, Response<ModelUnitRetrofit> response) {
                        if(response.code() == 201){
                            Toast.makeText(context,response.message(),Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelUnitRetrofit> call, Throwable t) {
                        Toast.makeText(context,"Add Unit Failure : "+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

    }

    public static void editUnit(DataList dataList){
        final ProgressDialog loading = LoadingClass.loadingAnimationAndText(context,"");
        loading.show();

        final DataList tempDataUnit = dataList;
        apiServices = APIUtilities.getApiServeices();

        alertDialogUnitEdit(tempDataUnit);

        apiServices.editUnit("application/json",APIUtilities.AUTHORIZATION_UNIT_EDIT,dataList)
                .enqueue(new Callback<ModelUnitRetrofit>() {
                    @Override
                    public void onResponse(Call<ModelUnitRetrofit> call, Response<ModelUnitRetrofit> response) {
                        loading.dismiss();
                        if(response.code() == 200){
                            Log.i("unitDatalist",response.body().getMessage());
                        }
                        else{
                            Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelUnitRetrofit> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(context,"Edit Unit Failure : "+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void deactiveUnit(DataList dataList){
        apiServices = APIUtilities.getApiServeices();

        apiServices.deactiveUnit("application/json",APIUtilities.AUTHORIZATION_UNIT_DEACTIVE,dataList.getId().toString())
                .enqueue(new Callback<ModelUnitRetrofit>() {
                    @Override
                    public void onResponse(Call<ModelUnitRetrofit> call, Response<ModelUnitRetrofit> response) {
                        if(response.code() == 200){
                            Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelUnitRetrofit> call, Throwable t) {
                        Toast.makeText(context,"Edit Unit Failure : "+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void searcUnit(){
        final ProgressDialog loading = LoadingClass.loadingAnimationAndText(context,"");
        loading.show();

        apiServices = APIUtilities.getApiServeices();

        apiServices.searchUnit(APIUtilities.AUTHORIZATION_UNIT_SEARCH,searchUnit.getText().toString())
                .enqueue(new Callback<ModelUnitRetrofit>() {
                    @Override
                    public void onResponse(Call<ModelUnitRetrofit> call, Response<ModelUnitRetrofit> response) {
                        loading.dismiss();

                        if(response.code()==200){
                            listUnit = response.body().getDataList();
                        }
                        else{
                            Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelUnitRetrofit> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(context,"Search Unit Failed",Toast.LENGTH_LONG).show();
                    }
                });
    }


}

