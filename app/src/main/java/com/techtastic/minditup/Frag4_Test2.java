package com.techtastic.minditup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag4_Test2 extends Fragment {

    public Frag4_Test2() {
        // Required empty public constructor
    }


       private TextView ques,quesNum;
    private Button option1, option2, option3, option4, option5;
    private ArrayList<TestModal> issueModalArrayList;

    int currentQues, questAttempt=1,maxscore,total=0;
    String A;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag4_test2, container, false);


        ques = v.findViewById(R.id.ques);
        quesNum = v.findViewById(R.id.quesNum);
        option1 = v.findViewById(R.id.idOption1);
        option2 = v.findViewById(R.id.idOption2);
        option3 = v.findViewById(R.id.idOption3);
        option4 = v.findViewById(R.id.idOption4);
        option5 = v.findViewById(R.id.idOption5);
        issueModalArrayList = new ArrayList<>();


        Bundle bundle = new Bundle();
        bundle=getArguments();
         A = bundle.getString("abcd");


        switch (A) {
            case "ptsd":
                getPtsdQues(issueModalArrayList);
                answerButtons();

                break;
            case "anxiety":
                getAnxQues(issueModalArrayList);
                answerButtons();
                break;
            case "depression":
                getDepQues(issueModalArrayList);
                answerButtons();
                break;
            case "adhd":
                getAdhdQues(issueModalArrayList);
                answerButtons();
                break;
        }


        return v;
    }


    private void answerButtons(){
        currentQues=0;
        setDataToViews2(currentQues);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questAttempt++;
                maxscore=1;

                total=total+maxscore;

                currentQues=currentQues+1;

                setDataToViews2(currentQues);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questAttempt++;
                maxscore=2;

                total=total+maxscore;

                currentQues=currentQues+1;

                setDataToViews2(currentQues);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questAttempt++;
                maxscore=3;

                total=total+maxscore;

                currentQues=currentQues+1;

                setDataToViews2(currentQues);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questAttempt++;
                maxscore=4;

                total=total+maxscore;

                currentQues=currentQues+1;

                setDataToViews2(currentQues);
            }
        });
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questAttempt++;
                maxscore=5;

                total=total+maxscore;

                currentQues=currentQues+1;

                setDataToViews2(currentQues);
            }
        });
    }

    private void setDataToViews2(int currentQues){


        quesNum.setText(questAttempt + "/5"+"questions answered");
        if(currentQues == 5){
            Frag5_score2 res= new Frag5_score2();
            Bundle bundle= new Bundle();
            bundle.putInt("total",total);
            bundle.putString("defg",A);
            res.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,res);
            ft.commit();
//            Todo:
        }else{
            ques.setText(issueModalArrayList.get(currentQues).getQuestion());
            option1.setText(issueModalArrayList.get(currentQues).getOption1());
            option2.setText(issueModalArrayList.get(currentQues).getOption2());
            option3.setText(issueModalArrayList.get(currentQues).getOption3());
            option4.setText(issueModalArrayList.get(currentQues).getOption4());
            option5.setText(issueModalArrayList.get(currentQues).getOption5());
        }

    }

    private void getPtsdQues(ArrayList<TestModal> issueModalArrayList){
        issueModalArrayList.add(new TestModal(1,"Do you feel cold or distanced from people, things, or your environment?\n",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(2,"Do you usually avoid people, places, activities, objects and situations that may trigger distressing memories?\n\n",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(3,"Do you feel like you are being overly watchful of one's surroundings in a suspecting way?\n",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(4,"Do you get flashbacks of some traumatic experience that haunts you every now and then?\n",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(5,"Do you feel like you get negative thoughts and feelings leading to ongoing and distorted beliefs about oneself or others?\n",
                "a","a","a","a","a"));
    }

    private void getAnxQues(ArrayList<TestModal> issueModalArrayList){
        issueModalArrayList.add(new TestModal(1,"Do you feel like you are being unable to sit still due to constant agitation?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(2,"Do you find yourself trembling in difficult situations?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(3,"How often do you have an uneasy stomach?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(4,"Do you feel like it is breathe when things are not going your way?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(5,"Are you in need for constant reassurance?",
                "a","a","a","a","a"));
    }

    private void getDepQues(ArrayList<TestModal> issueModalArrayList){
        issueModalArrayList.add(new TestModal(1,"Do you feel self-conscious, like a failure, or having disappointed yourself or your family?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(2,"Do you feel that it would be better for you to harm yourself or die?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(3,"Do you feel that your sadness makes it difficult for you to work, socialize or take care of yourself?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(4,"Do you keep blaming yourself for everything that is wrong in your life?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(5,"Do you hate bright places and objects?",
                "a","a","a","a","a"));
    }

    private void getAdhdQues(ArrayList<TestModal> issueModalArrayList){
        issueModalArrayList.add(new TestModal(1,"How frequently do you find it difficult to arrange yourself when you have to accomplish a task?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(2,"How frequently do you find yourself droning on in social settings?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(3,"How often do you lose things at home or at work or have trouble finding them?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(4,"How irritated do you feel when you aren’t getting enough attention?",
                "a","a","a","a","a"));

        issueModalArrayList.add(new TestModal(5,"How much impatient are you in everyday situation?",
                "a","a","a","a","a"));
    }


}
