package Clinica;
<<<<<<< Updated upstream
public class Cliente{
private String nombre;
private String apellido;
private int telefono;
private String direccion;
private String email;
private Mascota[] mascotas;
public Cliente(String nombre,String apellido,int telefono,String direccion,String email){
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.direccion = direccion;
    this.email = email;
}
public void CantMascotas(int cant){
    mascotas = new Mascota[cant];
}
public int getCantMascotas(){
    if(this.mascotas != null) return this.mascotas.length;
    else return -1;
}
public void setMascota(Mascota ingresando, int posicion){
    this.mascotas[posicion] = ingresando;
}
public Mascota getMascota(int posicion){
    return this.mascotas[posicion];
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
=======
public class Cliente extends Persona{
    String direccion;
    private Mascota[] mascotas;
    public Cliente(String nombre, String apellido , int telefono, String direccion, String email){
        super(nombre, apellido, telefono, email);
        this.direccion = direccion;
        
    }
    public void CantMascotas(int cant){
        mascotas = new Mascota[cant];
    }
    public int getCantMascotas(){   
        if(this.mascotas != null) return this.mascotas.length;
        else return -1;
    }
    public void setMascota(Mascota ingresando, int posicion){
        this.mascotas[posicion] = ingresando;
    }
    public Mascota getMascota(int posicion){
        return this.mascotas[posicion];
    }
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String c){
        this.direccion = c;
    }
    
>>>>>>> Stashed changes
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
        n = n + ";\n";
        return n;
    }

}