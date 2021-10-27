/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Classes.ArrayUnorderedList;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe Aposentos
 */
public class Aposentos {

    private String nome_aposento;
    private long fantasmas;
    private ArrayUnorderedList<String> ligacoes;

    /**
     * Método para obter a ligação
     *
     */
    public ArrayUnorderedList<String> getLigacoes() {
        return ligacoes;
    }

    /**
     * Método para atribuir as ligações
     *
     */
    public void setLigacoes(ArrayUnorderedList<String> ligacoes) {
        this.ligacoes = ligacoes;
    }

    /**
     * Método construtor
     *
     */
    public Aposentos(String nome_aposento, long fantasmas, ArrayUnorderedList arrayLigacoes) {
        this.nome_aposento = nome_aposento;
        this.fantasmas = fantasmas;
        this.ligacoes = arrayLigacoes;
    }

    public Aposentos(String nome_aposento, long fantasmas) {
        this.nome_aposento = nome_aposento;
        this.fantasmas = fantasmas;
    }

    public String getNome_aposento() {
        return nome_aposento;
    }

    public void setNome_aposento(String nome_aposento) {
        this.nome_aposento = nome_aposento;
    }

    public long getFantasmas() {
        return fantasmas;
    }

    public void setFantasmas(long fantasmas) {
        this.fantasmas = fantasmas;
    }
    
    
    @Override
    public String toString() {

        return  nome_aposento;
    }
        
   
    public String toString_normal() {
        return "Aposentos{" + "nome_aposento=" + nome_aposento + ", fantasmas=" + fantasmas + ", ligacoes=" + ligacoes + '}';
    }

    

}
