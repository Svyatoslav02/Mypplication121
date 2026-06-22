package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> students;
    private RecyclerView studentsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        studentsRecycleView = findViewById(R.id.studentsRecyclerView);

        students = new ArrayList<>();
        students.add(new Student("Mark","mark@gmail.com", "pv512"));
        students.add(new Student("Alice","Alice@gmail.com", "pv512"));
        students.add(new Student("Bob","mbob@gmail.com", "pv512"));
        students.add(new Student("Qw","qw@gmail.com", "pv512"));

        StudentAdapter adapter = new StudentAdapter(this,students);
        studentsRecycleView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}