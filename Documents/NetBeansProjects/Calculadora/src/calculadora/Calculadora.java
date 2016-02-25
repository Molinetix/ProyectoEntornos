/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Alumno
 */
public class Calculadora {

    int num1, num2;
    int cuenta;

    public Calculadora(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        
    }
    
    

    public int suma(){
        System.out.println("Primer commit");
        return num1+num2;
    }
    
    public int resta(){
        if(num1>=num2){
            return num1-num2;
        }else{
            return num2-num1;
        }
    }
    
    public int multiplicar(){
        return num1*num2;
    }
    
    public int dividir(){
        try{
            if(num1>=num2){
                int cuenta = num1/num2;
            return cuenta;
            }else{
            int cuenta = num2/num1;
            return cuenta;
        }
        }catch(IllegalArgumentException e){
            
        }
        return cuenta;
    }
   
    
}
