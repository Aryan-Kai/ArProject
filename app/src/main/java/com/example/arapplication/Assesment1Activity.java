package com.example.arapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.app.AlertDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Assesment1Activity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    ImageView questionimage;

    int score=0;
    int totalQuestion = Question2Answer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assesment2);

        questionimage = findViewById(R.id.questionimage);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(Assesment1Activity.this);
        ansB.setOnClickListener(Assesment1Activity.this);
        ansC.setOnClickListener(Assesment1Activity.this);
        ansD.setOnClickListener(Assesment1Activity.this);
        submitBtn.setOnClickListener(Assesment1Activity.this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();




    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(Question2Answer.correctAnswers[currentQuestionIndex])){
                score++;
                Toast.makeText(Assesment1Activity.this,"Correct Answer!!!",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Assesment1Activity.this,"OOPS!! You can do it!!!",Toast.LENGTH_SHORT).show();

            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionimage.setImageResource(Question1Answer.array[currentQuestionIndex]);
        questionTextView.setText(Question1Answer.question[currentQuestionIndex]);
        ansA.setText(Question1Answer.choices[currentQuestionIndex][0]);
        ansB.setText(Question1Answer.choices[currentQuestionIndex][1]);
        ansC.setText(Question1Answer.choices[currentQuestionIndex][2]);
        ansD.setText(Question1Answer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
            //Intent intent = new Intent(Assesment2Activity.this,BravoActivity.class);
            //startActivity(intent);
        }else{
            passStatus = "Failed";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(passStatus);

        builder.setMessage("Score is "+ score+" out of "+ totalQuestion);
        builder.setCancelable(false);
        builder.setPositiveButton("Restart",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restartQuiz();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Assesment1Activity.this,ModelActivity.class);
                startActivity(intent);
                finish();
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}