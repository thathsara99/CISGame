  package GUI;

import Server.RMIFacade;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RMIConnection {

    private Registry reg;
    private RMIFacade server;

    /**
     *RMI connection made connection wither server side and client side
     */
    public RMIConnection() {
        try {
            server = (RMIFacade) Naming.lookup("rmi://localhost/service");
        } catch (NotBoundException ex) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *get rmi connection
     * @return server 
     */
    public RMIFacade getServer() {
        System.out.println("Successfully Connected to the Server.....");
        return server;
    }

}
