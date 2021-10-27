/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe LinearNode
 */
public class LinearNode<T> {

    /**
     * Referência ao próximo nó na lista
     */
    private LinearNode<T> next;
    /**
     * Elemento armazenado neste nó
     */
    private T element;

    /**
     * Cria um nó vazio.
     */
    public LinearNode() {
        next = null;
        element = null;
    }

    /**
     * Cria um nó que armazena o elemento especificado.
     *
     */
    public LinearNode(T elem) {
        next = null;
        element = elem;
    }

    /**
     * Retorna o nó que segue este.
     *
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Define o nó que segue este.
     *
     */
    public void setNext(LinearNode<T> node) {
        next = node;
    }

    /**
     * Retorna o elemento armazenado neste nó.
     *
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento armazenado neste nó
     *
     */
    public void setElement(T elem) {
        element = elem;
    }
}
