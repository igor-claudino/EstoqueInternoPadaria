/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class UsuarioDAO {
    
    private Connection conectar;

    public UsuarioDAO() throws SQLException {
        this.conectar = Conexao.getConnection();
    }
    
    public void cadastrarUser(Usuario user) throws SQLException{
        
        String sql = "insert into usuario (user, senha) values(?, ?)";
        PreparedStatement stmt = (PreparedStatement) conectar.prepareCall(sql);
        
        stmt.setString(1, user.getUser());
        stmt.setString(2, user.getSenha());
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
        
        stmt.close();
        
        
        
    }
    
    public boolean logar(String user, String senha) throws SQLException{
        
        String sql = "select * from usuario";
        PreparedStatement stmt = (PreparedStatement) conectar.prepareCall(sql);
        boolean entrar = false;
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            if(user.equals(rs.getString("user")) && senha.equals(rs.getString("senha"))){
                entrar = true;
            }
            
        }
        
        return entrar;
        
    } 
    
    public void alterarUser(String user, String senha, String userAnt) throws SQLException{
        
        String sql = "update usuario set user = ?, senha = ? where id = ?";
        
        PreparedStatement stmt = (PreparedStatement) conectar.prepareCall(sql);
        
        stmt.setString(1, user);
        stmt.setString(2, senha);
        stmt.setInt(3, retornaId(userAnt));
        
        stmt.execute();
        
        stmt.close();
    }
    
    public int retornaId(String user) throws SQLException{
        
        String sql = "select * from usuario where user = ?";
        
        PreparedStatement stmt = (PreparedStatement) conectar.prepareCall(sql);
        
        stmt.setString(1, user);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        
        rs.close();
        
        return id;
        
        
        
    }
    
    
    
    
}
