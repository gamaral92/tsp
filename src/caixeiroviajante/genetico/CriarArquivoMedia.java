package caixeiroviajante.genetico;

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

        FileReader fileReader = new FileReader(new File("r/gap.dat"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
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
