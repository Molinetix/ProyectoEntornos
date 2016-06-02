/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.*;
import java.util.*;

/**
 *
 * @author Sergio
 */
public class Partida implements Serializable {

    private String palabras;
    
    
    public Partida(String palabras) {
        super();
        this.palabras = palabras;
    }

    public String getPalabras() {
        return palabras;
    }

    public void setPalabras(String palabras) {
        this.palabras = palabras;
    }
    
    public static void elegirPalabra() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException, NullPointerException {
        ObjectInputStream ol = null;
        ArrayList<String>Array = new ArrayList<String>();
        
        try {

            String ruta = "E:\\3-PROGRAMACION\\EVAL2\\Pro2Ev\\proyecto";
            String nombre = "aleatorios.txt";
            File f = new File(ruta, nombre);
            FileInputStream leer = new FileInputStream(f);

            while (true) {
                
                int contador=1;
                
                ol = new ObjectInputStream(leer);
                Partida Partida;
                Partida p = (Partida) ol.readObject();
                String seleccion = p.getPalabras();
                Array.add(seleccion);
  
                contador++;
            }
        } catch (IOException io) {
            
        } finally {
            ol.close();

        }
        int num = (int) (Math.random()*Array.size());
        System.out.println("\n***********************");
        System.out.println(Array.get(num));
        System.out.println("\n***********************");
        
    }

    static void addPalabra(String palabraEscrita) throws FileNotFoundException, IOException {
        String ruta = "E:\\3-PROGRAMACION\\EVAL2\\Pro2Ev\\proyecto";
        String nombre = "aleatorios.txt";
        File f = new File(ruta, nombre);
        FileOutputStream escribir = new FileOutputStream(f, true);
        ObjectOutputStream de = new ObjectOutputStream(escribir);
        de.writeObject(new Partida(palabraEscrita));

    }

    public static void pedirPalabra() throws IOException {
        int salida = 0;
        String palabraEscrita;
        Scanner teclado = new Scanner(System.in);
        Partida[] partida = new Partida[1];
        do {
            System.out.println("Escribe la palabra: ");
            palabraEscrita = teclado.next();
            addPalabra(palabraEscrita);

            System.out.println("Pulsa 0 para salir, cualquier otro número continuar");
            salida = teclado.nextInt();
        } while (salida != 0);

    }

    static int numeroJugadores() {
        Scanner teclado = new Scanner(System.in);
        int numeroJugadores = 0;
        int opcion = 0;

        do {
            System.out.println("Introduce el nº de jugadores: ");
            opcion = teclado.nextInt();
            if (opcion > 10) {
                System.out.println("El limite son 10 jugadores");
            } else if (opcion < 1) {
                System.out.println("Introdue algún jugador");
            } else {
                numeroJugadores = opcion;
            }
        } while (opcion > 10 || opcion < 1);

        return numeroJugadores;
    }
    

}
