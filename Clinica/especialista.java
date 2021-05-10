package Clinica;
import java.util.Date;
public class Especialista extends Persona{
    private String especialidad; 
    public Especialista(String especialidad, String nombre, String apellido , int telefono, String email){
        super(nombre, apellido, telefono, email);
        this.especialidad = especialidad;
    }
    public String getEspecialidad(){
        return this.especialidad;
    }
    public void setEspecialidad(String c){
        this.especialidad = c;
    }
    public String toString(){
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
    /*
    public Date getEntrada(){
        return this.entrada;
    }
    public void setEntrada(Date c){
        this.entrada = c;
    }

    public Date getSalida(){
        return this.salida;
    }
    public void setSalida(Date c){
        this.salida = c;
    }
    */
}
