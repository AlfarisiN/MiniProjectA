package com.android.mobilemarcom.event;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.adapters.EventAdapter;
import com.android.mobilemarcom.adapters.UnitAdapter;
import com.android.mobilemarcom.model.ModelEvent;
import com.android.mobilemarcom.model.ModelUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irfan Naufal Ridi on 24/10/2018.
 */

public class EventFragment extends Fragment {

    private RecyclerView recyclerList;
    private EventAdapter adapterEvent;
    private List<ModelEvent> listEvent = new ArrayList<>();

    private EditText searchEvent;
    private Button buttonEventAdd;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        context = view.getContext();
        searchEvent = (EditText)view.findViewById(R.id.eventSearch);
        buttonEventAdd = (Button)view.findViewById(R.id.buttonAddEvent);

        buttonEventAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
