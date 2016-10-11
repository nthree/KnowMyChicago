package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_Seven extends Question_Six{


    public static boolean checkAnswerSeven = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__seven);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Seven.this, Question_Six.class);
                startActivity(back);

                if (checkAnswerSix == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerSix);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerSix=false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 6 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                overridePendingTransition(R.animator.push_right_out, R.animator.push_right_in);
            }
        });
    }

    public void NextPage() {
        Button NextButton = (Button) this.findViewById(R.id.Next);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Question_Seven.this, Question_Eight.class);
                startActivity(next);

                if (checkAnswerSeven == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerSeven);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 8 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }


    //Check to see what answer is right for question 2

    public void AnswerSeven(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {

            case R.id.question7_radio1:
                if (checked) {
                    checkAnswerSeven = false;
                    break;
                }

            case R.id.question7_radio2:
                if (checked) {
                    checkAnswerSeven = false;
                    break;
                }
            case R.id.question7_radio3:
                if (checked) {
                    checkAnswerSeven = false;
                    break;
                }

            case R.id.question7_radio4:
                if (checked) {
                    checkAnswerSeven =true;
                    break;
                }

        }

    }


}//END OF LINE