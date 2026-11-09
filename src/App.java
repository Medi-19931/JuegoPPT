
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //parte declarativa
        // --- CÓDIGOS DE COLOR ANSI ---
        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String AMARILLO = "\u001B[33m";
        final String AZUL = "\u001B[34m";
        //CONTADOR GLOBAL
        final int MAXRONDAS=3;
        int partidasSolitario=0;
        int partidasMultijugador=0;
        int partidasTotales=0;
        int victoriasJ1;
        int victoriasConsola;
        int victoriasJ2;
        int empatesTotales=0;
        String resultadoFinal="";

        // CONTADOR GLOBAL DE LA SESIÓN
        int victoriasGlobalesJ1 = 0;
        int victoriasGlobalesConsola = 0;
        int victoriasGlobalesJ2 = 0;

        //CONTROL MENÚ

        int opcionMenu;
        int modoJuego=0;
        //partida actual

        int rondasJ1;
        int rondasConsola;
        int rondasJ2;
        int opcionJ1;
        int opcionRival;

        //ARRAYS
        String [] opciones={"Piedra","Papel","Tijera"};
        int [] historialRondas =new int[3];

        Scanner scanner=new Scanner(System.in);

        //cuerpo
       
        do { 
            System.out.println("");
            //menu
            System.out.println(AZUL + "========================================" + RESET);
            System.out.println(AZUL + "        PIEDRA, PAPEL Y TIJERA          " + RESET);
            System.out.println(AZUL + "========================================" + RESET);
            System.out.println("1. Solitario (Jugador 1 vs Consola)");
            System.out.println("2. Jugador 1 vs Jugador 2");
            System.out.println("3. Ver estadísticas de la sesión");
            System.out.println("4. Ver reglas e instrucciones");
            System.out.println(AZUL + "========================================" + RESET);
            System.out.println("5. Salir");
            System.out.println(AZUL + "========================================" + RESET);
            System.out.print("\nIngrese la opcion deseada (solo un numero del 1 al 5): ");
            opcionMenu=scanner.nextInt();

            if (opcionMenu==1) {
                //modo solitrio contra IA
                partidasSolitario++;
                modoJuego=1;
                System.out.println("\n");
                System.out.println("\n");
                System.out.println(AMARILLO + "----Bienvenido, MODO SOLITARIO----" + RESET);
                System.out.println("\n");
                System.out.println("\n");
                System.out.println(AMARILLO + "----------INICIO DE PARTIDA----------" + RESET);
                rondasJ1=0;
                rondasConsola=0;

                victoriasConsola=0;
                victoriasJ1=0;
                empatesTotales=0;
                int i;

                for (i=0 ; i<MAXRONDAS ; i++) {
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println(AMARILLO + "---------RONDA " + (i + 1) + "---------" + RESET);
                    rondasConsola=rondasConsola+1;
                    rondasJ1=rondasJ1+1;
                    
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println(VERDE + "---------TURNO DEL JUGADOR 1---------" + RESET);
                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v\n");

                    System.out.println("Elige tu  mejor jugada--------------------\n");
                    for (int j=0 ; j<opciones.length ; j++) {
                        System.out.println((j+1)+" = "+ opciones[j]);

                    }

                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v");

                    System.out.print("\nIngresa el numero de su jugada (1-3):");
                    opcionJ1=scanner.nextInt();

                    if (opcionJ1>= 1 && opcionJ1<=3) {
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println(ROJO + "--------------TURNO CONSOLA--------------" + RESET);
                        System.out.println("\n|");
                        System.out.println("|");
                        System.out.println("v\n");

                        //genera numeros enteros 1-3(jugada consola)
                        opcionRival =(int)(Math.random()*3)+1;
                        System.out.println(ROJO + "Consola eligió: " + opciones[opcionRival - 1] + "------------------" + RESET);
                        
                        

                        //comparacion de jugadas
                        //jugador1 1 -elige piedra
                        if (opcionJ1==1) {


                            if (opcionJ1==opcionRival) {
                                //consola elije piedra
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                
                            } else if (opcionRival==2) {
                                //consola elije papel(papel gana contra piedra)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : CONSOLA" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                
                            } else {
                                //consola elije tijera(tijera pierde contra piedra)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);
                                
                            }

                         //jugador1 2-elige papel
                        } else if (opcionJ1==2){

                           if (opcionJ1==opcionRival) {
                                //consola elije papel
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra pierde contra papel)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);
                                    
                            } else {
                                //consola elije tijera(tijera gana contra papel)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : CONSOLA" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                    
                            }
                        
                        //jugador1 3-elige tigera
                        } else if (opcionJ1==3){

                             if (opcionJ1==opcionRival) {
                                //consola elige tijera
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra gana contra tijera)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : CONSOLA" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                    
                            } else {
                                //consola elije papel(papel piedre contra tijera)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);
                            }
                            
                        } 
                            
                        


                    } else{
                            System.out.println("\nINGRESE SOLO  UN NUMERO DEL 1-3 DE LAS JUGADAS MOSTRADAS,RONDA PERDIDA ");
                            System.out.println("\n|");
                            System.out.println("|");
                            System.out.println("v\n");
                    }

                    System.out.println(AMARILLO + "========================================" + RESET);
                    System.out.println(AMARILLO + "               RESULTADOS               " + RESET);
                    System.out.println(AMARILLO + "========================================" + RESET);
                    System.out.printf("%-15s %6s %8s%n","EMPATE","JUGADOR1","CONSOLA");
                    System.out.printf("%-15d %6d %8d%n", empatesTotales, victoriasJ1, victoriasConsola);

                    if (victoriasJ1 < victoriasConsola) {
                        historialRondas[i] = 1;
                        System.out.println(ROJO + "\n-----------------------------------" + RESET);
                        System.out.println(ROJO + "----------Victoria: Consola--------" + RESET);
                        System.out.println(ROJO + "-----------------------------------" + RESET);
                    } else if (victoriasConsola < victoriasJ1){
                        historialRondas[i] = 2;
                        System.out.println(VERDE + "\n-------------------------------------" + RESET);
                        System.out.println(VERDE + "----------Victoria: Jugador 1--------" + RESET);
                        System.out.println(VERDE + "-------------------------------------" + RESET);
                        
                    }else {
                        historialRondas[i] = 0;
                        System.out.println(AZUL + "\n--------------------------" + RESET);
                        System.out.println(AZUL + "----------EMPATE----------" + RESET);
                        System.out.println(AZUL + "--------------------------" + RESET);
                    }
                    
                    

                }

                partidasTotales=partidasTotales+1;
                victoriasGlobalesJ1 = victoriasGlobalesJ1 + victoriasJ1;
                victoriasGlobalesConsola = victoriasGlobalesConsola + victoriasConsola;

                // GANADOR DEFINITIVO 
                System.out.println(AMARILLO + "\n========================================" + RESET);
                System.out.println(AMARILLO + "       RESULTADO FINAL DE LA PARTIDA    " + RESET);
                System.out.println(AMARILLO + "========================================" + RESET);
                if (victoriasJ1 < victoriasConsola) {
                    System.out.println(ROJO + "¡La CONSOLA gana la partida!" + RESET);
                    resultadoFinal="Victoria CONSOLA";
                } else if (victoriasConsola < victoriasJ1) {
                    System.out.println(VERDE + "¡El JUGADOR 1 gana la partida!" + RESET);
                    resultadoFinal="Victoria JUGADOR1";
                } else {
                    System.out.println(AZUL + "¡La partida termina en EMPATE global!" + RESET);
                    resultadoFinal="EMPATE";
                }
                
            } else if (opcionMenu==2){
                //jugador 1 y jugador 2
                partidasMultijugador++;
                modoJuego=2;
                System.out.println("\n");
                System.out.println("\n");
                System.out.println(AMARILLO + "Bienvenido, MODO MULTIJUGADOR" + RESET);
                System.out.println("\n");
                System.out.println("\n");

                System.out.println(AMARILLO + "\n----------INICIO DE PARTIDA----------" + RESET);
                rondasJ1=0;
                rondasJ2=0;

                victoriasJ2=0;
                victoriasJ1=0;
                empatesTotales=0;
                int i;

                for (i=0 ; i<MAXRONDAS ; i++) {
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println(AMARILLO + "\n---------RONDA " + (i + 1) + "---------" + RESET);
                    rondasJ2=rondasJ2+1;
                    rondasJ1=rondasJ1+1;
                    
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println(VERDE + "---------TURNO DEL JUGADOR 1---------" + RESET);
                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v\n");

                    System.out.println("Elige tu  mejor jugada--------------------\n");
                    for (int j=0 ; j<opciones.length ; j++) {
                        System.out.println((j+1)+" = "+ opciones[j]);

                    }

                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v");

                    System.out.print("\nIngresa el numero de su jugada  JUGADOR 1 (1-3):");
                    opcionJ1=scanner.nextInt();

                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");

                    System.out.println(ROJO + "\n---------TURNO DEL JUGADOR 2---------" + RESET);
                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v\n");
                    
                    System.out.println("Elige tu  mejor jugada--------------------\n");
                    for (int j=0 ; j<opciones.length ; j++) {
                        System.out.println((j+1)+" = "+ opciones[j]);

                    }

                    System.out.print("\nIngresa el numero de su jugada  JUGADOR 2 (1-3):");
                    opcionRival=scanner.nextInt();


                    if (opcionJ1>= 1 && opcionJ1<=3 && opcionRival>= 1 && opcionRival<=3) {
                        
                       

                        //comparacion de jugadas
                        //jugador1 1piedra 
                        if (opcionJ1==1) {


                            if (opcionJ1==opcionRival) {
                                //consola elije piedra
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                
                            } else if (opcionRival==2) {
                                //consola elije papel(papel gana contra piedra)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : JUGADOR2" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                
                            } else {
                                //consola elije tijera(tijera pierde contra piedra)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);
                                
                            }

                         //jugador1 2-elige papel
                        } else if (opcionJ1==2){

                           if (opcionJ1==opcionRival) {
                                //consola elije papel
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra pierde contra papel)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);
                                    
                            } else {
                                //consola elije tijera(tijera gana contra papel)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : JUGADOR2" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                    
                            }
                        
                        //jugador1 3-elige tigera
                        } else if (opcionJ1==3){

                             if (opcionJ1==opcionRival) {
                                //consola elige tijera
                                empatesTotales=empatesTotales+1;
                                System.out.println(AZUL + "\n------------------" + RESET);
                                System.out.println(AZUL + "Resultado: Empate" + RESET);
                                System.out.println(AZUL + "------------------" + RESET);
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra gana contra tijera)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println(ROJO + "\n------------------" + RESET);
                                System.out.println(ROJO + "Ganador : JUGADOR2" + RESET);
                                System.out.println(ROJO + "------------------" + RESET);
                                    
                            } else {
                                //consola elije papel(papel piedre contra tijera)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println(VERDE + "\n------------------" + RESET);
                                System.out.println(VERDE + "Ganador : JUGADOR1" + RESET);
                                System.out.println(VERDE + "------------------" + RESET);   
                            }
                            
                        } 
                            
                        


                    } else{
                            System.out.println(ROJO + "\nINGRESE SOLO UN NUMERO DEL 1-3 DE LAS JUGADAS MOSTRADAS, JUGADA PERDIDA" + RESET);
                            System.out.println("\n|");
                            System.out.println("|");
                            System.out.println("v\n");
                    }

                    System.out.println(AMARILLO + "========================================" + RESET);
                    System.out.println(AMARILLO + "               RESULTADOS               " + RESET);
                    System.out.println(AMARILLO + "========================================" + RESET);
                    System.out.printf("%-15s %6s %8s%n","EMPATE","JUGADOR1","JUGADOR2");
                    System.out.printf("%-15d %6d %8d%n", empatesTotales, victoriasJ1, victoriasJ2);

                    if (victoriasJ1 < victoriasJ2) {
                        historialRondas[i] = 1;
                        System.out.println(ROJO + "\n-----------------------------------" + RESET);
                        System.out.println(ROJO + "---------Victoria: Jugador 2-------" + RESET);
                        System.out.println(ROJO + "-----------------------------------" + RESET);
                    } else if (victoriasJ2 < victoriasJ1){
                        historialRondas[i] = 2;
                        System.out.println(VERDE + "\n-------------------------------------" + RESET);
                        System.out.println(VERDE + "----------Victoria: Jugador 1--------" + RESET);
                        System.out.println(VERDE + "-------------------------------------" + RESET);
                        
                    }else {
                        historialRondas[i] = 0;
                        System.out.println(AZUL + "\n--------------------------" + RESET);
                        System.out.println(AZUL + "----------EMPATE----------" + RESET);
                        System.out.println(AZUL + "--------------------------" + RESET);
                    }
                    
                    

                }

                partidasTotales=partidasTotales+1;
                victoriasGlobalesJ1 = victoriasGlobalesJ1 + victoriasJ1;
                victoriasGlobalesJ2 = victoriasGlobalesJ2 + victoriasJ2;

                // GANADOR DEFINITIVO 
                System.out.println(AMARILLO + "\n========================================" + RESET);
                System.out.println(AMARILLO + "       RESULTADO FINAL DE LA PARTIDA    " + RESET);
                System.out.println(AMARILLO + "========================================" + RESET);
                if (victoriasJ1 < victoriasJ2) {
                    resultadoFinal="Victoria JUGADOR2";
                    System.out.println(ROJO + "¡El JUGADOR 2 gana la partida!" + RESET);
                    
                    
                } else if (victoriasJ2 < victoriasJ1) {
                    resultadoFinal="Victoria JUGADOR1";
                    System.out.println(VERDE + "¡El JUGADOR 1 gana la partida!" + RESET);
                } else {
                    resultadoFinal="EMPATE";
                    System.out.println(AZUL + "¡La partida termina en EMPATE global!" + RESET);
                }


            } else if (opcionMenu==3){
                //estadisticas
                System.out.println(AMARILLO + "\n========================================" + RESET);
                System.out.println(AMARILLO + "        ESTADÍSTICAS DE LA SESIÓN       " + RESET);
                System.out.println(AMARILLO + "========================================" + RESET);
                System.out.println("--- RESUMEN GLOBAL ---");
                System.out.println("Partidas totales jugadas: "+partidasTotales);
                System.out.println(" - Modo Solitario (vs Consola): "+partidasSolitario);
                System.out.println(" - Modo Multijugador (J1 vs J2): "+partidasMultijugador);
                System.out.println(" - Victorias Totales Jugador 1: " + victoriasGlobalesJ1);
                System.out.println(" - Victorias Totales Consola: " + victoriasGlobalesConsola);
                System.out.println(" - Victorias Totales Jugador 2: " + victoriasGlobalesJ2);
                System.out.println(" - Empates totales: " + empatesTotales);

                //HISTORAL ÚLTIMA PARTIDA 
                System.out.println("\n--- DETALLE DE LA ÚLTIMA PARTIDA ---");
                if (modoJuego == 1) {
                    System.out.println(" - Modo de juego: Solitario (Jugador 1 vs Consola)");
                } else if (modoJuego == 2) {
                    System.out.println(" - Modo de juego: Multijugador (Jugador 1 vs Jugador 2)");
                } else {
                    System.out.println(" - Modo de juego: Ninguna partida jugada todavía.");
                }

                System.out.println("\nRONDAS------------------");
                //ULTIMA PARTIDA RONDAS
                for (int i = 0; i < historialRondas.length; i++) {
                    String ganadorRonda ="";
                    if ( historialRondas[i]==0) {
                        
                        ganadorRonda = "Resultado: Empate";
                        
                        
                    }else if (historialRondas[i]==2) {
                        
                        ganadorRonda = "Resultado: Victoria JUGADOR1 ";
                        
                    }else if(historialRondas[i]==1){
                        if (modoJuego==1) {
                            
                            ganadorRonda = "Resultado: Victoria Consola";
                           
                            
                        }else{
                            
                            ganadorRonda = "Resultado: Victoria JUGADOR2";
                            
                        }
                    }
                    System.out.println(" - Ronda " + (i + 1) + ": " + ganadorRonda);
                }

                // GANADOR DEFINITIVO PARTIDA
                System.out.println(AMARILLO + "\n========================================" + RESET);
                System.out.println(AMARILLO + "       RESULTADO FINAL: " + resultadoFinal + RESET);
                System.out.println(AMARILLO + "========================================" + RESET);
                

              
            } else if (opcionMenu==4){
                //reglas
                System.out.println(AZUL + "\n=====================================================" + RESET);
                System.out.println(AZUL + "                   REGLAS DEL JUEGO                  " + RESET);
                System.out.println(AZUL + "=====================================================" + RESET);
                System.out.println("1. El juego es un duelo al mejor de 3 rondas.");
                System.out.println("2. Gana la partida quien consiga 2 victorias primero.");
                System.out.println("3. En cada ronda debes elegir una opción:");
                System.out.println("   - 1: Piedra");
                System.out.println("   - 2: Papel");
                System.out.println("   - 3: Tijera");
                System.out.println("4. Reglas de combate:");
                System.out.println("   - La Piedra aplasta a la Tijera.");
                System.out.println("   - La Tijera corta el Papel.");
                System.out.println("   - El Papel envuelve a la Piedra.");
                System.out.println("   - Si ambos eligen lo mismo, hay empate.");
                System.out.println(AZUL + "=====================================================" + RESET);
              
            } else if (opcionMenu==5){

            }else {
                System.out.println(ROJO + "\nINGRESE SOLO UN NUMERO DEL 1-5 DE LAS OPCIONES MOSTRADAS, INTENTE OTRA VEZ " + RESET);
                System.out.println("\n|");
                System.out.println("|");
                System.out.println("v\n");
                
            }
            
        } while (opcionMenu!=5);

        System.out.println(VERDE + "\nUSTED HA SALIDO DEL JUEGO" + RESET);

        scanner.close();




    }
}
