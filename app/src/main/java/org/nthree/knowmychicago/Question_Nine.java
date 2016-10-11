package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Question_Nine extends Question_Eight{

    public static boolean checkAnswerNine = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__nine);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Nine.this, Question_Eight.class);
                startActivity(back);

                if (checkAnswerEight == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerEight);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerEight=false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 8 of 10";
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
                Intent next = new Intent(Question_Nine.this, Question_Ten.class);
                startActivity(next);

                final EditText checkAnswer= (EditText) findViewById(R.id.question9Answer);
                final String text1 = checkAnswer.getText().toString();
                final String text2 = "Twinkie";
                final String text3 = "Twinkies";

                if(text1.equalsIgnoreCase(text2) || text1.equalsIgnoreCase(text3)){
                    checkAnswerNine=true;
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerNine);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }
                else{
                    checkAnswerNine=false;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerNine);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }


                Context context = getApplicationContext();
                CharSequence text = "Question 10 of 10";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();



                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }

}//END OF LINE

