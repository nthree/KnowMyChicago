package org.nthree.knowmychicago;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class Question_Ten extends Question_Nine{

    public static boolean checkAnswerTen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__ten);

        PreviousPage();
        NextPage();
    }

    public void PreviousPage() {
        Button BackButton = (Button) this.findViewById(R.id.Back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Question_Ten.this, Question_Nine.class);
                startActivity(back);

                if (checkAnswerNine == true) {
                    numberOfCorrectAnswers -= 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerNine);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                    checkAnswerNine=false;
                }

                Context context = getApplicationContext();
                CharSequence text = "Question 9 of 10";
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
                Intent next = new Intent(Question_Ten.this, result.class);
                startActivity(next);


                CheckBox checked1 = (CheckBox) findViewById(R.id.checkbox1);
                CheckBox checked2 = (CheckBox) findViewById(R.id.checkbox2);
                CheckBox checked3 = (CheckBox) findViewById(R.id.checkbox3);
                CheckBox checked4 = (CheckBox) findViewById(R.id.checkbox4);

                if ((checked1.isChecked() && checked2.isChecked() && checked3.isChecked() && checked4.isChecked())) {
                    checkAnswerTen=true;
                    numberOfCorrectAnswers += 1;
                    Log.v("MainActivity", "Your answer was: " + checkAnswerTen);
                    Log.v("MainActivity", "Number of correct answer so far: " + numberOfCorrectAnswers);
                }
                else
                    checkAnswerTen=false;

                Context context = getApplicationContext();
                CharSequence text = "Moment of Truth";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }


        });

    }




}//END OF LINE