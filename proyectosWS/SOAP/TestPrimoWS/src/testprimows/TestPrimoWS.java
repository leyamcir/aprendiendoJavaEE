/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprimows;

import curso.Exception_Exception;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

/**
 *
 * @author Alicia Daza
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
                
                // Time before call
                long t0 = (new Date()).getTime();
                
                boolean primo = esprimo(opcion);  
                
                // Function lasting time
                long t1 = (new Date()).getTime()-t0;
                
                String es = (primo) ? " es" : " NO es"; 
                String primoResult = "El número "+ s + es + " primo (resultado 'esprimo' obtenido en "+ t1 +" ms.)";                   
                System.out.println(primoResult);
                
                // Faster algorythm
                // Time before call
                t0 = (new Date()).getTime();

                primo = esprimoFast(opcion);  
                
                // Function lasting time
                t1 = (new Date()).getTime()-t0;
                
                es = (primo) ? " es" : " NO es"; 
                primoResult = "El número "+ s + es + " primo (resultado 'esprimoFast' obtenido en "+ t1 +" ms.)";                   
                System.out.println(primoResult);
                
                
                System.out.println("Recuerde: inserte '-1' para salir.");
            } catch ( NumberFormatException e) {
                System.out.println("Debe introducir un número");
                System.out.println("Recuerde: inserte '-1' para salir.");
  
            } catch ( Exception_Exception e) {
                System.out.println("Excepción de WS: " + e.getMessage());
                System.out.println("Recuerde: inserte '-1' para salir.");
  
            } catch(Exception e){ 
                System.out.println("Error interno: " + e.getMessage());
                break;
            }
        }
        
        System.out.println("Aplicacion finalizada");
    }

    private static boolean esprimo(java.lang.Long numero) throws Exception_Exception {
        curso.HolaServicio_Service service = new curso.HolaServicio_Service();
        curso.HolaServicio port = service.getHolaServicioPort();
        
        return port.esprimo(numero);
    }

    private static boolean esprimoFast(java.lang.Long numero) throws Exception_Exception {
        curso.HolaServicio_Service service = new curso.HolaServicio_Service();
        curso.HolaServicio port = service.getHolaServicioPort();
        return port.esprimoFast(numero);
    }
    
    
}
