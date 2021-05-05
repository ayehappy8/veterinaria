package paqueteV;

public class mascotas {
private String nombre;
    public mascotas(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        String n;
        n = this.nombre;
        n = n + ";";

        return n;
    }
}
