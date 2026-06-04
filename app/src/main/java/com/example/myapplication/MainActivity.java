package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button SubmitButton = findViewById(R.id.button);
        EditText EmailText = findViewById(R.id.editTextTextEmailAddress);
        EditText NameText = findViewById(R.id.editTextText);
        EditText AgeText = findViewById(R.id.editTextNumber);

        SubmitButton.setOnClickListener( obj -> {
            if(UtilityFunctions.TextFieldIsEmpty(EmailText) || UtilityFunctions.TextFieldIsEmpty(NameText)
            || UtilityFunctions.TextFieldIsEmpty(AgeText))
            {
                return;
            }
            Student student = new Student(NameText.toString(), Integer.parseInt(AgeText.toString()), EmailText.toString());
            System.out.println(student.toString());
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}