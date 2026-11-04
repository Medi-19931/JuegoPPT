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

                for (i=0 ; i<=MAXRONDAS ; i++) {
                    System.out.println("\n---------RONDA "+(i+1)+"---------");
                    rondasConsola=rondasConsola+1;
                    rondasJ1=rondasJ1+1;
                    
                    System.out.println("---------TURNO DEL JUGADOR 1---------");
                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v\n");

                    System.out.println("Elige tu  mejor jugada--------------------\n");
                    for (i=0 ; i<=MAXRONDAS ; i++) {
                        System.out.println((i+1)+" = "+ opciones[i]);

                    }

                    System.out.println("\n|");
                    System.out.println("|");
                    System.out.println("v");
                    do {
                        System.out.print("\nIngresa el numero de su jugada:");
                        opcionJ1=scanner.nextInt();
                        opcionRival =(int)(Math.random()*4);

                        

                        if (opcionJ1==1) {


                            if (opcionJ1==opcionRival) {

                                empatesTotales=empatesTotales+1;
                                System.out.println("Empate");
                                
                            } else if (opcionJ1<opcionRival) {
                                
                                victoriasConsola=victoriasConsola+1;
                                System.out.println("Ganador : CONSOLA");
                                
                            } else if (opcionJ1>opcionRival) {
                                
                                victoriasJ1=victoriasJ1+1;
                                System.out.println("Ganador : JUGADOR1");
                                
                            }

                            
                        } else if (opcionJ1==2){
                            
                        } else if (opcionJ1==3){
                            
                        } else {
                            System.out.println("\nINGRESE SOLO  UN NUMERO DEL 1-3 DE LAS JUGADAS MOSTRADAS,INTENTE OTRA VEZ ");
                            System.out.println("\n|");
                            System.out.println("|");
                            System.out.println("v\n");
                        }


                    } while (opcionJ1!=0);
                }



                //for (i=0 ; i<=MAXRONDAS ; i++) {
                    //if () {
                        
                    //} else {
                        
                   // }

                //}

                
            } else if (opcionMenu==2){
                //jugador 1 y jugador 2
                modoJuego=2;
                System.out.println("B");
              
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
