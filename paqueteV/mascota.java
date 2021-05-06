package paqueteV;

public class Mascota{

private String nombre;
private String sexo;
private int edad;
private String especie;
private String raza;

    public  Mascota(String nombre, String sexo, int edad, String especie, String raza){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String c){
        this.nombre = c;
    }
    public String getSexo(){
        return this.sexo;
    }
    public void setSexo(String c){
        this.sexo = c;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int c){
        this.edad = c;
    }
    public String getEspecie(){
        return this.especie;
    }
    public void setEspecie(String c){
        this.especie = c;
    }
    public String getRaza(){
        return this.raza;
    }
    public void setRaza(String c){
        this.raza = c;
    }

    public String toString() {
        String n;
        n = this.nombre;
        n = n + ",";
        n= n + this.sexo;
        n = n + ",";
        n= n + this.edad;
        n = n + ",";
        n= n + this.especie;
        n = n + ",";
        n= n + this.raza;
        n = n + ";\n";

        return n;
    }
}
