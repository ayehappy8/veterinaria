package paqueteV;
public class cliente{
private String nombre;
private String apellido;
private int telefono;
private String direccion;
private String email;

public cliente(String nombre,String apellido,int telefono,String direccion,String email){
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.direccion = direccion;
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
public String getDireccion(){
    return this.direccion;
}
public void setDireccion(String c){
    this.direccion = c;
}
public String getEmail(){
    return this.email;
}
public void setEmail(String c){
    this.email = c;
}

@Override
    public String toString() {
        String n;
        n = this.nombre;
        n = n + ",";
        n= n + this.apellido;
        n = n + ",";
        n= n + this.telefono;
        n = n + ",";
        n= n + this.direccion;
        n = n + ",";
        n= n + this.email;
        n = n + ";";

        return n;
    }

}