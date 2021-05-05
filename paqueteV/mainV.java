package paqueteV;

import java.util.Scanner;


import java.io.*;
public class  mainV{
public static void main(String[] args) {
    String clientes= "clientes";
    String mascotas = "mascotas";
    creadorDeArchivo(mascotas);
    creadorDeArchivo(clientes);
    //eleminadorDeArchivo("clientes");
    Scanner sc = new Scanner(System.in);
    //datos cliente
    System.out.println("escriba su nombre");
    String nombreC = sc.next();
    System.out.println("escriba su apellido ");
    String apellido = sc.next();
    System.out.println("escriba su telefono");
    int telefono = sc.nextInt();
    System.out.println("escriba su direccion ");
    String direccion = sc.next();
    System.out.println("escriba su email ");
    String email = sc.next();
    //datos cliente
    cliente cliente = new cliente(nombreC, apellido, telefono, direccion, email);
    //datos mascota
    Scanner scN = new Scanner(System.in);
    System.out.println("escriba el nombre de la mascota");
    String nombreM = scN.next();
    System.out.println("escriba el sexo de " + nombreM);
    String sexo = scN.next();
    System.out.println("escriba la edad de " + nombreM);
    int edad = scN.nextInt();
    System.out.println("escriba la especie de " + nombreM);
    String especie = scN.next();
    System.out.println("escriba la raza de " + nombreM);
    String raza = scN.next();
    //datos mascota
    mascota mascota = new mascota (nombreM,sexo,edad,especie,raza);

    
    

    //escritura

    try { 
    FileWriter escritorMascotas = new FileWriter("paqueteV/datos/" + mascotas + ".txt",true);
    
        escritorMascotas.append(mascota.toString());
        escritorMascotas.close();
        System.out.println("ha terminado de escribir "+ mascotas);
    FileWriter escritorClientes = new FileWriter("paqueteV/datos/" + clientes + ".txt",true);    
        escritorClientes.append(cliente.toString());
        escritorClientes.close();
        System.out.println("ha terminado de escribir " + clientes);
        }catch (Exception e) {
            System.out.println("Error");
            
        }

 // lectura  

    try {
        File archivoM = new File("paqueteV/datos/" + mascotas + ".txt");
        Scanner lectorM = new Scanner(archivoM);

        while(lectorM.hasNextLine()){
            String linea = lectorM.nextLine();
            System.out.println("datos mascotas");
            System.out.println(linea);
        }
        lectorM.close();
        File archivoC = new File("paqueteV/datos/" + clientes + ".txt");
        Scanner lectorC = new Scanner(archivoC);

        while(lectorC.hasNextLine()){
            String linea = lectorC.nextLine();
            System.out.println("clientes");
            System.out.println(linea);
        }
        lectorC.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("Error al leer el");
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
                System.out.println("Hubo un error en la eliminacion");
            }
}
    
}


