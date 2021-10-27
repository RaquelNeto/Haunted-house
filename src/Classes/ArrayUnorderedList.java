package Classes;

import Interfaces.UnorderedListADT;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe ArrayUnorderedList
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Cria uma lista vazia usando a capacidade padrão.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Cria uma lista vazia usando o tamanho especificado.
     *
     */
    public ArrayUnorderedList(int capacity) {
        super(capacity);
    }

    /**
     * Adiciona o elemento especificado à frente da lista.
     *
     */
    @Override
    public void addToFront(T newElement) {
        if (this.getArrayList().length == this.size()) {
            expandCapacity();
        }
        for (int i = getRear() - 1; i > 0; i--) {
            getArrayList()[i] = getArrayList()[i - 1];
        }
        getArrayList()[0] = newElement;
    }

    /**
     * Adiciona o elemento especificado na parte traseira da lista.
     *
     */
    @Override
    public void addToRear(T newElement) {
        if (this.getArrayList().length == this.size()) {
            expandCapacity();
        }
        getArrayList()[getRear()] = newElement;
        setRear(getRear() + 1);
    }

    /**
     * Adiciona o elemento especificado após o elemento de destino especificado.
     * Lança uma ElementNotFoundException se o destino não for encontrado.
     *
     */
    @Override
    public void addAfter(T newElement, T target) {
        if (this.getArrayList().length == this.size()) {
            expandCapacity();
        }
        int pos = 0;

        for (int i = 0; i < getRear() - 1; i++) {
            if (getArrayList()[i] == target) {
                pos = i;
            }
        }
        rearrangeArray(pos);
        getArrayList()[pos] = newElement;
    }

}
