package Clinica;

public class Mascota{
private String dueno;
private String nombre;
private String sexo;
private int edad;
private String especie;
private String raza;
private Hora hora;
    public Mascota(String dueno, String nombre, String sexo, int edad, String especie, String raza, Hora hora){
        this.dueno = dueno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.hora = hora;
    }
    public Hora getHora(){
        return this.hora;
    }
    public void setHora(Hora c){
        this.hora = c;
    }
    public String getDueno() {
        return this.dueno;
    }
    public void setDueno(String c) {
        this.dueno = c;
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
        String n = this.nombre;
        n += ",";
        n += this.sexo;
        n += ",";
        n += this.edad;
        n += ",";
        n += this.especie;
        n += ",";
        n += this.raza;
        n += ";\n";

        return n;
    }
}
