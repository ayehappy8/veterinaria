package Clinica;

public class Persona  {
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    public Persona(String nombre, String apellido, int telefono, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;        
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String c){
        this.nombre = c;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String c){
        this.apellido = c;
    }
    public int getTelefono(){
        return this.telefono;
    }
    public void setTelefono(int c){
        this.telefono = c;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String c){
        this.email = c;
    }
}
