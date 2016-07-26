/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientews;

/**
 *
 * @author Alicia Daza
 */
public class ClienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(hola("Prueba desde cliente"));
        System.out.println(hola(null));
    }

    // Right click -> Insert Code -> Call Web Service Operation (select remote method)
    private static String hola(java.lang.String name) {
        clientews.HolaServicio_Service service = new clientews.HolaServicio_Service();
        clientews.HolaServicio port = service.getHolaServicioPort();
        return port.hola(name);
    }
    
    
}
