package com.techtastic.minditup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2_Test extends Fragment {

    public Frag2_Test() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;

    private TextView question,questionNumber;
    private Button option1Btn, option2Btn, option3Btn, option4Btn, option5Btn;
    private ArrayList<TestModal> testModalArrayList;

    int questionAttempted = 1, currentPos;
    int dep=0, anxiety=0, ptsd=0, adhd=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.frag2_test, container, false);
        parentFrameLayout = getActivity().findViewById(R.id.assessment_frameLayout);

        question = view.findViewById(R.id.question);
        questionNumber = view.findViewById(R.id.questionNumber);
        option1Btn = view.findViewById(R.id.idBtnOption1);
        option2Btn = view.findViewById(R.id.idBtnOption2);
        option3Btn = view.findViewById(R.id.idBtnOption3);
        option4Btn = view.findViewById(R.id.idBtnOption4);
        option5Btn = view.findViewById(R.id.idBtnOption5);
        testModalArrayList = new ArrayList<>();

        getQuizQuestion(testModalArrayList);
        currentPos= 1;
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted++;

                currentPos=currentPos+1;

                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted++;

                currentPos=currentPos+1;

                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted++;

                if(currentPos==3 || currentPos==5 || currentPos==10){
                    anxiety+=1;
                }
                if(currentPos==6 || currentPos==7){
                    dep+=1;
                }
                if(currentPos==11){
                    adhd+=1;
                }

                currentPos=currentPos+1;

                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted++;

                if(currentPos==1 || currentPos==2 || currentPos==3 || currentPos==11){
                    ptsd+=1;
                }
                if(currentPos==4){
                    anxiety+=1;
                }
                if(currentPos==5 || currentPos==8){
                    dep+=1;
                }
                if(currentPos==6 || currentPos==7 || currentPos==9 || currentPos==10){
                    adhd+=1;
                }

                currentPos=currentPos+1;

                setDataToViews(currentPos);
            }
        });
        option5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted++;

                if(currentPos==1 || currentPos==2 || currentPos==3 || currentPos==11){
                    ptsd+=1;
                }
                if(currentPos==4){
                    anxiety+=1;
                }
                if(currentPos==5 || currentPos==8){
                    dep+=1;
                }
                if(currentPos==6 || currentPos==7 || currentPos==9 || currentPos==10){
                    adhd+=1;
                }

                currentPos=currentPos+1;

                setDataToViews(currentPos);
            }
        });
        return view;
    }

    private void setDataToViews(int currentPos) {
        questionNumber.setText(questionAttempted + "/10"+"questions answered");
        if(questionAttempted == 11){
            Frag3_score dsp= new Frag3_score();
            Bundle bundle= new Bundle();
            bundle.putInt("ptsd",ptsd);
            bundle.putInt("depression",dep);
            bundle.putInt("adhd",adhd);
            bundle.putInt("anxiety",anxiety);
            dsp.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,dsp);
            ft.commit();
//            Todo:
        }else{
            question.setText(testModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(testModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(testModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(testModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(testModalArrayList.get(currentPos).getOption4());
            option5Btn.setText(testModalArrayList.get(currentPos).getOption5());
        }
    }

    private void getQuizQuestion(ArrayList<TestModal> testModalArrayList) {

        testModalArrayList.add(new TestModal(1,"Do you get nightmares about the events or intrusive thought about the event when you did not want to?",
                "Never","Hardly Ever","Maybe sometimes","Most of the time","Always"));

        testModalArrayList.add(new TestModal(2,"Do you feel bad or that you were unable to stop blaming others or yourself for the traumatic experience they may have brought about?",
                "Never","Not very often","Maybe sometimes","A lot of time","Always"));

        testModalArrayList.add(new TestModal(3,"Do you think you are being on guard all the time, vigilant, or flustered?",
                "Completely Untrue","Somewhat Untrue","I'm unsure","Somewhat True","Completely True"));

        testModalArrayList.add(new TestModal(4,"Do you overthink normal life situations way too much?",
                "Never","Rarely","Sometimes","Often","Always"));

        testModalArrayList.add(new TestModal(5,"Do you sweat a lot?",
                "Not Really","Maybe a little","Somewhat","Quite a bit","A lot"));

        testModalArrayList.add(new TestModal(6,"How often are you not able to sleep properly throughout the night?",
                "Never","Hardly ever","Maybe sometimes","Most of the time","Always"));

        testModalArrayList.add(new TestModal(7,"How often do you find yourself having difficulty in concentrating over a task?",
                "Never","Hardly ever","Maybe sometimes","Most of the time","Always"));

        testModalArrayList.add(new TestModal(8,"How often do you have poor diet patterns and no appetite/ overly hungry?",
                "Never","Hardly ever","Maybe sometimes","Most of the time","Always"));

        testModalArrayList.add(new TestModal(9,"How frequently do you miss when working on a monotonous or challenging project?",
                "Never","Rarely","Sometimes","Often","Always"));

        testModalArrayList.add(new TestModal(10,"How frequently do you disrupt people who are working?",
                "Never","Rarely","Sometimes","Often","Always"));

        testModalArrayList.add(new TestModal(11,"How frequently do you struggle to recall appointments or other obligations?",
                "Never","Rarely","Sometimes","Often","Always"));

    }
}