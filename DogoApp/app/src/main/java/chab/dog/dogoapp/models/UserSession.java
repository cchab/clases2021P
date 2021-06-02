package chab.dog.dogoapp.models;

public class UserSession {
    int id;
    String Nombre;
    String Apellido;
    String Email;
    String Password;
    String Uid;


    public UserSession(String nombre, String apellido, String email, String password) {
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
    }

    public UserSession() {
    }





    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
