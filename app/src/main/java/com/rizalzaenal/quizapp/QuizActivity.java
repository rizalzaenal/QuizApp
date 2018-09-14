package com.rizalzaenal.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    EditText editTextAnswer1;
    EditText editTextAnswer3;
    RadioGroup radioGroupAnswer2;
    RadioButton radioButtonAnswer2;
    CheckBox checkBoxAnswer4a;
    CheckBox checkBoxAnswer4;
    CheckBox checkBoxAnswer5;
    CheckBox checkBoxAnswer5a;
    Button buttonCheck;
    private int rightAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        bindView();

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResult();
            }
        });


    }

    private void bindView() {
        editTextAnswer1 = findViewById(R.id.et_answer1);
        editTextAnswer3 = findViewById(R.id.et_answer3);
        radioGroupAnswer2 = findViewById(R.id.radiogroup_answer2);
        radioButtonAnswer2 = findViewById(R.id.radio_answer2);
        checkBoxAnswer4 = findViewById(R.id.cb_answer4);
        checkBoxAnswer4a = findViewById(R.id.cb_answer4a);
        checkBoxAnswer5 = findViewById(R.id.cb_answer5);
        checkBoxAnswer5a = findViewById(R.id.cb_Asnwer5a);
        buttonCheck = findViewById(R.id.btn_check);
    }

    private void checkResult() {
        if (editTextAnswer1.getText().toString().equalsIgnoreCase(getString(R.string.answer1))) {
            rightAnswerCount++;
        }

        int radioChecked = radioGroupAnswer2.getCheckedRadioButtonId();

        if (radioChecked == R.id.radio_answer2) {
            rightAnswerCount++;
        }

        if (editTextAnswer3.getText().toString().equalsIgnoreCase(getString(R.string.answer3))) {
            rightAnswerCount++;
        }

        if (checkBoxAnswer4.isChecked() && checkBoxAnswer4a.isChecked()) {
            rightAnswerCount++;
        }

        if (checkBoxAnswer5.isChecked() && checkBoxAnswer5a.isChecked()) {
            rightAnswerCount++;
        }

        Toast.makeText(this, "You got " + rightAnswerCount + " right answer!", Toast.LENGTH_SHORT).show();

        rightAnswerCount = 0;

    }
}
