/***
 * RMI connection to consist with abstract methods to exchange the data in between the server and the client.
 */
package Server;
//abstract class 
import Services.Answer;
import Services.QandAns;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public interface RMIFacade extends Remote{
    public String login(String email, String password) throws RemoteException;
    public String Register(String username, String email, String password, String confirm_password) throws RemoteException;
    public void saveAnswers (Answer [] ansArray, String email) throws RemoteException;
    public String Admin(String username, String password) throws RemoteException;
    public ArrayList<QandAns> getDetails(String email) throws RemoteException;
    public   String gettotalMarks() throws RemoteException;
    public   String getUmarks(String username) throws RemoteException;

    

    
   

    
}
