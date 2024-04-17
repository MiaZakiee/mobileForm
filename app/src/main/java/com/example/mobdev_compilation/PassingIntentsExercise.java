package com.example.mobdev_compilation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class PassingIntentsExercise extends AppCompatActivity {

    String[] yearLevel = {"1","2","3","4","5"};
    String[] programs = {"BSCS","BSIT","BSCPE","BSHM"};
//    List<EditText> fields = new ArrayList<>();
    EditText[] field = new EditText[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Spinner spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, yearLevel);
        spinnerYear.setAdapter(adapterYear);

        Spinner spinnerProgram = (Spinner) findViewById(R.id.spinnerProgram);
        ArrayAdapter<String> adapterProgram = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, programs);
        spinnerProgram.setAdapter(adapterProgram);

        int ctr = 1;
        for (int i = 0; i < 7; i++) {
            String id = "txt" + Integer.toString(ctr++);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            field[i] = ((EditText) findViewById(resID));
        }

        field[0].setTextColor(Color.GRAY);
        field[1].setTextColor(Color.GRAY);

        if (field[0].getText().equals("First Name")) {
            field[0].setOnClickListener(v -> {
                field[0].setTextColor(Color.BLACK);
                field[0].setText("");
            });
        }
        field[1].setOnClickListener(v -> {
            field[1].setTextColor(Color.BLACK);
            field[1].setText("");
        });

        Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

//        RESET BUTTONS
        btnClear.setOnClickListener(v -> {
            field[0].setTextColor(Color.GRAY);
            field[0].setText("First name");
            field[1].setTextColor(Color.GRAY);
            field[1].setText("Last name");
            for (EditText f : field) {
                f.setText("");
            }
        });
    }
}