package com.android.mobilemarcom.souvenir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mobilemarcom.R;

public class EditSouvenirActivity extends Activity {
    private Context context = this;
    private EditText edit_souvenir_name,edit_souvenir_notes;
    private AutoCompleteTextView edit_souvenir_unit;
    private Button btn_edit_souvenir_save, btn_edit_souvenir_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir_edit);

        edit_souvenir_name = (EditText) findViewById(R.id.edit_souvenir_name);
        edit_souvenir_notes = (EditText) findViewById(R.id.edit_souvenir_notes);
        edit_souvenir_unit = (AutoCompleteTextView) findViewById(R.id.edit_souvenir_unit);
        btn_edit_souvenir_save = (Button) findViewById(R.id.btn_edit_souvenir_save);
        btn_edit_souvenir_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Data successfully updated !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btn_edit_souvenir_cancel = (Button) findViewById(R.id.btn_edit_souvenir_cancel);
        btn_edit_souvenir_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
