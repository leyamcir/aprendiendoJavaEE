/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprimows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author cas
 */
public class TestPrimoWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long opcion = 0;

        while (opcion != -1){
            System.out.println("TestPrimoWS");
            System.out.println("===========");
            System.out.print("Inserte un número para saber si es primo ==> ");
            try{
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                opcion = Long.parseLong(s);                    
                boolean primo = esprimo(opcion);     
                String es = (primo) ? " es" : " NO es"; 
                String primoResult = "El número "+ s + es + " primo";                   
                System.out.println(primoResult);

            } catch(Exception e){ 
                //e.printStackTrace();
                System.out.println("El número introducido es incorrecto");
            }
        }
        
        System.out.println("Aplicacion finalizada");
    }

    private static boolean esprimo(java.lang.Long numero) {
        curso.HolaServicio_Service service = new curso.HolaServicio_Service();
        curso.HolaServicio port = service.getHolaServicioPort();
        return port.esprimo(numero);
    }
    
    
    
}
