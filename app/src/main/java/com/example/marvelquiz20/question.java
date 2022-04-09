package com.example.marvelquiz20;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class question extends AppCompatActivity {
    TextView number;
    TextView question;
    RadioGroup radioGroup;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    ImageView image;
    Button next;
    int i=0;
    String questions[]={"WHAT IS THE NAME OF PETER PARKER'S BEST FRIEND AND WHAT IS THE NAME OF THE CHARACTER FROM COMICS?","WHAT IS THE COLOUR OF POWER STONE?","WHO IS THE VILLAIN OF CAPTAIN AMERICA:CVIL WAR?","WHO IS THE KEEPER OF SOUL STONE?","IS STORMBREAKER STRONGER THAN FULLY COMPLETED INFINITY GAUNTLET?"};
    String options1[]={"NED AND THE GUY IN THE CHAIR","PURPLE","WINTER SOLDIER","TONY STARK","YES"};
    String options2[]={"NED LEEDS AND THE GUY IN THE CHAIR","RED","DR.ZEMO","THANOS","HELL YEAH!!"};
    String options3[]={"HARRY OSBORN AND GREEN GOBLIN","GREEN","TONY STARK","RED SKULL","PROBABLY"};
    String options4[]={"NED AND THE THING","YELLOW","ARNIM ZOLA","STEVE ROGERS","NO"};
    String answers[]={"NED LEEDS AND THE GUY IN THE CHAIR","PURPLE","DR.ZEMO","RED SKULL","NO"};
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        next = findViewById(R.id.button);
        number = findViewById(R.id.questionNum);
        question = findViewById(R.id.question);
        radioGroup=findViewById(R.id.rg);
        option1=findViewById(R.id.rb1);
        option2=findViewById(R.id.rb2);
        option3=findViewById(R.id.rb3);
        option4=findViewById(R.id.rb4);
        image=findViewById(R.id.images);
        int a=i+1;
        number.setText(String.valueOf(a));
        question.setText(questions[i]);
        option1.setText(options1[i]);
        option2.setText(options2[i]);
        option3.setText(options3[i]);
        option4.setText(options4[i]);
        image.setImageResource(R.drawable.question1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                AlertDialog.Builder builder = new AlertDialog.Builder(question.this);
                if (id==-1){
                    builder.setMessage("One option must be selected");
                    builder.setTitle("Error");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else{
                    RadioButton rb= findViewById(id);
                    String ans=String.valueOf(rb.getText());
                    if(ans.equals(answers[i])){
                        score++;
                    }
                    radioGroup.clearCheck();
                i++;
                    if(i<5) {
                        number.setText(String.valueOf(i + 1));
                        question.setText(questions[i]);
                        option1.setText(options1[i]);
                        option2.setText(options2[i]);
                        option3.setText(options3[i]);
                        option4.setText(options4[i]);
                        if (i == 1) {
                            image.setImageResource(R.drawable.question2);
                        } else if (i == 2) {
                            image.setImageResource(R.drawable.question3);
                        } else if (i == 3) {
                            image.setImageResource(R.drawable.question4);
                        } else if (i == 4) {
                            image.setImageResource(R.drawable.question5);
                        }

                    }
                    else if (i == 5) {
                        Intent intent = new Intent(question.this, result.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    }
                }



            }
        });



    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(question.this);
        builder.setMessage("Do you want to exit? Changes will not be saved!!");
        builder.setTitle("MARVEL QUIZ");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent= new Intent(question.this,MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();   }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
