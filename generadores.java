import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class generadores {
    static int[] Tabla = {0,0,0,0,0,0,0,0,0,0};

    public static int[] getTabla() {
        return Tabla;
    }

    static List<Double> datosGenerados = new ArrayList<>();

    public static List<Double> getDatosGenerados() {
        return datosGenerados;
    }

    static List<Double> recurrencias = new ArrayList<>();
    static int n = 0;
    public long a;
    public long c;
    public long m;
    public long xn; // semilla, iterador

    public generadores(long a, long c, long m, long xn) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.xn = xn;
    }

    public static void generadorLinCong(int DatRequer){
       
        Scanner input = new Scanner(System.in);
    
        System.out.print("a es: ");
        int a = input.nextInt();
    
        System.out.print("c es: ");
        int c = input.nextInt();
    
        System.out.print("m es: ");
        int m = input.nextInt();
    
        System.out.print("Xo es: ");
        int Xo = input.nextInt();
    
        n = DatRequer;
        System.out.println();
    
        datosGenerados.add((double) Xo);
        recurrencias.add((double) (Math.round(Xo / (double) m * 1000) / 1000));
        int res = (a * Xo + c) % m;
        evaluarRecurrencia(res, m);
    
        for (int i = 0; i < n; i++) {
            datosGenerados.add((double) res);
            recurrencias.add((double) (Math.round(res / (double) m * 1000) / 1000));
            evaluarRecurrencia(res, m);
            res = (a * res + c) % m;
        }
    
        hallarPeriodo();
        
    }

    public static void generadorEstMin(int DatRequer){
        Scanner sc = new Scanner(System.in);
        int a, m, Xo;
        System.out.print("a es: ");
        a = sc.nextInt();
        System.out.print("m es: ");
        m = sc.nextInt();
        System.out.print("Xo es: ");
        Xo = sc.nextInt();
        sc.close();

        n = DatRequer;
        System.out.println();

        int res = (a * Xo) % m;
        datosGenerados.add((double) Xo);
        recurrencias.add((double) Math.round((Xo / (double) m) * 1000) / 1000);
        evaluarRecurrencia(res, m);

        for (int i = 0; i < n - 1; i++) {
            res = (a * res) % m;
            datosGenerados.add((double) res);
            recurrencias.add((double) Math.round((res / (double) m) * 1000) / 1000);
            evaluarRecurrencia(res, m);
        }

        hallarPeriodo();
    }

    public static void generatorStanMinFact(int DatRequer){
        Scanner sc = new Scanner(System.in);
        int a, m, Xo;
        System.out.print("a es: ");
        a = sc.nextInt();
        System.out.print("m es: ");
        m = sc.nextInt();
        System.out.print("Xo es: ");
        Xo = sc.nextInt();
        sc.close();

        n = DatRequer;
        System.out.println();
    
        int res = (a * Xo) % m;
        datosGenerados.add((double) Xo);
        recurrencias.add((double) Math.round((Xo / (double) m) * 1000) / 1000);
        evaluarRecurrencia(res, m);

        ArrayList<Long> listaLong = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            res = (a * res) % m;
            double xn = 0;
            double q = Math.floor(m / a);
            long qlong = (long)q;
            long r = m % a;

            xn = (a * xn) % m;
            if(xn >= 0){
                listaLong.add((long) (a * (xn % qlong)-r * Math.floor(xn/qlong)));
            }else {
                listaLong.add((long) (a * (xn % q)-r * Math.floor(xn/q)+m));
            }

            datosGenerados.add((double) res);
            recurrencias.add((double) Math.round((res / (double) m) * 1000) / 1000);
            evaluarRecurrencia(res, m);
        }

        hallarPeriodo();
    }

    public static void generadorJava(int DatRequer){
        n = DatRequer;
        Random rnd = new Random();
        for (int i = 0; i < DatRequer; i++) {
            int res = rnd.nextInt(2000) + 1;
            datosGenerados.add((double) res);
            recurrencias.add((double) res/2000);
            evaluarRecurrencia(res, 2000);
        }
        hallarPeriodo();
    }

    public static void evaluarRecurrencia(double Xn, double m) {
        double Rn = Xn/m;
        if (Rn < 0.1 && Rn >= 0) {
            Tabla[0] += 1;
        } else if (Rn < 0.2 && Rn >= 0.1) {
            Tabla[1] += 1;
        } else if (Rn < 0.3 && Rn >= 0.2) {
            Tabla[2] += 1;
        } else if (Rn < 0.4 && Rn >= 0.3) {
            Tabla[3] += 1;
        } else if (Rn < 0.5 && Rn >= 0.4) {
            Tabla[4] += 1;
        } else if (Rn < 0.6 && Rn >= 0.5) {
            Tabla[5] += 1;
        } else if (Rn < 0.7 && Rn >= 0.6) {
            Tabla[6] += 1;
        } else if (Rn < 0.8 && Rn >= 0.7) {
            Tabla[7] += 1;
        } else if (Rn < 0.9 && Rn >= 0.8) {
            Tabla[8] += 1;
        } else {
            Tabla[9] += 1;
        }
    }
    
    public static ArrayList<Double> returnTabla() {
        ArrayList<Double> lista = new ArrayList<Double>();
        // Agregar elementos a la lista aquí, si es necesario
        return lista;
    }
    
    public static int returnN() {
        return n;
    }
    
    public static ArrayList<Double> returnRecurrrencias() {
        return new ArrayList<>(recurrencias);
    }
    
    public static ArrayList<Double> returnDatos() {
        return new ArrayList<>(datosGenerados);
    }
    
    public static void ReiniciarArreglos(long[] arrayList) {
        Arrays.fill(arrayList, 0);
    }
    
    public static void ReiniciarListas(ArrayList<Double> lista) {
        lista.clear();
    }

    private static void hallarPeriodo() {
        try {
            int periodo = datosGenerados.subList(1, datosGenerados.size()).indexOf(datosGenerados.get(0)) + 1;
           JOptionPane.showMessageDialog(null,"El periodo para este generador es: " + periodo);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"No hay periodo disponible para la cantidad de datos que generó.");
        }
    }

    public static void verDatosGenerados(List<Double> datos) {
        for (int i = 0; i < datos.size(); i++) {
            System.out.println(datos.get(i));
        }
    }
}