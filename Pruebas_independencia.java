import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Pruebas_independencia {
    static List<String> corridas = new ArrayList<String>();
    static int[][] TablaSeries = new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    static int[][] TablaSeriesCalc = new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};

public static int contarCorridas(int[] recurrencias) {
    int Corridas = 0;
    int ValCorrida = 0;
    int pos = 0;
    int neg = 0;
    for (int i = 0; i < recurrencias.length - 1; i++) {
        if (i == 0) {
            corridas.add("*");
            if (recurrencias[i] > recurrencias[i + 1]) {
                pos = 1;
                corridas.add("-");
            } else if (recurrencias[i] < recurrencias[i + 1]) {
                neg = 1;
                corridas.add("+");
            }
            ValCorrida = recurrencias[i + 1];
        } else if (pos == 1 && recurrencias[i] < recurrencias[i + 1]) {
            ValCorrida = recurrencias[i + 1];
            corridas.add("+");
        } else if (neg == 1 && recurrencias[i] > recurrencias[i + 1]) {
            ValCorrida = recurrencias[i + 1];
            corridas.add("-");
        } else if (pos == 1 && recurrencias[i] > recurrencias[i + 1]) {
            ValCorrida = recurrencias[i + 1];
            pos = 0;
            neg = 1;
            Corridas++;
            corridas.add("-");
        } else if (neg == 1 && recurrencias[i] < recurrencias[i + 1]) {
            ValCorrida = recurrencias[i + 1];
            pos = 1;
            neg = 0;
            Corridas++;
            corridas.add("+");
        }
    }
    return Corridas;
}

public static void pruebaCorridas(List<String> corridas) {
    int N = corridas.size();
    List<String> secuencia = new ArrayList<String>(corridas);
    List<String> comportamiento = new ArrayList<String>();
    for (int i = 0; i < secuencia.size() - 1; i++) {
        int diff = Integer.parseInt(secuencia.get(i + 1)) - Integer.parseInt(secuencia.get(i));
        if (diff > 0) {
            comportamiento.add("C");
        } else if (diff < 0) {
            comportamiento.add("D");
        } else {
            comportamiento.add("I");
        }
    }
    int[] recurrencias = new int[comportamiento.size()];
    for (int i = 0; i < comportamiento.size(); i++) {
        recurrencias[i] = comportamiento.get(i).equals("C") ? 1 : 0;
    }
    int Corridas = contarCorridas(recurrencias);
    double Varianza = ((2 * N) - 1) / 3.0;
    double Media = ((16 * N) - 29) / 90.0;
    double Z = 1.96;
    double Zo = -1.96;
    int hipotesis = 0;
    double numerador = Corridas - Varianza;
    double denominador = Math.sqrt(Media);
    double Zobs = new BigDecimal(numerador / denominador).setScale(3, RoundingMode.HALF_UP).doubleValue();
    mostrarCorridas(secuencia, "Secuencia");
    mostrarCorridas(comportamiento, "Comportamiento de crecimiento-decrecimiento");
    if (Zobs < Z && Zobs > Zo) {
        hipotesis = 1;
    }
    if (hipotesis == 1) {
        System.out.println("Hay en total: " + Corridas + " corridas");
        System.out.println("No hay evidencia para rechazar la hipotesis de independencia");
        System.out.println(Zo + " < " + Zobs + " < " + Z);
    } else {
        System.out.println("Hay en total: " + Corridas + " corridas");
        System.out.println("Se rechaza la hipotesis de independencia");
        System.out.println(Zobs + " Esta fuera del intervalo " + "[" + Zo + " , " + Z + " ]");
    }
}

public static void mostrarCorridas(List<String> corridas, String titulo) {
    int contador = 0;
    System.out.println("");
    System.out.println("////////////////// " + titulo + " //////////////////");
    System.out.println("");
    for (int i = 0; i < corridas.size() / 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (contador < corridas.size()) {
                System.out.print(corridas.get(contador) + " ");
                contador++;
            }
        }
        System.out.println("");
    }
    System.out.println("");
    System.out.println("////////////////////////////////////////////////////");
}

public static double[][] mapearPares(int[] recurrencias) {
    int n = recurrencias.length;
    double[][] pares = new double[n - 1][2];
    for (int i = 0; i < n - 1; i++) {
        pares[i][0] = recurrencias[i];
        pares[i][1] = recurrencias[i + 1];
    }
    return pares;
}

public static void ubicarPares(double[][] ParesRecurrencias, int[][] TablaSeries) {
    for (int i = 0; i < ParesRecurrencias.length; i++) {
        for (int j = 0; j < 1; j++) {
            if (ParesRecurrencias[i][j] < 0.2 && ParesRecurrencias[i][j] >= 0) {
                if (ParesRecurrencias[i][j+1] < 0.2 && ParesRecurrencias[i][j+1] >= 0) {
                    TablaSeries[0][0]++;
                } else if (ParesRecurrencias[i][j+1] < 0.4 && ParesRecurrencias[i][j+1] >= 0.2) {
                    TablaSeries[0][1]++;
                } else if (ParesRecurrencias[i][j+1] < 0.6 && ParesRecurrencias[i][j+1] >= 0.4) {
                    TablaSeries[0][2]++;
                } else if (ParesRecurrencias[i][j+1] < 0.8 && ParesRecurrencias[i][j+1] >= 0.6) {
                    TablaSeries[0][3]++;
                } else if (ParesRecurrencias[i][j+1] < 1 && ParesRecurrencias[i][j+1] >= 0.8) {
                    TablaSeries[0][4]++;
                }
            } else if (ParesRecurrencias[i][j] < 0.4 && ParesRecurrencias[i][j] >= 0.2) {
                if (ParesRecurrencias[i][j+1] < 0.2 && ParesRecurrencias[i][j+1] >= 0) {
                    TablaSeries[1][0]++;
                } else if (ParesRecurrencias[i][j+1] < 0.4 && ParesRecurrencias[i][j+1] >= 0.2) {
                    TablaSeries[1][1]++;
                } else if (ParesRecurrencias[i][j+1] < 0.6 && ParesRecurrencias[i][j+1] >= 0.4) {
                    TablaSeries[1][2]++;
                } else if (ParesRecurrencias[i][j+1] < 0.8 && ParesRecurrencias[i][j+1] >= 0.6) {
                    TablaSeries[1][3]++;
                } else if (ParesRecurrencias[i][j+1] < 1 && ParesRecurrencias[i][j+1] >= 0.8) {
                    TablaSeries[1][4]++;
                }
            } else if (ParesRecurrencias[i][j] < 0.6 && ParesRecurrencias[i][j] >= 0.4) {
                if (ParesRecurrencias[i][j+1] < 0.2 && ParesRecurrencias[i][j+1] >= 0) {
                    TablaSeries[2][0]++;
                } else if (ParesRecurrencias[i][j+1] < 0.4 && ParesRecurrencias[i][j+1] >= 0.2) {
                    TablaSeries[2][1]++;
                } else if (ParesRecurrencias[i][j+1] < 0.6 && ParesRecurrencias[i][j+1] >= 0.4) {
                    TablaSeries[2][2]++;
                } else if (ParesRecurrencias[i][j+1] < 0.8 && ParesRecurrencias[i][j+1] >= 0.6) {
                    TablaSeries[2][3]++;
                } else if (ParesRecurrencias[i][j+1] < 1 && ParesRecurrencias[i][j+1] >= 0.8) {
                    TablaSeries[1][4]++;
                }
            } else if (ParesRecurrencias[i][j] < 0.8 && ParesRecurrencias[i][j] >= 0.6) {
                if (ParesRecurrencias[i][j+1] < 0.2 && ParesRecurrencias[i][j+1] >= 0) {
                    TablaSeries[3][0]++;
                } else if (ParesRecurrencias[i][j+1] < 0.4 && ParesRecurrencias[i][j+1] >= 0.2) {
                    TablaSeries[3][1]++;
                } else if (ParesRecurrencias[i][j+1] < 0.6 && ParesRecurrencias[i][j+1] >= 0.4) {
                    TablaSeries[3][2]++;
                } else if (ParesRecurrencias[i][j+1] < 0.8 && ParesRecurrencias[i][j+1] >= 0.6) {
                    TablaSeries[3][3]++;
                } else if (ParesRecurrencias[i][j+1] < 1 && ParesRecurrencias[i][j+1] >= 0.8) {
                    TablaSeries[3][4]++;
                }
            } else if (ParesRecurrencias[i][j] < 1 && ParesRecurrencias[i][j] >= 0.8) {
                if (ParesRecurrencias[i][j+1] < 0.2 && ParesRecurrencias[i][j+1] >= 0) {
                    TablaSeries[4][0]++;
                } else if (ParesRecurrencias[i][j+1] < 0.4 && ParesRecurrencias[i][j+1] >= 0.2) {
                    TablaSeries[4][1]++;
                } else if (ParesRecurrencias[i][j+1] < 0.6 && ParesRecurrencias[i][j+1] >= 0.4) {
                    TablaSeries[4][2]++;
                } else if (ParesRecurrencias[i][j+1] < 0.8 && ParesRecurrencias[i][j+1] >= 0.6) {
                    TablaSeries[4][3]++;
                } else if (ParesRecurrencias[i][j+1] < 1 && ParesRecurrencias[i][j+1] >= 0.8) {
                    TablaSeries[4][4]++;
                }
            }
        }
    }
}

public static void calcularChi(int[][] tablaSeries2, double datosGenerados) {
    double FE = (datosGenerados/2) / 25;
    double[][] tablaSeriesCalc = new double[tablaSeries2.length][tablaSeries2[0].length];
    
    for (int i = 0; i < tablaSeries2.length; i++) {
        for (int j = 0; j < tablaSeries2[i].length; j++) {
            double numerador = Math.pow((FE - tablaSeries2[i][j]), 2);
            tablaSeriesCalc[i][j] = numerador / FE;
        }
    }
}

public static void dibujarSeries(int[][] tablaSeries2, int[][] tablaSeriesCalc2) {
    BigDecimal colum = BigDecimal.ZERO;
    MathContext mc = new MathContext(1);
    System.out.println("//////////////////////////// Tabla de Frecuencia ///////////////////////////////////////////////////");
    System.out.println();
    for (int i = 0; i < tablaSeries2.length; i++) {
        if (i == 0) {
            System.out.println("             |0 - 0.2  | 0.2 - 0.4  |  0.4 - 0.6  | 0.6 - 0.8  | 0.8 - 1  |");
        }
        if (colum.add(new BigDecimal(0.2, mc)).compareTo(BigDecimal.ONE) <= 0) {
            System.out.print(colum + "-" + colum.add(new BigDecimal(0.2, mc)) + "  ");
            colum = colum.add(new BigDecimal(0.2, mc));
        }
        for (int j = 0; j < tablaSeries2[i].length; j++) {
            System.out.print("     " + tablaSeries2[i][j] + "     ");
        }
        System.out.println();
    }
    System.out.println("");
    colum = BigDecimal.ZERO;
    System.out.println("//////////////////////////// Tabla aplicando X^2 ///////////////////////////////////////////////////");
    System.out.println();
    for (int i = 0; i < tablaSeriesCalc2.length; i++) {
        if (i == 0) {
            System.out.println("             |0 - 0.2  | 0.2 - 0.4  |  0.4 - 0.6  | 0.6 - 0.8  | 0.8 - 1  |");
        }
        if (colum.add(new BigDecimal(0.2, mc)).compareTo(BigDecimal.ONE) <= 0) {
            System.out.print(colum + "-" + colum.add(new BigDecimal(0.2, mc)) + "  ");
            colum = colum.add(new BigDecimal(0.2, mc));
        }
        for (int j = 0; j < tablaSeriesCalc2[i].length; j++) {
            System.out.print("     " + tablaSeriesCalc2[i][j] + "     ");
        }
        System.out.println();
    }
    System.out.println();
}

public static void reiniciarMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
        }
    }
}

public static void pruebaSeries(int[] arrayList) {
    double Xcritico = 16.92;
    double Xcalc = 0;
    double[][] pares = mapearPares(arrayList);
    ubicarPares(pares, TablaSeries);
    calcularChi(TablaSeries, 88);
    for (int i = 0; i < TablaSeriesCalc.length; i++) {
        for (int j = 0; j < TablaSeriesCalc[i].length; j++) {
            Xcalc += TablaSeriesCalc[i][j];
        }
    }
    dibujarSeries(TablaSeries, TablaSeriesCalc);
    if (Xcalc <= Xcritico) {
        System.out.println("Como Xcalc <= X2crit SE ACEPTA!!! la hipotesis de que los datos tienen distribucion uniforme bidimensional");
        System.out.println("");
        System.out.println(Xcalc + " <= " + Xcritico);
        System.out.println("");
    } else {
        System.out.println("Como Xcalc > X2crit NO SE ACEPTA!!! la hipotesis de que los datos tienen distribucion uniforme bidimensional");
        System.out.println("");
        System.out.println(Xcalc + " > " + Xcritico);
        System.out.println("");
    }
    reiniciarMatrix(TablaSeriesCalc);
    reiniciarMatrix(TablaSeries);
}

public static int[] calcularPoker(int[] recurrencias) {
    int[] casos = new int[]{0, 0, 0};
    int[] datos = new int[recurrencias.length];
    int[] digitos;
    for (int i = 0; i < datos.length; i++) {
        if (recurrencias[i] < 1) {
            String numero = String.valueOf(recurrencias[i]);
            if (numero.length() == 3) {
                numero = numero + "00";
            } else if (numero.length() == 4) {
                numero = numero + "0";
            }
            String numeroDec = numero.replace("0.", "");
            digitos = new int[numeroDec.length()];
            for (int j = 0; j < numeroDec.length(); j++) {
                digitos[j] = Integer.parseInt(String.valueOf(numeroDec.charAt(j)));
            }
            if (digitos[0] == digitos[1] && digitos[1] == digitos[2]) {
                casos[2] += 1;
            } else if (digitos[0] != digitos[1] && digitos[0] != digitos[2] && digitos[1] != digitos[2]) {
                casos[0] += 1;
            } else {
                casos[1] += 1;
            }
        } else {
            casos[2] += 1;
        }
    }
    return casos;
}

public static void pruebaPoker(int[] arrayList) {
    int[] FO = calcularPoker(arrayList);
    double[] FE = {720, 270, 10};
    double Xcalc = 0;
    double Xcritico = 5.99;
    for (int i = 0; i < FO.length; i++) {
        Xcalc += Math.pow((FO[i] - FE[i]), 2) / FE[i];
    }
    Xcalc = Math.round(Xcalc * 1000) / 1000.0; // Redondea a 3 decimales
    if (Xcalc <= Xcritico) {
        System.out.println("Como Xcalc <= Xcrit SE ACEPTA!!! la hipotesis de que los datos tienen una independencia");
        System.out.println("");
        System.out.println(Xcalc + " <= " + Xcritico);
        System.out.println("");
    } else {
        System.out.println("Como Xcalc > Xcrit NO SE ACEPTA!!! la hipotesis de que los datos tienen una independencia");
        System.out.println("");
        System.out.println(Xcalc + " > " + Xcritico);
        System.out.println("");
    }
}

}
