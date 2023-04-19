import java.util.*;

public class menu {
    static boolean contador = true;
    static boolean contador2 = true;
    static boolean contador3 = true;

    public static void probarGeneradores() {
        while (true) {
            System.out.println(
                    "############################# Bienvenido al menu de generadores ###############################");
            System.out.println("");
            System.out.println("1.Generador lineal congruente");
            System.out.println("2.Generador estandar minimo");
            System.out.println("3.Generador estandar minimo factorizable");
            System.out.println("4.Generador de java");
            System.out.println("5.Volver");
            System.out.println("");
            System.out.println("############################################################");
            Scanner sc = new Scanner(System.in);
            int Puntero_Interno = sc.nextInt();
            while (Puntero_Interno > 4 || Puntero_Interno < 1) {
                Puntero_Interno = sc.nextInt();
            }
            if (Puntero_Interno == 1) {
                System.out.println(
                        "######################## Bienvenido al  generador lineal congruente ####################################");
                System.out.println("");
                System.out.println("Ingrese los datos que desea generar: ");
                int datos = sc.nextInt();
                generadores.generadorLinCong(datos);
                generadores.verDatosGenerados(generadores.returnDatos());
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                System.out.println("############################################################");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                while (true) {
                    if (Puntero_Interno2 == 1) {
                        System.out.println("Recurrencia lineal congruente");
                        generadores.verDatosGenerados(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    } else if (Puntero_Interno2 == 2) {
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    }
                }
            } else if (Puntero_Interno == 2) {
                System.out.println(
                        "######################## Bienvenido al generador de estandar minimo ####################################");
                System.out.println("");
                System.out.println("Ingrese los datos que desea generar: ");
                int datos = sc.nextInt();
                generadores.generadorEstMin(datos);
                generadores.verDatosGenerados(generadores.returnDatos());
                System.out.println("");
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                System.out.println("");
                System.out.println("############################################################");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                while (true) {
                    if (Puntero_Interno2 == 1) {
                        System.out.println("");
                        System.out.println("Mostrar recurrencia del estandar minimo");
                        generadores.verDatosGenerados(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    } else if (Puntero_Interno2 == 2) {
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    }
                }
            } else if (Puntero_Interno == 3) {
                System.out.println(
                        "######################## Bienvenido al generador de estandar minimo factorizable ####################################");
                System.out.println("");
                System.out.println("Ingrese los datos que desea generar: ");
                int datos = sc.nextInt();
                generadores.generatorStanMinFact(datos);
                generadores.verDatosGenerados(generadores.returnDatos());
                System.out.println("");
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                System.out.println("");
                System.out.println("############################################################");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                while (true) {
                    if (Puntero_Interno2 == 1) {
                        System.out.println("");
                        System.out.println("Mostrar recurrencia del estandar minimo factorizable");
                        generadores.verDatosGenerados(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    } else if (Puntero_Interno2 == 2) {
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    }
                }
            } else if (Puntero_Interno == 4) {
                System.out.println(
                        "######################## Bienvenido al generador de java ####################################");
                System.out.println("");
                System.out.println("Ingrese los datos que desea generar: ");
                int datos = sc.nextInt();
                generadores.generadorJava(datos);
                generadores.verDatosGenerados(generadores.returnDatos());
                System.out.println("");
                System.out.println("1.Mostrar recurrencia");
                System.out.println("2.Volver");
                System.out.println("");
                System.out.println("############################################################");
                int Puntero_Interno2 = sc.nextInt();
                while (Puntero_Interno2 > 2 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = sc.nextInt();
                }
                while (true) {
                    if (Puntero_Interno2 == 1) {
                        System.out.println("");
                        System.out.println("Mostrar recurrencia de generador de java");
                        generadores.verDatosGenerados(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    } else if (Puntero_Interno2 == 2) {
                        generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        generadores.ReiniciarListas(generadores.returnDatos());
                        break;
                    }
                }
            } else if (Puntero_Interno == 5) {
                generadores.ReiniciarListas(generadores.returnTabla());
                generadores.ReiniciarListas(generadores.returnRecurrrencias());
                generadores.ReiniciarListas(generadores.returnDatos());
                break;
            }
        }
    }

    public static void menuUniformidad() {
        while (true) {
            System.out.println(
                    "############################# Bienvenido al menu de pruebas de uniformidad e independencia ###############################");
            System.out.println("\n");
            System.out.println("1.Generador lineal congruente");
            System.out.println("2.Generador estandar minimo");
            System.out.println("3.Generador estandar minimo factorizable");
            System.out.println("4.Generador de java");
            System.out.println("5.Volver");
            System.out.println("############################################################");
            Scanner scanner = new Scanner(System.in);
            int punteroInterno = scanner.nextInt();
            while (punteroInterno > 4 || punteroInterno < 1) {
                punteroInterno = scanner.nextInt();
            }
            if (punteroInterno == 1) {
                pruebasUniformidadIndependencia(1);
            } else if (punteroInterno == 2) {
                pruebasUniformidadIndependencia(2);
            } else if (punteroInterno == 3) {
                pruebasUniformidadIndependencia(3);
            } else if (punteroInterno == 4) {
                break;
            }
        }
    }

    public static void pruebasUniformidadIndependencia(int PunteroInterno) {
        if (PunteroInterno == 1) {
            while (true) {
                System.out.println(
                        "######################## Bienvenido al menu de pruebas de uniformidad del generador lineal congruente ####################################");
                System.out.println("1.Prueba de x2");
                System.out.println("2.Prueba kolmogorov");
                System.out.println("3.Volver");
                System.out.println("############################################################");
                System.out.println("");

                int PunteroInterno2 = Integer.parseInt(System.console().readLine("Porfavor seleccione una prueba: "));
                System.out.println("");
                while (PunteroInterno2 > 3 || PunteroInterno2 < 1) {
                    PunteroInterno2 = Integer.parseInt(System.console().readLine("Porfavor seleccione una prueba: "));
                }

                if (PunteroInterno2 == 1) {
                    System.out.println("");
                    System.out.println("/////////PRUEBA DE CHI CUADRADO ////////////////");
                    int datos = Integer.parseInt(System.console().readLine("Cuantos datos desea generar: "));
                    Pruebas_uniformidad.PruebaChiCuadrado(1, datos);
                    System.out.println("\n");

                    while (true) {
                        System.out.println(
                                "######################## Bienvenido al menu de las pruebas de independencia del generador lineal congruente ####################################");
                        System.out.println("Que desea hacer ahora?");
                        System.out.println("1.Pruebas de Independencia");
                        System.out.println("2.volver");
                        System.out.println(
                                "######################## ############################################## ####################################");

                        int PunteroInterno3 = Integer.parseInt(System.console().readLine("Escoga una opcion: "));
                        System.out.println("");
                        while (PunteroInterno3 > 2 || PunteroInterno3 < 1) {
                            PunteroInterno3 = Integer.parseInt(System.console().readLine("Escoga una opcion: "));
                        }

                        if (PunteroInterno3 == 1) {
                            System.out.println(
                                    "######################## Bienvenido a las pruebas de independencia del generador lineal congruente ####################################");
                            System.out.println("1.Prueba de corrida");
                            System.out.println("2.Prueba de serie");
                            System.out.println("3.Prueba de poker");
                            System.out.println("4.Volver");
                            System.out.println(
                                    "##############################################################################################################");

                            int PunteroInterno4 = Integer
                                    .parseInt(System.console().readLine("Porfavor seleccione una prueba: "));
                            System.out.println("");
                            while (PunteroInterno4 > 4 || PunteroInterno4 < 1) {
                                PunteroInterno4 = Integer
                                        .parseInt(System.console().readLine("Porfavor seleccione una prueba: "));
                            }

                            while (true) {
                                if (PunteroInterno4 == 1) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de corrida ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.PruebaCorridas(generadores.returnRecurrrencias(),
                                    // datos);
                                    break;
                                } else if (PunteroInterno4 == 2) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de series ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.pruebaSeries(generadores.returnRecurrrencias());
                                    break;
                                } else if (PunteroInterno4 == 3) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de poker ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.pruebaPoker(generadores.returnRecurrrencias());
                                    break;
                                } else if (PunteroInterno4 == 3) {
                                    break;
                                }
                            }
                        } else if (PunteroInterno3 == 2) {
                            generadores.ReiniciarListas(generadores.returnTabla());
                            generadores.ReiniciarListas(generadores.returnDatos());
                            generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        }
                    }
                } else if (PunteroInterno2 == 3) {
                    break;
                }
            }
        } else if (PunteroInterno == 2) {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println(
                        "######################## Bienvenido al menu de las pruebas de uniformidad del generador de Estandar minimo ####################################");
                System.out.println("1.Prueba de x2");
                System.out.println("2.Prueba kolmogorov");
                System.out.println("3.Volver");
                System.out.println("############################################################");
                int Puntero_Interno2 = input.nextInt();
                System.out.println("");
                while (Puntero_Interno2 > 3 || Puntero_Interno2 < 1) {
                    Puntero_Interno2 = input.nextInt();
                }
                if (Puntero_Interno2 == 1) {
                    System.out.println("\n");
                    System.out.println("/////////PRUEBA DE chi cuadrado////////////////");
                    System.out.print("Cuantos datos desea generar: ");
                    int datos = input.nextInt();
                    Pruebas_uniformidad.PruebaChiCuadrado(2, datos);
                    System.out.println("\n");
                    while (true) {
                        System.out.println(
                                "######################## Bienvenido al menu de las pruebas de independencia del generador de Estandar minimo ####################################");
                        System.out.println("Que desea hacer ahora?");
                        System.out.println("1.Pruebas de Independencia");
                        System.out.println("2.volver");
                        System.out.println(
                                "######################## ############################################## ####################################");
                        int Puntero_Interno3 = input.nextInt();
                        System.out.println("");
                        while (Puntero_Interno3 > 2 || Puntero_Interno3 < 1) {
                            Puntero_Interno3 = input.nextInt();
                        }
                        if (Puntero_Interno3 == 1) {
                            System.out.println(
                                    "######################## Bienvenido a las pruebas de independencia ####################################");
                            System.out.println("1.Prueba de corrida");
                            System.out.println("2.Prueba de serie");
                            System.out.println("3.Prueba de poker");
                            System.out.println("4.Volver");
                            System.out.println(
                                    "##############################################################################################################");
                            int Puntero_Interno4 = input.nextInt();
                            System.out.println("");
                            while (Puntero_Interno4 > 4 || Puntero_Interno4 < 1) {
                                Puntero_Interno4 = input.nextInt();
                            }
                            while (true) {
                                if (Puntero_Interno4 == 1) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de corrida ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.PruebaCorridas(generadores.returnRecurrrencias(),
                                    // datos);
                                    break;
                                } else if (Puntero_Interno4 == 2) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de series ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.pruebaSeries(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 3) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de poker ///////////////////");
                                    System.out.println("");
                                    // Pruebas_independencia.pruebaPoker(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 4) {
                                    break;
                                }

                            }
                        } else if (Puntero_Interno3 == 2) {
                            generadores.ReiniciarListas(generadores.returnTabla());
                            generadores.ReiniciarListas(generadores.returnDatos());
                            generadores.ReiniciarListas(generadores.returnRecurrrencias());
                            break;
                        }
                    }
                } else if (Puntero_Interno2 == 2) {
                    System.out.println("\n");
                    System.out.println("/////////PRUEBA DE KOLMOGOROV////////////////");
                    System.out.print("Cuantos datos desea generar: ");
                    int datos = input.nextInt();
                    Pruebas_uniformidad.pruebaKolmogorov(2, datos);
                    System.out.println("\n");
                    while (true) {
                        System.out.println(
                                "######################## Bienvenido al menu de las pruebas de independencia del generador de Estandar minimo ####################################");
                        System.out.println("Que desea hacer ahora?");
                        System.out.println("1.Pruebas de Independencia");
                        System.out.println("2.volver");
                        System.out.println(
                                "######################## ############################################## ####################################");
                        int Puntero_Interno3 = input.nextInt();
                        System.out.println("");
                        while (Puntero_Interno3 > 2 || Puntero_Interno3 < 1) {
                            Puntero_Interno3 = input.nextInt();
                        }
                        if (Puntero_Interno3 == 1) {
                            System.out.println(
                                    "######################## Bienvenido a las pruebas de independencia ####################################");
                            System.out.println("1.Prueba de corrida");
                            System.out.println("2.Prueba de serie");
                            System.out.println("3.Prueba de poker");
                            System.out.println("4.Volver");
                            System.out.println(
                                    "##############################################################################################################");
                            int Puntero_Interno4 = input.nextInt();
                            System.out.println("");
                            while (Puntero_Interno4 > 4 || Puntero_Interno4 < 1) {
                                Puntero_Interno4 = input.nextInt();
                            }
                            while (true) {
                                if (Puntero_Interno4 == 1) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de corrida ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.PruebaCorridas(generadores.returnRecurrrencias(), datos);
                                    break;
                                } else if (Puntero_Interno4 == 2) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de series ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaSeries(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 3) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de poker ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaPoker(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 4) {
                                    break;
                                }

                            }
                        } else if (Puntero_Interno3 == 2) {
                            generadores.ReiniciarListas(generadores.returnTabla());
                            generadores.ReiniciarListas(generadores.returnDatos());
                            generadores.ReiniciarListas(generadores.returnRecurrrencias());
                            break;
                        }
                    }
                } else if (Puntero_Interno2 == 3) {
                    break;
                }
            }
        }
        if (PunteroInterno == 3) {
            Scanner sc = new Scanner(System.in);
            int punteroInterno = 3;

            while (true) {
                System.out.println(
                        "######################## Bienvenido al menu de las pruebas de uniformidad del generador de Java ####################################");
                System.out.println("1.Prueba de x2");
                System.out.println("2.Prueba kolmogorov");
                System.out.println("3.Volver");
                System.out.println("############################################################");
                int punteroInterno2 = sc.nextInt();
                System.out.println("");
                while (punteroInterno2 > 3 || punteroInterno2 < 1) {
                    System.out.println("Porfavor seleccione una prueba:");
                    punteroInterno2 = sc.nextInt();
                }
                if (punteroInterno2 == 1) {
                    System.out.println("\n");
                    System.out.println("/////////PRUEBA DE CHI CUADRADO ////////////////");
                    System.out.print("Cuantos datos desea generar: ");
                    int datos = sc.nextInt();
                    Pruebas_uniformidad.PruebaChiCuadrado(3, datos);
                    System.out.println("");
                    while (true) {
                        System.out.println(
                                "######################## Bienvenido al menu de las pruebas de independencia del generador de Java ####################################");
                        System.out.println("Que desea hacer ahora?");
                        System.out.println("1.Pruebas de Independencia");
                        System.out.println("2.volver");
                        System.out.println(
                                "######################## ############################################## ####################################");
                        int punteroInterno3 = sc.nextInt();
                        System.out.println("");
                        while (punteroInterno3 > 2 || punteroInterno3 < 1) {
                            System.out.println("Escoga una opcion:");
                            punteroInterno3 = sc.nextInt();
                        }
                        if (punteroInterno3 == 1) {
                            System.out.println(
                                    "######################## Bienvenido a las pruebas de independencia ####################################");
                            System.out.println("1.Prueba de corrida");
                            System.out.println("2.Prueba de serie");
                            System.out.println("3.Prueba de poker");
                            System.out.println("4.Volver");
                            System.out.println(
                                    "##############################################################################################################");
                            int punteroInterno4 = sc.nextInt();
                            System.out.println("");
                            while (punteroInterno4 > 4 || punteroInterno4 < 1) {
                                System.out.println("Porfavor seleccione una prueba:");
                                punteroInterno4 = sc.nextInt();
                            }
                            while (true) {
                                if (punteroInterno4 == 1) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de corrida ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.PruebaCorridas(generadores.returnRecurrrencias(), datos);
                                    break;
                                } else if (punteroInterno4 == 2) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de series ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaSeries(generadores.returnRecurrrencias());
                                    break;
                                } else if (punteroInterno4 == 3) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de poker ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaPoker(generadores.returnRecurrrencias());
                                    break;
                                } else if (punteroInterno4 == 4) {
                                    break;
                                }
                            }
                        } else if (punteroInterno3 == 2) {
                            generadores.ReiniciarListas(generadores.returnTabla());
                            generadores.ReiniciarListas(generadores.returnDatos());
                            generadores.ReiniciarListas(generadores.returnRecurrrencias());
                        }
                    }
                } else if (punteroInterno2 == 2) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("\n");
                    System.out.println("/////////PRUEBA DE KOLMOGOROV////////////////");
                    System.out.print("Cuantos datos desea generar: ");
                    int datos = input.nextInt();
                    Pruebas_uniformidad.pruebaKolmogorov(3, datos);
                    System.out.println("\n");

                    while (true) {
                        System.out.println(
                                "######################## Bienvenido al menu de las pruebas de independencia del generador de Python ####################################");
                        System.out.println("Que desea hacer ahora?");
                        System.out.println("1.Pruebas de Independencia");
                        System.out.println("2.volver");
                        System.out.println(
                                "######################## ############################################## ####################################");
                        int Puntero_Interno3 = input.nextInt();
                        System.out.println("");
                        while (Puntero_Interno3 > 2 || Puntero_Interno3 < 1) {
                            Puntero_Interno3 = input.nextInt();
                        }
                        if (Puntero_Interno3 == 1) {
                            System.out.println(
                                    "######################## Bienvenido a las pruebas de independencia ####################################");
                            System.out.println("1.Prueba de corrida");
                            System.out.println("2.Prueba de serie");
                            System.out.println("3.Prueba de poker");
                            System.out.println("4.Volver");
                            System.out.println(
                                    "##############################################################################################################");
                            int Puntero_Interno4 = input.nextInt();
                            System.out.println("");
                            while (Puntero_Interno4 > 4 || Puntero_Interno4 < 1) {
                                Puntero_Interno4 = input.nextInt();
                            }
                            while (true) {
                                if (Puntero_Interno4 == 1) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de corrida ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.PruebaCorridas(generadores.returnRecurrrencias(), datos);
                                    break;
                                } else if (Puntero_Interno4 == 2) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de series ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaSeries(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 3) {
                                    System.out.println("");
                                    System.out.println("///////////////////// Prueba de poker ///////////////////");
                                    System.out.println("");
                                    //Pruebas_independencia.pruebaPoker(generadores.returnRecurrrencias());
                                    break;
                                } else if (Puntero_Interno4 == 4) {
                                    break;
                                }
                            }
                        } else if (Puntero_Interno3 == 2) {
                            System.out.println("cls");
                            generadores.ReiniciarListas(generadores.returnTabla());
                            generadores.ReiniciarListas(generadores.returnDatos());
                            generadores.ReiniciarListas(generadores.returnRecurrrencias());
                            break;
                        }
                    }
                } else if (punteroInterno2 == 3) {
                    break;
                }
            }
        }
    }

    public static void menuPrincipal() {
        boolean contador = true;
        while (contador) {
            System.out.println("############################ MENU ###################################");
            System.out.println("Bienvenido al menu de las pruebas de independencia y uniformidad");
            System.out.println("\n");
            System.out.println("1.Probar generadores");
            System.out.println("2.Pruebas de uniformidad e independencia");
            System.out.println("3.Salir");
            System.out.println("\n");
    
            Scanner scanner = new Scanner(System.in);
            int punteroMenu = scanner.nextInt();
    
            while (punteroMenu > 3 || punteroMenu < 1) {
                System.out.println("Eliga un número entero entre 1 y 3, no es tan difícil:");
                punteroMenu = scanner.nextInt();
            }
    
            if (punteroMenu == 1) {
                System.out.println("");
                probarGeneradores();
            } else if (punteroMenu == 2) {
                System.out.println("");
                menuUniformidad();
            } else {
                break;
            }
        }
        System.out.println("##################### FIN DEL PROGRAMA ##############################");
    }
}
