import java.util.*;
import java.lang.*;
import java.io.*;

public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean contador = true;
        boolean contador2 = true;
        boolean contador3 = true;
        while (true) {
            System.out.println("");
            System.out.println("1.Generador lineal congruente");
            System.out.println("2.Generador estandar minimo");
            System.out.println("3.Generador de java");
            System.out.println("4.Volver");
            System.out.println("");
            int Puntero_Interno = sc.nextInt();
            while (Puntero_Interno > 4 || Puntero_Interno < 1) {
                Puntero_Interno = sc.nextInt();
            }
            if (Puntero_Interno == 1) {
                System.out.println("");
                int datos = sc.nextInt();
                generadorlincong(datos);
                VerDatosGenerados(returnDatos());
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                if (Puntero_Interno2 == 1) {
                    prueba.prueba_chi_cuadrado(returnDatos());
                } else {
                    contador2 = false;
                }
            } else if (Puntero_Interno == 2) {
                System.out.println("");
                int datos = sc.nextInt();
                generadorMinimo(datos);
                VerDatosGenerados(returnDatos());
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                if (Puntero_Interno2 == 1) {
                    prueba.prueba_chi_cuadrado(returnDatos());
                } else {
                    contador2 = false;
                }
            } else if (Puntero_Interno == 3) {
                System.out.println("");
                int datos = sc.nextInt();
                generadorPython(datos);
                VerDatosGenerados(returnDatos());
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                if (Puntero_Interno2 == 1) {
                    prueba.prueba_chi_cuadrado(returnDatos());
                } else {
                    contador2 = false;
                }
            } else {
                contador = false;
                break;
            }
        }
    }
}
