package com.techtastic.minditup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag10_DiaryWritting extends Fragment {
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> mArrayList;
    private AppDatabase mDatabase;
    private int requestCode;
    private int resultCode;
    @Nullable
    private Intent data;


    public Frag10_DiaryWritting() {
        // Required empty public constructor
    }


    public static Frag10_DiaryWritting newInstance() {
        return new Frag10_DiaryWritting();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        JournalDao journalDao = mDatabase.journalDao();
        List<Journal> allJournals = journalDao.getAll();
        mArrayList.clear();
        for (Journal journal : allJournals) {
            mArrayList.add(journal.title);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Set up listener for the journal fragment's FloatingActionButton
         */
        FloatingActionButton fab = view.findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add code for creating a journal entry
                Intent intent = new Intent(getActivity(), NotepadEntry.class);
                startActivity(intent);
            }
        });

        mDatabase = AppDatabase.getDatabase(view.getContext());
        final JournalDao journalDao = mDatabase.journalDao();
        List<Journal> allJournals = journalDao.getAll();
        mArrayList = new ArrayList<>();
        for (Journal journal : allJournals) {
            mArrayList.add(journal.title);
        }

        mAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.list_item, mArrayList);

        ListView listView = view.findViewById(R.id.journal_list_view);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Journal entry = journalDao.getAll().get(position);
//                Intent intent = new Intent(view.getContext(), NotepadEntry.class);
//                intent.putExtra("Title", entry.title);
//                intent.putExtra("Body", entry.body);
//                startActivityForResult(intent, 0x0);
            }
        });

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag10_diary_writting, container, false);
    }
}