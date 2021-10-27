/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Iterator;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Interface ListADT extende Iterable
 */
public interface ListADT<T> extends Iterable<T> {

    /**
     * Remove e retorna o primeiro elemento desta lista.
     *
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     * Remove e retorna o último elemento desta lista.
     *
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     * Remove e retorna o elemento especificado dessa lista.
     *
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     *
     */
    public T first() throws EmptyCollectionException;

    /**
     * Retorna uma referência ao último elemento nesta lista.
     *
     */
    public T last() throws EmptyCollectionException;

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     *
     */
    public boolean contains(T target);

    /**
     * Retornará true se esta lista não contiver elementos.
     *
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta lista.
     *
     */
    public int size();

    /**
     * Retorna um iterador para os elementos nesta lista.
     *
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Retorna uma representação de sequência desta lista.
     *
     */
    @Override
    public String toString();
}
