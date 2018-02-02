package com.iteso.app_tarea2_clase5;

/**
 * Created by Carlos Rivera on 01/02/2018.
 */

public class Alumno {
    public String nombre = "";
    public String telefono = "";
    public boolean hombre = false;
    public boolean mujer = false;
    public String educacion = "";
    public String libro = "";
    public boolean deporte = false;


    public void setNombre (String name){
        this.nombre = name;
    }
    public void setTelefono (String phone){
        this.telefono = phone;
    }
    public void setHombre (boolean masc){
        this.hombre = masc;
    }
    public void setMujer (boolean fem){
        this.mujer = fem;
    }
    public void setEducacion (String education){
        this.educacion = education;
    }
    public void setBook (String book){
        this.libro = book;
    }
    public void setSport (boolean sport){
        this.deporte = sport;
    }

    @Override
    public String toString() {
            String selected = "";
            selected = "Nombre: " + nombre + "\nTelefono: " + telefono + "\nSexo: " + (hombre?"Masculino":"Femenino")+"\nEscolaridad: " +
                    educacion + "\nLibro: " + libro + "Practica deporte: " + (deporte?"Si":"No");
        return  selected;
    }
}
