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
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.uas_akb_if1_10119015.Login_Activity;
import com.example.uas_akb_if1_10119015.R;
import com.google.firebase.auth.FirebaseAuth;


public class Logout_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logout_, container, false);


        Button btn1 = (Button) view.findViewById(R.id.ya);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login_Activity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}