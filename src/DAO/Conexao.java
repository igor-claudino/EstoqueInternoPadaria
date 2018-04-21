/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class Conexao {
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException er) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, er);
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o BD!!");
        }
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/estoque_padaria", "root", "");
    }
    
}
