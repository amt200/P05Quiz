package c346.rp.edu.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox oneWay, round;
Button btnPlus, btnMinus, submit;
TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneWay = findViewById(R.id.checkBoxOneWay);
        round = findViewById(R.id.checkBoxRound);
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        number = findViewById(R.id.textViewNumber);
        submit = findViewById(R.id.buttonSubmit);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            int num = Integer.parseInt(number.getText().toString());
            @Override
            public void onClick(View v) {

                number.setText(num--);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            int num = Integer.parseInt(number.getText().toString());
            @Override
            public void onClick(View v) {
                number.setText(num++);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            String type = "";
            double total = 0;
            @Override

            public void onClick(View v) {
                if(oneWay.isChecked() && round.isChecked()){
                    Toast.makeText(MainActivity.this,"You cannot choose both ticket types " +
                            "at the same time.",Toast.LENGTH_SHORT);
                }
                else if(Integer.parseInt(number.getText().toString()) == 0){
                    Toast.makeText(MainActivity.this,"Invalid pax number!",Toast.LENGTH_SHORT);
                }
                else{

                    if(oneWay.isChecked()){
                        type = "One Way";
                        total = 100 * Integer.parseInt(number.getText().toString());
                    }
                    else{
                        type = "Round Trip";
                        total = 100 * Integer.parseInt(number.getText().toString()) *2;
                    }
                }
                String display = "You have selected "+type+" Trip.\n"+"Your air ticket costs $ "+String.format("%.2f".total);
                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                it.putExtra("output",display);
                startActivity(it);
            }
        });

    }
}
