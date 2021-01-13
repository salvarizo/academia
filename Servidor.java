
package edu.ucam.rmi.academia;

import edu.ucam.rmi.academia.dao.AlumnoDAO;
import edu.ucam.rmi.academia.dao.AlumnoDAOInterface;
import edu.ucam.rmi.academia.dao.CursoDAO;
import edu.ucam.rmi.academia.dao.CursoDAOInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Salva Rizo
 */
public class Servidor {

    public static void main(String[] args) {
    	Number[] arr = new Integer[10];
    	arr[0] = 1;
        try {
            CursoDAOInterface cursoDAO = CursoDAO.getInstancia();
            AlumnoDAOInterface alumnoDAO = AlumnoDAO.getInstancia();

            Registry theRegistry = null;
            
            try {
                System.err.println("Locating registry...");
                theRegistry = LocateRegistry.getRegistry(1234);
                theRegistry.list();
                System.err.println("Registry located!");
            } catch (Exception e) {
                
                try {
                    System.err.println("Registry not located.");
                    System.err.println("Creating registry...");
                    theRegistry = LocateRegistry.createRegistry(1234);
                    theRegistry.list();
                    System.err.println("Registry created!");
                } catch (Exception e2) {
                    System.err.println("Error creating registry:" + e2.getMessage());
                    theRegistry = null;
                    
                }
            }
            

            java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress()
                    + ":1234/alumnos", alumnoDAO);
            java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress()
                    + ":1234/cursos", cursoDAO);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

}
