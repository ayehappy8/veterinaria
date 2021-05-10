package Clinica;
import java.util.Date;
public class Hora{
	Especialista veterinario;
	String paciente;
	Date fecha;
	public Hora(Especialista veterinario,String paciente, Date fecha){
		this.veterinario = veterinario;
		this.paciente = paciente;
        this.fecha = fecha;
	}
	public Especialista getVeterinario(){
        return this.veterinario;
    }
    public void setVeterinario(Especialista c){
        this.veterinario = c;
    }
	public String getPaciente(){
        return this.paciente;
    }
    public void setPaciente(String c){
        this.paciente = c;
    }
	public Date getFecha(){
        return this.fecha;
    }
    public void setFecha(Date c){
        this.fecha = c;
    }
    public String toString(){
        String n = this.veterinario.getNombre();
        n += ",";
        n += this.paciente;
        n += ",";
        n += this.fecha;
        n += ";\n";
        return n;
    }
}