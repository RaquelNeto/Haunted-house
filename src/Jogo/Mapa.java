/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Exceptions.EmptyCollectionException;
import Classes.ArrayUnorderedList;
import Classes.Network;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Classe Mapa
 */
public class Mapa {

    String nome;
    Network<Aposentos> mapa;
    long Score;
    Jogador jogo;

    /**
     * Método construtor
     *
     */
    public Mapa() throws IOException {

        this.mapa = new Network<>();
        //readMapFromJSONFile();
    }

    /**
     * Método construtor
     *
     */
    public Mapa(Jogador jogo) throws IOException {
        this.jogo = jogo;
        this.mapa = new Network<>();
        // readMapFromJSONFile();
    }

    /**
     * Método para obter o jogo
     *
     */
    public Jogador getJogo() {
        return jogo;
    }

    /**
     * Método para atribuir o jogo
     *
     */
    public void setJogo(Jogador jogo) {
        this.jogo = jogo;
    }

    /**
     * Método para obter o Nome
     *
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para obter o mapa
     *
     */
    public Network<Aposentos> getMapa() {
        return mapa;
    }

    /**
     * Método para obter o score
     *
     */
    public long getScore() {
        return Score;
    }

    /**
     * Método responsável por ler os objetos JSON e instanciar cada um deles
     * como ({@link Mapa}) ao mesmo tempo que adiciona cada um ao grafo
     *
     */
    public final void readMapFromJSONFile(String path) throws FileNotFoundException, IOException {
        JSONParser parser = new JSONParser();
        Aposentos aposentos;
        ArrayUnorderedList UnorderedarrayLigacoes;
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            nome = (String) jsonObject.get("nome");
            Score = (long) jsonObject.get("pontos");
            JSONArray mapa1 = (JSONArray) jsonObject.get("mapa");
            String name_ap = null;
            aposentos = new Aposentos("entrada", 0, new ArrayUnorderedList<String>());
            mapa.addVertex(aposentos);

            for (Object objectMapa : mapa1) {
                UnorderedarrayLigacoes = new ArrayUnorderedList<String>();
                JSONObject jsonObjectMapa = (JSONObject) objectMapa;
                name_ap = (String) jsonObjectMapa.get("aposento");
                long fantasma = (long) jsonObjectMapa.get("fantasma");
                JSONArray Ligacoes = (JSONArray) jsonObjectMapa.get("ligacoes");
                for (Object edges : Ligacoes) {
                    UnorderedarrayLigacoes.addToRear(edges);

                }

                aposentos = new Aposentos(name_ap, fantasma, UnorderedarrayLigacoes);

                mapa.addVertex(aposentos);

            }

            aposentos = new Aposentos("exterior", 0, new ArrayUnorderedList<String>());
            mapa.addVertex(aposentos);

        } catch (ParseException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateGraph();
    }

    /**
     * Método responsável por atualizar as ligações do grafo
     *
     */
    public void updateGraph() throws IOException {
        int t = -1;
        for (int i = 0; i < this.mapa.size(); i++) {
            for (int y = 0; y < this.mapa.getAdjacencyList()[i].getHead().getVertex().getLigacoes().size(); y++) {
                t = findAposento(this.mapa.getAdjacencyList()[i].getHead().getVertex().getLigacoes().getElement(y));
                mapa.addEdge(this.mapa.getAdjacencyList()[i].getHead().getVertex(), this.mapa.getAdjacencyList()[t].getHead().getVertex(), this.mapa.getAdjacencyList()[t].getHead().getVertex().getFantasmas());
                mapa.addEdge(this.mapa.getAdjacencyList()[t].getHead().getVertex(), this.mapa.getAdjacencyList()[i].getHead().getVertex(), this.mapa.getAdjacencyList()[i].getHead().getVertex().getFantasmas());

            }
        }
    }

    /**
     * Método para encontrar o aposento
     *
     */
    public int findAposento(String apo) {
        int index = 0;
        boolean encontrou=false;
        for (int i = 0; i < this.mapa.size(); i++) {
            if (this.mapa.getAdjacencyList()[i].getHead().getVertex().getNome_aposento().equals(apo)) {
                index = i;
                encontrou=true;
            }
            
        }
        if(!encontrou){
           index=-1; 
        }
        return index;
    }

    /**
     * Método para imprimir_vertices
     *
     */
    public void imprimir_vertices() throws EmptyCollectionException {

        for (int i = 0; i < mapa.size(); i++) {
            System.out.println(mapa.getAdjacencyList()[i].getHead().getVertex().toString_normal());
        }
       
    }
    
    
    public void clear(){
         int t = -1;
        for (int i = 0; i < this.mapa.size(); i++) {
            for (int y = 0; y < this.mapa.getAdjacencyList()[i].getHead().getVertex().getLigacoes().size(); y++) {
                t = findAposento(this.mapa.getAdjacencyList()[i].getHead().getVertex().getLigacoes().getElement(y));
                mapa.removeEdge(this.mapa.getAdjacencyList()[i].getHead().getVertex(), this.mapa.getAdjacencyList()[t].getHead().getVertex());
                mapa.removeEdge(this.mapa.getAdjacencyList()[t].getHead().getVertex(), this.mapa.getAdjacencyList()[i].getHead().getVertex());

            }
        }
    }
    

}
