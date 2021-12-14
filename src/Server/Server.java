
package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author User
 */
//public class Server extends UnicastRemoteObject implements RMIFacade{
    public class Server {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
         System.out.println("Server is starting.....");
        try {
            RMIFacade obj = new RMIImplementation();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("service", obj);
            System.out.println("Server is Running...");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
    }


}