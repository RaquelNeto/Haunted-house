/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Exceptions.EmptyCollectionException;
import Interfaces.GraphADT;
import Jogo.Node;
import java.util.Iterator;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * O grafo representa uma implementação de lista com uma matriz de adjacência de
 * um grafo.
 *
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 15;
    protected int numVertices;
    protected LinkedList<T> adjacencyList[];

    /**
     * Construtor que permite a instanciação da classe com um tamanho por
     * defeito (15)
     */
    public Graph() {
        this.numVertices = 0;
        this.adjacencyList = new LinkedList[DEFAULT_CAPACITY];

        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

    }

    /**
     * Construtor que permite a instanciação da classe com um determinado
     * tamanho recebido
     *
     */
    public Graph(int capacity) {
        this.numVertices = 0;
        this.adjacencyList = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

    }

    /**
     * Método para obter a adjacencyList
     *
     */
    public LinkedList<T>[] getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Método para atribuir a adjacencyList
     *
     */
    public void setAdjacencyList(LinkedList<T>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    /**
     * Adiciona um vértice ao gráfico, expandindo a capacidade do gráfico se
     * necessário. Também associa um objeto ao vértice.
     *
     */
    @Override
    public void addVertex(T vertex) {

        if (this.numVertices == this.DEFAULT_CAPACITY) {
            expandCapacity();
        }

        if (getIndex(vertex) == -1) {
            Node<T> newNode = new Node<>(vertex);

            for (LinkedList temp : this.adjacencyList) {
                if (temp.getHead() == null) {
                    temp.setHead(newNode);
                    break;
                }
            }

            this.numVertices++;

        } else {
            System.out.println("Já existe!!");
        }

    }

    
    /**
     *
     * Remove um único vértice com o valor fornecido do gráfico.
     *
     */
    @Override
    public void removeVertex(T vertex) {

        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjacencyList[i].getHead().getVertex() == vertex) {
                for (int j = i; j < this.numVertices - 1; j++) {
                    this.adjacencyList[j] = this.adjacencyList[j + 1];
                }

                updateAdjacencyList(vertex);

            }
        }

    }

    /**
     * Método que faz um update a adjacencyList
     *
     */
    private void updateAdjacencyList(T vertex) {

        for (int i = 0; i < this.numVertices; i++) {
            this.adjacencyList[i].remove(vertex);
        }
        this.adjacencyList[this.numVertices] = null;
        this.numVertices--;
    }

     /**
     * Insere uma aresta entre dois vértices do gráfico.
     *
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        if (!vertex1.equals(vertex2)) {
            this.adjacencyList[this.getIndex(vertex1)].add(vertex2);
            this.adjacencyList[this.getIndex(vertex2)].add(vertex1);
        }
    }

    /**
     * Remove uma aresta entre dois vértices do gráfico.
     *
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjacencyList[i].getHead().getVertex() == vertex1) {
                this.adjacencyList[i].remove(vertex2);
            }
        }
        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjacencyList[i].getHead().getVertex() == vertex2) {
                this.adjacencyList[i].remove(vertex1);
            }
        }
    }

     /**
     * Retorna um iterador que executa uma primeira travessia de pesquisa de
     * largura começando no índice fornecido.
     *
     */
    @Override
    public Iterator iteratorBFS(T startVertex) throws EmptyCollectionException {
        boolean visited[] = new boolean[this.numVertices];
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        LinkedQueue<T> tempQueue = new LinkedQueue();

        if (!indexIsValid(getIndex(startVertex))) {
            return tempList.iterator();
        }

        visited[getIndex(startVertex)] = true;
        tempQueue.enqueue(startVertex);

        while (!tempQueue.isEmpty()) {
            T visitedVertex = tempQueue.dequeue();
            tempList.addToRear(visitedVertex);

            int i = getIndex(visitedVertex);
            Node actual = this.adjacencyList[i].getHead();

            while (actual.getNextNode() != null) {
                if (!visited[getIndex((T) actual.getNextNode().getVertex())]) {
                    tempQueue.enqueue((T) actual.getNextNode().getVertex());
                    visited[getIndex((T) actual.getNextNode().getVertex())] = true;
                }
                actual = actual.getNextNode();
            }
        }

        return tempList.iterator();
    }

    /**
     * Retorna um iterador que executa uma primeira busca em profundidade pela
     * primeira partida no vertice fornecido.
     *
     */
    @Override
    public Iterator iteratorDFS(T startVertex) {

        boolean visited[] = new boolean[this.numVertices];
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>(this.numVertices);
        LinkedStack<T> tempStack = new LinkedStack<>();

        if (!indexIsValid(getIndex(startVertex))) {
            return tempList.iterator();
        }
        tempList.addToRear(startVertex);
        tempStack.push(startVertex);
        depthFirstSearch(tempList, tempStack, visited);

        return tempList.iterator();
    }

    /**
     * Método para pesquisar no DFS
     *
     */
    private void depthFirstSearch(ArrayUnorderedList<T> tempList, LinkedStack<T> tempStack, boolean visited[]) {

        if (!tempStack.isEmpty()) {
            T vertexToVisit = tempStack.peek();
            visited[this.getIndex(vertexToVisit)] = true;

            Node actual = this.adjacencyList[this.getIndex(vertexToVisit)].getHead();
            while (actual.getNextNode() != null) {
                if (!visited[getIndex((T) actual.getNextNode().getVertex())]) {
                    tempStack.push((T) actual.getNextNode().getVertex());
                    tempList.addToRear((T) actual.getNextNode().getVertex());
                    depthFirstSearch(tempList, tempStack, visited);
                }
                actual = actual.getNextNode();
            }
            tempStack.pop();
        }
    }

    /**
     * Retorna um iterador que contém o caminho mais curto entre os dois
     * vértices.
     *
     */
    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) throws EmptyCollectionException {
        boolean visited[] = new boolean[this.numVertices];
        int pred[] = new int[this.numVertices];
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        LinkedQueue<T> tempQueue = new LinkedQueue();
        LinkedStack<T> tempStack = new LinkedStack<>();

        if (!indexIsValid(getIndex(startVertex))) {
            return tempList.iterator();
        }

        for (int i = 0; i < pred.length; i++) {
            pred[i] = -1;
        }

        visited[getIndex(startVertex)] = true;
        tempQueue.enqueue(startVertex);

        while (!tempQueue.isEmpty()) {
            T visitedVertex = tempQueue.dequeue();

            if (visitedVertex == targetVertex) {
                break;
            }

            int i = getIndex(visitedVertex);
            Node actual = this.adjacencyList[i].getHead();

            while (actual.getNextNode() != null) {
                if (!visited[getIndex((T) actual.getNextNode().getVertex())]) {
                    tempQueue.enqueue((T) actual.getNextNode().getVertex());
                    visited[getIndex((T) actual.getNextNode().getVertex())] = true;
                    pred[getIndex((T) actual.getNextNode().getVertex())] = i;
                }
                actual = actual.getNextNode();
            }
        }

        int index = getIndex(targetVertex);
        while (index != -1) {
            tempStack.push(this.adjacencyList[index].getHead().getVertex());
            index = pred[index];
        }

        while (!tempStack.isEmpty()) {
            tempList.addToRear(tempStack.pop());
        }

        return tempList.iterator();
    }

    /**
     * Retorna verdadeiro se o grafo estiver vazio e falso caso contrário.
     *
     */
    @Override
    public boolean isEmpty() {
        return this.adjacencyList[0].getHead() == null;
    }

     /**
     * Retorna true se o grafo estiver conectado e false em caso contrário
     *
     */
    @Override
    public boolean isConnected() throws EmptyCollectionException {
        if (isEmpty()) {
            return false;
        }

        for (int i = 0; i < this.numVertices; i++) {
            Iterator<T> iterator = iteratorBFS(this.adjacencyList[i].getHead().getVertex());
            int count = 0;

            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            if (count != this.numVertices) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna o número de vértices no grafo.
     *
     */
    @Override
    public int size() {
        return this.numVertices;
    }

    /**
     * Retorna o valor do índice da primeira ocorrência do vértice. Retorna -1
     * se a chave não for encontrada.
     *
     */
    public int getIndex(T vertex) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.adjacencyList[i].getHead().getVertex() == vertex) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna true se o índice fornecido for válido.
     *
     */
    public boolean indexIsValid(int index) {
        return index < this.numVertices && index >= 0;
    }

     /**
     * Cria novas matrizes para armazenar o conteúdo do gráfico com o dobro da
     * capacidade.
     */
    private void expandCapacity() {
        Graph<T> expandedNetwork = new Graph<>(DEFAULT_CAPACITY + 15);

        System.arraycopy(this.adjacencyList, 0, expandedNetwork.adjacencyList, 0, this.numVertices);
        this.adjacencyList = expandedNetwork.adjacencyList;
    }

}
