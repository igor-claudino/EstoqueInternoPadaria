/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Igor
 */
public class RetiroDAO {
    
    private Connection conectar;

    public RetiroDAO() throws SQLException {
        this.conectar = Conexao.getConnection();
    }
    
    public void addRetiro(Produto p, double ret) throws SQLException{
        
        String sql = "insert into retiro (data, id_produto, quantRet) values(?,?,?)";
        PreparedStatement stmt = conectar.prepareCall(sql);
        
        stmt.setDate(1, new Date(System.currentTimeMillis()));
        stmt.setInt(2, p.getId());
        stmt.setDouble(3, ret);
        
        stmt.execute();
        
        stmt.close();
        
    }
    
}
