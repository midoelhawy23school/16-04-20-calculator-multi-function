package com.calcolatricecompleta.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.calcolatricecompleta.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EquetionSolver#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquetionSolver extends Fragment {
  TextView TeSecA,TeSecB,TeSecC,TVrestulte;
  Button BtnEqual;

  public EquetionSolver() {
    // Required empty public constructor
  }



  public static EquetionSolver newInstance(String param1, String param2) {
    EquetionSolver fragment = new EquetionSolver();
    Bundle args = new Bundle();

    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View myView = inflater.inflate(R.layout.fragment_equetion_solver, container, false);
    //TeSecA,TeSecB,TeSecC,TVrestulte;
    TeSecA = myView.findViewById(R.id.TeSecA);
    TeSecB = myView.findViewById(R.id.TeSecB);
    TeSecC = myView.findViewById(R.id.TeSecC);
    TVrestulte = myView.findViewById(R.id.TVrestulte);
    BtnEqual = myView.findViewById(R.id.BtnEqual);

    BtnEqual.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        double A,B,C,delat,root,x1,x2;
        String equtionResult = null;
        try {
          A = Double.parseDouble(TeSecA.getText().toString());
        }catch (Exception e){
          A = 0;
        }

        try {
          B = Double.parseDouble(TeSecB.getText().toString());
        }catch (Exception e){
          B = 0;
        }

        try {
          C = Double.parseDouble(TeSecC.getText().toString());
        }catch (Exception e){
          C = 0;
        }

        delat = B * B - 4.0 * A * C;

        if(delat>0){
          root = Math.pow(delat, 0.5);
          x1 = (-B + root) / (A*2);
          x2 = (-B - root) / (A*2);
          equtionResult = getString(R.string.equation_has_2_x);
          equtionResult = equtionResult.replaceAll("\\__X1__\\b", ""+x1);
          equtionResult = equtionResult.replaceAll("\\__X2__\\b", ""+x2);
          equtionResult = equtionResult.replaceAll("\\__DELTA__\\b", ""+delat);
          equtionResult = equtionResult.replaceAll("\\__ROOT__\\b", ""+root);
          equtionResult = equtionResult.replaceAll("\\__NEWLINE__\\b", ""+System.getProperty("line.separator"));

        }else if(delat == 0){
          x1 = -B / (A*2);
          equtionResult = getString(R.string.equation_has_2_x);
          equtionResult = equtionResult.replaceAll("\\__X1__\\b", ""+x1);
          equtionResult = equtionResult.replaceAll("\\__NEWLINE__\\b", ""+System.getProperty("line.separator"));
        }else {
          equtionResult = getString(R.string.equation_havent_solution);
        }

        TVrestulte.setText(equtionResult);




      }
    });

    return myView;
  }



}
