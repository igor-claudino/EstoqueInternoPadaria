/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class ProdutoDAO {
    
    private Connection conectar;

    public ProdutoDAO() throws SQLException {
        this.conectar = Conexao.getConnection();
    }
    
    public void inserirProduto(Produto p) throws SQLException{
        
        String sql = "insert into produtos(nome, quant, modo, categoria) values(?,?,?,?)";
        PreparedStatement stmt = conectar.prepareCall(sql);
        
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getQuant());
        stmt.setString(3, p.getModo());
        stmt.setString(4, p.getCategoria());
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!!");
        
        stmt.close();
        
        
    }
    
    public List<Produto> List(String filtro) throws SQLException, ParseException {
        String sql;
        if(filtro.equals("")){
            sql = "select * from produtos order by nome asc";
        }else{
            sql = "select * from produtos where categoria = '"+filtro+"' order by nome asc";
        }
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Produto> minhaList = new ArrayList<Produto>();
        while(rs.next())
        {
            
            minhaList.add(populateProduto(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static Produto populateProduto(ResultSet rs) throws SQLException, ParseException{
        
        Produto p = new Produto();
        
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setQuant(rs.getDouble("quant"));
        p.setModo(rs.getString("modo"));
        p.setCategoria(rs.getString("categoria"));
        
        return p;
        
    }
    
    public void excluirProduto(Produto p) throws SQLException{
        String sql = "delete from produtos where id = ?";
        PreparedStatement stmt = conectar.prepareCall(sql);
        
        stmt.setInt(1, p.getId());
        
        JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!!!");
        
        stmt.execute();
    }
    
    public void editarProduto(Produto p) throws SQLException{
        
        String sql = "update produtos set nome = ?, quant = ?, modo = ?, categoria = ? where id = ?";
        PreparedStatement stmt = conectar.prepareCall(sql);
        
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getQuant());
        stmt.setString(3, p.getModo());
        stmt.setString(4, p.getCategoria());
        stmt.setInt(5, p.getId());
        
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!!");
        stmt.close();
    }
    
    public void reporEstoque(Produto p) throws SQLException{
        
        String sql = "update produtos set quant = ? where id = ?";
        
        PreparedStatement stmt = conectar.prepareCall(sql);
        
        stmt.setDouble(1, p.getQuant());
        stmt.setInt(2, p.getId());
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Alteração bem-sucedida!!");
        stmt.close();
    }
    
    public List<Produto> ListPesq(String nome, String filtro) throws SQLException, ParseException{
        
        String sql;
        if(filtro.equals("")){
        sql = "select * from produtos where nome like '%"+nome+"%' order by nome asc";    
        }else{
            sql = "select * from produtos where categoria = '"+filtro+"' and nome like '%"+nome+"%' order by nome asc";
        } 
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Produto> minhaList = new ArrayList<Produto>();
        while(rs.next())
        {
            
            
            minhaList.add(populateProduto(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
        
    }
    

