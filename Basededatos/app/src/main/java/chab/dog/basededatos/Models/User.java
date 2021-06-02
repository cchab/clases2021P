package chab.dog.basededatos.Models;

public class User {
    int id,age;
    String nombre;

    public User(int age, String nombre) {
        this.age = age;
        this.nombre = nombre;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
