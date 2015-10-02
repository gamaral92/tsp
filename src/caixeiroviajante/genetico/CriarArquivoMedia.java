package caixeiroviajante.genetico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author gabrielamaral
 */
public class CriarArquivoMedia {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(new File("r/distancia.dat"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        double[][] matriz = new double[21][];
        int linha = 0;
        while (bufferedReader.ready()) {
            String[] string = bufferedReader.readLine().split(" ");
            matriz[linha] = new double[string.length];
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = Double.parseDouble(string[coluna]);
            }
            linha++;
        }
        double[] media = new double[matriz[0].length];
        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            double valor = 0.0;
            for (linha = 0; linha < matriz.length; linha++) {
                valor += matriz[linha][coluna];
            }
            media[coluna] = valor;
        }
        Arquivo arquivo = new Arquivo("mediadistancia.dat");
        for (double m : media) {
            arquivo.escrever(m + " ");
        }
        arquivo.salvar();
        arquivo.fecharRecursos();
    }

}
