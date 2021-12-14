/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class DB_connection {
    
    static Connection game;
    
    /***
     * set database connection using JDBC Driver
     * @throws Exception
     */
    
    private static void setConnection() throws Exception{
          Class.forName("com.mysql.cj.jdbc.Driver");
        game = DriverManager.getConnection("jdbc:mysql://localhost:3308/iqpro", "root", "");
    }
    
    /***
     * iud include for insert,update,delete data between the database
     * @param sql
     * @throws Exception 
     */
    
    public static void iud(String sql) throws Exception {
        if (game == null) {
            setConnection();
        }
        game.createStatement().executeUpdate(sql);
    }
    
    /***
     * search method use for search data from database
     * @param sql
     * @return search data
     * @throws Exception 
     */
    
    public static ResultSet search(String sql) throws Exception {//search
        if (game == null) {
            setConnection();
        }
        return game.createStatement().executeQuery(sql);
    }
    
    /**
     *value insert method for insert value for database(only insert values are executed)
     * @param sql
     * @throws Exception
     */
    public static void saveAnswersDB(String sql) throws Exception {
        if (game == null) {
            setConnection();
        }
        game.createStatement().executeUpdate(sql);
    }
    
    /**
     *method for update value from database.(only update values will be executed)
     * @param sql
     * @throws Exception
     */
    public static void updateAnswerDB (String sql) throws Exception {
        if (game == null) {
            setConnection();
        }
        game.prepareStatement(sql).executeUpdate();
    }
}
