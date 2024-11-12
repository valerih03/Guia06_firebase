package com.example.loginproyect.Models;

import java.io.Serializable;

public class Presupuesto implements Serializable {
    private String id;
    private String nombre;
    private double monto;
    private boolean activo;
    private String userId; // Nuevo campo para el UID del usuario

    public Presupuesto(String nombre, double monto, boolean activo, String userId) {
        this.nombre = nombre;
        this.monto = monto;
        this.activo = activo;
        this.userId = userId; // Asigna el UID del usuario
    }

    public Presupuesto() {
    }

    // Getters y setters para userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getters y setters existentes
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", monto=" + monto +
                ", activo=" + activo +
                ", userId='" + userId + '\'' +
                '}';
    }
}