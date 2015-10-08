package caixeiroviajante.genetic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabrielamaral
 */
public class CriarArquivoMedia {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(new File("r/r2/distancia.dat"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        arquivo(bufferedReader);
        valores(bufferedReader);
    }

    private static void arquivo(BufferedReader bufferedReader) throws NumberFormatException, IOException {
        double[][] matriz = new double[20][];

        int linha = 0;
        while (bufferedReader.ready() && linha < 20) {
            String[] strings = bufferedReader.readLine().split(" ");
            matriz[linha] = new double[strings.length - 1];
            for (int coluna = 0; coluna < strings.length - 1; coluna++) {
                matriz[linha][coluna] = Double.parseDouble(strings[coluna]);
            }
            linha++;
        }
        double[] media = new double[matriz[0].length];
        for (int j = 0; j < matriz[0].length; j++) {
            double valor = 0.0;
            for (int i = 0; i < matriz.length; i++) {
                valor += matriz[i][j];
            }
            media[j] = valor / 20.0;
        }

        Arquivo a = new Arquivo("r2/mediadistancia.dat");
        StringBuilder builder = new StringBuilder();
        for (double d : media) {
            builder.append(d).append("\n");
        }
        a.quebraLinha();
        a.escrever(builder.toString());
        a.salvar();
        a.fecharRecursos();

    }

    private static void valores(BufferedReader bufferedReader) throws IOException, NumberFormatException {
        double[] gap = new double[300];
        int indice = 0;
        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            gap[indice++] = Double.parseDouble(string);
        }
        double maiorValor = Double.MIN_VALUE;
        double menorValor = Double.MAX_VALUE;
        for (double g : gap) {
            if (g > maiorValor) {
                maiorValor = g;
            }
            if (g < menorValor) {
                menorValor = g;
            }
        }
        System.out.println("maior valor: " + maiorValor);
        System.out.println("menor valor: " + menorValor);
    }

}
