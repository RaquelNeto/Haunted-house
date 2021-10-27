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
 * Interface StackADT
 */
public interface StackADT<T> {

    /**
     * Adiciona um elemento ao topo da pilha.
     *
     */
    public void push(T element);

    /**
     * Remove e retorna o elemento superior da pilha.
     *
     */
    public T pop() throws EmptyCollectionException;

    /**
     * Retorna sem remover o elemento superior da pilha.
     *
     */
    public T peek() throws EmptyCollectionException;

    /**
     * Retorna true se essa pilha não contém elementos.
     *
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos na pilha.
     *
     */
    public int size();

    /**
     * Retorna uma representação de string da pilha.
     *
     */
    @Override
    public String toString();

}
