
package Services;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class QandAns implements Serializable {
    private String qno;
    private String question;
    private String answer;

    /**
     *read questions and answers from databse 
     * @param qno
     * @param question
     * @param answer
     */
    public QandAns(String qno, String question, String answer) {
        this.qno = qno;
        this.question = question;
        this.answer = answer;
    }

    /**
     *get question number 
     * @return question number 
     */
    public String getQno() {
        return qno;
    }

    /**
     *get question 
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     *get true value of answer from database 
     * @return answer 
     */
    public String getAnswer() {
        return answer;
    }
    
    
}
