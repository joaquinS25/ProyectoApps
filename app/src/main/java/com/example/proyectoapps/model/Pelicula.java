package com.example.proyectoapps.model;

public class Pelicula {
    String autor, duracion, genero, titulo;
    boolean is12pm, is2pm, is4pm, is6pm, is2D, is3D;

    public Pelicula(){}

    public Pelicula(String autor, String duracion, String genero, String titulo, boolean is12pm, boolean is2pm, boolean is4pm, boolean is6pm, boolean is2D, boolean is3D) {
        this.autor = autor;
        this.duracion = duracion;
        this.genero = genero;
        this.titulo = titulo;
        this.is12pm = is12pm;
        this.is2pm = is2pm;
        this.is4pm = is4pm;
        this.is6pm = is6pm;
        this.is2D = is2D;
        this.is3D = is3D;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isIs12pm() {
        return is12pm;
    }

    public void setIs12pm(boolean is12pm) {
        this.is12pm = is12pm;
    }

    public boolean isIs2pm() {
        return is2pm;
    }

    public void setIs2pm(boolean is2pm) {
        this.is2pm = is2pm;
    }

    public boolean isIs4pm() {
        return is4pm;
    }

    public void setIs4pm(boolean is4pm) {
        this.is4pm = is4pm;
    }

    public boolean isIs6pm() {
        return is6pm;
    }

    public void setIs6pm(boolean is6pm) {
        this.is6pm = is6pm;
    }

    public boolean isIs2D() {
        return is2D;
    }

    public void setIs2D(boolean is2D) {
        this.is2D = is2D;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }
}
