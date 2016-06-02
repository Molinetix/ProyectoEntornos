/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class Menu {
    
    public static void Menu() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Scanner teclado = new Scanner(System.in);
        int opcion=-1;
        
        do{
        System.out.println("1. Jugar partida");
        System.out.println("2. Añadir palabras");
        System.out.println("3. Top 3");
        System.out.println("4. Estadísticas jugadores");
        System.out.println("0. Salir");
        opcion = teclado.nextInt();//..
        
        switch(opcion){
            case 1:
                Jugadores.crearJugadores(Partida.numeroJugadores());
                
                break;
            case 2:
                //Partida.pedirPalabra();
                break;
            case 3:
                Partida.elegirPalabra();
                break;
            case 4:
                Jugadores.leerJugadores();
                break;
        }
        
        
        }while(opcion!=0);
        
    }
}
