
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
 * create object array to save to answer reading temporary files 
 *to identify the object 
 * @author User
 */
public class Answer implements Serializable{
    private int qno;
    private String proAnswer;
    
    
    /***
     * answer are searialized to connect with RMI 
     * identify the object
     * @param qno
     * @param proAnswer 
     */

    public Answer(int qno, String proAnswer) {
        this.qno = qno;
        this.proAnswer = proAnswer;
    }

    /**
     *get question number 
     * @return question number
     */
    public int getQno() {
        return qno;
    }

    /**
     * get question answer 
     * @return answer
     */
    public String getProAnswer() {
        return proAnswer;
    }
    
    /**
     *read temporary values from local disk
     * @param quesNo
     * @param ans
     */
    public static void saveProAnswer (int quesNo, Answer ans) {
        try {
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream(new File("D:\\iqQuizProTemp\\ans"+quesNo+".iq"));
            ObjectOutputStream outputStm = new ObjectOutputStream(fileOut);
            outputStm.writeObject(ans);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(answerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(answerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
