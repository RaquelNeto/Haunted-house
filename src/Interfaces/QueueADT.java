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
 * Interface QueueADT
 */
public interface QueueADT<T> {

    /**
     * Adiciona um elemento na parte traseira desta fila. elemento
     *
     */
    public void enqueue(T element);

    /**
     * Remove e retorna o elemento na frente desta fila.
     *
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Retorna sem remover o elemento na frente desta fila.
     *
     */
    public T first() throws EmptyCollectionException;

    /**
     * Retorna true se essa fila não contiver elementos.
     *
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta fila.
     *
     */
    public int size();

    /**
     * Retorna uma representação de string dessa fila.
     *
     */
    @Override
    public String toString();
}
