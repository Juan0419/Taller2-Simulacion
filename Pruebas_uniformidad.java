import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pruebas_uniformidad {
    static int[] tablaFrecuencia = new ArrayList<>();
    static double[] chiCalculadoTabla = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    static double[] kolmogorovCalculado = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    static double[] FOA = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    private static ArrayList<Double> ChiCalculadoTabla = new ArrayList<>();


    public static void pruebaChiCuadrado(int mode, int datosGenerados) {
        if (mode == 1) {
            generadores.generadorLinCong(datosGenerados);
        } else if (mode == 2) {
            generadores.generadorEstMin(datosGenerados);
        } else {
            generadores.generadorJava(datosGenerados);
        }
        tablaFrecuencia = generadores.getTabla();
        List<Double> totalDatosGenerados = generadores.getDatosGenerados();
        double Xcritico = 16.92;
        chiCalculado(tablaFrecuencia, totalDatosGenerados);
        dibujarTabla(tablaFrecuencia, Xcritico, totalDatosGenerados);
        if (sum(chiCalculadoTabla) <= Xcritico) {
            System.out.println("");
            System.out.println("Según la prueba de Chi cuadrado el generador es BUENO!!! en cuanto a uniformidad");
            System.out.println("ChiCalculado es: " + sum(chiCalculadoTabla));
            System.out.println("Según la prueba chiCuadrado: ChiCalculado <= chicritico");
            System.out.println(sum(chiCalculadoTabla) + " <= " + Xcritico);
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Según la prueba de Chi cuadrado el generador NO!!!!! es bueno en cuanto a uniformidad");
            System.out.println("ChiCalculado es: " + sum(chiCalculadoTabla));
            System.out.println("Según la prueba chiCuadrado: ChiCalculado <= chicritico");
            System.out.println(sum(chiCalculadoTabla) + " > " + Xcritico);
            System.out.println("");
        }
        verDatos();
        verRecurrencias();
    }

    public static void chiCalculado(int[] tablaFrecuencia2, long totalDatosGenerados) {
        ChiCalculadoTabla.clear();
        BigDecimal bd = BigDecimal.valueOf(totalDatosGenerados);
        BigDecimal numDiv10 = bd.divide(BigDecimal.valueOf(10));
        BigDecimal cuadrado;
        for (int i = 0; i < 10; i++) {
            cuadrado = numDiv10.subtract(BigDecimal.valueOf(tablaFrecuencia2.length)).pow(2);
            BigDecimal div = cuadrado.divide(numDiv10, 2, BigDecimal.ROUND_HALF_UP);
            double result = div.doubleValue();
            ChiCalculadoTabla.add(result);
        }
    }
    
    public static void dibujarTabla(BigDecimal tablaFrecuencia2, double xcritico, char[] totalDatosGenerados) {
        BigDecimal rango = BigDecimal.ZERO;
        System.out.println("  Rango  |   FE   |   FO     |  (FE - FO)^2 / FE | ");
        for (int i = 0; i < 10; i++) {
            BigDecimal cuadrado = (new BigDecimal(totalDatosGenerados).divide(BigDecimal.TEN).subtract(tablaFrecuencia2[i])).pow(2);
            BigDecimal ChiCalculado = cuadrado.divide(new BigDecimal(totalDatosGenerados).divide(BigDecimal.TEN), 1, BigDecimal.ROUND_HALF_UP);
            System.out.println(rango + "-" + rango.add(new BigDecimal("0.1")) + " | " + tablaFrecuencia2[i] + " | " + new BigDecimal(totalDatosGenerados).divide(BigDecimal.TEN) + "      |" + ChiCalculado);
            rango = rango.add(new BigDecimal("0.1"));
        }
    }

    public void calcKolmogorov(BigDecimal[] tablaFrecuencia2, int numerodatos) {
        BigDecimal Rango = new BigDecimal("0.1");
        for (int i = 0; i < 10; i++) {
            double FOA_i = (double) tablaFrecuencia2[i];
            double KolmogorovCalculado_i = Math.abs(Rango.doubleValue() - (FOA_i / numerodatos));
            kolmogorovCalculado[i] = KolmogorovCalculado_i;
            Rango = Rango.add(new BigDecimal("0.1"));
        }
    }

    public void pruebaKolmogorov(int modo, int datosGenerados) {
        GeneradorEstadistico ge = new GeneradorEstadistico();
        BigDecimal[] TablaFrecuencia = new BigDecimal[10];
        double Dmcritico = 1.36 / Math.sqrt(datosGenerados);
        if (modo == 1) {
            ge.generadorlincong(datosGenerados);
        } else if (modo == 2) {
            ge.generadorestmin(datosGenerados);
        } else {
            ge.generadorPython(datosGenerados);
        }
        TablaFrecuencia = ge.returnTabla();
        calcularFOA(TablaFrecuencia);
        calcKolmogorov(TablaFrecuencia, datosGenerados);
        dibujarKolmogorov(TablaFrecuencia, datosGenerados);
        if (Arrays.stream(kolmogorovCalculado).max().getAsDouble() <= Dmcritico) {
            System.out.println("");
            System.out.println("Segun la prueba de Kolmogorov el generador es BUENO!!! en cuanto a uniformidad");
            System.out.println(Arrays.stream(kolmogorovCalculado).max().getAsDouble() + " <= " + Dmcritico);
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Segun la prueba de Kolmogorov el generador NO!!!!! es bueno en cuanto a uniformidad");
            System.out.println(Arrays.stream(kolmogorovCalculado).min().getAsDouble() + " > " + Dmcritico);
            System.out.println("");
        }
        verDatos();
        verRecurrencias();
    }

    public static void calcularFOA(BigDecimal[] tablaFrecuencia2) {
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                FOA[i] = tablaFrecuencia2[i];
            } else {
                FOA[i] = tablaFrecuencia2[i] + FOA[i-1];
            }
        }
    }

    public static void dibujarKolmogorov(BigDecimal[] TablaFrecuencia, int datosGenerados) {
        int rango = 0;
        BigDecimal decimal0_1 = new BigDecimal("0.1");
        System.out.println("  Rango  |   FO   |   FOA     |    POA  |  PEA  | |PEA  - POA | ");
        for (int i = 0; i < 10; i++) {
            BigDecimal POA = FOA[i].divide(new BigDecimal(datosGenerados), 3, BigDecimal.ROUND_HALF_UP);
            BigDecimal PEA = decimal0_1.add(new BigDecimal(rango)).setScale(1);
            System.out.println(rango + "-" + (rango + 0.1) + " | " + TablaFrecuencia[i] + " | " + FOA[i] + "  | " + POA + "  | " + PEA + "     | " + kolmogorovCalculado[i]);
            rango += 0.1;
        }
    }

    public static void verDatos() {
        System.out.println("Desea ver los datos generados?: ");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.nextLine();
            try {
                if (Integer.parseInt(opcion) == 1) {
                    generadores.verDatosGenerados(generadores.returnDatos());
                    break;
                } else if (Integer.parseInt(opcion) == 2) {
                    break;
                } else {
                    System.out.println("Opcion inexistente");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
        }
    }

    public static void verRecurrencias() {
        System.out.println("Desea ver las recurrencias generadas?: ");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.next();
            try {
                if (Integer.parseInt(opcion) == 1) {
                    generadores.verDatosGenerados(generadores.returnRecurrrencias());
                    break;
                } else if (Integer.parseInt(opcion) == 2) {
                    break;
                } else {
                    System.out.println("Opcion inexistente");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
        }
    }
}