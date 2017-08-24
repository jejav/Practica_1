package com.example.jesusjavier.practica1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RadioButton chCuadro,chTriangulo,chCubo,chCirculo;
    private EditText text1,text2;
    private TextView teResult;
    private  float valor1,valor2;
    private float area,perimetro,volumen;
    private String cadena1,cadena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chCuadro=(RadioButton) findViewById(R.id.chCuadro);
        chTriangulo=(RadioButton) findViewById(R.id.chTriangulo);
        chCubo=(RadioButton)findViewById(R.id.chCubo);
        chCirculo=(RadioButton)findViewById(R.id.chCirculo);
        text1=(EditText)findViewById(R.id.Edvalor1);
        text2=(EditText)findViewById(R.id.Edvalor2);
        teResult=(TextView)findViewById(R.id.teResult);


    }

    public void onCheckboxClicked(View view) {
        int id=view.getId();
        if (id==R.id.chCuadro){
            text1.setHint(getResources().getString(R.string.msgcuadro));
            text1.setEnabled(true);
            text2.setEnabled(false);
            text2.setVisibility(view.INVISIBLE);
        }
        else if(id==R.id.chCirculo){
            text1.setHint(getResources().getString(R.string.msgcirculo));
            text1.setEnabled(true);
            text2.setEnabled(false);
            text2.setVisibility(view.INVISIBLE);
        }
        else if(id==R.id.chTriangulo){
            text1.setHint(getResources().getString(R.string.msgbasetriangulo));
            text2.setHint(getResources().getString(R.string.msgaltura));
            text1.setEnabled(true);
            text2.setEnabled(true);
            text2.setVisibility(view.VISIBLE);
        }
        else if(id==R.id.chCubo){
            text1.setHint(getResources().getString(R.string.msgcubo));
            text1.setEnabled(true);
            text2.setEnabled(false);
            text2.setVisibility(view.INVISIBLE);
        }



    }

    public void calcular_valor(View view) {


        cadena1=text1.getText().toString();
        cadena2=text2.getText().toString();

       if((cadena1.isEmpty()|| cadena1.equals("")||cadena1.length()==0)||((cadena1.isEmpty()
               || cadena2.equals("")||cadena2.length()==0)&& chTriangulo.isChecked()) ){
            Context context = getApplicationContext();
            CharSequence text = "Hay campos sin llenar ";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
       

       else {

           if (chCuadro.isChecked()) {
               valor1 = Float.valueOf(text1.getText().toString());
               //valor1=Integer.valueOf(text1.getText().toString());
               area = valor1 * valor1;
               perimetro = 4 * valor1;
               teResult.setText("Area: " + area + "\nPerimetro: " + perimetro);

           } else if (chCirculo.isChecked()) {
               valor1 = Float.parseFloat(text1.getText().toString());

               area = ((float) Math.PI) * (valor1 * valor1);
               perimetro = 2 * ((float) Math.PI) * valor1;
               teResult.setText("Area del circulo : " + area + "\nPerímetro: " + perimetro);

           } else if (chTriangulo.isChecked()) {
               valor1 = Float.parseFloat(text1.getText().toString());
               valor2 = Float.parseFloat(text2.getText().toString());
               area = (valor1 * valor2) / 2;
               perimetro = 3 * valor1;
               teResult.setText("Área del Triangulo: " + area + "\nPerímetro: " + perimetro);

           } else if (chCubo.isChecked()) {
               valor1 = Float.parseFloat(text1.getText().toString());
               area = 6 * (valor1 * valor1);
               volumen = valor1 * valor1 * valor1;
               teResult.setText("Area superficial : " + area + "\nVolumen: " + volumen);

           }

        }



    }
}
