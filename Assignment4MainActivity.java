package com.example.itc162_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.Format;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private EditText tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempText = findViewById(R.id.tempText);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.convert:
                RadioButton F = findViewById(R.id.radioF);
                RadioButton C = findViewById(R.id.radioC);
                TextView out = findViewById(R.id.tempOutput);
                float temp = Float.parseFloat(tempText.getText().toString());

                if(F.isChecked()) {
                    String output = String.valueOf(conversion.fahrenheit(temp));
                    out.setText(output + Html.fromHtml("℃"));
                } else if(C.isChecked()) {
                    String output = String.valueOf(conversion.celsius(temp));
                    out.setText(output + Html.fromHtml("℉"));
                } else {
                    return;
                }
                break;
        }
    }
}
