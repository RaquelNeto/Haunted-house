/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */

/**
 * GraphADT define a interface para uma estrutura de dados gráficos.
 *
 */
public interface GraphADT<T> {

    /**
     * Adiciona um vértice a este gráfico, associando o objeto ao vértice.
     *
     */
    public void addVertex(T vertex);

    /**
     * Remove um único vértice com o valor fornecido deste gráfico.
     *
     */
    public void removeVertex(T vertex);

    /**
     * Insere uma aresta entre dois vértices deste gráfico.
     *
     */
    public void addEdge(T vertex1, T vertex2);

    /**
     * Remove uma aresta entre dois vértices deste gráfico.
     *
     */
    public void removeEdge(T vertex1, T vertex2);

    /**
     * Retorna um primeiro iterador de largura começando com o vértice
     * fornecido.
     *
     */
    public Iterator iteratorBFS(T startVertex) throws EmptyCollectionException;

    /**
     * Retorna um primeiro iterador de profundidade começando com o vértice
     * fornecido.
     *
     */
    public Iterator iteratorDFS(T startVertex);

    /**
     * Retorna um iterador que contém o caminho mais curto entre os dois
     * vértices.
     *
     */
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws EmptyCollectionException;

    /**
     * Retorna true se este gráfico estiver vazio, false caso contrário.
     *
     */
    public boolean isEmpty();

    /**
     * Retorna true se este gráfico estiver conectado, false caso contrário.
     *
     */
    public boolean isConnected() throws EmptyCollectionException;

    /**
     * Retorna o número de vértices neste gráfico.
     *
     */
    public int size();

    /**
     * Retorna uma representação de string da matriz de adjacência.
     *
     */
    @Override
    public String toString();
}
