package com.calcolatricecompleta;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.calcolatricecompleta.fragments.CalcolatriceBase;
import com.calcolatricecompleta.fragments.EquetionSolver;
import com.calcolatricecompleta.fragments.LogicSolver;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  TextView TVPageTitle;
  BottomNavigationView bottomNavigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //TVPageTitle = findViewById(R.id.)
    setContentView(R.layout.activity_main);
    bottomNavigation = findViewById(R.id.bottom_navigation);
    bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    openFragment(CalcolatriceBase.newInstance("", ""));
  }

  public void openFragment(Fragment fragment) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()) {
            case R.id.nav_calcolatrice_base:
              openFragment(CalcolatriceBase.newInstance("", ""));
              Toast.makeText(getBaseContext(),getText(R.string.base_calcolator_selected),Toast.LENGTH_SHORT).show();

              return true;
            case R.id.nav_equetion_calc:
              openFragment(EquetionSolver.newInstance("", ""));
              Toast.makeText(getBaseContext(),getText(R.string.equetion_calculater_selected),Toast.LENGTH_SHORT).show();

              return true;
            case R.id.nav_logic_calc:
              openFragment(LogicSolver.newInstance("", ""));
              Toast.makeText(getBaseContext(),getText(R.string.logic_calculater_selected),Toast.LENGTH_SHORT).show();
              return true;
          }
          return false;
        }
      };




}
