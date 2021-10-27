/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.NetworkADT;
import Jogo.Node;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe Network que extende Graph e implementa NetworkADT
 */
public class Network<T> extends Graph<T> implements NetworkADT<T> {

    /**
     * Construtor que permite a instanciação da classe com um tamanho por
     * defeito (15)
     */
    public Network() {
        super();
    }

    /**
     * Construtor que permite a instanciação da classe com um determinado
     * tamanho recebido
     *
     */
    public Network(int capacity) {
        super(capacity);
    }

    /**
     * Método responsável por adicionar uma ligação (aresta) entre dois vértices
     * recebidos com um determinado peso também recebido
     *
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        this.adjacencyList[this.getIndex(vertex1)].add(vertex2);

        Node actual = this.adjacencyList[this.getIndex(vertex1)].getHead();
        while (actual.getNextNode() != null) {
            if (actual.getNextNode().getVertex() == vertex2) {
                actual.getNextNode().setWeight(weight);

            }
            actual = actual.getNextNode();
        }

    }

    /**
     * Método responsável por determinar o menor peso entre dois vertices.
     * 
     */
    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        double peso = 0;
        try {
            Iterator<T> it = (Iterator<T>) this.iteratorShortestPath(vertex1, vertex2);
            T origem = it.next(); //primeiro vertice - entrada
            T proximoDestiono = it.next(); // primeira ligacao
            while (it.hasNext()){
                peso += this.getWeight(origem, proximoDestiono);
                origem = proximoDestiono;
                proximoDestiono = it.next();
            }
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peso;
    }
    
   

    public Double getWeight(T vertex1, T vertex2) {
        Double x = 0.0;

        Node actual = this.adjacencyList[this.getIndex(vertex1)].getHead();
        while (actual.getNextNode() != null) {
            if (actual.getNextNode().getVertex() == vertex2) {
                x = actual.getNextNode().getWeight();
            }
            actual = actual.getNextNode();
        }
        return x;
    }

}
