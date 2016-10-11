package org.nthree.knowmychicago;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class result extends Question_Ten {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        restartQuiz();
    }


    public void restartQuiz() {
        Button restartButton = (Button) this.findViewById(R.id.restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restart = new Intent(result.this, MainActivity.class);
                startActivity(restart);

                Context context = getApplicationContext();
                CharSequence text = "Restarting Quiz";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                overridePendingTransition(R.animator.push_right_out, R.animator.push_right_in);
            }
        });
    }

    //Displaying results with red and blue color grading
    public void submitGrade(View view) {

        String gradeSummary;
        TextView correct= (TextView)findViewById(R.id.results_box);
        TextView incorrect = (TextView) findViewById(R.id.results_box);

        if(checkAnswerOne){
            gradeSummary = "Question 1:           ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText((gradeSummary));
        }else {
            gradeSummary = "Question 1:           ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText((gradeSummary));
        }

        if(checkAnswerTwo){
            gradeSummary += "Question 2:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "Question 2:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        if(checkAnswerThree){
            gradeSummary += "\nQuestion 3:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 3:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        if(checkAnswerFour){
            gradeSummary += "\nQuestion 4:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 4:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        if(checkAnswerFive){
            gradeSummary += "\nQuestion 5:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 5:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        if(checkAnswerSix){
            gradeSummary += "\nQuestion 6:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 6:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }
        if(checkAnswerSeven){
            gradeSummary += "\nQuestion 7:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 7:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }
        if(checkAnswerEight){
            gradeSummary += "\nQuestion 8:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 8:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }
        if(checkAnswerNine){
            gradeSummary += "\nQuestion 9:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 9:         ";
            gradeSummary += getResources().getString(R.string.Red);
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        if(checkAnswerTen){
            gradeSummary += "\nQuestion 10:         ";
            gradeSummary += getResources().getString(R.string.Blue);
            gradeSummary += "\n\nTotal: " + numberOfCorrectAnswers + " out of 10";
            correct.setText(Html.fromHtml(gradeSummary));
        }else {
            gradeSummary += "\nQuestion 10:         ";
            gradeSummary += getResources().getString(R.string.Red);
            gradeSummary += "\n\n     Total: " + numberOfCorrectAnswers + " out of 10";
            incorrect.setText(Html.fromHtml(gradeSummary));
        }

        }


    }




