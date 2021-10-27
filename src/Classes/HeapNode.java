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
 * Classe HeapNode que extende BinaryTreeNode
 *
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    protected HeapNode<T> parent;

    /**
     * Cria um heap node com dados especificos.
     *
     */
    public HeapNode(T obj) {
        super(obj);
        this.parent = null;
    }
}
