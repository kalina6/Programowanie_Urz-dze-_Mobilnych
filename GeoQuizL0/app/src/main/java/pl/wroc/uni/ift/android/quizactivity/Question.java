package pl.wroc.uni.ift.android.quizactivity;

/**
 * Created by Kalina on 15.10.2017.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    Question( int textResId, boolean answerTrue ){

        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId(){
        return mTextResId;
    }

    public void setTextResId( int textResId){
        mTextResId = textResId;
    }

    public boolean isAnswerTrue(){
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue){
        mAnswerTrue=answerTrue;
    }
}