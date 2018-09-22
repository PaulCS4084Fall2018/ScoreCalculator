package com.example.delaney.scorecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mMessageTextView;
    private int colourPoints = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // This method is called when the app launches
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code you add goes after setContentView
        mMessageTextView = findViewById(R.id.message_textview);

        final Button threeFixesButton = findViewById(R.id.three_fixes);
        threeFixesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 0;
                updateColour();

            }



        });

        final Button twoFixesButton = findViewById(R.id.two_fixes);
        twoFixesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colourPoints = 25;
                updateColour();

            }
        });

        Button oneFixButton = findViewById(R.id.one_fix);
        oneFixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 75;
                updateColour();

            }
        });

        Button zeroFixButton = findViewById(R.id.zero_fixes);
        zeroFixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 150;
                updateColour();

            }
        });



        // temp area
       // mMessageTextView.setText("Paul is cool!");



    }

    private void updateColour() {
        mMessageTextView.setText(getString(R.string.colour_points, colourPoints));

    }


}
