package com.example.testtwo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//int count = 0;
//private Button loginButton,logOutButton;
//private TextView textView;

    private EditText editText1,editText2;
    private Button addButton, subButton;
    private TextView resultTextView;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText1 = findViewById(R.id.editText1Id);
        editText2 = findViewById(R.id.editText2Id);
        addButton = findViewById(R.id.addButtonId);
        subButton = findViewById(R.id.subButtonId);
        resultTextView = findViewById(R.id.resultTextView);


        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);



//       loginButton = findViewById(R.id.loginButtonId);
//       logOutButton = findViewById(R.id.logoutButton);
//        textView = findViewById(R.id.textViewId);
//
//        logOutButton.setOnClickListener(this);
//        loginButton.setOnClickListener(this);

//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                count++;
////                textView.setText("Login button is clicked "+ count + " times");
//                textView.setText("Login button is clicked!");
//            }
//        });
//        logOutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Logout Button is clicked!");
//            }
//        });

    }

    @Override
    public void onClick(View view) {

        try {
            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();
            //converting into double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if (view.getId()==R.id.addButtonId){
                double sum = num1+num2;
                resultTextView.setText("Result : " + sum);

            }
            if (view.getId()==R.id.subButtonId){
                double sub = num1-num2;
                resultTextView.setText("Result : " + sub);
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Please Enter Number", Toast.LENGTH_SHORT).show();
        }




    }

//    @Override
//    public void onClick(View view) {
//
//        if (view.getId() == R.id.loginButtonId){
////            textView.setText("Login Button is clicked!");
//            Toast.makeText(MainActivity.this, "Login Button is clicked",Toast.LENGTH_SHORT).show();
//
//        }
//        if (view.getId() == R.id.logoutButton){
////            textView.setText("Logout Button is clicked!");
//            Toast.makeText(MainActivity.this, "Logout Button is Clicked!", Toast.LENGTH_SHORT).show();
//        }


//    }
}