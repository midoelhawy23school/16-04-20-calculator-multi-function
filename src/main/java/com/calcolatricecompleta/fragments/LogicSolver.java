package com.calcolatricecompleta.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.calcolatricecompleta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogicSolver#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogicSolver extends Fragment {
    Button BtnNot,BtnOr,BtnAnd,BtnCancelChar,BtnBraketsOpen,BtnBraketsClose,BtnTrue,BtnFalse,BtnEqual;
    TextView TvMonitor,TvDubger;

    boolean FirestResult;
    String LogicString;
  List<String> Operations = new ArrayList<String>();

  public LogicSolver() {
    // Required empty public constructor
  }


  public static LogicSolver newInstance(String param1, String param2) {
    LogicSolver fragment = new LogicSolver();
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
    View myView =  inflater.inflate(R.layout.fragment_logic_solver, container, false);
    /*Button BtnNot,BtnOr,BtnAnd,BtnCancelChar,BtnBraketsOpen,BtnBraketsClose,BtnTrue,BtnFalse;
    TextView TvMonitor;*/

    Operations.add("(");
    Operations.add("True");
    Operations.add("|");
    Operations.add("False");
    Operations.add(")");
    Operations.add("&");
    Operations.add("(");
    Operations.add("True");
    Operations.add("&");
    Operations.add("False");
    Operations.add("&");
    Operations.add("!");
    Operations.add("(");
    Operations.add("False");
    Operations.add("|");
    Operations.add("!");
    Operations.add("True");
    Operations.add(")");
    Operations.add(")");



    BtnNot = myView.findViewById(R.id.BtnNot);
    BtnOr = myView.findViewById(R.id.BtnOr);
    BtnAnd = myView.findViewById(R.id.BtnAnd);
    BtnCancelChar = myView.findViewById(R.id.BtnCancelChar);
    BtnBraketsOpen = myView.findViewById(R.id.BtnBraketsOpen);
    BtnBraketsClose = myView.findViewById(R.id.BtnBraketsClose);
    BtnTrue = myView.findViewById(R.id.BtnTrue);
    BtnFalse = myView.findViewById(R.id.BtnFalse);
    BtnEqual = myView.findViewById(R.id.BtnEqual);
    TvMonitor = myView.findViewById(R.id.TvMonitor);
    TvDubger = myView.findViewById(R.id.TvDubger);

    TvMonitor.setText(Operations.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));

    /*==========================EVENTS============================*/
    BtnNot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("!");
      }
    });

    /*==========================EVENTS============================*/

    BtnOr.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("|");
      }
    });

    /*==========================EVENTS============================*/

    BtnAnd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("&");
      }
    });

    /*==========================EVENTS============================*/

    BtnBraketsOpen.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("(");
      }
    });
    /*==========================EVENTS============================*/

    BtnBraketsClose.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop(")");
      }
    });
    /*==========================EVENTS============================*/

    BtnTrue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("True");
      }
    });
    /*==========================EVENTS============================*/
    BtnFalse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setMonitorWithLop("False");
      }
    });
    /*==========================EVENTS============================*/
    BtnCancelChar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        removeLast();

      }
    });
    /*==========================EVENTS============================*/
    BtnEqual.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        solveAll();
      }
    });



    return  myView;
  }

  @RequiresApi(api = Build.VERSION_CODES.N)
  public boolean solveAll() {
    List<String> Expression = new ArrayList<String>();
    //"((1,&,1),|,(!,1))"
    //try {
      for (int i = 0;i<Operations.size();i++){
        String Operator = Operations.get(i);
        if(Operator.equals("True")){
          Operator = "1";
        }else if(Operator.equals("False")){
          Operator = "0";
        }
          Expression.add(Operator);
      }

      prepareOperation(Expression);


   /* }catch(Exception e){
      TvMonitor.setText("False");
      Toast.makeText(getActivity(),"error",Toast.LENGTH_SHORT).show();
    }*/
    return  true;
  }

  public void setMonitorWithLop(String op) {
    Operations.add(op);
    TvMonitor.setText(Operations.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
  }


  public void removeLast(){
    try {
      Operations.remove(Operations.size()-1);
      TvMonitor.setText(Operations.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));
    }catch (Exception e){
      Toast.makeText(getActivity(),"error",Toast.LENGTH_SHORT);
    }
  }


  public List replaceSingolNegation(List data){


    for (int i = 0; i < data.size(); i++) {
      String nextElemnt  = i+1 < data.size() ? (String) data.get(i + 1) : "2";
      if (data.get(i).equals("!")) {
        if (nextElemnt.equals("1")){
          data.set(i,"0");
          data.remove(i + 1);

        }else if(nextElemnt.equals("0")){
          data.set(i,"1");
          data.remove(i + 1);

        }else if(nextElemnt.equals("2")){
          data.set(i,"1");
        }
      }
    }

    return data;

  }


  public List SolveSingolOr(List data){


    for (int i = 0; i < data.size(); i++) {
      String prevElement  = i-1 >= 0 ? (String) data.get(i - 1) : "2";
      String nextElemnt  =  i+1 < data.size() ? (String) data.get(i + 1) : "2";
      if (data.get(i).equals("|")) {

        if (nextElemnt.equals("1") || prevElement.equals("1")){
          data.set(i,"1");
          if(nextElemnt.equals("1") || nextElemnt.equals("0"))  data.remove(i + 1);
          if(prevElement.equals("1") || prevElement.equals("0"))  data.remove(i - 1);


        }else if((nextElemnt.equals("0") || nextElemnt.equals(")") ) && (prevElement.equals("0") || prevElement.equals("(") )){
          data.set(i,"1");
          if(nextElemnt.equals("1") || nextElemnt.equals("0"))  data.remove(i + 1);
          if(prevElement.equals("1") || prevElement.equals("0"))  data.remove(i - 1);

        }

      }
    }

    return data;

  }



  public List SolveSingolAnd(List data){


    for (int i = 0; i < data.size(); i++) {
      String prevElement  = i-1 >= 0 ? (String) data.get(i - 1) : "2";
      String nextElemnt  =  i+1 < data.size() ? (String) data.get(i + 1) : "2";
      if (data.get(i).equals("&")) {

        if (nextElemnt.equals("1") && prevElement.equals("1")){
          data.set(i,"1");
          if(nextElemnt.equals("1") || nextElemnt.equals("0"))  data.remove(i + 1);
          if(prevElement.equals("1") || prevElement.equals("0"))  data.remove(i - 1);


        }else if((nextElemnt.equals("0") || nextElemnt.equals(")") ) || (prevElement.equals("0") || prevElement.equals("(") )){
          data.set(i,"0");
          if(nextElemnt.equals("1") || nextElemnt.equals("0"))  data.remove(i + 1);
          if(prevElement.equals("1") || prevElement.equals("0"))  data.remove(i - 1);

        }

      }
    }

    return data;

  }


  public List RemoveUnimportantBrakets(List data){


    for (int i = 0; i < data.size(); i++) {
      String prevElement  = i-1 >= 0 ? (String) data.get(i - 1) : "2";
      String nextElemnt  =  i+1 < data.size() ? (String) data.get(i + 1) : "2";

      if(prevElement.equals("(") && nextElemnt.equals(")")){
       data.remove(i + 1);
       data.remove(i - 1);
      }

    }

    return data;

  }






  public boolean prepareOperation(List data){
    boolean LatsElement;


    int whileCounter = 0;
    while (data.size() > 1 && whileCounter < 20) {

      data = replaceSingolNegation(data);
      data = SolveSingolOr(data);
      data = SolveSingolAnd(data);
      data = RemoveUnimportantBrakets(data);

      whileCounter++;
    }


    if(data.size() == 1){

      if(data.get(0).equals("1")) {
        Operations.removeAll(Operations);
        Operations.add("True");
        TvMonitor.setText("True");
      }else if(data.get(0).equals("0")){
        Operations.removeAll(Operations);
        Operations.add("False");
        TvMonitor.setText("False");
      }else{
        TvDubger.setText(getText(R.string.i_cant_resolve_this_expression));
      }
    }else{
      TvDubger.setText(getText(R.string.i_cant_resolve_this_expression));
    }
    //TvDubger.setText(data.toString().replace("[","").replace("]","").replace(",","").replace(" ",""));


    Toast.makeText(getActivity(),"Not : "+data.toString(),Toast.LENGTH_LONG).show();
    return true;

  }











}
