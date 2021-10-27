/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyCollectionException;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Interface HeapADT extende BinaryTreeADT
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {

    /**
     * Adiciona o objeto especificado a este heap.
     *
     */
    public void addElement(T obj);

    /**
     * Remove o elemento com o valor mais baixo desse heap.
     *
     */
    public T removeMin() throws EmptyCollectionException;

    /**
     * Retorna uma referência ao elemento com o menor valor neste heap.
     *
     */
    public T findMin() throws EmptyCollectionException;
}
