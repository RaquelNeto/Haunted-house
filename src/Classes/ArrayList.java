/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.ListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe ArrayList que implementa o ListADT
 */
public class ArrayList<T> implements ListADT<T> {

    /**
     * Constante para representar a capacidade default do ArrayList
     */
    private final int DEFAULT_CAPACITY = 15;

    /**
     * Array de elementos genéricos para representar o ArrayList
     */
    private T[] arrayList;
    /**
     * int que representa a próxima posição disponível no ArrayList
     */
    private int rear;

    /**
     * int que representa um contador
     */
    protected int modCount = 0;

    /**
     * Cria uma lista vazia usando a capacidade padrão(default).
     */
    public ArrayList() {
        this.arrayList = (T[]) new Object[DEFAULT_CAPACITY];
        this.rear = 0;

    }

    /**
     * Cria uma lista vazia usando a capacidade especificada
     *
     */
    public ArrayList(int capacity) {
        this.arrayList = (T[]) new Object[capacity];
        this.rear = 0;
    }

    /**
     * Classe que representa um Iterador
     */
    private class BasicIterator<T> implements Iterator<T> {

        private int current;
        private int expectedModCount;
        private boolean okToRemove;

        public BasicIterator() {
            current = 0;
            expectedModCount = modCount;
            okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (isEmpty()) {
                throw new IllegalStateException("Empty list!");
            }

            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException("No more elements!");
            }

            okToRemove = true;
            current++;

            return (T) arrayList[current - 1];
        }
    }

    /**
     * Retorna um iterador para os elementos nesta lista.
     */
    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }

    public T[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(T[] arrayList) {
        this.arrayList = arrayList;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    /**
     * Remove e retorna o primeiro elemento desta lista.
     *
     */
    @Override
    public T removeFirst() {
        T temp = this.first();
        this.arrayList[0] = null;

        this.rearrangeArray(0);
        this.rear--;

        return temp;
    }

    /**
     * Remove e retorna o último elemento desta lista.
     *
     */
    @Override
    public T removeLast() {
        T temp = this.last();
        this.arrayList[this.rear - 1] = null;

        this.rear--;

        return temp;
    }

    /**
     * Remove e retorna o elemento especificado dessa lista.
     *
     */
    @Override
    public T remove(T element) {

        //fazer com iterator
        for (int i = 0; i < this.rear; i++) {
            if (this.arrayList[i].equals(element)) {
                T temp = this.arrayList[i];
                this.arrayList[i] = null;
                this.rearrangeArray(i);
                this.rear--;

                return temp;
            }
        }
        System.out.println("Element not found");
        return null;
    }

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     *
     */

    @Override
    public T first() {
        return this.arrayList[0];
    }

    /**
     * Retorna uma referência ao último elemento nesta lista.
     *
     */
    @Override
    public T last() {
        return this.arrayList[this.rear - 1];
    }

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     *
     */
    @Override
    public boolean contains(T target) {
        for (T o : this.arrayList) {
            if (target.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retornará true se esta lista não contiver elementos.
     *
     */
    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }

    /**
     * Retorna o número de elementos nesta lista.
     *
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Cria novas matrizes para armazenar o conteúdo do grafo com o dobro da
     * capacidade.
     */
    public void expandCapacity() {

        ArrayList expandedArrayList = new ArrayList<>(this.arrayList.length * 2);
        System.arraycopy(this.arrayList, 0, expandedArrayList.getArrayList(), 0, this.arrayList.length);

        this.arrayList = (T[]) expandedArrayList.getArrayList();
    }

    /**
     * Método para obter o elemento
     *
     */
    public T getElement(int i) throws NoSuchElementException {
        return this.arrayList[i];
    }

    /**
     * Método para rearranjar o Array
     *
     */
    public void rearrangeArray(int position) {

        for (int i = this.rear; i >= position; i--) {
            this.arrayList[i] = this.arrayList[i - 1];
        }
        this.rear++;
    }

    /**
     * Método toString
     *
     */
    @Override
    public String toString() {
        String ola = null;
        for (int i = 0; i < size(); i++) {

            ola = "ArrayList{" + "arrayList=" + arrayList[i] + '}';
        }
        return ola;
    }

}
