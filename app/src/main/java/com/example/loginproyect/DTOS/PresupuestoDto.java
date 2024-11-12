package com.example.loginproyect.DTOS;

public class PresupuestoDto {
    private String nombre;
    private double monto;
    private boolean activo;
    private String userId; // Nuevo campo para el UID del usuario

    public PresupuestoDto(String nombre, double monto, boolean activo, String userId) {
        this.nombre = nombre;
        this.monto = monto;
        this.activo = activo;
        this.userId = userId; // Asigna el UID del usuario
    }

    // Constructor sin userId para casos donde no se necesite
    public PresupuestoDto(String nombre, double monto, boolean activo) {
        this.nombre = nombre;
        this.monto = monto;
        this.activo = activo;
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
}  