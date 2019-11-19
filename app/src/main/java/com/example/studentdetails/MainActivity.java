package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    RadioGroup rdoG;
    RadioButton rdoBtn;
    RadioButton rdoMale,rdoFemale,rdoOthers;
    Button btnSave;
    TextView tvOutput;

    private Spinner spinCountry;
    private AutoCompleteTextView Auto;
    private String[] Batch = {"22A","22B","22C"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinCountry = findViewById(R.id.sCountry);
        Auto = findViewById(R.id.actvBatch);
        etName = findViewById(R.id.etName);
        rdoG = findViewById(R.id.rdogrp);
        btnSave = findViewById(R.id.btnSave);
        tvOutput = findViewById(R.id.tvOutput);



        String countries[] = {"Nepal","India","China","UK","USA"};
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spinCountry.setAdapter(adapter);

        ArrayAdapter stringArray = new ArrayAdapter(
                this,
                android.R.layout.select_dialog_item,
                Batch
        );
        Auto.setAdapter(stringArray);
        Auto.setThreshold(1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etName.getText())){
                    etName.setError("Enter Name");
                    return;
                }

                String Name;

                Name = etName.getText().toString();

                String Text = spinCountry.getSelectedItem().toString();

                String Batch = Auto.getText().toString();

                int selectedId = rdoG.getCheckedRadioButtonId();

                rdoBtn = findViewById(selectedId);

                String value = rdoBtn.getText().toString();

                tvOutput.setText(Name);
                tvOutput.append(System.getProperty("line.separator"));
                tvOutput.append(value);
                tvOutput.append(System.getProperty("line.separator"));
                tvOutput.append(Text);
                tvOutput.append(System.getProperty("line.separator"));
                tvOutput.append(Batch);



            }
        });

    }
}
