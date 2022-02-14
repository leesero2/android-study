package com.example.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewNumberPicker);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);

        Language.initLanguages();
        numberPicker.setMaxValue(Language.getLanguageArrayList().size() - 1);
        numberPicker.setMinValue(0);
        numberPicker.setDisplayedValues(Language.languageNames());


//        numberPicker.setMaxValue(10);
//        numberPicker.setMinValue(0);
        //numberPicker.setValue(5);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText("selected: "+ Language.getLanguageArrayList().get(i1).getName());
            }
        });

    }


}