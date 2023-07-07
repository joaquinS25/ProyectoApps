package com.example.proyectoapps.model;

public class User {
    String nombreUser,apellidoUser,dniUser,celularUser,emailUser;
    int edadUser;
    public User(){}

    public User(String nombreUser, String apellidoUser, String dniUser, String celularUser, String emailUser, int edadUser) {
        this.nombreUser = nombreUser;
        this.apellidoUser = apellidoUser;
        this.dniUser = dniUser;
        this.celularUser = celularUser;
        this.emailUser = emailUser;
        this.edadUser = edadUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getApellidoUser() {
        return apellidoUser;
    }

    public void setApellidoUser(String apellidoUser) {
        this.apellidoUser = apellidoUser;
    }

    public String getDniUser() {
        return dniUser;
    }

    public void setDniUser(String dniUser) {
        this.dniUser = dniUser;
    }

    public String getCelularUser() {
        return celularUser;
    }

    public void setCelularUser(String celularUser) {
        this.celularUser = celularUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getEdadUser() {
        return edadUser;
    }

    public void setEdadUser(int edadUser) {
        this.edadUser = edadUser;
    }
}
