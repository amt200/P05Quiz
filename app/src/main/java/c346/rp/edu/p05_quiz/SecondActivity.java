package c346.rp.edu.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResult = findViewById(R.id.textViewTicket);
        Intent value = getIntent();
        String result = value.getStringExtra("output");
        tvResult.setText(result);
    }
}
