/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe Jogador
 */
public class Jogador {

    private String name;
    private double pontos;

    /**
     * Método construtor
     *
     */
    public Jogador(String name, double pontos) {
        this.name = name;
        this.pontos = pontos;
    }

    /**
     * Método para obter o Nome
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Método para atribuir o Nome
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obter os pontos
     *
     */
    public double getPontos() {
        return pontos;
    }

    /**
     * Método para atribuir os pontos
     *
     */
    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    /**
     * Método toString
     *
     */
    @Override
    public String toString() {
        return "Jogador{" + "name=" + name + ", pontos=" + pontos + '}';
    }

}
