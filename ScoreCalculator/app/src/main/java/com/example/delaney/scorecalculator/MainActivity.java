package com.example.delaney.scorecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // naming convention in android says that member variable start with an 'm'
    private TextView mColourPointsView; // member variable for connecting to TextView object



    private EditText mNearBallDistanceEditText;
    private TextView mNearBallPointsTextView;

    private EditText mFarBallDistanceEditText;
    private TextView mFarBallPointsTextView;

    private EditText mRobotHomeDistanceEditText;
        private TextView mRobotHomePointsTextView;



    private int colourPoints = 0;
    private int points = 0;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // This method is called when the app launches
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code you add goes after setContentView.
        
        //'col_points' is the id of our colour points result in activity_main TextView, so
        // now we have a connection to the object (who's id is col_points)
        mColourPointsView = findViewById(R.id.col_points);  //col_points on Line 18 of activity_main.xml




    // Connects to object who's id is 'near_ball_distance'
       mNearBallDistanceEditText = findViewById(R.id.near_ball_distance); //"near_ball_distance" id is on line 124 of activity_main
       mNearBallPointsTextView = findViewById(R.id.near_ball_points);

        // Connects to object who's id is 'far_ball_distance'
        mFarBallDistanceEditText = findViewById(R.id.far_ball_distance);
        mFarBallPointsTextView = findViewById(R.id.far_ball_points);

        // Connects to object who's id is 'robot home_distance'
        mRobotHomeDistanceEditText = findViewById(R.id.robot_home_distance);
        mRobotHomePointsTextView = findViewById(R.id.robot_home_points);




    // Three fixes button onclick listener
        final Button threeFixesButton = findViewById(R.id.three_fixes);
        threeFixesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 0;
                updateColour();

            }



        });
        // Two fixes button onclick listener
        final Button twoFixesButton = findViewById(R.id.two_fixes);
        twoFixesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colourPoints = 25;
                updateColour();

            }
        });
        // One fix button onclick listener
        final Button oneFixButton = findViewById(R.id.one_fix);
        oneFixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 75;
                updateColour();

            }
        });
        // Zero fixes button onclick listener
        final Button zeroFixButton = findViewById(R.id.zero_fixes);
        zeroFixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colourPoints = 150;
                updateColour();

            }
        });


        // Update button onclick listener for near ball, far ball, robot distance
        Button updateButton = findViewById(R.id.update_Button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              update_points_value();
            }
        });






        // temp area
       // mMessageTextView.setText("Paul is cool!");



    }
    // updateColour method is called when the 'Fixes' buttons are pressed, it  sets the
    // colour_points string equal to the value of the private variable colourPoints
    private void updateColour() {
        mColourPointsView.setText(getString(R.string.colour_points, colourPoints));

    }


    // update points method for calculating near ball, far ball and robot home points
    private void update_points_value(){

// Near Ball calculation
int nearBallDistance = Integer.parseInt(mNearBallDistanceEditText.getText().toString());

if (nearBallDistance<=5.0)
    mNearBallPointsTextView.setText("110");
else if (nearBallDistance<=10.0)
    mNearBallPointsTextView.setText("100");
else if (nearBallDistance<=20.0)
    mNearBallPointsTextView.setText("80");
else if (nearBallDistance<= 30.0)
    mNearBallPointsTextView.setText("50");
else if (nearBallDistance <=45.0)
    mNearBallPointsTextView.setText("10");
else mNearBallPointsTextView.setText("0");

//Far Ball calculation
int farBallDistance = Integer.parseInt(mNearBallDistanceEditText.getText().toString());

if (farBallDistance<=5.0)
    mFarBallPointsTextView.setText("220");
else if (farBallDistance<=10.0)
    mFarBallPointsTextView.setText("200");
else if (farBallDistance<=20.0)
    mFarBallPointsTextView.setText("160");
else if (farBallDistance<=30.0)
    mFarBallPointsTextView.setText("100");
else if (farBallDistance<=45.0)
    mFarBallPointsTextView.setText("20");
else mFarBallPointsTextView.setText("0");

int robotHomeDistance = Integer.parseInt(mRobotHomeDistanceEditText.getText().toString());

if (robotHomeDistance<=5.0)
    mRobotHomePointsTextView.setText("110");
else if (robotHomeDistance<=10.0)
    mRobotHomePointsTextView.setText("100");
else if (robotHomeDistance<=20.0)
    mRobotHomePointsTextView.setText("80");
else if (robotHomeDistance<=30.0)
    mRobotHomePointsTextView.setText("50");
else if (robotHomeDistance<=45.0)
    mRobotHomePointsTextView.setText("10");
else mRobotHomePointsTextView.setText("0");


    }



}
