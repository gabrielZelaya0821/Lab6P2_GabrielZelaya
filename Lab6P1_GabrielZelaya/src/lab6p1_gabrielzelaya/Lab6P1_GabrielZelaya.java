package lab6p1_gabrielzelaya;
import java.util.Random;
import java.util.Scanner;

public class Lab6P1_GabrielZelaya {
    
    public static int[][] crearMatriz(int fila, int columna){
        int[][] matriz = new int[fila][columna];
        return matriz;
    }
    
    public static int[][] llenarMatrizRandom(int[][] matriz, int max, int min){
        int random = new Random().nextInt((max-min)+1)+min;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random;
                random = new Random().nextInt((max-min)+1)+min;
            }
        }
        return matriz;
    }
    
    public static void imprimirMatrizInt(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("");
        }
    }
    public static void imprimirMatrizChar(int[][] matriz, int fila, int columna){
        char[][] matrizChar = new char[fila][columna];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                char ascii = (char)matriz[i][j];
                matrizChar[i][j] = ascii;
                System.out.print("["+matrizChar[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
    public static void ejercicio2(int num){
        int numUsuario = num;
        int numMaquina = new Random().nextInt((5-1)+1)+1;
        int[][] matriz = {{0,1,3,1,5}, {1,0,2,4,2}, {3,2,0,3,5}, {1,4,3,0,4}, {5,2,5,4,0}};
        int ganador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (numUsuario == i && numMaquina == j){
                    ganador = matriz[i][j];
                }
            }
        }
        System.out.println("La maquina eligió: " + numMaquina);
        if(numMaquina == ganador){
            System.out.println("¡La máquina gana!");
        } else {
            System.out.println("¡Jugador gana!");
        }
    }
    
    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        int menu;
        do {
            System.out.println("----------Menú----------");
            System.out.println("(1)El juego de la vida\n(2)Piedra papel o...\n(3)Blink\n(4)Salir");
            menu = entrada.nextInt();
            switch(menu){
                case 1:
                    break;
                case 2:
                    System.out.println("(1)Rock\n(2)Paper\n(3)Scissors\n(4)Spock\n(5)Lizard");
                     System.out.println("Elija que queire usar: ");
                     int usuario = entrada.nextInt();
                     ejercicio2(usuario);
                    break;
                case 3:
                    System.out.println("Determine el ancho de la matriz: ");
                    int largo = entrada.nextInt();
                    System.out.println("Determine el largo de la matriz: ");
                    int ancho = entrada.nextInt();
                    int[][] matriz = crearMatriz(ancho,largo);
                    int[][] matrizLlenada = llenarMatrizRandom(matriz,122,97);
                    imprimirMatrizInt(matrizLlenada);
                    System.out.println("");
                    imprimirMatrizChar(matrizLlenada,ancho,largo);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Número no es válido, intente de nuevo");
            }
        }while(menu!=4);
                
        if (menu == 4){
            System.out.println("Saliendo del menú");
        }
    }

    public static void main(String[] args) {
        menu();
    }
    
}
