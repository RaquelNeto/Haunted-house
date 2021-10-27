/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import java.util.Iterator;

/**
 * ESTG - IPP
 * Engenharia Informática - 2º Ano
 * Estrutura de Dados
 * 
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */

/**
 * Classe LinkedBinaryTree que implementa o BinaryTreeADT
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Cria uma arvore binaria vazia.
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Cria uma arvore binaria com o elemento especificado como sua raiz.
     *
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<>(element);
    }

    /**
     * Retorna a referencia do root
     *
     */
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        return root.element;
    }

    /**
     * Retorna true se a arvore binaria estiver vazia,falso caso contrario
     *
     */
    @Override
    public boolean isEmpty() {
         return count == 0;
    }

    /**
     * Retorna true se a arvore binaria estiver vazia,falso caso contrario
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Retorna true se a arvore binaria conter um elemento que corresponde ao
     * elemento especificado
     *
     */
    @Override
    public boolean contains(T targetElement) {
         return (this.findAgain(targetElement, root) != null);
    }

    /**
     * Retorna uma referência ao elemento de destino especificado se ele for encontrado em
     * esta árvore binária. Lança um NoSuchElementException se o destino especificado
     * o elemento não foi encontrado na árvore binária.
     *
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        if (current == null) {
        
            throw new ElementNotFoundException("binary tree");
           
        }
        return (current.element);
    }

   /**
     * Retorna uma referência ao elemento de destino especificado se ele for
     * encontrado em esta árvore binária.
     *
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        if (next.element.equals(targetElement)) {
            return next;
        }
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }
        return temp;
    }

     /**
     * Executa uma passagem inorder nesta árvore binária chamando um Método
     * inorder sobrecarregado e recursivo que começa com a raiz.
     *
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inOrder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Executa uma travessia em ordem recursiva.
     */
    private void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inOrder(node.left, tempList);
            tempList.addToRear(node.element);
            inOrder(node.right, tempList);
        }
    }

    /**
     * Executa uma travessia em ordem recursiva.
     *
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        preOrder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Executa uma passagem de pré-encomenda recursiva.
     *
     */
    private void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }
    }

    /**
     * Executa uma passagem de postorder nesta árvore binária ao chamar um
     * método de classificação póstorder e recursivo que começa na raiz.
     *
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        postOrder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Executa uma passagem de postorder nesta árvore binária ao chamar um
     * método de classificação póstorder e recursivo que começa na raiz.
     *
     */
    private void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }

     /**
     * Executa uma passagem de levelorder nesta árvore binária ao chamar um
     * método de classificação levelorder e recursivo que começa na raiz.
     *
     */
    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        LinkedQueue<T> tempQueue = new LinkedQueue<>();

        tempQueue.enqueue((T) root);
        levelOrder(tempList, tempQueue);

        return tempList.iterator();
    }

    /**
     * Executa uma passagem de levelorder recursiva
     *
     */
    public void levelOrder(ArrayUnorderedList<T> tempList, LinkedQueue<T> tempQueue) throws EmptyCollectionException {
        BinaryTreeNode<T> node;

        while (!tempQueue.isEmpty()) {

            node = (BinaryTreeNode) tempQueue.dequeue();
            tempList.addToRear(node.element);

            if (node.left != null) {
                tempQueue.enqueue((T) node.left);
            }
            if (node.right != null) {
                tempQueue.enqueue((T) node.right);
            }
            levelOrder(tempList, tempQueue);
        }
    }

}
