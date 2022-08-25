package com.techtastic.minditup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag6_home extends Fragment {

    public Frag6_home() {
        // Required empty public constructor
    }

    private ImageView b1, b2, b3, b4, b5;
    private int mCurrentMood = 1;
    private int mCurrentMoodIntensity = 1;
    RelativeLayout yogalayout, meditationlayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag6_home, container, false);
        b1 = view.findViewById(R.id.veryhappy);
        b2 = view.findViewById(R.id.happy);
        b3 = view.findViewById(R.id.normal);
        b4 = view.findViewById(R.id.sad);
        b5 = view.findViewById(R.id.verysad);
        yogalayout = view.findViewById(R.id.yoga_layout);
        meditationlayout = view.findViewById(R.id.meditation_layout);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showMoodIntensityDialog ();

            }
        });

        yogalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Act5_Yoga.class));
            }
        });

        meditationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Act6_Meditation.class));
            }
        });




        return view;
    }

    class MoodIntensityDialogSeekListener implements SeekBar.OnSeekBarChangeListener {
        /**
         * Listens for updates on the SeekBar used to get the user's current mood.
         * The data is stored which is then used to save to the local SQLite database.
         */
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // Progress goes from 0-5 but we use 1-6
            mCurrentMoodIntensity = progress + 1;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    class MoodIntesityDialogListener implements DialogInterface.OnClickListener {
        /**
         * Listens for the event in which the user chooses a mood intensity
         * using the SeekBar then hits the submit button.
         */
        @Override
        public void onClick(DialogInterface dialog, int which) {
            saveMoodToDatabase();
            Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
            FragmentTransaction ft= getFragmentManager().beginTransaction();
            ft.replace(R.id.baseFrameLayout,new Frag9_MoodTracker());
            ft.commit();
//            enable button todo
        }
    }

    void saveMoodToDatabase() {
        /**
         * Saves the current mood state to the SQLite database.
         */
        AppDatabase database = AppDatabase.getDatabase(getActivity().getApplicationContext());
        MoodDao moodDao = database.moodDao();

        // Get the last entered date
        List<Mood> allMoods = moodDao.getAll();
        int numberOfMoods = allMoods.size();
        int lastEnteredDate = 0;
        if (numberOfMoods > 0) {
            lastEnteredDate = allMoods.get(numberOfMoods - 1).date;
        }

        // Create the new Mood
        Mood currentMood = new Mood(lastEnteredDate + 1, mCurrentMood, mCurrentMoodIntensity);
        moodDao.insert(currentMood);

    }



    void showMoodIntensityDialog () {
        /**
         * Shows the dialog that asks the user the intensity of the mood
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DarkAlertDialog);
        SeekBar seekBar = new SeekBar(getActivity());
        seekBar.setMax(4);
        seekBar.setOnSeekBarChangeListener(new MoodIntensityDialogSeekListener());

        builder.setTitle("How intense is this feeling?");
        builder.setView(seekBar);
        builder.setPositiveButton("Save", new MoodIntesityDialogListener());

        builder.show();
    }
}