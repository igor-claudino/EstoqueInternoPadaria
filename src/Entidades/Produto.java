/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Forms.SwingColumn;

/**
 *
 * @author Igor
 */
public class Produto {
    
    private Integer id;
    @SwingColumn (description= "Nome")
    private String nome;
    @SwingColumn (description= "Quant.")
    private double quant;
    @SwingColumn (description= "Modo")
    private String modo;
    @SwingColumn (description= "Categoria")
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    
    
    
}
