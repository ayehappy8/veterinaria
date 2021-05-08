package Clinica;

public class especialista extends Persona{

    private String especialidad; 
    
    public especialista(String especialidad, String nombre, String apellido , int telefono, String email){
        super(nombre, apellido, telefono, email);
        this.especialidad = especialidad;
}
public String getEspecialidad(){
return this.especialidad;
}
public void setEspecialidad(String c){
    this.especialidad = c;
}
}

