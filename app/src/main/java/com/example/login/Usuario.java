package com.example.login;

public class Usuario {
    int id;
    String Nombre, Apellido, Usuario, Contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Contraseña = contraseña;
    }

    public boolean isNull(){
        if (Nombre.equals("")&&Apellido.equals("")&&Usuario.equals("")&Contraseña.equals("")){
            return false;
        }
        else {
            return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
}
