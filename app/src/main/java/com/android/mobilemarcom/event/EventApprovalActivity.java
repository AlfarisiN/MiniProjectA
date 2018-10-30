package com.android.mobilemarcom.event;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobilemarcom.R;
import com.android.mobilemarcom.model.modelevent.DataList;
import com.android.mobilemarcom.model.modelevent.ModelEventRetrofit;
import com.android.mobilemarcom.retrofit.APIUtilities;
import com.android.mobilemarcom.retrofit.RequestAPIServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventApprovalActivity extends AppCompatActivity {

    final Context context = this;
    TextView textCode,textName,textPlace,textStartDate,textEndDate,textBudget,textNotes,textRequestedBy,textRequestDate,textStatus;
    AutoCompleteTextView inputAssignTo;
    Button buttonApprove,buttonReject,buttonCancel;
    Toolbar toolbar;

    RequestAPIServices apiServices;
    List<DataList> listAssign = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_approval);

        textCode = (TextView)findViewById(R.id.eventApprovalTextCode);
        textName = (TextView)findViewById(R.id.eventApprovalTextName);
        textPlace = (TextView)findViewById(R.id.eventApprovalTextPlace);
        textStartDate = (TextView)findViewById(R.id.eventApprovalTextStartDate);
        textEndDate = (TextView)findViewById(R.id.eventApprovalTextEndDate);
        textBudget = (TextView)findViewById(R.id.eventApprovalTextBudget);
        textNotes = (TextView)findViewById(R.id.eventApprovalTextNotes);
        textRequestedBy = (TextView)findViewById(R.id.eventApprovalTextRequestedBy);
        textRequestDate = (TextView)findViewById(R.id.eventApprovalTextRequestDate);
        textStatus = (TextView)findViewById(R.id.eventApprovalTextStatus);
        inputAssignTo = (AutoCompleteTextView) findViewById(R.id.eventApprovalAssignTo);
        buttonApprove = (Button)findViewById(R.id.eventApprovalButtonApprove);
        buttonReject = (Button)findViewById(R.id.eventApprovalButtonReject);
        buttonCancel = (Button)findViewById(R.id.eventApprovalButtonCancel);
        toolbar = (Toolbar)findViewById(R.id.eventApprovalToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event Approval");

        pushedButton();

        inputAssignTo.setThreshold(1);
        inputAssignTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                arrayAdapter = getEmailAddressAdapter(context,s.toString());

                inputAssignTo.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    private ArrayAdapter<String> getEmailAddressAdapter(Context context,String path) {

        eventAutoComplete(path);

        String[] addresses = new String[listAssign.size()];
        for (int i = 0; i < addresses.length; i++) {
            addresses[i] = listAssign.get(i).getId().toString();
        }

        return new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, addresses);
    }

    public void eventAutoComplete(String path){
        apiServices = APIUtilities.getApiServeices();

        if(inputAssignTo.getText() != null){
            apiServices.autoCompleteEvent(APIUtilities.AUTHORIZATION_UNIT_SEARCH,path)
                    .enqueue(new Callback<ModelEventRetrofit>() {
                        @Override
                        public void onResponse(Call<ModelEventRetrofit> call, Response<ModelEventRetrofit> response) {
                            List<DataList> tempUnitList;

                            if(listAssign.size() == 0) {
                                if(response.code()==200){
                                    listAssign = response.body().getDataList();
                                }
                            }
//                            else{
//                                tempUnitList = response.body().getDataList();
//                                for (int i = 0;i<response.body().getDataList().size();i++){
//                                    listAssign.add(tempUnitList.get(i));
//                                }
//                            }
                        }

                        @Override
                        public void onFailure(Call<ModelEventRetrofit> call, Throwable t) {

                        }
                    });
        }
    }

    public void eventRejection(){
        LinearLayout linearLayout = new LinearLayout(context);
        EditText rejectReason = new EditText(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(10,10,10,10);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        rejectReason.setHorizontallyScrolling(false);
        rejectReason.setMinHeight(3);
        rejectReason.setHint("Notes");
        linearLayout.setLayoutParams(params);
        linearLayout.addView(rejectReason);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle("Reject Reason")
                .setView(linearLayout)
                .setPositiveButton("Reject", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rejectMethod();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }

    public void rejectMethod(){
        apiServices = APIUtilities.getApiServeices();

        apiServices.rejectEvent(APIUtilities.CONTENT_HEADER,APIUtilities.AUTHORIZATION_UNIT_SEARCH,inputAssignTo.getText().toString())
                .enqueue(new Callback<ModelEventRetrofit>() {
                    @Override
                    public void onResponse(Call<ModelEventRetrofit> call, Response<ModelEventRetrofit> response) {
                        if(response.code() == 200){
                            Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelEventRetrofit> call, Throwable t) {
                        Toast.makeText(context,"Reject Event Failed",Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void pushedButton(){

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventRejection();
            }
        });
    }
}
