package com.example.myintent2ndto1st;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
   ActivityResultLauncher launcher = registerForActivityResult(
           new ActivityResultContracts.StartActivityForResult(),
           result -> {
               if (result.getResultCode() == 1 && result.getData()!=null){
                   textView.setText(result.getData().getStringExtra("key"));
               }
           }
   );

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
        button = findViewById(R.id.button1Id);
        textView = findViewById(R.id.textViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch(new Intent(FirstActivity.this, SecondActivity.class));
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent,1);
            }
        });
    }




    
    /*তুমি এখানে launcher.launch(...) লিখছো কারণ —

launcher হলো সেই ActivityResultLauncher object,
যেটা তুমি registerForActivityResult() দিয়ে রেজিস্টার করেছো,
আর .launch(intent) মানে হলো:

"এই intent নিয়ে অন্য Activity চালাও, এবং সেই Activity শেষ হলে result আমাকে ফেরত দাও।"
📌 সহজভাবে —

পুরনো methodে: startActivityForResult(intent, requestCode); → result আসত onActivityResult() এ।

নতুন methodে: launcher.launch(intent); → result আসে তুমি registerForActivityResult() এ যেই callback দিয়েছো সেখানে।*/






//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
//        super.onActivityResult(requestCode, resultCode, data, caller);
//
//        if (requestCode==1){
//            String value = data.getStringExtra("key");
//            textView.setText(value);
//        }
//
//
//    }
}
//-------------------------------------------------------





/*what is the purpose of registerForActivityResult()
ChatGPT said:

registerForActivityResult() এর মূল উদ্দেশ্য হলো —
পুরনো startActivityForResult() এর জায়গায় নতুন, সহজ এবং lifecycle-aware উপায়ে অন্য Activity থেকে data (result) নেওয়া।

Purpose / কাজ

অন্য Activity ওপেন করা এবং রেজাল্ট ফেরত পাওয়া
যেমন – তুমি FirstActivity থেকে SecondActivity ওপেন করছো, আর SecondActivity কিছু data ফেরত পাঠাবে (যেমন নাম, ইমেইল ইত্যাদি)।

Deprecated API রিপ্লেস করা

startActivityForResult() আর onActivityResult() Android 11 (API 30) থেকে deprecated।

এর বদলে registerForActivityResult() + callback system ব্যবহার করা হয়।

Lifecycle-safe

পুরনো পদ্ধতিতে configuration change (যেমন স্ক্রিন ঘোরানো) হলে data হারিয়ে যেত।

নতুন পদ্ধতিতে Activity এবং Fragment-এর lifecycle অনুযায়ী safe থাকে।

Cleaner code

আগে আলাদা করে method override করতে হতো (onActivityResult()), এখন inline callback দিয়েই সব করা যায়।

Basic Workflow

তুমি একটি ActivityResultLauncher object তৈরি করো → যেখানে result আসবে সেই callback দিয়ে।

যখন দরকার, launcher.launch(intent) দিয়ে Activity চালু করো।

Activity শেষ হলে, result সেই callback এ চলে আসবে।*/