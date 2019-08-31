package com.ahmedabdelmajeedkhozam.achieveyourgoals;

import android.os.Bundle;

import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class Singleitem extends AppCompatActivity {

    SeekBar seek;
    int MAX = 60; // Highest value for text size
    int MIN = 20; // Lowest value for text size
    int PLUS = 2; //Provide the text size for each step

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snigle_item);

        TextView title = (TextView)findViewById(R.id.title_id);
        text = (TextView)findViewById(R.id.text_id);

        title.setText(getIntent().getExtras().getString("subjectt"));
        text.setText(getIntent().getExtras().getInt("textt"));

        seek = (SeekBar) findViewById(R.id.seeeekbar);
        seek.setMax((MAX-MIN)/PLUS);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setTextSize(MIN + (progress * PLUS));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
