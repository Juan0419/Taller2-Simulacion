import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Pruebas_uniformidad {
static double[] chiCalculadoTabla = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
static double[] kolmogorovCalculado = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
static double[] FOA = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

// """TablaFrecuencia,datosGenerados""" parametros prueba x2
public static void PruebaChiCuadrado(int modo, int datosGenerados) {
    // datosGenerados = Integer.parseInt(System.console().readLine("Cuantos datos desea generar: "));
    if (modo == 1) {
        generadores.generadorLinCong(datosGenerados);
    } else if (modo == 2) {
        generadores.generadorEstMin(datosGenerados);
    } else {
        generadores.generadorJava(datosGenerados);
    }
    ArrayList<Double> TablaFrecuencia = generadores.returnTabla();
    // datosGenerados = #1000
    double Xcritico = 16.92; // double Xcritico = Double.parseDouble(System.console().readLine("Ingrese el chi critico: "));
    chiCalculado(TablaFrecuencia, datosGenerados);
    dibujarTabla(TablaFrecuencia, Xcritico, datosGenerados);
    if (Arrays.stream(chiCalculadoTabla).sum() <= Xcritico) {
        System.out.println("");
        System.out.println("Segun la prueba de Chi cuadrado el generador es BUENO!!! en cuanto a uniformidad");
        System.out.println("ChiCalculado es: " + Arrays.stream(chiCalculadoTabla).sum());
        System.out.println("Segun la prueba chiCuadrado: ChiCalculado <= chicritico");
        System.out.println(Arrays.stream(chiCalculadoTabla).sum() + " <= " + Xcritico);
        System.out.println("");
    } else {
        System.out.println("");
        System.out.println("Segun la prueba de Chi cuadrado el generador NO!!!!! es bueno en cuanto a uniformidad");
        System.out.println("ChiCalculado es: " + Arrays.stream(chiCalculadoTabla).sum());
        System.out.println("Segun la prueba chiCuadrado: ChiCalculado <= chicritico");
        System.out.println(Arrays.stream(chiCalculadoTabla).sum() + " > " + Xcritico);
        System.out.println("");
    }
    verDatos();
    verRecurrencias();
}

public static void chiCalculado(ArrayList<Double> tablaFrecuencia, int datosGenerados) {
    BigDecimal[] chiCalculadoTabla = new BigDecimal[10];
    MathContext mc = new MathContext(2);

    for (int i = 0; i < 10; i++) {
        BigDecimal cuadrado = new BigDecimal(Math.pow((datosGenerados/10.0 - tablaFrecuencia.get(i)), 2));
        BigDecimal division = cuadrado.divide(new BigDecimal(datosGenerados/10.0), mc);
        chiCalculadoTabla[i] = division;
    }
}
    
public static BigDecimal[] getChiCalculadoTabla() {
    BigDecimal[] chiCalculadoTabla = new BigDecimal[10];
    // aquí iría la lógica para calcular los valores de chiCalculadoTabla
    return chiCalculadoTabla;
}

public static void dibujarTabla(ArrayList<Double> tablaFrecuencia, double xc, int datosGenerados) {
    BigDecimal[] chiCalculadoTabla = getChiCalculadoTabla();
    MathContext mc = new MathContext(1);

    double rango = 0.0;
    System.out.println("  Rango  |   FE   |   FO     |  (FE - FO)^2 / FE | ");
    for (int i = 0; i < 10; i++) {
        BigDecimal fe = new BigDecimal(tablaFrecuencia.get(i), mc);
        BigDecimal fo = new BigDecimal(datosGenerados/10.0, mc);
        System.out.println(rango + " - " + (rango + 0.1) + " | " + fe + " | " + fo + " | " + chiCalculadoTabla[i]);
        rango += 0.1;
    }
}

public static void calcKolmogorov(ArrayList<Double> tablaFrecuencia, int numeroDatos) {
    MathContext mc = new MathContext(3);
    BigDecimal rango = new BigDecimal(0.1);
    BigDecimal[] kolmogorovCalculado = new BigDecimal[10];

    for (int i = 0; i < 10; i++) {
        BigDecimal foa = new BigDecimal(tablaFrecuencia.get(i), mc);
        BigDecimal calculado = rango.subtract(foa.divide(new BigDecimal(numeroDatos), mc)).abs();
        kolmogorovCalculado[i] = calculado;
        rango = rango.add(new BigDecimal(0.1));
    }
}

public static void pruebaKolmogorov(int modo, int datosGenerados) {
    double dmCritico = 1.36 / Math.sqrt(datosGenerados);

    if (modo == 1) {
        generadores.generadorLinCong(datosGenerados);
    } else if (modo == 2) {
        generadores.generadorEstMin(datosGenerados);
    } else {
        generadores.generadorJava(datosGenerados);
    }

    ArrayList<Double> tablaFrecuencia = generadores.returnTabla();
    calcularFOA(tablaFrecuencia);
    calcKolmogorov(tablaFrecuencia, datosGenerados);
    dibujarKolmogorov(tablaFrecuencia, datosGenerados);

    if (DoubleStream.of(kolmogorovCalculado).max().getAsDouble() <= dmCritico) {
        System.out.println("");
        System.out.println("Según la prueba de Kolmogorov, el generador es BUENO en cuanto a uniformidad");
        System.out.println(DoubleStream.of(kolmogorovCalculado).max().getAsDouble() + " <= " + dmCritico);
        System.out.println("");
    } else {
        System.out.println("");
        System.out.println("Según la prueba de Kolmogorov, el generador NO es bueno en cuanto a uniformidad");
        System.out.println(DoubleStream.of(kolmogorovCalculado).min().getAsDouble() + " > " + dmCritico);
        System.out.println("");
    }

    verDatos();
    verRecurrencias();
}

public static void calcularFOA(ArrayList<Double> tablaFrecuencia) {
    for (int i = 0; i < 10; i++) {
        if (i == 0) {
            FOA[i] = tablaFrecuencia.get(i);
        } else {
            FOA[i] = tablaFrecuencia.get(i) + FOA[i-1];
        }
    }
}

public static void dibujarKolmogorov(ArrayList<Double> tablaFrecuencia, int datosGenerados) {
    MathContext mc = new MathContext(1);
    BigDecimal rango = new BigDecimal(0);

    System.out.println("  Rango  |   FO   |   FOA     |    POA  |  PEA  | |PEA  - POA | ");
    for (int i = 0; i < 10; i++) {
        BigDecimal foa = new BigDecimal(FOA[i], mc);
        BigDecimal poa = foa.divide(new BigDecimal(datosGenerados), mc);
        BigDecimal pea = rango.add(new BigDecimal(0.1), mc);
        BigDecimal diff = pea.subtract(poa).abs();
        System.out.println(rango + "-" + rango.add(new BigDecimal(0.1)) + " | " + tablaFrecuencia.get(i) + " | " + FOA[i] + "  |   " + poa + "  |  " + pea + "     |  " + diff);
        rango = rango.add(new BigDecimal(0.1), mc);
    }
}

public static void verDatos() {
    System.out.println("Desea ver los datos generados?: ");
    System.out.println("[1] Si");
    System.out.println("[2] No");

    while (true) {
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();

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
    Scanner input = new Scanner(System.in);
    while (true) {
        String opcion = input.nextLine();
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