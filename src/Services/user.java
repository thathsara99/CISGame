package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Create cookie for user and save username temperory in local disk
 */
public class user implements Serializable {

    private String email;
    private String password;

    /**
     *save user name for the cookie 
     * @param email
     * @param password
     */
    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     *get email from user 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *get password from user 
     * @return
     */
    public String getPassword() {
        return password;
    }
/***
 * user name will save in local file temporary
 * @param u1 
 */
    public static void addCookie (user u1) {
        try {
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream(new File("D:\\iqQuizProTemp\\userCookie.iq"));
            ObjectOutputStream outputStm = new ObjectOutputStream(fileOut);
            outputStm.writeObject(u1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(answerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(answerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
