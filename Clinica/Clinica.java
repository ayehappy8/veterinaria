package Clinica;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.Date;
import java.time.*;
public class Clinica{
    public static String[] conductores ={
        "Seba",
        "Juan",
        "Jaime",
        "Ignacio",
        "Maxi",
    };
    public static String[] especialidades={// (neurolog´?a, reproducci´on, odontolog´?a, oncolog´?a y Cardiolog´?a
        "Neurología",
        "Reproducción",
        "Odontología",
        "Oncología",
        "Cardiología",
    };
    private static Especialista[] especialistas = new Especialista[5];
    private static File archivoM = creadorDeArchivo("mascotas");
    private static File archivoC = creadorDeArchivo("clientes");
    private static File archivoU = creadorDeArchivo("urgencias");
    private static File archivoE = creadorDeArchivo("especialistas");
    static Scanner sc = new Scanner(System.in);
    private static Ambulancia[] ambulancias = new Ambulancia[5];
    public static void main(String[] args){ 
        byte[] array = new byte[6];
        for(int i = 0; i<ambulancias.length; i++){
            Random rand = new Random();
            String newpatente="";
            for(int j = 0; j<6;j++){
                char next;
                do{
                    next = (char)(rand.nextInt(90 + 1 - 48) + 48);
                }while(next >= 58 && next <=64);
                newpatente= newpatente + next;
            }
            ambulancias[i] = new Ambulancia(conductores[i], newpatente);
        }
        //for(Ambulancia ambul:ambulancias)System.out.println("ambulancia creada: "+ ambul.getConductor() + " "+ambul.getPatente());
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
                    guardar("clientes", cliente.toString());
                    for(int i = 0;i < cliente.getCantMascotas(); i++) guardar("mascotas", cliente.getMascota(i).toString());
                    // lectura  
                break;
                case 2: //lamado de urgencia
                    Urgencia nueva = new Urgencia();
                    System.out.println("Ingrese su nombre");
                    nueva.setNombre(sc.nextLine());
                    System.out.println("Ingrese su motivo");
                    nueva.setMotivo(sc.nextLine());
                    System.out.println("Ingrese su numero");
                    nueva.setNumero(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Ingrese su ubicación");
                    nueva.setUbicacion(sc.nextLine());
                    guardar("urgencias", nueva.toString());
                    System.out.println("\nverificando ambulancias disponibles...");
                    for(int i = 0; i < ambulancias.length && nueva.getAtendido().equals("no atendido");i++){
                        if(ambulancias[i].urgencia == null){
                            ambulancias[i].urgencia = nueva;
                            nueva.setAtendido("atendido");
                            System.out.println("Será atendido por "+ambulancias[i].getConductor()+" en la ambulancia con patente "+ambulancias[i].getPatente());
                        }
                        else System.out.println("No hay ambulancias disponibles");
                    }
                    guardar("urgencias", nueva.toString());

                break;
                case 3: mostrar("clientes");
                break;
                case 4: mostrar("mascotas");
                break;
                case 5: mostrar("urgencias");
                break;
                case 6: eliminarDatos();
                break;
                case 7: mostrarAmbulancias();
                break;
                case 8:
                    limpiar("especialistas");
                    for(int i = 0; i<especialistas.length; i++){
                        especialistas[i] = ingresarEspecialista(especialidades[i]);
                        guardar("especialistas", especialistas[i].toString());
                    }
                break;
                case 9:
                    mostrar("especialistas");
                    int linea;
                    do{
                        System.out.println("Ingrese la linea de especialistas a ingresar");
                        linea = sc.nextInt();
                        sc.nextLine();
                    }
                    while(linea<=0 || linea >=5);
                    especialistas[linea] = ingresarEspecialista(especialidades[linea]);
                    limpiar("especialistas");
                    for(Especialista guardando:especialistas) guardar("especialistas", guardando.toString());

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
        System.out.println("\n Escoja una opción");
        System.out.println("1: Pedir una hora");
        System.out.println("2: Llamado de urgencia");
        System.out.println("3: Ver clientes");
        System.out.println("4: Ver mascotas");
        System.out.println("5: Ver urgencias");
        System.out.println("6: Editar datos y archivos");
        System.out.println("7: Ver ambulancias");
        System.out.println("8: Ingresar especialistas");
        System.out.println("0: Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    public static void mostrarAmbulancias(){
        for(Ambulancia mostrando: ambulancias){
            System.out.print("Ambulancia de "+ mostrando.getConductor()+ " Patente: "+mostrando.getPatente());
            if(mostrando.getUrgencia() != null) System.out.println(" Ocupada");
            else System.out.println(" Libre");
        }
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
        System.out.println("Elija el especialista con el que quiere atender a su mascota");
        for(int i = 0; i<especialidades.length; i++) System.out.println((i+1)+": "+especialidades[i]);
        String esp = especialidades[sc.nextInt()-1];
        sc.nextLine();
        LocalDate hoy = LocalDate.now();
        Date dfinal;
        /*do{
            dfinal = java.sql.Date.valueOf(hoy.plusDays(1));
            hoy=hoy.plusDays(1);
            System.out.println("viendo dia "+ dfinal);
        }while(dfinal.getDay() == 6 || dfinal.getDay() == 0);
        System.out.println("La fecha final es "+ dfinal);
        Hora hora = new Hora(esp, nombreM, dfinal);
        //datos mascota*/
        return new Mascota(dueno.getNombre(), nombreM,sexo,edad,especie,raza);
    }
    public static Especialista ingresarEspecialista(String esp){
        System.out.println("ingrese el nombre del veterinario de "+esp);
        String nombre = sc.nextLine();
        System.out.println("ingrese el apellido del veterinario de "+esp);
        String apellido = sc.nextLine();
        System.out.println("ingrese el telefono del veterinario de "+esp);
        int telefono = sc.nextInt();
        sc.nextLine();
        System.out.println("ingrese el email del veterinario de "+esp);
        String email = sc.nextLine();
        return new Especialista(esp, nombre, apellido, telefono, email);
    }
    public static void mostrar(String editando) {
        try{
            Scanner lector = null;
            int lineas= 0;
            if(editando.equals("clientes")) lector = new Scanner(archivoC);
            else if(editando.equals("mascotas")) lector = new Scanner(archivoM);
            else if(editando.equals("urgencias")) lector = new Scanner(archivoU);
            else if(editando.equals("especialistas")) lector = new Scanner(archivoE);
            System.out.println("Datos guardados de "+ editando);
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.print("Linea "+lineas);
                for(String mostrando: linea.split(";")) System.out.print(" | "+mostrando);
                System.out.print("\n");
                lineas++;
            }
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
    }
    public static void guardar(String editando, String texto){
        try{
            FileWriter escritor = null;
            if(editando.equals("clientes")) escritor= new FileWriter(archivoC,true);  
            else if(editando.equals("mascotas")) escritor=new FileWriter(archivoM,true);
            else if(editando.equals("urgencias")) escritor = new FileWriter(archivoU, true);
            else if(editando.equals("especialistas")) escritor = new FileWriter(archivoE, true);
            escritor.append(texto);
            escritor.close();
            System.out.println("ha terminado de escribir en " + editando);
        }
        catch(Exception e){
            System.out.println("Error escribiendo datos de "+editando);
        }
    }
    public static void eliminar(String editando, int eliminar) {
        try{
            Scanner lector = null;
            int lineas= 0;
            String finaltxt = "";
            if(editando.equals("clientes")) lector = new Scanner(archivoC);
            else if(editando.equals("mascotas")) lector = new Scanner(archivoM);
            else if(editando.equals("urgencias")) lector = new Scanner(archivoU);
            else if(editando.equals("especialistas")) lector = new Scanner(archivoE);
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                if(lineas != eliminar) finaltxt+=linea + "\n";
                lineas++;
            }
            FileWriter escritor=null;
            if(editando.equals("clientes")) escritor = new FileWriter(archivoC,false);
            else if(editando.equals("mascotas")) escritor = new FileWriter(archivoM,false);
            else if(editando.equals("urgencias")) escritor = new FileWriter(archivoU, false);
            else if(editando.equals("especialistas")) escritor = new FileWriter(archivoE, false);
            escritor.write(finaltxt);
            escritor.close();
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
        catch(IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void limpiar(String editando) {
        try{
            FileWriter escritor=null;
            if(editando.equals("clientes")) escritor = new FileWriter(archivoC,false);
            else if(editando.equals("mascotas")) escritor = new FileWriter(archivoM,false);
            else if(editando.equals("urgencias")) escritor = new FileWriter(archivoU, false);
            else if(editando.equals("especialistas")) escritor = new FileWriter(archivoE, false);
            escritor.write("");
            escritor.close();
            System.out.println("Datos de "+editando+" han sido limpiados");
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
        catch(IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void eliminarDatos(){
        int opcion;
        do{
            System.out.println("\nElija una opcion");
            System.out.println("1: Editar archivos de clientes");
            System.out.println("2: Editar archivos de mascotas");
            System.out.println("3: Editar archivos de urgencias");
            System.out.println("0: Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: editar("clientes");
                break;
                case 2: editar("mascotas");
                break;
                case 3: editar("urgencias");
                break;
            }
        }while(opcion!=0);
    }
    public static void editar(String editando){
        int opcion;
        do{
            System.out.println("\nElija una opcion");
            System.out.println("1: eliminar archivo de "+editando);
            System.out.println("2: eliminar algun dato de "+editando);
            System.out.println("3: limpiar todos los datos de "+editando);
            System.out.println("0: Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: eliminadorDeArchivo(editando);
                break;
                case 2:{
                    mostrar(editando);
                    System.out.println("Elija que linea desea eliminar");
                    eliminar(editando, sc.nextInt());
                    sc.nextLine();
                }
                break;
                case 3: limpiar(editando);
                break;
            }
        }while(opcion!=0);
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
    public static File eliminadorDeArchivo(String nombre){
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