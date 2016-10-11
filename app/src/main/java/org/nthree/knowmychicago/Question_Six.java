package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_Six extends Question_Five{


    public static boolean checkAnswerSix = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__six);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Six.this, Question_Five.class);
                startActivity(back);

                if (checkAnswerFive == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerFive);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerFive=false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 5 of 10";
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
                Intent next = new Intent(Question_Six.this, Question_Seven.class);
                startActivity(next);

                if (checkAnswerSix == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerSix);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 7 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);

            }


        });

    }


    //Check to see what answer is right for question 2

    public void AnswerSix(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {

            case R.id.question6_radio1:
                if (checked) {
                    checkAnswerSix = false;
                    break;
                }

            case R.id.question6_radio2:
                if (checked) {
                    checkAnswerSix = true;
                    break;
                }
            case R.id.question6_radio3:
                if (checked) {
                    checkAnswerSix = false;
                    break;
                }

            case R.id.question6_radio4:
                if (checked) {
                    checkAnswerSix =false;
                    break;
                }

        }

    }


}//END OF LINE