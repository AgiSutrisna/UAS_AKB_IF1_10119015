package com.example.uas_akb_if1_10119015.Fragment;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_if1_10119015.Adapter.Adapter;
import com.example.uas_akb_if1_10119015.AddNoteActivity;
import com.example.uas_akb_if1_10119015.NB_Database;
import com.example.uas_akb_if1_10119015.Notebook;
import com.example.uas_akb_if1_10119015.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;
    FloatingActionButton button;
    Adapter adapter;
    List<Notebook> notes;

    public Home_Fragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        recyclerView = view.findViewById(R.id.listOfNote);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        button = view.findViewById(R.id.addBtn);

        NB_Database db = new NB_Database(view.getContext());
        notes = db.getNotes();
        adapter = new Adapter(view.getContext(),notes);
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddNoteActivity.class);
                startActivity(i);
            }
        });

        return view;

    }

}