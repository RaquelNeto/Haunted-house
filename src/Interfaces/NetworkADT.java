/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * ESTG - IPP
 * Engenharia Informática - 2º Ano
 * Estrutura de Dados
 * 
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */

/**
 * NetworkADT define a interface para uma rede.
 *
 */
public interface NetworkADT<T> {

    /**
     * Insere uma aresta entre dois vértices deste gráfico.
     *
     */
    public void addEdge(T vertex1, T vertex2, double weight);

    /**
     * Retorna o peso do caminho mais curto nesta rede.
     *
     */
    public double shortestPathWeight(T vertex1, T vertex2);
}
