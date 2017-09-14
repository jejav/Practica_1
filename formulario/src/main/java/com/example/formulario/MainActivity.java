package com.example.formulario;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.icu.util.Calendar.*;

public class MainActivity extends AppCompatActivity {

    private Spinner sCiudad;
    private String ciudad;
    private String nombre,pass,passconfirm,correo,fecha,sexo="Masculino",hobbies="";
    private CheckBox cJugar,cPescar,cLeer,cPasear;

    private Button btnfecha;
    private EditText edfecha,edNombre,edPassw,edPassconfirm,edMail;
    private TextView tDatos;
    private int dia,mes,anio;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sCiudad=(Spinner)findViewById(R.id.sCiudad);
        btnfecha=(Button)findViewById(R.id.btnfecha);
        edfecha= (EditText)findViewById(R.id.edfecha);
        edNombre=(EditText)findViewById(R.id.edNombre);
        edPassw=(EditText)findViewById(R.id.edPassw);
        edPassconfirm=(EditText)findViewById(R.id.edPassconfirm);
        edMail=(EditText)findViewById(R.id.edMail);
        tDatos=(TextView)findViewById(R.id.tDatos);
        cJugar=(CheckBox)findViewById(R.id.cJugar);
        cPescar=(CheckBox)findViewById(R.id.cPescar);
        cLeer=(CheckBox)findViewById(R.id.cLeer);
        cPasear=(CheckBox)findViewById(R.id.cPasear);

        final Calendar c= Calendar.getInstance();

        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        anio=c.get(Calendar.YEAR);

        ////////////////////////////////////////////////////////////////////////////

        btnfecha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatePickerDialog datepicker=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int MonthOfYear, int DayOfMonth) {
                       edfecha.clearFocus();

                        edfecha.setText(DayOfMonth+"/"+ (MonthOfYear+1)+"/"+year);
                        edfecha.setSelection(edfecha.getText().length());
                    }
                }
                ,dia,mes,anio);
                datepicker.updateDate(anio,mes,dia);
                datepicker.show();
            }
        });

        edfecha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        //////////////////////////////////////////////////////////////////////////

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_dropdown_item);
        sCiudad.setAdapter(adapter);


        sCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void OnButtonCLicked(View view) {

        nombre= edNombre.getText().toString();
        pass=edPassw.getText().toString();
        passconfirm=edPassconfirm.getText().toString();
        correo= edMail.getText().toString();
        fecha=edfecha.getText().toString();



        if(TextUtils.isEmpty(nombre.trim())){
            edNombre.setError("Ingresa un dato");
            edNombre.requestFocus();
        }
         else if(TextUtils.isEmpty(pass.trim())){
            edPassw.setError("Ingresa una contraseña");
            edPassw.requestFocus();
        }
        else if(TextUtils.isEmpty(passconfirm.trim())){
            edPassconfirm.setError("Ingresa la contraseña nuevamente");
            edPassconfirm.requestFocus();
        }
        else if(TextUtils.isEmpty(correo.trim())){
            edMail.setError("Ingresa una dirección de Correo");
            edMail.requestFocus();
        }
        else if(TextUtils.isEmpty(fecha.trim())){
            edfecha.setError("Escoge una fecha");
            edfecha.requestFocus();
        }
        else{
            if(pass.equals(passconfirm)){
                tDatos.setText("Datos Ingresados:"+"\nNombre: "+nombre +"\nContraseña: " + pass +"\nCorreo: "
                        +correo+ "\nFecha de Nacimiento: "+fecha+ "\nLugar de Nacimiento: "
                        +ciudad+"\nSexo: "+sexo+ "\nHobbies: " + hobbies);
            }
            else{
                tDatos.setText("Las contraseñas no coinciden");

            }

        }

    }

    public void onCheckboxClicked(View view) {
        hobbies="";
        if(cJugar.isChecked()){hobbies=hobbies+" "+"Jugar";}
        if(cLeer.isChecked()){hobbies=hobbies+" "+ "Leer";}
        if (cPasear.isChecked()) {hobbies=hobbies+" "+"Pasear";}
        if(cPescar.isChecked()){hobbies=hobbies+" "+"Pescar";}
    }

    public void onRadioButtonClicked(View view) {
        int id=view.getId();
        if(id==R.id.rMasculino){
            sexo="Masculino";

        }
        if(id==R.id.rFemenino){
            sexo="Femenino";

        }
    }
}
