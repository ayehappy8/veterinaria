package Clinica;
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
        n = n + ";\n";
        return n;
    }
}