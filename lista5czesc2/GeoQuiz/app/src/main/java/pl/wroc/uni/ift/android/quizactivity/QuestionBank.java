package pl.wroc.uni.ift.android.quizactivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalina on 21.11.2017.
 */

public class QuestionBank {

    private static QuestionBank INSTANCE;
    private Question[] tablica;
    private List<Question> pytania;

    private QuestionBank() {
                tablica = new Question[]{
                new Question(R.string.question_stolica_polski, true),
                new Question(R.string.question_stolica_dolnego_slaska, false),
                new Question(R.string.question_sniezka, true),
                new Question(R.string.question_wisla, true)
        };
        pytania = new ArrayList<>();
        pytania.add(tablica[0]);
        pytania.add(tablica[1]);
        pytania.add(tablica[2]);
        pytania.add(tablica[3]);

    }

    public static QuestionBank getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE=new QuestionBank();
        }
        return INSTANCE;

    }

    public Question getQuestion (int index){
        return tablica[index];
    }

    public int size(){
        return tablica.length;
    }

    public List<Question> getQuestions(){
        return pytania;
    }















}
