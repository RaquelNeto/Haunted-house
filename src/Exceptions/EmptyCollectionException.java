/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Excepção EmptyCollectionException
 */
public class EmptyCollectionException extends Exception {

    public EmptyCollectionException() {
        super();
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
