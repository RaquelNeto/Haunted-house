/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacegrafica;

import Classes.ArrayUnorderedList;
import Exceptions.EmptyCollectionException;
import Jogo.Jogador;
import Jogo.Mapa;
import Jogo.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;


/**
 * ESTG - IPP Engenharia Informática - 2º Ano Estrutura de Dados
 *
 * @author Raquel Neto Nº8160129
 * @author Manuel Lemos Nº8170552
 */
/**
 * Interface Gráfica
 */
public class InterfaceGraph {

    private Mapa mapa;
    private Jogo.Jogador jogo;
    boolean mapa_carregado = false;

    /**
     * Initiates the graphic interface
     *
     */
    public InterfaceGraph() throws IOException, EmptyCollectionException, InterruptedException {
        mapa = new Mapa();

        this.mainMenu();

    }

    /**
     * Main menu of the software
     *
     */
    public void mainMenu() throws IOException, EmptyCollectionException, InterruptedException {

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        int option;
        System.out.println("***************Jogo Casa Assombrada**************");
        System.out.println("*                (1)Adicionar jogador          *");
        System.out.println("*                (2)Carregar mapa              *");
        System.out.println("*                (3)Manual                     *");
        System.out.println("*                (4)Simulação                  *");
        System.out.println("*                (0)Exit                       *");
        System.out.println("************************************************");

        System.out.println("Option: ");
        Scanner scanner = new Scanner(System.in);

        option = scanner.nextInt();

        switch (option) {
            case 1:
                if (mapa_carregado) {
                    System.out.println("Insira o seu nome: ");
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String nome = in.readLine();
                    long score = this.mapa.getScore();
                    this.jogo = new Jogador(nome, score);
                    this.mapa.setJogo(jogo);
                    System.out.println("Começará com 100 pontos!!");
                    this.mainMenu();
                } else {
                    System.out.println("Carregar mapa!!!");

                    this.mainMenu();
                }
                break;
            case 2:
                mapa.readMapFromJSONFile("Mapa/mapa.json");
                this.mapa_carregado = true;
                this.mainMenu();
                break;

            case 3:
                if (mapa_carregado) {
                this.menuManual();
                 } else {
                    System.out.println("Carregar mapa!!!");

                    this.mainMenu();
                }
                break;

            case 4:
            if (mapa_carregado) {
                this.menuSimulacao();
                 } else {
                    System.out.println("Carregar mapa!!!");

                    this.mainMenu();
            }
                break;

            case 0:
                System.exit(0);

            default:
                this.mainMenu();
                break;
        }

    }

    /**
     * Menu para o tipo de jogo Manual
     *
     */
    public void menuManual() throws IOException, EmptyCollectionException, InterruptedException {
        clear();
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************Menu Manual***************");
        System.out.println("*          (1)Básico                   *");
        System.out.println("*          (2)Normal                   *");
        System.out.println("*          (3)Dificil                  *");
        System.out.println("*          (4)Back to Main Menu        *");
        System.out.println("****************************************");

        clear();

        System.out.println("Option: ");
        option = scanner.nextInt();

        switch (option) {
            case 1:

                jogo();
                break;
            case 2:

                for (int i = 0; i < mapa.getMapa().size(); i++) {
                    mapa.getMapa().getAdjacencyList()[i].getHead().getVertex().setFantasmas((mapa.getMapa().getAdjacencyList()[i].getHead().getVertex().getFantasmas()) * 2);
                    mapa.clear();
                    mapa.updateGraph();
                }
                jogo();
                break;

            case 3:
                for (int i = 0; i < mapa.getMapa().size(); i++) {
                    mapa.getMapa().getAdjacencyList()[i].getHead().getVertex().setFantasmas((mapa.getMapa().getAdjacencyList()[i].getHead().getVertex().getFantasmas()) * 3);
                    mapa.clear();
                    mapa.updateGraph();
                }
                jogo();
                break;

            case 4:
                mainMenu();
                break;

            default:
                this.menuManual();
                break;
        }
    }

    /**
     * Menu para o tipo de jogo Simulção
     *
     */
    public void menuSimulacao() throws IOException, EmptyCollectionException {
        int h=this.mapa.findAposento("entrada");
        int p=this.mapa.findAposento("exterior");
        Iterator itr = this.mapa.getMapa().iteratorShortestPath(this.mapa.getMapa().getAdjacencyList()[h].getHead().getVertex(), this.mapa.getMapa().getAdjacencyList()[p].getHead().getVertex());

        while (itr.hasNext()) {
            System.out.println(itr.next().toString());

        }
        System.out.println("Score: " + (this.mapa.getScore() - this.mapa.getMapa().shortestPathWeight(this.mapa.getMapa().getAdjacencyList()[h].getHead().getVertex(), this.mapa.getMapa().getAdjacencyList()[p].getHead().getVertex())));

    }

    /**
     * Insere espaço branco na interface
     */
    private void clear() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public void jogo() throws IOException {

        double score = this.jogo.getPontos();
        ArrayUnorderedList<String> aposentos_utilizador = new ArrayUnorderedList();
        String ap_atual = null;
        int p = this.mapa.findAposento("entrada");
        ap_atual = this.mapa.getMapa().getAdjacencyList()[p].getHead().getVertex().getNome_aposento();
        ArrayUnorderedList<String> arraytemp = new ArrayUnorderedList();

        do {
            System.out.println("Posição atual:" + ap_atual);

            aposentos_utilizador.addToRear(ap_atual);
            int j = this.mapa.findAposento(ap_atual);

            Node temp = this.mapa.getMapa().getAdjacencyList()[j].getHead().getNextNode_();
            int pos = 0;
            if (this.mapa.findAposento("entrada") == j || this.mapa.getMapa().getAdjacencyList()[j].getHead().getVertex().getLigacoes().size() == 0) {
                while (temp != null) {

                    System.out.println(pos + " - " + temp.getVertex().toString());
                    temp = temp.getNextNode_();
                    pos++;
                }
            } else {

                for (int lig = 0; lig < this.mapa.getMapa().getAdjacencyList()[j].getHead().getVertex().getLigacoes().size(); lig++) {
                    System.out.println(this.mapa.getMapa().getAdjacencyList()[j].getHead().getVertex().getLigacoes().getElement(lig));

                }
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Se desejar sair, escrever uma letra,fica com a pontuação a 0, se desistir!!! ");
            System.out.println("Inseira o nome do aposento que deseja ir: ");
            
            String escolha = in.readLine();
            
             int posicao_atual = this.mapa.findAposento(ap_atual);
             
             int posicao_ida = this.mapa.findAposento(escolha);
             
             if(posicao_ida==-1){
                 score=0;
                 this.jogo.setPontos(score);
             }else{
            score = jogo.getPontos() - this.mapa.getMapa().getWeight(this.mapa.getMapa().getAdjacencyList()[posicao_atual].getHead().getVertex(), this.mapa.getMapa().getAdjacencyList()[posicao_ida].getHead().getVertex());
             }
            System.out.println(score);
            this.jogo.setPontos(score);
            ap_atual = escolha;

            if (this.jogo.getPontos() < 0) {
                System.out.println("/////////////////");
                System.out.println("/ Perdeu o jogo /");
                System.out.println("/////////////////\n");
            } else {
                System.out.println("*******************");
                System.out.println("*Score Atual: " + this.jogo.getPontos());
                System.out.println("*******************\n");
            }

        } while (!(ap_atual.equals("exterior")) && this.jogo.getPontos() > 0);
    }

}
