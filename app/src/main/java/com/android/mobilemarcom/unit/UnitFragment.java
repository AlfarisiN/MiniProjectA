package com.android.mobilemarcom.unit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.UnitAdapter;
import com.android.mobilemarcom.model.ModelUnit;

import java.util.ArrayList;
import java.util.List;

public class UnitFragment extends Fragment {

    private RecyclerView recyclerList;
    private UnitAdapter adapterUnit;
    private List<ModelUnit> listUnit = new ArrayList<>();

    private EditText searchUnit;
    private Button buttonUnitAdd;
    public EditText unitAddName,unitNotes;
    Context context;

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

        listUnit.add(new ModelUnit("asd123","hmmm","asd","Kilograms"));

        adapterUnit = new UnitAdapter(context,listUnit);
        recyclerList.setAdapter(adapterUnit);

        return view;
    }

    public void alertDialogAdd(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View tempView = inflater.inflate(R.layout.dialog_add_unit,null);

        unitAddName = (EditText)tempView.findViewById(R.id.unitNameInput);
        unitNotes = (EditText)tempView.findViewById(R.id.unitInputNote);



        builder.setCancelable(false);
        builder.setTitle("Masukkan Data Unit")
                .setView(tempView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tempName = unitAddName.getText().toString();
                        String tempStat= unitNotes.getText().toString();

                        listUnit.add(new ModelUnit("asd111",tempName,"active",tempStat));
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

}
