package paqueteV;
import java.util.Scanner;
import java.io.*;
public class  mainV{
public static void main(String[] args) {
    String juanismoDocumento= "juanismoDocumento";
    creadorDeArchivo(juanismoDocumento);
    //eleminadorDeArchivo("juanismoDocumento");
    Scanner sc = new Scanner(System.in);
    String nombreCliente;
    String nombreMascota;
    System.out.println("escriba su nombre");
    nombreCliente = sc.next();
    try {
    FileWriter escritor = new FileWriter("paqueteV/datos/" + juanismoDocumento + ".txt");
        escritor.append(nombreCliente);
        escritor.close();
        System.out.println("ha terminado de escribir");

        }catch (Exception e) {
            System.out.println("Error");
        }
    }
public static void creadorDeArchivo(String nombre){
    try {
        File archivo = new File("paqueteV/datos/"+ nombre +".txt");
        if(archivo.createNewFile()){
            System.out.println("Archivo Creado: " + archivo.getName());
        } else {
            System.out.println("El archivo descrito ya existe");
        }
            }catch (Exception e) {
                System.out.println("Hubo un error en la creacion");
            }
}
public static void eleminadorDeArchivo(String nombre){
    try {
        File archivo = new File("paqueteV/datos/"+ nombre +".txt");
        if(archivo.delete()){
            System.out.println("Archivo eleminado " + archivo.getName());
        } else {
            System.out.println("El archivo no existe");
        }
            }catch (Exception e) {
                System.out.println("Hubo un error en la creacion");
            }
}
}

