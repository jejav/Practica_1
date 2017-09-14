package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText teDisplay;
    private TextView numero_1,numero_2,numero_3,numero_4,numero_5;
    private TextView numero_6,numero_7,numero_8,numero_9,numero_0;
    private TextView suma,resta,divi,mult;
    private TextView punto,igual;
    private String resultado="";
    private String operacion="";
    private float oper1,oper2,res;

    private boolean opercheck=false,checkMenos=false,checkNum=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teDisplay=(EditText)findViewById(R.id.TeDisplay);
        numero_0=(TextView)findViewById(R.id.numero_0);
        numero_1=(TextView)findViewById(R.id.numero_1);
        numero_2=(TextView)findViewById(R.id.numero_2);
        numero_3=(TextView)findViewById(R.id.numero_3);
        numero_4=(TextView)findViewById(R.id.numero_4);
        numero_5=(TextView)findViewById(R.id.numero_5);
        numero_6=(TextView)findViewById(R.id.numero_6);
        numero_7=(TextView)findViewById(R.id.numero_7);
        numero_8=(TextView)findViewById(R.id.numero_8);
        numero_9=(TextView)findViewById(R.id.numero_9);
        suma=(TextView)findViewById(R.id.suma);
        resta=(TextView)findViewById(R.id.resta);
        mult=(TextView)findViewById(R.id.mult);
        divi=(TextView)findViewById(R.id.divi);
        punto=(TextView)findViewById(R.id.punto);
        igual=(TextView)findViewById(R.id.signo_igual);

        teDisplay.setKeyListener(null); //EditText no editable

    }
// ====== METODOS PARA AGREGAR NUMEROS =========
    public void clickSiete(View view) {
        resultado=resultado+"7";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickOcho(View view) {
        resultado=resultado+"8";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickNueve(View view) {
        resultado=resultado+"9";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickCuatro(View view) {
        resultado=resultado+"4";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickCinco(View view) {
        resultado=resultado+"5";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickSeis(View view) {
        resultado=resultado+"6";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickUno(View view) {
        resultado=resultado+"1";
        teDisplay.setText(resultado);
        checkNum=true;
    }
    public void clickDos(View view) {
        resultado=resultado+"2";
        teDisplay.setText(resultado);
    }

    public void clickTres(View view) {
        resultado=resultado+"3";
        teDisplay.setText(resultado);
        checkNum=true;
    }

    public void clickCero(View view) {
        resultado=resultado+"0";
        teDisplay.setText(resultado);
        checkNum=true;
    }
//=================== METODOS DE OPERACIONES =====================
////////////RESTA//////
    public void clickResta(View view) {
        if(!checkMenos ){
            resultado="-";
            teDisplay.setText(resultado);
            checkMenos=true;
        }
        else if (checkMenos && checkNum ){
            operacion="-";
            oper1=Float.parseFloat(teDisplay.getText().toString());
            teDisplay.setText("");
            resultado="";
            punto.setEnabled(true);
            opercheck=false;
            checkMenos=false;
        }
    }
////////////SUMA//////////
    public void clickSuma(View view) {
        if(!opercheck && checkNum){
            oper1=Float.parseFloat(teDisplay.getText().toString());
            teDisplay.setText("");
            resultado="";
            punto.setEnabled(true);
            opercheck=true;
            checkMenos=false;
        }
        operacion="+";
    }
/////MULTIPLICACION///////
    public void clickMult(View view) {
        if(!opercheck && checkNum){
            oper1=Float.parseFloat(teDisplay.getText().toString());
            teDisplay.setText("");
            resultado="";
            punto.setEnabled(true);
            opercheck=true;
            checkMenos=false;
        }
        operacion="*";

    }
/////////DIVISION/////
    public void clickDiv(View view) {
        if(!opercheck && checkNum){
            oper1=Float.parseFloat(teDisplay.getText().toString());
            teDisplay.setText("");
            resultado="";
            punto.setEnabled(true);
            opercheck=true;
            checkMenos=false;
        }
        operacion="/";

    }
//////PUNTO DECIMAL///
    public void clickPunto(View view) {
        punto.setEnabled(false);
        resultado=resultado+".";
        teDisplay.setText(resultado);

    }
//===========================EJECUCION DE OPERACION =========================
    public void clickIgual(View view) {
        punto.setEnabled(true);
        if ( !TextUtils.isEmpty(teDisplay.getText().toString().trim())) {

            if (operacion == "+") {
                oper2 = Float.parseFloat(teDisplay.getText().toString());
                opercheck=false;

                try {
                    res = oper1 + oper2;
                    teDisplay.setTextSize(18);
                    if(oper2<0){
                        teDisplay.setText( oper1 +"+"+ "("+ oper2 +")"+"= "+ res);
                    }
                    else {
                        teDisplay.setText( oper1 +"+"+oper2+"= "+ res);
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }

            } else if (operacion == "-") {
                oper2 = Float.parseFloat(teDisplay.getText().toString());
                opercheck=false;

                try {
                    res = oper1 - oper2;
                    teDisplay.setTextSize(18);
                    if(oper2<0){
                        teDisplay.setText( oper1 +"-"+ "("+ oper2 +")"+"= "+ res);
                    }
                    else {
                        teDisplay.setText( oper1 +"-"+oper2+"= "+ res);
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }

            } else if (operacion == "*") {
                oper2 = Float.parseFloat(teDisplay.getText().toString());
                opercheck=false;

                try {
                    res = oper1 * oper2;
                    teDisplay.setTextSize(18);
                    if(oper2<0){
                        teDisplay.setText( oper1 +"*"+ "("+ oper2 +")"+"= "+ res);
                    }
                    else {
                        teDisplay.setText( oper1 +"*"+oper2+"= "+ res);
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }

            } else if (operacion == "/") {
                oper2 = Float.parseFloat(teDisplay.getText().toString());
                opercheck=false;
                try {
                    res = oper1 / oper2;
                    teDisplay.setTextSize(18);
                    if(oper2<0){
                        teDisplay.setText( oper1 +"/"+ "("+ oper2 +")"+"= "+ res);
                    }
                    else {
                        teDisplay.setText( oper1 +"/"+oper2+"= "+ res);
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
            oper1=res; //Guarda el resultado para seguir operando si se necesita
        }
    }

//////// FUNCION PARA LIMPIAR //////
    public void Clear(View view) {
        teDisplay.setTextSize(40);
        teDisplay.setText("");
        operacion="";
        resultado="";
        res=0;
        opercheck=false;checkMenos=false;checkNum=false;

    }
}
