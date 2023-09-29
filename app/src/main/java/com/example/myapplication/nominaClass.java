package com.example.myapplication;

import java.io.Serializable;

public class nominaClass implements Serializable {

    private int numRecibo;
    private String nombre;
    private Float horasNormal;
    private Float horasExtras;
    private int puesto;


    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getHorasNormal() {
        return horasNormal;
    }

    public void setHorasNormal(Float horasNormal) {
        this.horasNormal = horasNormal;
    }

    public Float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Float horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public nominaClass() {
        this.numRecibo = numRecibo;
        this.nombre = nombre;
        this.horasNormal = horasNormal;
        this.horasExtras = horasExtras;
        this.puesto = puesto;
    }


    public float calcularSubtotal(){
        float subTotal=0;
        if (this.getPuesto()==1){
            subTotal= (this.getHorasNormal()*50)+(this.getHorasExtras()*100);
        }
        else if (this.getPuesto()==2){
            subTotal= (this.getHorasNormal()*70)+(this.getHorasExtras()*140);
        }
        else if (this.getPuesto()==3){
            subTotal= (this.getHorasNormal()*100)+(this.getHorasExtras()*200);
        }
        return subTotal;
    }


    public float calcularImpuesto() {
        float impuesto = 0;
        impuesto=calcularSubtotal()*0.16f;
        return impuesto;
    }

    public float calcularTotal(){
        float total = calcularSubtotal()-calcularImpuesto();
        return total;
    }

}