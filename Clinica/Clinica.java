package Clinica;
import java.util.Scanner;
import java.io.*;
public class Clinica{
    private static File archivoM = creadorDeArchivo("mascotas");
    private static File archivoC = creadorDeArchivo("clientes");
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //eleminadorDeArchivo("clientes");
        boolean salir = false;
        do{
            switch(menu()){
            //datos cliente
                case 1:
                    Cliente cliente = ingresarCliente();
                    //datos mascota
                    System.out.println("Ingrese la cantidad de mascotas para ingresar");
                    cliente.CantMascotas(sc.nextInt());
                    sc.nextLine();
                    for(int i = 0; i < cliente.getCantMascotas(); i++){
                        System.out.println("Ingrese los datos de la mascota " + (i+1));
                        cliente.setMascota(ingresarMascota(cliente), i);
                    }
                    //datos mascota
                    try{
                        FileWriter escritorClientes = new FileWriter(archivoC,true);    
                        escritorClientes.append(cliente.toString());
                        escritorClientes.close();
                        System.out.println("ha terminado de escribir " + "clientes");
                    }
                    catch(Exception e){
                        System.out.println("Error escribiendo datos del cliente");
                    }
                    for(int i = 0;i < cliente.getCantMascotas(); i++){
                        try{
                            FileWriter escritorMascotas = new FileWriter(archivoM,true);
                            escritorMascotas.append(cliente.getMascota(i).toString());
                            escritorMascotas.close();
                            System.out.println("ha terminado de escribir "+ "mascotas");
                        }catch(Exception e){
                            System.out.println("Error escribiendo datos de la mascota "+ i);       
                        }
                    }
                    // lectura  
                break;
                case 2: mostrarClientes();
                break;
                case 3: mostrarMascotas();
                break;
                case 0: 
                    salir = true;
                    System.out.println("Hasta luego!");
                break;
            }
        }while(!salir);
    }
    //metodos estaticos del main
    public static int menu(){
        System.out.println("*********BIENVENIDO A CLINICA VETERINARIA ICINF**********");
        System.out.println("Donde si no pagas, tu perro muere...");
        System.out.println("\n Escoja una opci�n");
        System.out.println("1: Ingresar como cliente");
        System.out.println("2: Ver clientes");
        System.out.println("3: Ver mascotas");
        System.out.println("0: Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    public static Cliente ingresarCliente(){
        System.out.println("Escriba su nombre");
        String nombreC = sc.nextLine();
        System.out.println("Escriba su apellido ");
        String apellido = sc.nextLine();
        System.out.println("Escriba su telefono");
        int telefono = sc.nextInt();
        sc.nextLine();
        System.out.println("Escriba su direccion ");
        String direccion = sc.nextLine();
        System.out.println("Escriba su email ");
        String email = sc.nextLine();
        //datos cliente
        return new Cliente(nombreC, apellido, telefono, direccion, email);
    }
    public static Mascota ingresarMascota(Cliente dueno){
        System.out.println("Escriba el nombre de la mascota");
        String nombreM = sc.nextLine();
        System.out.println("Escriba el sexo de " + nombreM);
        String sexo = sc.nextLine();
        System.out.println("Escriba la edad de " + nombreM);
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Escriba la especie de " + nombreM);
        String especie = sc.nextLine();
        System.out.println("Escriba la raza de " + nombreM);
        String raza = sc.nextLine();
        //datos mascota
        return new Mascota(dueno.getNombre(), nombreM,sexo,edad,especie,raza);
    }
    public static void mostrarClientes() {
        try{
            Scanner lector = new Scanner(archivoC);
            System.out.println("Clientes.");
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.println(linea);
            }
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
    }
    public static void mostrarMascotas() {
        try{
            Scanner lector = new Scanner(archivoM);
            System.out.println("Mascotas:");
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.println(linea);
            }
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
    }
    public static File creadorDeArchivo(String nombre){
        File archivo = new File("Clinica/datos/"+ nombre +".txt");;
        try{
            if(archivo.createNewFile()) System.out.println("Archivo Creado: " + archivo.getName());
            else System.out.println("El archivo descrito ya existe");
        }
        catch(Exception e){
            System.out.println("Hubo un error en la creacion");
        }
        return archivo;
    }
    public static File eleminadorDeArchivo(String nombre){
        File archivo = new File("Clinica/datos/"+ nombre +".txt");;
        try{
            if(archivo.delete())System.out.println("Archivo eleminado " + archivo.getName());
            else System.out.println("El archivo no existe");
        }
        catch(Exception e){
            System.out.println("Hubo un error en la eliminacion");
        }
        return archivo;
    }    
}