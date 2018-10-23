package com.android.mobilemarcom.employee;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.mobilemarcom.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class EmployeeTable extends AppCompatActivity {
    private Button buttonSearchName;
    private android.support.v7.widget.Toolbar toolbar;
    private TableView tableView;
    private ImageView test;
    String[][] employeeData={
            {"01.01.01","nama","pt abc","aktif"},
            {"02.02.02","ini nama","pt abc","aktif"},
            {"03.03.03","bukan nama","pt abc","aktif"},
            {"04.04.04","siapa","pt abc","aktif"},
            {"05.05.05","apa","pt abc","aktif"},
            {"06.06.06","nama apa","pt abc","aktif"},

    };
    static String[] employeeHeader={"ID","FULLNAME","COMPANY","STATUS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        test = (ImageView) findViewById(R.id.test);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        buttonSearchName = (Button) findViewById(R.id.buttonSearchName);
//        buttonSearchName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tableView.setDataAdapter(new SimpleTableDataAdapter(EmployeeTable.this, spaceProbes));
//            }
//        });
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        final TableView<String[]> tableView = (TableView<String[]>) findViewById(R.id.tableView);
//        tableView = (TableView) findViewById(R.id.tableView);
        tableView.setHeaderBackgroundColor(Color.parseColor("#2ECC71"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, employeeHeader));
        tableView.setColumnCount(5);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableView.setDataAdapter(new SimpleTableDataAdapter(EmployeeTable.this, employeeData));
            }
        });
        tableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(EmployeeTable.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }
}
