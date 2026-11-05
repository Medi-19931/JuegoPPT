import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //parte declarativa
        //CONTADOR GLOBAL
        final int MAXRONDAS=3;
        int partidasTotales;
        int victoriasJ1;
        int victoriasConsola;
        int victoriasJ2;
        int empatesTotales;

        //CONTROL MENÚ

        int opcionMenu;
        int modoJuego;
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
            System.out.println("========================================");
            System.out.println("        PIEDRA, PAPEL Y TIJERA");          
            System.out.println("========================================");
            System.out.println("1. Solitario (Jugador 1 vs Consola)");
            System.out.println("2. Jugador 1 vs Jugador 2");
            System.out.println("3. Ver estadísticas de la sesión");
            System.out.println("4. Ver reglas e instrucciones");
            System.out.println("5. Salir");
            System.out.print("\nIngrese la opcion deseada (solo un numero del  1 al 5): ");
            opcionMenu=scanner.nextInt();

            if (opcionMenu==1) {
                //modo solitrio contra IA
                modoJuego=1;
                System.out.println("Biemvenido,MODO SOLITARIO");

                System.out.println("\n----------INICIO DE PARTIDA----------");
                rondasJ1=0;
                rondasConsola=0;

                victoriasConsola=0;
                victoriasJ1=0;
                empatesTotales=0;
                int i;

                for (i=0 ; i<MAXRONDAS ; i++) {
                    System.out.println("\n---------RONDA "+(i+1)+"---------");
                    rondasConsola=rondasConsola+1;
                    rondasJ1=rondasJ1+1;
                    
                    System.out.println("---------TURNO DEL JUGADOR 1---------");
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
                        
                        System.out.println("\n--------------TURNO CONSOLA--------------");
                        System.out.println("\n|");
                        System.out.println("|");
                        System.out.println("v\n");

                        //genera numeros enteros 1-3(jugada consola)
                        opcionRival =(int)(Math.random()*3)+1;
                        System.out.println("Consola eligió: "+opciones[opcionRival-1]+"------------------");
                        
                        

                        //comparacion de jugadas
                        //jugador1 1 -elige piedra
                        if (opcionJ1==1) {


                            if (opcionJ1==opcionRival) {
                                //consola elije piedra
                                empatesTotales=empatesTotales+1;
                                System.out.println("Resultado: Empate");
                                
                            } else if (opcionRival==2) {
                                //consola elije papel(papel gana contra piedra)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println("Ganador : CONSOLA");
                                
                            } else {
                                //consola elije tijera(tijera pierde contra piedra)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");
                                
                            }

                         //jugador1 2-elige papel
                        } else if (opcionJ1==2){

                           if (opcionJ1==opcionRival) {
                                //consola elije papel
                                empatesTotales=empatesTotales+1;
                                System.out.println("Resultado: Empate");
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra pierde contra papel)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");
                                    
                            } else {
                                //consola elije tijera(tijera gana contra papel)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println("Ganador : CONSOLA");
                                    
                            }
                        
                        //jugador1 3-elige tigera
                        } else if (opcionJ1==3){

                             if (opcionJ1==opcionRival) {
                                //consola elige tijera
                                empatesTotales=empatesTotales+1;
                                System.out.println("Resultado: Empate");
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra gana contra tijera)
                                victoriasConsola=victoriasConsola+1;
                                System.out.println("Ganador : CONSOLA");
                                    
                            } else {
                                //consola elije papel(papel piedre contra tijera)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");   
                            }
                            
                        } 
                            
                        


                    } else{
                            System.out.println("\nINGRESE SOLO  UN NUMERO DEL 1-3 DE LAS JUGADAS MOSTRADAS,INTENTE OTRA VEZ ");
                            System.out.println("\n|");
                            System.out.println("|");
                            System.out.println("v\n");
                    }

                    System.out.println("========================================");
                    System.out.println("               RESULTADOS");          
                    System.out.println("========================================");
                    System.out.printf("%-15s %6s %8s%n","EMPATE","JUGADOR1","CONSOLA");
                    System.out.printf("%-15d %6d %d%n", empatesTotales, victoriasJ1, victoriasConsola);

                    if (victoriasJ1 < victoriasConsola) {
                        System.out.println("\n-----------------------------------");
                        System.out.println("----------Victoria: Consola--------");
                        System.out.println("-----------------------------------");
                    } else if (victoriasConsola < victoriasJ1){
                        System.out.println("\n-------------------------------------");
                        System.out.println("----------Victoria: Jugador 1--------");
                        System.out.println("-------------------------------------");
                        
                    }else {
                        System.out.println("\n--------------------------");
                        System.out.println("----------EMPATE----------");
                        System.out.println("--------------------------");
                    }
                    
                    

                }



                //for (i=0 ; i<=MAXRONDAS ; i++) {
                    //if () {
                        
                    //} else {
                        
                   // }

                //}

                
            } else if (opcionMenu==2){
                //jugador 1 y jugador 2
                modoJuego=2;
                
                System.out.println("Biemvenido,MODO MULTIJUGADOR");

                System.out.println("\n----------INICIO DE PARTIDA----------");
                rondasJ1=0;
                rondasJ2=0;

                victoriasJ2=0;
                victoriasJ1=0;
                empatesTotales=0;
                int i;

                for (i=0 ; i<MAXRONDAS ; i++) {
                    System.out.println("\n---------RONDA "+(i+1)+"---------");
                    rondasJ2=rondasJ2+1;
                    rondasJ1=rondasJ1+1;
                    
                    System.out.println("---------TURNO DEL JUGADOR 1---------");
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

                    System.out.println("\n---------TURNO DEL JUGADOR 2---------");
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
                                System.out.println("Resultado: Empate");
                                
                            } else if (opcionRival==2) {
                                //consola elije papel(papel gana contra piedra)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println("Ganador : JUGADOR2");
                                
                            } else {
                                //consola elije tijera(tijera pierde contra piedra)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");
                                
                            }

                         //jugador1 2-elige papel
                        } else if (opcionJ1==2){

                           if (opcionJ1==opcionRival) {
                                //consola elije papel
                                empatesTotales=empatesTotales+1;
                                System.out.println("Resultado: Empate");
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra pierde contra papel)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");
                                    
                            } else {
                                //consola elije tijera(tijera gana contra papel)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println("Ganador : JUGADOR2");
                                    
                            }
                        
                        //jugador1 3-elige tigera
                        } else if (opcionJ1==3){

                             if (opcionJ1==opcionRival) {
                                //consola elige tijera
                                empatesTotales=empatesTotales+1;
                                System.out.println("Resultado: Empate");
                                    
                            } else if (opcionRival==1) {
                                //consola elije piedra (piedra gana contra tijera)
                                victoriasJ2=victoriasJ2+1;
                                System.out.println("Ganador : JUGADOR2");
                                    
                            } else {
                                //consola elije papel(papel piedre contra tijera)
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");   
                            }
                            
                        } 
                            
                        


                    } else{
                            System.out.println("\nINGRESE SOLO  UN NUMERO DEL 1-3 DE LAS JUGADAS MOSTRADAS,INTENTE OTRA VEZ ");
                            System.out.println("\n|");
                            System.out.println("|");
                            System.out.println("v\n");
                    }

                    System.out.println("========================================");
                    System.out.println("               RESULTADOS");          
                    System.out.println("========================================");
                    System.out.printf("%-15s %6s %8s%n","EMPATE","JUGADOR1","JUGADOR2");
                    System.out.printf("%-15d %6d %d%n", empatesTotales, victoriasJ1, victoriasJ2);

                    if (victoriasJ1 < victoriasJ2) {
                        System.out.println("\n-----------------------------------");
                        System.out.println("---------Victoria: Jugador 2-------");
                        System.out.println("-----------------------------------");
                    } else if (victoriasJ2 < victoriasJ1){
                        System.out.println("\n-------------------------------------");
                        System.out.println("----------Victoria: Jugador 1--------");
                        System.out.println("-------------------------------------");
                        
                    }else {
                        System.out.println("\n--------------------------");
                        System.out.println("----------EMPATE----------");
                        System.out.println("--------------------------");
                    }
                    
                    

                }

              
            } else if (opcionMenu==3){
                //estadisticas
                System.out.println("C");
              
            } else if (opcionMenu==4){
                //reglas
                System.out.println("\n=====================================================");
                System.out.println("                   REGLAS DEL JUEGO                  ");
                System.out.println("=====================================================");
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
                System.out.println("=====================================================");
              
            } else {
                System.out.println("\nINGRESE SOLO  UN NUMERO DEL 1-5 DE LAS OPCIONES MOSTRADAS,INTENTE OTRA VEZ ");
                System.out.println("\n|");
                System.out.println("|");
                System.out.println("v\n");
                
            }
            
        } while (opcionMenu!=5);

        System.out.println("\nUSTED A SALIDO DEL JUEGO");





    }
}
