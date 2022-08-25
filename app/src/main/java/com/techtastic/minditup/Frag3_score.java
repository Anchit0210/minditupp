package com.techtastic.minditup;

import android.content.Intent;
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
public class Frag3_score extends Fragment {


    public Frag3_score() {
        // Required empty public constructor
    }

    private TextView result;
    private Button b1;
    Act3_Assessment assessment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag3_score, container, false);

        b1 = v.findViewById(R.id.tohome1);
        assessment = (Act3_Assessment)getActivity();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Act4_BasePage.class);
                startActivity(i);

            }
        });

        result = v.findViewById(R.id.result);
        whichProblem();

        return v;

    }

    private void whichProblem(){
        Bundle bundle = new Bundle();
        bundle=getArguments();
        int dep = bundle.getInt("depression");
        int ptsd = bundle.getInt("ptsd");
        int adhd = bundle.getInt("adhd");
        int anx = bundle.getInt("anxiety");


//        scenario 1
        if(dep==ptsd && ptsd==adhd && adhd==anx && anx==0){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep +" You have no problem");
        }

//        scenario 2
        else if(dep<=2 && ptsd<=2 && adhd<=2 && anx<=2 ){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep +" You have thodi si problem");
        }

//        scenario 3
//        no equality
        else if(ptsd>adhd && ptsd>anx && ptsd>dep){

            String  A ="ptsd";

            Frag4_Test2 tst= new Frag4_Test2();
//            Frag5_score2 lmn = new Frag5_score2();
            bundle.putString("abcd",A);
            tst.setArguments(bundle);
//            lmn.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,tst);
            ft.commit();
//            Todo:


//            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "you have ptsd");
        }
        else if(anx>adhd && anx>ptsd && anx>dep){

            String  A ="anxiety";

            Frag4_Test2 tst= new Frag4_Test2();
//            Frag5_score2 lmn = new Frag5_score2();
            bundle.putString("abcd",A);
            tst.setArguments(bundle);
//            lmn.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,tst);
            ft.commit();
//            Todo:

//            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + " You have anx");
        }
        else if(dep>adhd && dep>anx && dep>ptsd){

            String  A ="depression";

            Frag4_Test2 tst= new Frag4_Test2();
//            Frag5_score2 lmn = new Frag5_score2();
            bundle.putString("abcd",A);
            tst.setArguments(bundle);
//            lmn.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,tst);
            ft.commit();
//            Todo:

//            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "you have dep");
        }
        else if(adhd>ptsd && adhd>anx && adhd>dep){

            String  A ="adhd";

            Frag4_Test2 tst= new Frag4_Test2();
//            Frag5_score2 lmn = new Frag5_score2();
            bundle.putString("abcd",A);
            tst.setArguments(bundle);
//            lmn.setArguments(bundle);
            FragmentTransaction ft= getFragmentManager().beginTransaction();
//            FragmentTransaction.addToBackStack(null);
            ft.replace(R.id.assessment_frameLayout,tst);
            ft.commit();
//            Todo:

//            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "you have adhd");
        }


//        3 equality
        else if(ptsd==adhd && adhd==dep){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call ptsd adhd dep set");
        }
        else if(ptsd==anx && anx==adhd){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call anx ptsd adhd set");
        }
        else if(ptsd==anx && anx==dep){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call anx dep ptsd set");
        }
        else if(anx==dep && dep==adhd){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call anx dep adhd set");
        }


//        2 equality
        else if(ptsd==adhd){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call ptsd adhd set");
        }
        else if(ptsd==dep){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call ptsd dep set");
        }
        else if(ptsd==anx){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call ptsd anx set");
        }
        else if(dep==adhd){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call dep adhd set");
        }
        else if(anx==adhd){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call anx adhd set");
        }
        else if(anx==dep){
            result.setText("ptsd: "+ ptsd +" adhd: "+ adhd +"anx: "+ anx + "dep: "+ dep + "Call anx dep set");

        }
        //            todo
//            design the score1 xml file + have the contents
//            set the changable contents


    }

    }