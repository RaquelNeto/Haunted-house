
package Jogo;

import java.util.Objects;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe Node que implementa Comparable
 */
public class Node<T> implements Comparable<T> {

    private T vertex;
    private double weight;

    private Node<T> nextNode;
    
     private Node<T> last;

   /**
     * Método construtor para criar uma instância do Node com um vértice
     * específico;
     *
     */
    public Node(T vertex) {
        this.vertex = vertex;
        this.weight = 0;
    }

    /**
     * Método construtor para outro nó
     *
     */
    public Node(Node anotherNode) {
        this.nextNode = anotherNode.getNextNode();
        this.vertex = (T) anotherNode.getVertex();
        this.weight = 0;
    }

    /**
     * Método construtor
     */
    public Node(Node nextNode, T vertex) {
        this.nextNode = nextNode;
        this.vertex = vertex;
        this.weight = 0;
    }

    /**
     * Método para obter o nó seguinte
     *
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * Retorna o aposento
     */
    public Node<T> getNextNode_() {
        return nextNode;
    }

    public void setLast(Node last) {
        this.last = last;
    }
    
/**
     * Método para atribuir o nó seguinte
     *
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Método para obter o vértice
     *
     */
    public T getVertex() {
        return vertex;
    }

    /**
     * Método para atribuir o vertice
     *
     */
    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    /**
     * Método para obter o peso
     *
     */
    public double getWeight() {
        return weight;
    }

     /**
     * Método para atribuir o peso
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Método para obter o ultimo aposento
     */
    public Node<T> getLast_() {
        return last;
    }
    
    /**
     * Método para obter o ultimo nó
     */
    public Node getLast() {
        return last;
    }
    
    
/**
     * Método para comparar os pesos
     * 
     */
    @Override
    public int compareTo(T objToCompare) {
        Node temp = (Node) objToCompare;
        
        if (this.weight < temp.weight) {
            return -1;
        }
        if (this.weight == temp.weight) {
            return 0;
        } 
        
        return 1;
    }

    /**
     * Método para comparar os pesos
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        Node cmpNode = (Node) obj;
        
        return this.vertex == cmpNode.getVertex();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.vertex);
        return hash;
    }

    @Override
    public String toString() {
        return "Node{" + "vertex=" + vertex + ", nextNode=" + nextNode + '}';
    }
    
}
