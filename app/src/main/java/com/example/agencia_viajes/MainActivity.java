package com.example.agencia_viajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jetcantidad, jetvalor;
    CheckBox jcbiva, jcbdescuento;
    TextView jtvventabruta, jtviva, jtvdescuento, jtvneto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto y asociar objetos Java con
        //objetos Xml
        getSupportActionBar().hide();
        //Relacionamos los objetos xml con los objetos java
        jetcantidad = findViewById(R.id.etcantidad);
        jetvalor = findViewById(R.id.etvalor);
        jcbiva = findViewById(R.id.cbiva);
        jcbdescuento= findViewById(R.id.cbdescuento);
        jtvventabruta = findViewById(R.id.tvventabruta);
        jtviva = findViewById(R.id.tviva);
        jtvdescuento= findViewById(R.id.tvdescuento);
        jtvneto = findViewById(R.id.tvneto);


    }//FIN ONCREATE

    public void Calcular(View view){

        String cantidad, valor;
        cantidad = jetcantidad.getText().toString();
        valor = jetvalor.getText().toString();
        //Validar que si digitaron numeros
        if (cantidad.isEmpty() || valor.isEmpty()){
            Toast.makeText(this, "Las cantidades son requeridas", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }else{
            int cantidad1;
            double valor1, descuento=0, venta_bruta, total_pagar, iva=0;
            //Conversiones de texto a numerico
            cantidad1 = Integer.parseInt(cantidad);
            valor1 = Float.parseFloat(valor);
            //Intanciar la clase ClsAcciones
            ClsAcciones Obj_Acciones = new ClsAcciones();
            venta_bruta = Obj_Acciones.Calcular_valor_bruto(cantidad1,valor1);
            if (jcbiva.isChecked()){
                iva = Obj_Acciones.Calcular_iva(venta_bruta);
            }
            if (jcbdescuento.isChecked()){
                descuento = Obj_Acciones.Calcular_descuento(venta_bruta);
            }
            total_pagar = Obj_Acciones.Calcular_neto(cantidad1,venta_bruta,descuento,iva);
            //Mostrar los resultados
             jtvventabruta.setText(String.valueOf(venta_bruta));
             jtviva.setText(String.valueOf(iva));
             jtvdescuento.setText(String.valueOf(descuento));
             jtvneto.setText(String.valueOf(total_pagar));
        }

    }//Fin Calcular

    public void Limpiar(View view){
        jetcantidad.setText("");
        jetvalor.setText("");
        jtvneto.setText("0");
        jtviva.setText("0");
        jtvdescuento.setText("0");
        jtvventabruta.setText("0");
    }
}