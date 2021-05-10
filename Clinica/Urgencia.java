package Clinica;
public class Urgencia{
	private String nombre;
	private String motivo;
	private int numero;
	private String ubicacion;
	private String atendido = "no atendido";
	public Urgencia(){

	}
	public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String c){
        this.nombre = c;
    }
	public String getMotivo(){
        return this.motivo;
    }
    public void setMotivo(String c){
        this.motivo = c;
    }
	public int getNumero(){
        return this.numero;
    }
    public void setNumero(int c){
        this.numero = c;
    }
	public String getUbicacion(){
        return this.ubicacion;
    }
    public void setUbicacion(String c){
        this.ubicacion = c;
    }
	public void setAtendido(String c){
		this.atendido = c;
	}
	public String getAtendido(){
		return this.atendido;
	}
    public String toString() {
        String n = this.nombre;
        n += ",";
        n += this.motivo;
        n += ",";
        n += this.numero;
        n += ",";
        n += this.ubicacion;
		n += ",";
		n+= this.atendido;
		n += ";\n";
        return n;
    }
}