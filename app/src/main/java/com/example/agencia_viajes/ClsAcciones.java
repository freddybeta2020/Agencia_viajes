/*4.Leer la cantidad de personas que viajan, el valor por persona que viajan a Cartagena y luego imprimir:
-	Valor bruto del viaje
-	Valor del IVA (19%), preguntar si tiene o no IVA
-	Descuento: el descuento es del 10% sobre el valor bruto, preguntar si tiene o no descuento
-	Valor neto del viaje
Nota: utilizar para cada uno un método*/

package com.example.agencia_viajes;

public class ClsAcciones {

    public double Calcular_valor_bruto(int cantidad_personas, double valor_viaje){
        return cantidad_personas * valor_viaje;
    }

    public double Calcular_descuento(double valor_bruto){
        double descuento = 10;
        return (valor_bruto*descuento)/100;
    }

    public double Calcular_iva(double valor_bruto){
        double iva = 19;
        return  (valor_bruto * iva)/100;
    }

    public double Calcular_neto(int cantidad_personas, double valor_viaje, double descuento, double iva){
        return cantidad_personas * valor_viaje - descuento + iva;
    }

}
