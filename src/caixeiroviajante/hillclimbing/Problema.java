package caixeiroviajante.hillclimbing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author gabrielamaral
 */
public class Problema {

    private int[][] matriz;
    private int[] tour;
    private int quantidadeDeCidades;
    private int cidadeAleatoria1;
    private int cidadeAleatoria2;

    public boolean readFile(String nomeArquivo) {
        try {
            FileReader fileReader = new FileReader(new File(nomeArquivo));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                quantidadeDeCidades = Integer.parseInt(parametros[0]);
            }

            matriz = new int[quantidadeDeCidades][quantidadeDeCidades];
            tour = new int[quantidadeDeCidades];

            int i = 0;
            while (bufferedReader.ready()) {
                String linha = bufferedReader.readLine();
                String[] parametros = linha.split(" ");
                for (int j = quantidadeDeCidades - 1, pos = parametros.length - 1; j > quantidadeDeCidades - parametros.length - 1; j--, pos--) {
                    matriz[i][j] = Integer.parseInt(parametros[pos]);
                    matriz[j][i] = matriz[i][j];
                }
                i++;
            }

            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Arquivo " + nomeArquivo + " não encontrado.");
            return false;
        }
    }

    public void hillClimbing() {
        int iteracoes = 0;
        int valor = Integer.MAX_VALUE;
        while (valor > 26000) {
            solucaoInicial();
            int cont = 0;
            while (cont < 50000) {
                valor = funcaoObjetivo();
                swap();
                int novoValor = funcaoObjetivo();
                if (novoValor > valor) {
                    volta();
                }
                cont++;
            }
            iteracoes++;
        }
        System.out.println(funcaoObjetivo());
        mostrarTour();
    }

    private void solucaoInicial() {
        for (int i = 0; i < quantidadeDeCidades; i++) {
            tour[i] = i;
        }
    }

    private int funcaoObjetivo() {
        int funcaoObjetivo = 0;
        int cidadeInicial = 0;
        for (int proximaCidade = 1; proximaCidade < quantidadeDeCidades; proximaCidade++) {
            funcaoObjetivo += matriz[tour[cidadeInicial]][tour[proximaCidade]];
            cidadeInicial = proximaCidade;
        }
        funcaoObjetivo += matriz[tour[quantidadeDeCidades - 1]][tour[0]];
        return funcaoObjetivo;
    }

    private void swap() {
        Random random = new Random();
        cidadeAleatoria1 = random.nextInt(quantidadeDeCidades);
        cidadeAleatoria2 = random.nextInt(quantidadeDeCidades);
        while (cidadeAleatoria1 == cidadeAleatoria2) {
            cidadeAleatoria2 = random.nextInt(quantidadeDeCidades);
        }

        volta();
    }

    private void volta() {
        int aux = tour[cidadeAleatoria1];
        tour[cidadeAleatoria1] = tour[cidadeAleatoria2];
        tour[cidadeAleatoria2] = aux;
    }

    private void mostrarTour() {
        for (int i = 0; i < quantidadeDeCidades; i++) {
            System.out.print(tour[i] + "\t");
        }
        System.out.println("");
    }

}
