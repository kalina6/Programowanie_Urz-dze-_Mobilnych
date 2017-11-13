package pl.wroc.uni.ift.android.quizactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private final static String EXTRA_KEY_ANSWER = "Answer";
    private final static String KEY_QUESTION = "QUESTION";
    private final static String EXTRA_KEY_SHOWN = "Shown";
    TextView mTextViewAnswer;
    Button mButtonShow;


    boolean mAnswer;
    boolean podgladanie = false;
    String podejrzanaodp ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        // z quiz act 82 83 pobiera odp wstawia tutaj w EXTRA_KEY_ANSWER i przypisuje mAnswer i leci do sprawdzenia w dolnym if
        mAnswer = getIntent().getBooleanExtra(EXTRA_KEY_ANSWER,false);
        if(savedInstanceState!=null){
            podgladanie=savedInstanceState.getBoolean("wasShown");
            podejrzanaodp=savedInstanceState.getString("napis");
        }



        mTextViewAnswer = (TextView) findViewById(R.id.text_view_answer);
        mTextViewAnswer.setText(podejrzanaodp);
        mButtonShow = (Button) findViewById(R.id.button_show_answer);
        mButtonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer) {
                    podejrzanaodp ="Prawda";
                    mTextViewAnswer.setText(podejrzanaodp);
                } else {
                    podejrzanaodp = "Fałsz";
                    mTextViewAnswer.setText(podejrzanaodp);
                }
                setAnswerShown(true);
                podgladanie = true;
            }
        });

        setAnswerShown(false);
        podgladanie = false;
    }


    public static boolean wasAnswerShown(Intent data)
    {
        return data.getBooleanExtra(EXTRA_KEY_SHOWN, false);
    }

    public static Intent newIntent(Context context, boolean answerIsTrue)
    {

        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(EXTRA_KEY_ANSWER, answerIsTrue);
        return intent;

    }

    private void setAnswerShown (boolean isAnswerShown) {
        //intent  polaczenie (przesyłanie danych) miedzy cheatactivity a quizactivity
        Intent data = new Intent();
        data.putExtra(EXTRA_KEY_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
    super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("wasShown" , podgladanie );
        savedInstanceState.putString("napis",podejrzanaodp );

    }


}
