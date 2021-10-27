/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Interface BinaryTreeADT
 *
 */
public interface BinaryTreeADT<T> {

    /**
     * Retorna uma referência ao elemento root
     *
     */
    public T getRoot() throws EmptyCollectionException;

    /**
     * Retorna true se essa árvore binária estiver vazia e falsa caso contrário.
     *
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta árvore binária.
     *
     */
    public int size();

    /**
     * Retorna true se a árvore binária contém um elemento que corresponde ao
     * elemento especificado e false caso contrário.
     *
     */
    public boolean contains(T targetElement);

    /**
     * Retorna uma referência ao elemento especificado se ele for encontrado
     * neste árvore binária. Lança uma exceção se o elemento especificado não
     * for encontrado.
     *
     */
    public T find(T targetElement) throws ElementNotFoundException;

    /**
     * Retorna a representação em cadeia da árvore binária.
     *
     */
    @Override
    public String toString();

    /**
     * Executa uma passagem inorder nesta árvore binária chamando um Método
     * inorder sobrecarregado e recursivo que começa com a raiz.
     *
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Executa um percurso de pré-encomenda nessa árvore binária chamando um
     * Método de pré-encomenda recursiva e sobrecarregada que começa com a raiz.
     *
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Executa um percurso pós-ordem nessa árvore binária chamando um Método
     * pós-encomenda recursiva sobrecarregado que começa com a raiz.
     *
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Executa um percurso de ordem de nível na árvore binária, usando uma fila.
     *
     */
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException;

}
