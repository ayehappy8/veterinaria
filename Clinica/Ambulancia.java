package Clinica;
public class Ambulancia{
	String conductor;
	Urgencia urgencia;
	String patente;
	public Ambulancia(String conductor, String patente){
		this.conductor = conductor;
		this.patente = patente;
	}
	public String getConductor(){
        return this.conductor;
    }
    public void setConductor(String c){
        this.conductor = c;
    }
	public String getPatente(){
        return this.patente;
    }
    public void setPatente(String c){
        this.patente = c;
    }
	public Urgencia getUrgencia(){
        return this.urgencia;
    }
    public void setUrgencia(Urgencia c){
        this.urgencia = c;
    }
}