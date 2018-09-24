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

    private TextView mWhiteBlack;

    private TextView mTotal;

    private TextView mReset;


    private int colourPoints=0;
    private int points=0;
    private int whiteBlack=0;
    private int totalPoints=0;






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

       // Sets the initial NearBallPoints value to zero
        mNearBallPointsTextView.setText("0");


        // Connects to object who's id is 'far_ball_distance'
        mFarBallDistanceEditText = findViewById(R.id.far_ball_distance);
        mFarBallPointsTextView = findViewById(R.id.far_ball_points);

        //Sets the initial FarBallPoints value to zero
        mFarBallPointsTextView.setText("0");

        // Connects to object who's id is 'robot home_distance'
        mRobotHomeDistanceEditText = findViewById(R.id.robot_home_distance);
        mRobotHomePointsTextView = findViewById(R.id.robot_home_points);

        //Sets the initial RobotHomePoints value to zero
        mRobotHomePointsTextView.setText("0");




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
                totalPoints(); // Call totalPoints method to update total points




            }
        });


        // Update button onclick listener for near ball, far ball, robot distance
        final Button updateButton = findViewById(R.id.update_Button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              update_points_value();
            }
        });




        // Connect to white_black TextView on the activity_main.xml
        mWhiteBlack = findViewById(R.id.white_black_points);
        mWhiteBlack.setText("0 WB Points");

        Button wbFailureButton = findViewById(R.id.wb_fail);
        wbFailureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               whiteBlack = 0;
               updateWhiteBlack();
            }
        });

        Button wbSuccess = findViewById(R.id.wb_success);
        wbSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whiteBlack = 60;
                updateWhiteBlack();

            }
        });
//***************************************************************************88
    // Connect to Total TextView on the activity_main.xml
   mTotal = findViewById(R.id.message_textview);
   totalPoints = colourPoints;

    mTotal.setText(getString(R.string.total_score, whiteBlack));



        // temp area
       // mMessageTextView.setText("Paul is cool!");



    Button resetButton = findViewById(R.id.reset);
    resetButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            colourPoints =0;
            whiteBlack = 0;
            mWhiteBlack.setText("0 WB Points");
            mNearBallPointsTextView.setText("0");
            mFarBallPointsTextView.setText("0");
            mRobotHomePointsTextView.setText("0");
            totalPoints = 0;
            mTotal.setText(getString(R.string.total_score, totalPoints));
            updateColour();



        }
    });


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

        mNearBallPointsTextView.setText("0");

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

totalPoints();

    }

private void updateWhiteBlack (){
      mWhiteBlack.setText(getString(R.string.Wb_points, whiteBlack));

    totalPoints();

}

private void totalPoints (){

    // When WB Success button is pressed the following code gets all the values and totals
    // them (i.e. totalPoints), the the totalPoints value is displayed.
    int nearBall = Integer.parseInt(mNearBallPointsTextView.getText().toString());
    int farBall = Integer.parseInt(mFarBallPointsTextView.getText().toString());
    int robotHome = Integer.parseInt(mRobotHomePointsTextView.getText().toString());

    totalPoints = (colourPoints + whiteBlack + robotHome + nearBall + farBall);


    mTotal.setText(getString(R.string.total_score, totalPoints));

    //******************************************


}



}
