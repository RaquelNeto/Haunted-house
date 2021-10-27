/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.StackADT;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe LinkedStack que implementa StackADT
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinearNode<T> head;
    private int size;

    /**
     * Método construtor
     */
    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adiciona o elemento especificado ao topo desta pilha, expandindo a
     * capacidade do array de pilhas, se necessário.
     *
     */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.setNext(head);
            head = newNode;
            size++;
        }

    }

    /**
     * Remove o elemento na parte superior desta pilha e retorna uma referência
     * a isto. Lança um EmptyCollectionException se a pilha estiver vazia.
     *
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T element = head.getElement();
        head = head.getNext();
        size--;
        return element;
    }

    /**
     * Retorna uma referência ao elemento na parte superior desta pilha. O
     * elemento não é removido da pilha. Lança um EmptyCollectionException se a
     * pilha está vazia.
     *
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * Método para ver se LinkedStack está vazia
     *
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Método para o tamanho
     *
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Método toString
     *
     */
    @Override
    public String toString() {
        String str = "";
        LinearNode<T> c = head;
        for (int i = 0; i < size; i++) {
            str = str + c.getElement() + " ";
            c = c.getNext();
        }

        return str + "";

    }
}
