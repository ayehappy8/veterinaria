package paqueteV;
import java.util.Scanner;
import java.io.*;
public class  mainV{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    File archivo = new File("paqueteV/datos/datosMain.txt");
    System.out.print("se puede leer : " + archivo.canRead());
    }
    
}
