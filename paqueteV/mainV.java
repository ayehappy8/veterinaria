package paqueteV;

import java.util.Scanner;
import java.io.*;
public class  mainV{
    private static File archivoM = creadorDeArchivo("mascotas");
    private static File archivoC = creadorDeArchivo("clientes");
    public static void main(String[] args) {
        //eleminadorDeArchivo("clientes");
        Scanner sc = new Scanner(System.in);
        //datos cliente
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
        Cliente cliente = new Cliente(nombreC, apellido, telefono, direccion, email);
        //datos mascota
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
        Mascota mascota = new Mascota(nombreM,sexo,edad,especie,raza);

        //escritura

        try{
            FileWriter escritorMascotas = new FileWriter(archivoM,true);
            escritorMascotas.append(mascota.toString());
            escritorMascotas.close();
            System.out.println("ha terminado de escribir "+ "mascotas");
            FileWriter escritorClientes = new FileWriter(archivoC,true);    
            escritorClientes.append(cliente.toString());
            escritorClientes.close();
            System.out.println("ha terminado de escribir " + "clientes");
        }catch(Exception e){
            System.out.println("Error en la escritura de datos");       
        }

        // lectura  

        try{
            Scanner lector_archivos = new Scanner(archivoM);
            System.out.println("datos mascotas");
            while(lector_archivos.hasNextLine()){
                String linea = lector_archivos.nextLine();
                System.out.println(linea);
            }
            lector_archivos.close();
            Scanner archivos = new Scanner(archivoC);
            System.out.println("clientes");
            while(lector_archivos.hasNextLine()){
                String linea = lector_archivos.nextLine();
                System.out.println(linea);
            }
            lector_archivos.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el");
        }
    }
    //metodos estaticos del main
    public static File creadorDeArchivo(String nombre){
        File archivo = new File("paqueteV/datos/"+ nombre +".txt");;
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
        File archivo = new File("paqueteV/datos/"+ nombre +".txt");;
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


