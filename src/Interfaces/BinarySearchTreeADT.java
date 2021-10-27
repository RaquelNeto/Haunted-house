/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.ElementNotFoundException;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */

/**
 * Interface BinarySearchTreeADT extend BinaryTreeADT
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

    /**
     * Adiciona o elemento especificado ao local apropriado nesta árvore.
     *
     */
    public void addElement(T element);

    /**
     * Remove e retorna o elemento especificado dessa árvore.
     *
     */
    public T removeElement(T targetElement) throws ElementNotFoundException;

    /**
     * Remove todas as ocorrências do elemento especificado dessa árvore.
     *
     */
    public void removeAllOccurrences(T targetElement);

    /**
     * Remove e retorna o menor elemento dessa árvore.
     *
     */
    public T removeMin();

    /**
     * Remove e retorna o maior elemento dessa árvore.
     *
     */
    public T removeMax();

    /**
     * Retorna uma referência ao menor elemento nesta árvore.
     *
     */
    public T findMin();

    /**
     * Retorna uma referência ao maior elemento nesta árvore.
     *
     */
    public T findMax();
}
