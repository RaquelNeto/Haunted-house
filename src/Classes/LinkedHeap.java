/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import Exceptions.EmptyCollectionException;
import Interfaces.HeapADT;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe LinkedHeap que extende LinkedBinaryTree e implementa HeapADT
 */
public class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {

    public HeapNode<T> lastNode;

    /**
     * Método construtor
     */
    public LinkedHeap() {
        super();
    }

    /**
     * Adiciona o elemento especificado a este heap na posição apropriada de
     * acordo com seu valor-chave Observe que elementos iguais são adicionados
     * ao certo.
     *
     */
    @Override
    public void addElement(T obj) {
        HeapNode<T> node = new HeapNode<>(obj);

        if (this.root == null) {
            this.root = node;
        } else {
            HeapNode<T> nextParent = getNextParentAdd();

            if (nextParent.left == null) {
                nextParent.left = node;
            } else {
                nextParent.right = node;
            }
            node.parent = nextParent;
        }

        this.lastNode = node;
        count++;

        if (count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Retorna o nó que será o pai do novo nó
     *
     */
    private HeapNode<T> getNextParentAdd() {
        HeapNode<T> result = lastNode;

        while ((result != this.root) && (result.parent.left != result)) {
            result = result.parent;
        }

        if (result != this.root) {
            if (result.parent.right == null) {
                result = result.parent;
            } else {
                result = (HeapNode<T>) result.parent.right;
                while (result.left != null) {
                    result = (HeapNode<T>) result.left;
                }
            }
        } else {
            while (result.left != null) {
                result = (HeapNode<T>) result.left;
            }
        }
        return result;
    }

   /**
     * Reordena esse heap depois de adicionar um nó.
     */
    private void heapifyAdd() {
        T temp;
        HeapNode<T> next = this.lastNode;

        temp = next.element;

        while ((next != root) && (((Comparable) temp).compareTo(next.parent.element) < 0)) {
            next.element = next.parent.element;
            next = next.parent;
        }
        next.element = temp;
    }

     /**
     * Remova o elemento com o valor mais baixo nesta pilha e retorne um
     * referência a ele. Lança um EmptyCollectionException se o heap estiver
     * vazio.
     *
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        T minElement = root.element;
        if (count == 1) {
            this.root = null;
            this.lastNode = null;
        } else {
            HeapNode<T> next_last = getNewLastNode();
            if (this.lastNode.parent.left == lastNode) {
                this.lastNode.parent.left = null;
            } else {
                this.lastNode.parent.right = null;
            }
            this.root.element = this.lastNode.element;
            this.lastNode = next_last;
            heapifyRemove();
        }
        count--;
        return minElement;
    }

    /**
     * Retorna o nó que será o novo último nó após uma remoção.
     
     */
    private HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;
        while ((result != root) && (result.parent.left == result)) {
            result = result.parent;
        }
        if (result != root) {
            result = (HeapNode<T>) result.parent.left;
        }
        while (result.right != null) {
            result = (HeapNode<T>) result.right;
        }
        return result;
    }

     /**
     * Reordena esse heap após remover o elemento raiz.
     */
    private void heapifyRemove() {
        T temp;
        HeapNode<T> node = (HeapNode<T>) root;
        HeapNode<T> left = (HeapNode<T>) node.left;
        HeapNode<T> right = (HeapNode<T>) node.right;
        HeapNode<T> next;

        if ((left == null) && (right == null)) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (((Comparable) left.element).compareTo(right.element) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.element;
        while ((next != null) && (((Comparable) next.element).compareTo(temp) < 0)) {
            node.element = next.element;
            node = next;
            left = (HeapNode<T>) node.left;
            right = (HeapNode<T>) node.right;
            if ((left == null) && (right == null)) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (((Comparable) left.element).compareTo(right.element) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        node.element = temp;
    }

    /**
     * Retorna o elemento com o valor mais baixo nesta pilha. Lança uma
     * EmptyCollectionException se a pilha estiver vazia.
     *
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        return this.getRoot();
    }
      
    
   
}
