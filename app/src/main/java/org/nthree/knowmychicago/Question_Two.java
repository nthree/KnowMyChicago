package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class Question_Two extends Question_One {


    public static boolean checkAnswerTwo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__two);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Two.this, Question_One.class);
                startActivity(back);

                if (checkAnswerOne == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerOne =false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 1 of 10";
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
                Intent next = new Intent(Question_Two.this, Question_Three.class);
                startActivity(next);

                if (checkAnswerTwo == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerTwo);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }


                Context context = getApplicationContext();
                CharSequence text = "Question 3 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }


    //Check to see what answer is right for question 2

    public void AnswerTwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {

            case R.id.question2_radio1:
                if (checked) {
                    checkAnswerTwo = false;
                    break;
                }

            case R.id.question2_radio2:
                if (checked) {
                    checkAnswerTwo = false;
                    break;
                }
            case R.id.question2_radio3:
                if (checked) {
                    checkAnswerTwo = true;
                    break;
                }

            case R.id.question2_radio4:
                if (checked) {
                    checkAnswerTwo = false;
                    break;
                }

        }

    }


}//END OF LINE

