/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class Pantalla {
    
  
        static int pideEntero() {
        int n = 0;
        boolean opcion=false;
        do{
        Scanner teclado = new Scanner(System.in);
        System.out.print("\tIntroduce un número: ");
        
        try {
            n = teclado.nextInt();
            opcion = true;
        } catch (InputMismatchException i) {

            System.err.println("\tNo se pueden introducir letras.");
        }
        }while(opcion==false);
        return n;
    
        }
        
        static String pideLetra(){
            String letra = "";
            boolean correcto=false;
            Scanner teclado = new Scanner(System.in);
            do{
            System.out.println("Introduce un caracter de [a-z]: ");
            letra = teclado.next();
            if(letra.matches("[a-z].*") && letra.length()== 1){
                correcto = true;
            }else if(letra.length()>1){
                System.out.println("Sólo tienes que introducir una letra");
            }else{
                System.out.println("Carácter no valido");
            }
            }while(!correcto);
            return letra;
        }
}
