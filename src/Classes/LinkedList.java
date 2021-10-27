package Classes;

import Jogo.Node;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe LinkedList

 */
public class LinkedList<T> {

    private Node<T> head;
    private int size;

    /**
     * Construtor da lista
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Método construtor
     *
     */
    public LinkedList(Node<T> head) {
        this.head = head;
        this.size = 1;
    }

    /**
     * Método para obter head
     *
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Método para atribuir head
     *
     */
    public void setHead(Node<T> head) {
        if (isEmpty()) {
            size++;
        }
        this.head = head;

    }

    /**
     * Retorna o número de elementos nesta lista.
     *
     */
    public int getSize() {
        return size;
    }

    /**
     * Método para adicionar a lista
     *
     */
    public void add(T element) {
        Node<T> nova = new Node<>(element);

        if (isEmpty()) {
            head = nova;

        } else {
            Node<T> current = head;
            Node<T> anterior = null;
            while (current.getNextNode() != null) {
                current = current.getNextNode();

            }
            //liga o novo nó a lista
            current.setNextNode(nova);
            nova.setLast(current);
            current = nova;
        }
        this.size++;
    }

    /**
     * Método que remove um elemento
     *
     */
    public void remove(T element) {
        if (isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }

        Node<T> nodeToRemove = this.head;
        Node<T> previous = null;

        while (nodeToRemove != null && element != nodeToRemove.getVertex()) {
            previous = nodeToRemove;
            nodeToRemove = nodeToRemove.getNextNode();
        }
        if (nodeToRemove == this.head) {
            this.head = this.head.getNextNode();
            this.size--;
        } else if (nodeToRemove != null) {
            previous.setNextNode(nodeToRemove.getNextNode());
            this.size--;
        }
    }

    /**
     * Método de lista vazia
     *
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Método para imprimir a lista
     */
    public void printList() {
        Node<T> iteratorNode = this.head;

        while (iteratorNode != null) {
            System.out.print(iteratorNode.getVertex() + "; ");
            iteratorNode = iteratorNode.getNextNode();
        }
    }
}
