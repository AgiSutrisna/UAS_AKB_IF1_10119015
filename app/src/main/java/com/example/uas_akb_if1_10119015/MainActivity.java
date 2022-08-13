package com.example.uas_akb_if1_10119015;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.uas_akb_if1_10119015.Fragment.About_Fragment;
import com.example.uas_akb_if1_10119015.Fragment.Home_Fragment;
import com.example.uas_akb_if1_10119015.Fragment.Logout_Fragment;
import com.example.uas_akb_if1_10119015.Fragment.Profile_Fragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.buttom_navigation);

        meowitem();

        Fragmentawal();

        PilihMenu();
    }

    private void meowitem () {
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_info));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_profile));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_logout));

    }

    private void PilihMenu() {
            bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
                @Override
                public Unit invoke(MeowBottomNavigation.Model model) {
                    switch (model.getId()) {
                        case 1:
                            replace(new Home_Fragment());
                            break;

                        case 2:
                            replace(new About_Fragment());
                            break;

                        case 3:
                            replace(new Profile_Fragment());
                            break;

                        case 4:
                            replace(new Logout_Fragment());
                            break;



                    }
                    return null;
                }
            });

            bottomNavigation.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
                @Override
                public Unit invoke(MeowBottomNavigation.Model model) {
                    Toast.makeText(MainActivity.this, "Kamu sudah disini", Toast.LENGTH_SHORT).show();
                    return null;
                }
            });
        }

    private void Fragmentawal() {
        replace(new Home_Fragment());
        bottomNavigation.show(1, true);
    }


    private void replace (Fragment fragment){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }
    }
