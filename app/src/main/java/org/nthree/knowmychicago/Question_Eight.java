package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_Eight extends Question_Seven{


    public static boolean checkAnswerEight = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__eight);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Eight.this, Question_Seven.class);
                startActivity(back);

                if (checkAnswerSeven == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerSeven);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerSeven=false;
                }
                Context context = getApplicationContext();
                CharSequence text = "Question 7 of 10";
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
                Intent next = new Intent(Question_Eight.this, Question_Nine.class);
                startActivity(next);

                if (checkAnswerEight == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerEight);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }
                Context context = getApplicationContext();
                CharSequence text = "Question 9 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }


    //Check to see what answer is right for question 8

    public void AnswerEight(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {

            case R.id.question8_radio1:
                if (checked) {
                    checkAnswerEight = true;
                    break;
                }

            case R.id.question8_radio2:
                if (checked) {
                    checkAnswerEight = false;
                    break;
                }
            case R.id.question8_radio3:
                if (checked) {
                    checkAnswerEight = false;
                    break;
                }

            case R.id.question8_radio4:
                if (checked) {
                    checkAnswerEight = false;
                    break;
                }

        }

    }


}//END OF LINE