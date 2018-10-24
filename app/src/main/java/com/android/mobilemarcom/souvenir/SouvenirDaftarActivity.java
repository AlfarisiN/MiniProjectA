package com.android.mobilemarcom.souvenir;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
=======
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07
import android.widget.Toast;

import com.android.mobilemarcom.R;

public class SouvenirDaftarActivity extends Activity {
    private Context context = this;
<<<<<<< HEAD
    private EditText daftar_souvenir_name, daftar_souvenir_unit, daftar_souvenir_notes;
    private Button btn_daftar_souvenir_save, btn_daftar_souvenir_cancel;
=======
    private EditText daftar_souvenir_name, daftar_souvenir_notes;
    private AutoCompleteTextView daftar_souvenir_unit;
    private Button btn_daftar_souvenir_save, btn_daftar_souvenir_cancel;
    private String[] UNIT = {"20", "30", "50"};
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir_daftar);

        daftar_souvenir_name = (EditText) findViewById(R.id.daftar_souvenir_name);
<<<<<<< HEAD
        daftar_souvenir_unit = (EditText) findViewById(R.id.daftar_souvenir_unit);
        daftar_souvenir_notes = (EditText) findViewById(R.id.daftar_souvenir_notes);
        btn_daftar_souvenir_save = (Button) findViewById(R.id.btn_daftar_souvenir_save);
        btn_daftar_souvenir_cancel = (Button) findViewById(R.id.btn_daftar_souvenir_cancel);
        
=======
        daftar_souvenir_unit = (AutoCompleteTextView) findViewById(R.id.daftar_souvenir_unit);
        daftar_souvenir_notes = (EditText) findViewById(R.id.daftar_souvenir_notes);
        btn_daftar_souvenir_save = (Button) findViewById(R.id.btn_daftar_souvenir_save);
        btn_daftar_souvenir_cancel = (Button) findViewById(R.id.btn_daftar_souvenir_cancel);
        tampilkanAutoComplete();
>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07
        btn_daftar_souvenir_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiInput();
                finish();
            }
        });

<<<<<<< HEAD
    }
    
=======
        btn_daftar_souvenir_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void tampilkanAutoComplete(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.select_dialog_item,UNIT);
        daftar_souvenir_unit.setThreshold(1);
        daftar_souvenir_unit.setAdapter(adapter);
        daftar_souvenir_unit.setTextColor(Color.RED);
    }


>>>>>>> 5d4151802a82ed4af11b963c20140995aa0a1a07
    private void validasiInput(){
        if (daftar_souvenir_name.getText().toString().trim().length() == 0){
            Toast.makeText(context, "Name is not null!", Toast.LENGTH_SHORT).show();
        }  else {
            //logic insert buku ke database
            Toast.makeText(context, "Data successfully added !", Toast.LENGTH_SHORT).show();
        }
    }
}
