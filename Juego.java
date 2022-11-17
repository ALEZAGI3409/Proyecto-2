import java.util.ArrayList;
import java.util.Scanner;
public class Juego {

    public static Tanque tablero[][] = new Tanque[2][2];

    public static void empezarJuego(){
        ArrayList<Tanque> juego = new ArrayList();

        int numero = (int)(Math.random()*4+1);

        for(int i=0; i<numero; i++){
            int numero2 = (int)(Math.random()*(2-1+1)+1);
            if(numero2==1){
                TanqueNormal TN = new TanqueNormal();
                juego.add(TN);
            }
            else if(numero2==2){
                TanqueAlien TA = new TanqueAlien();
                juego.add(TA);
            }
        }

        if(numero==1){
            tablero[0][0] = juego.get(0);
            tablero[0][1] = null;
            tablero[1][0] = null;
            tablero[1][1] = null;
            System.out.print("\n-------------\n|"+tablero[0][0].toString()+"|     |\n-------------\n|     |     |\n-------------");
        }
        if(numero==2){
            tablero[0][0] = juego.get(0);
            tablero[0][1] = juego.get(1);
            tablero[1][0] = null;
            tablero[1][1] = null;
            System.out.print("\n-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|     |     |\n-------------");
        }
        if(numero==3){
            tablero[0][0] = juego.get(0);
            tablero[0][1] = juego.get(1);
            tablero[1][0] = juego.get(2);
            tablero[1][1] = null;
            System.out.print("\n-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|"+tablero[1][0].toString()+"|     |\n-------------");
        }
        if(numero==4){
            tablero[0][0] = juego.get(0);
            tablero[0][1] = juego.get(1);
            tablero[1][0] = juego.get(2);
            tablero[1][1] = juego.get(3);
            System.out.print("\n-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|"+tablero[1][0].toString()+"|"+tablero[1][1].toString()+"|\n-------------");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese 1 para iniciar el juego\nIngrese 2 para cerrar el juego");
        System.out.print("Ingrese su opcion: ");
        int op = sc.nextInt();
        if(op==1){
            Juego.empezarJuego();
            while(true){
                System.out.println("\nIngrese 1 para Disparar una bala\nIngrese 2 para Activar bomba atomica\nIngrese 3 para Activar tanque mutante\nIngrese 4 para La frase de la abuela\nIngrese 5 para Conteo de disparos\nIngrese 6 para leer cantidad de salud\nIngrese 7 para cerrar el juego");
                System.out.print("Ingrese su opcion: ");
                int in = sc.nextInt();
                if(in==1){
                    System.out.print("Ingrese la posicion en la que quiere Disparar: ");
                    int p = sc.nextInt();
                    Tanque.dispararBala(p);
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==2){
                    Tanque.bombaAtomica();
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==3){
                    Tanque.tanqueMutante();
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==4){
                    Tanque.fraseAbuela();
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==5){
                    System.out.println("\nEl numero de disparos hechos es: "+Tanque.conteoDisparos());
                    if(tablero[0][0]==null && tablero[0][1]==null && tablero[1][0]==null && tablero[1][1]==null){
                        System.out.print("-------------\n|     |     |\n-------------\n|     |     |\n-------------");
                    }
                    else if(tablero[0][1]==null && tablero[1][0]==null && tablero[1][1]==null){
                        System.out.print("-------------\n|"+tablero[0][0].toString()+"|     |\n-------------\n|     |     |\n-------------");
                    }
                    else if(tablero[1][0]==null && tablero[1][1]==null){
                        System.out.print("-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|     |     |\n-------------");
                    }
                    else if(tablero[1][1]==null){
                        System.out.print("-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|"+tablero[1][0].toString()+"|     |\n-------------");
                    }
                    else{
                        System.out.print("-------------\n|"+tablero[0][0].toString()+"|"+tablero[0][1].toString()+"|\n-------------\n|"+tablero[1][0].toString()+"|"+tablero[1][1].toString()+"|\n-------------");
                    }
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==6){
                    Tanque.cantidadSalud();
                    if(Tanque.finJuego()==1){
                        break;
                    }
                }
                else if(in==7){
                    System.out.println("\nGracias por jugar");
                    break;
                }
            }
        }
        if(op==2){
            System.out.println("\nGracias por jugar");
            System.exit(op);
        }
    }
}