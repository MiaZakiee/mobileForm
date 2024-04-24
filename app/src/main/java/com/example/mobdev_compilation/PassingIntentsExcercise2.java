package com.example.mobdev_compilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PassingIntentsExcercise2 extends AppCompatActivity {

    TextView tf [] = new TextView[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_excercise2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        int ctr = 1;
        for (int i = 0; i < 9; i++) {
            String id = "tf" + Integer.toString(ctr++);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            tf[i] = ((TextView) findViewById(resID));
        }

        Intent intent = getIntent();

        tf[0].setText(intent.getStringExtra("fname"));
        tf[1].setText(intent.getStringExtra("lname"));
        tf[2].setText(intent.getStringExtra("gender"));
        tf[3].setText(intent.getStringExtra("bday"));
        tf[4].setText(intent.getStringExtra("pnum"));
        tf[5].setText(intent.getStringExtra("eperson"));
        tf[6].setText(intent.getStringExtra("econtact"));
        tf[7].setText(intent.getStringExtra("program"));
        tf[8].setText(intent.getStringExtra("year"));

        Button back = (Button) findViewById(R.id.btnReturn);
        back.setOnClickListener(v -> {
            Intent intent1 = new Intent(
                    PassingIntentsExcercise2.this,
                    PassingIntentsExercise.class);
            startActivity(intent1);
        });
    }
}