package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String val = getIntent().getStringExtra("counter");
        TextView tekstview = findViewById(R.id.textView8);
        tekstview.setText(val);

        Button activity1Button = findViewById(R.id.button4);
        Button activity2Button = findViewById(R.id.button5);

        activity1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity1();
            }
        });

        activity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity2();
            }
        });

        View layout = findViewById(R.id.main);
        if (layout != null) {
            layout.setOnTouchListener(new OnSwipeTouchListener(this) {
                @Override
                public void onSwipeLeft() {
                    goToActivity1();
                }

                @Override
                public void onSwipeRight() {
                    goToActivity2();
                }
            });
        }
    }

    private void goToActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    private void goToActivity2() {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        TextView text = findViewById(R.id.textView8);
        intent.putExtra("counter",text.getText().toString());
        startActivity(intent);
    }
}