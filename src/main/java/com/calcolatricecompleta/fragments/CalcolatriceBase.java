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
 * Use the {@link CalcolatriceBase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcolatriceBase extends Fragment {
  Button B1,B2,B3,B4,B5,B6,B7,B8,B9,B0,Bpoint,Bequal,Bplus,Bmains,Bmulti,Bdivesion,Bcancel;//tutti i buttoni
  TextView Tmonitor;
  float FristNum,SecondNum,Result;
  int operation;



  public CalcolatriceBase() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment CalcolatriceBase.
   */
  // TODO: Rename and change types and number of parameters
  public static CalcolatriceBase newInstance(String param1, String param2) {
    CalcolatriceBase fragment = new CalcolatriceBase();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //B0 = (Button) getView().findViewById(R.id.B0);






  }





  public void setTmonitro(String Num) {
    Tmonitor.setText(Tmonitor.getText().toString()+Num);
  }


  public void prepareOperation(int op){
    if(operation == 0){
      FristNum = Float.parseFloat(Tmonitor.getText().toString());
      operation = op;
      Tmonitor.setText("");
    }else{
      FristNum = DoEqual();
      Tmonitor.setText("");
      operation = op;
    }
  }


  public float DoEqual(){
    SecondNum = Float.parseFloat(Tmonitor.getText().toString());



    switch (operation){
      case 1:
        Result = FristNum + SecondNum;
        Tmonitor.setText(Float.toString(Result));
        FristNum = 0;
        SecondNum = 0;
        operation = 0;
        break;
      case 2 :
        Result = FristNum - SecondNum;
        Tmonitor.setText(Float.toString(Result));
        FristNum = 0;
        SecondNum = 0;
        operation = 0;
        break;
      case 3 :
        Result = FristNum * SecondNum;
        Tmonitor.setText(Float.toString(Result));
        FristNum = 0;
        SecondNum = 0;
        operation = 0;
        break;
      case 4 :
        if (SecondNum != 0){
          Result = FristNum / SecondNum;
          Tmonitor.setText(Float.toString(Result));
          FristNum = 0;
          SecondNum = 0;
          operation = 0;
        }else{
          Tmonitor.setText("∞");
        }
        break;


    }

    return  Result;

  }






  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    View myView =  inflater.inflate(R.layout.fragment_calcolatrice_base, container, false);

    B0 = (Button) myView.findViewById(R.id.B0);
    B1 = (Button) myView.findViewById(R.id.B1);
    B2 = (Button) myView.findViewById(R.id.B2);
    B3 = (Button) myView.findViewById(R.id.B3);
    B4 = (Button) myView.findViewById(R.id.B4);
    B5 = (Button) myView.findViewById(R.id.B5);
    B6 = (Button) myView.findViewById(R.id.B6);
    B7 = (Button) myView.findViewById(R.id.B7);
    B8 = (Button) myView.findViewById(R.id.B8);
    B9 = (Button) myView.findViewById(R.id.B9);
    Bpoint = (Button) myView.findViewById(R.id.Bpoint);
    Bequal = (Button) myView.findViewById(R.id.Bequal);
    Bplus = (Button) myView.findViewById(R.id.Bplus);
    Bmains = (Button) myView.findViewById(R.id.Bmains);
    Bdivesion = (Button) myView.findViewById(R.id.Bdives);
    Bcancel = (Button) myView.findViewById(R.id.Ncancel);
    Bmulti = (Button) myView.findViewById(R.id.Bmultip);

    Tmonitor = (TextView) myView.findViewById(R.id.Tmonitor);


    /*<<====================================Listrner Su i buttoni ==============================*/
    B0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("0");//Un metodo che prende in input una string poi lo concatena alla text view
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("1");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("2");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("3");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("4");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("5");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("6");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("7");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B8.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("8");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    B9.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro("9");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Listner==============================*/
    Bpoint.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setTmonitro(".");
      }
    });
    /*====================================Listner==============================>>*/

    /*<<====================================Addetion==============================*/
    Bplus.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        prepareOperation(1);
      }
    });
    /*====================================Addetion==============================>>*/

    /*<<====================================Soustraction==============================*/

    Bmains.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        prepareOperation(2);
      }
    });
    /*====================================Soustraction==============================>>*/

    /*<<====================================Multiplication==============================*/
    Bmulti.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        prepareOperation(3);
      }
    });
    /*====================================Multiplication==============================>>*/

    /*<<====================================Division==============================*/

    Bdivesion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        prepareOperation(4);
      }
    });
    /*====================================Division==============================>>*/

    /*<<====================================Equal ==============================*/
    Bequal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DoEqual();
      }
    });
    /*====================================Equal ==============================>>*/


    /*<<====================================Cancel ==============================*/
    Bcancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Tmonitor.setText("");
        FristNum = 0;
        SecondNum = 0;
        operation = 0;
      }
    });
    /*====================================Cancel ==============================>>*/

      return myView;

  }



  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    /*<<====================================I link con gl'elementi ==============================
    B0 = (Button) myView.findViewById(R.id.B0);
    B1 = (Button) myView.findViewById(R.id.B1);
    B2 = (Button) myView.findViewById(R.id.B2);
    B3 = (Button) myView.findViewById(R.id.B3);
    B4 = (Button) myView.findViewById(R.id.B4);
    B5 = (Button) myView.findViewById(R.id.B5);
    B6 = (Button) myView.findViewById(R.id.B6);
    B7 = (Button) myView.findViewById(R.id.B7);
    B8 = (Button) myView.findViewById(R.id.B8);
    B9 = (Button) myView.findViewById(R.id.B9);
    Bpoint = (Button) myView.findViewById(R.id.Bpoint);
    Bequal = (Button) myView.findViewById(R.id.Bequal);
    Bplus = (Button) myView.findViewById(R.id.Bplus);
    Bmains = (Button) myView.findViewById(R.id.Bmains);
    Bdivesion = (Button) myView.findViewById(R.id.Bdives);
    Bcancel = (Button) myView.findViewById(R.id.Ncancel);
    Bmulti = (Button) myView.findViewById(R.id.Bmultip);

    Tmonitor = (TextView) myView.findViewById(R.id.Tmonitor);*/


  }





}
