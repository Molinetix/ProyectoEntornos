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
public class Jugadores implements Serializable{

    

    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int porcentajePartidas;

    public int getPorcentajePartidas() {
        return porcentajePartidas;
    }

    public void setPorcentajePartidas(int porcentajePartidas) {
        this.porcentajePartidas = porcentajePartidas;
    }

    public Jugadores(String nombre, int partidasGanadas, int partidasPerdidas, int porcentajePartidas) {
        super();
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.porcentajePartidas = porcentajePartidas;
    }

    public Jugadores(String nombre) {
        this.nombre = nombre;

    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
 
//lectura de jugadores
    public static void leerJugadores() throws IOException, ClassNotFoundException, NullPointerException {
        ObjectInputStream ol = null;
        ArrayList<Jugadores>ArrayJugadores = new ArrayList<>();
        try {
            String ruta = "E:\\3-PROGRAMACION\\EVAL2\\Pro2Ev\\proyecto";
            String nombre = "datos.txt";
            File f = new File(ruta, nombre);
            FileInputStream leer = new FileInputStream(f);
            
            
            while (true) {
                ol = new ObjectInputStream(leer);
                Jugadores Jugadores;
                int calculo;
                Jugadores p = (Jugadores) ol.readObject();
                ArrayJugadores.add(p);
                
                    System.out.println("<------------INFORMACION JUGADOR------------>");
                    System.out.println("Nombre jugador: " + p.getNombre());
                    System.out.println("Partidas ganadas: " + p.getPartidasGanadas());
                    System.out.println("Partidas perdidas: " + p.getPartidasPerdidas());
                    if (p.getPartidasGanadas() == 0) {
                        System.out.println("Porcentaje de victorias: 0%");
                        calculo = (p.getPartidasGanadas() * 100) / (p.getPartidasGanadas() + p.getPartidasPerdidas());
                        p.setPorcentajePartidas(calculo);
                    } else {
                        System.out.println("Porcentaje de victorias: " + (p.getPartidasGanadas() * 100) / (p.getPartidasGanadas() + p.getPartidasPerdidas()) + "%");
                        calculo = (p.getPartidasGanadas() * 100) / (p.getPartidasGanadas() + p.getPartidasPerdidas());
                        p.setPorcentajePartidas(calculo);
                    }
                    System.out.println("<------------------------------------------->");
            }
        } catch (IOException io) {
            System.out.println("\n***********************");
        } catch (NullPointerException f) {
            System.err.println("No hay jugadores introducidos");
        } finally {
            ol.close();
        }

    }      
    
    public static void escribirJugador(String jugador, int ganadas, int perdidas, int porcentaje) throws FileNotFoundException, IOException, ClassNotFoundException {
        String ruta = "E:\\3-PROGRAMACION\\EVAL2\\Pro2Ev\\proyecto";
        String nombre = "datos.txt";
        File f = new File(ruta, nombre);
        FileOutputStream escribir = new FileOutputStream(f, true);
        ObjectOutputStream de = new ObjectOutputStream(escribir);
        de.writeObject(new Jugadores(jugador, ganadas, perdidas, porcentaje));

    }

    public static void crearJugadores(int numJugadores) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        Jugadores[] jugador = new Jugadores[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1));
            String nombrar;
            nombrar = teclado.next();
        
            
            escribirJugador(nombrar, (i + 1), 2, 0);
        }

    }  
    
}
