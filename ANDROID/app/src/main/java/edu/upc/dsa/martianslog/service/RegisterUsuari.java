package edu.upc.dsa.martianslog.service;

public class RegisterUsuari
{
    private String idUser;
    private String name;
    private String surname;
    private String username;
    private String password;

    public RegisterUsuari(){}

    public RegisterUsuari(String name, String surname, String username, String password)
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
