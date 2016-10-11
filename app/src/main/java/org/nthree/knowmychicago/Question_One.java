package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question_One extends AppCompatActivity {

    public static int numberOfCorrectAnswers;
    public static boolean checkAnswerOne = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__one);

        PreviousPage();
        NextPage();
    }


    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_One.this, MainActivity.class);
                startActivity(back);
                overridePendingTransition(R.animator.push_right_out, R.animator.push_right_in);
            }
        });
    }

    public void NextPage() {
        Button NextButton = (Button) this.findViewById(R.id.Next);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Question_One.this, Question_Two.class);
                startActivity(next);

                if (checkAnswerOne == true) {
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 2 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_left_out, R.animator.push_left_in);
            }


        });

    }

    public void AnswerOne(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.question1_radio1:
                if (checked) {
                    //numberOfCorrectAnswers += 1;
                    checkAnswerOne = true;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    // Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    break;
                }

            case R.id.question1_radio2:
                if (checked) {
                    checkAnswerOne = false;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    break;
                }
            case R.id.question1_radio3:
                if (checked) {
                    checkAnswerOne = false;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    break;
                }
            case R.id.question1_radio4:
                if (checked) {
                    checkAnswerOne = false;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerOne);
                    break;
                }

        }
    }

}


