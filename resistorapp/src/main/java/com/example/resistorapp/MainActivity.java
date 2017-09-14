package com.example.resistorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner banda1,banda2,banda3,banda4;
    private TextView bcolor1,bcolor2,bcolor3,bcolor4,resistance,tolerancia;
    private int color1,color2,color3,color4;
    private double resistencia;
    private int tol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banda1=(Spinner)findViewById(R.id.banda1);
        banda2=(Spinner)findViewById(R.id.banda2);
        banda3=(Spinner)findViewById(R.id.banda3);
        banda4=(Spinner)findViewById(R.id.banda4);
        bcolor1=(TextView)findViewById(R.id.bcolor1);
        bcolor2=(TextView)findViewById(R.id.bcolor2);
        bcolor3=(TextView)findViewById(R.id.bcolor3);
        bcolor4=(TextView)findViewById(R.id.bcolor4);
        resistance=(TextView)findViewById(R.id.resistance);
        tolerancia=(TextView)findViewById(R.id.tolerance);

        ArrayAdapter<CharSequence> linea1 = ArrayAdapter.createFromResource(this,
                R.array.lista1, android.R.layout.simple_spinner_item);
        banda1.setAdapter(linea1);

        banda1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                color1 = adapterView.getSelectedItemPosition();
                switch (color1){
                    case 0:
                        bcolor1.setBackgroundResource(R.color.brown);
                        break;
                    case 1:
                        bcolor1.setBackgroundResource(R.color.red);
                        break;
                    case 2:
                        bcolor1.setBackgroundResource(R.color.orange);
                        break;
                    case 3:
                        bcolor1.setBackgroundResource(R.color.yellow);
                        break;
                    case 4:
                        bcolor1.setBackgroundResource(R.color.green);
                        break;
                    case 5:
                        bcolor1.setBackgroundResource(R.color.blue);
                        break;
                    case 6:
                        bcolor1.setBackgroundResource(R.color.violet);
                        break;
                    case 7:
                        bcolor1.setBackgroundResource(R.color.gray);
                        break;
                    case 8:
                        bcolor1.setBackgroundResource(R.color.white);
                        break;

                }

                Calcular();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> linea2 = ArrayAdapter.createFromResource(this,
                R.array.lista2, android.R.layout.simple_spinner_item);
        banda2.setAdapter(linea2);

        banda2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                color2 = adapterView.getSelectedItemPosition();
                switch (color2){
                    case 0:
                        bcolor2.setBackgroundResource(R.color.black);
                        break;
                    case 1:
                        bcolor2.setBackgroundResource(R.color.brown);
                        break;
                    case 2:
                        bcolor2.setBackgroundResource(R.color.red);
                        break;
                    case 3:
                        bcolor2.setBackgroundResource(R.color.orange);
                        break;
                    case 4:
                        bcolor2.setBackgroundResource(R.color.yellow);
                        break;
                    case 5:
                        bcolor2.setBackgroundResource(R.color.green);
                        break;
                    case 6:
                        bcolor2.setBackgroundResource(R.color.blue);
                        break;
                    case 7:
                        bcolor2.setBackgroundResource(R.color.violet);
                        break;
                    case 8:
                        bcolor2.setBackgroundResource(R.color.gray);
                        break;
                    case 9:
                        bcolor2.setBackgroundResource(R.color.white);
                        break;


                }

                Calcular();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> linea3 = ArrayAdapter.createFromResource(this,
                R.array.lista3, android.R.layout.simple_spinner_item);
        banda3.setAdapter(linea3);

        banda3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                color3 = adapterView.getSelectedItemPosition();
                switch (color3){
                    case 0:
                        bcolor3.setBackgroundResource(R.color.silver);
                        break;
                    case 1:
                        bcolor3.setBackgroundResource(R.color.gold);
                        break;
                    case 2:
                        bcolor3.setBackgroundResource(R.color.black);
                        break;
                    case 3:
                        bcolor3.setBackgroundResource(R.color.brown);
                        break;
                    case 4:
                        bcolor3.setBackgroundResource(R.color.red);
                        break;
                    case 5:
                        bcolor3.setBackgroundResource(R.color.orange);
                        break;
                    case 6:
                        bcolor3.setBackgroundResource(R.color.yellow);
                        break;
                    case 7:
                        bcolor3.setBackgroundResource(R.color.green);
                        break;
                    case 8:
                        bcolor3.setBackgroundResource(R.color.blue);
                        break;
                    case 9:
                        bcolor3.setBackgroundResource(R.color.violet);
                        break;
                    case 10:
                        bcolor3.setBackgroundResource(R.color.gray);
                        break;
                    case 11:
                        bcolor3.setBackgroundResource(R.color.white);
                        break;


                }

                Calcular();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> linea4 = ArrayAdapter.createFromResource(this,
                R.array.lista4, android.R.layout.simple_spinner_item);
        banda4.setAdapter(linea4);

        banda4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                color4  = adapterView.getSelectedItemPosition();
                switch (color4){
                    case 0:
                        bcolor4.setBackgroundResource(R.color.silver);
                        break;
                    case 1:
                        bcolor4.setBackgroundResource(R.color.gold);
                        break;
                    case 2:
                        bcolor4.setBackgroundResource(R.color.brown);
                        break;
                    case 3:
                        bcolor4.setBackgroundResource(R.color.red);
                        break;
                    case 4:
                        bcolor4.setBackgroundResource(R.color.green);
                        break;


                }

                Calcular();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Calcular(){
        resistencia=(color1+1)*10 + (color2);
        switch (color3){
            case 0:
                resistencia*=0.01;
                break;
            case 1:
                resistencia*=0.1;
                break;
            case 2:
                break;
            default:
                resistencia*=Math.pow(10,color3-2);
        }


        if(resistencia>=1000000){
            resistencia/=1000000;
            resistance.setText("Valor : "+ resistencia+ " MΩ");
        }
        else if(resistencia>=1000){
            resistencia/=1000;
            resistance.setText("Valor : "+resistencia+ " KΩ");
        }
        else{
            resistance.setText("Valor : "+ String.format("%.2f", resistencia)+ " Ω");

        }

        switch (color4){
            case 0:
                tolerancia.setText("Tolerancia: 10%");
                break;
            case 1:
                tolerancia.setText("Tolerancia: 5%");
                break;
            case 2:
                tolerancia.setText("Tolerancia: 1%");
                break;
            case 3:
                tolerancia.setText("Tolerancia: 2%");
                break;
            case 4:
                tolerancia.setText("Tolerancia: 0.5%");
                break;
        }

    }




}
