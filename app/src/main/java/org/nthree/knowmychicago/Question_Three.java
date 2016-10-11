package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_Three extends Question_Two {


    public static boolean checkAnswerThree = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__three);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Three.this, Question_Two.class);
                startActivity(back);

                if (checkAnswerTwo == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerTwo);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerTwo=false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 2 of 10";
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
                Intent next = new Intent(Question_Three.this, Question_Four.class);
                startActivity(next);

                if (checkAnswerThree == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerThree);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 4 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }


    //Check to see what answer is right for question 2

    public void AnswerThree(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {

            case R.id.question3_radio1:
                if (checked) {
                    checkAnswerThree = false;
                    break;
                }

            case R.id.question3_radio2:
                if (checked) {
                    checkAnswerThree = false;
                    break;
                }
            case R.id.question3_radio3:
                if (checked) {
                    checkAnswerThree = true;
                    break;
                }

            case R.id.question3_radio4:
                if (checked) {
                    checkAnswerThree = false;
                    break;
                }

        }

    }


}//END OF LINE
