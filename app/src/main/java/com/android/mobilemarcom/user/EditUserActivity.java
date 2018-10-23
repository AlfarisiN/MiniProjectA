package com.android.mobilemarcom.user;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mobilemarcom.R;

public class EditUserActivity extends Activity {
    private Context context = this;
    private EditText etUsername,editText4,editText5;
    private Button button1,button2;
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView autoCompleteRole,autoCompleteEmploye;
    private String[] ROLE = {"Staff","Admin","Secretaris","Bendahara"};
    private String[] EMPLOYE = {"Isti Wiska","Muhammad Ghozi","Bagus Sujiwo","Ghina Maulia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        textInputLayout = (TextInputLayout) findViewById(R.id.username_text_input_layout);
        etUsername = (EditText) findViewById(R.id.etUsername);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        autoCompleteRole = (AutoCompleteTextView) findViewById(R.id.autoCompleteRole);
        autoCompleteEmploye = (AutoCompleteTextView) findViewById(R.id.autoCompleteEmploye);
        setupFloatingLabelError();
        tampil_auto_complete();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vallidasi();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void tampil_auto_complete(){
        //array ROLE
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.select_dialog_item,ROLE);
        autoCompleteRole.setThreshold(1);
        autoCompleteRole.setAdapter(adapter);
        autoCompleteRole.setTextColor(Color.RED);

        //array EMPLOYE
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context,android.R.layout.select_dialog_item,EMPLOYE);
        autoCompleteEmploye.setThreshold(1);
        autoCompleteEmploye.setAdapter(adapter1);
        autoCompleteEmploye.setTextColor(Color.RED);
    }

    private void setupFloatingLabelError() {
        etUsername.addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 4) {
                    textInputLayout.setError("Username tidak boleh ksosong");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void vallidasi(){
        if(autoCompleteRole.getText().toString().trim().length()==0){
            Toast.makeText(context,"Role tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }else if(autoCompleteEmploye.getText().toString().trim().length()==0){
            Toast.makeText(context,"Employe tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }
    }
}
