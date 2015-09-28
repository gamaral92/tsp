package caixeiroviajante.genetico;

/**
 *
 * @author gabrielamaral
 */
public class Estatisticas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arquivo arquivoGap = new Arquivo("gap.dat");
        Arquivo arquivoDistancia = new Arquivo("distancia.dat");

        Caminho caminho = new Caminho();
        caminho.lerArquivo("gr137.tsp"); //69853

        int quantidadeGap = 0;
        int quantidadeDistancia = 0;

        while (quantidadeGap++ < 300) {
            
            boolean escrever = true;
            if (quantidadeDistancia++ > 20) {
                escrever = false;
            }
            System.out.println("Iteração: " + quantidadeGap);
            Evolucao e = new Evolucao(0.085, 25, caminho);

            Populacao p = new Populacao(100, true, caminho);

            StringBuilder builder = new StringBuilder();
            if (escrever) {
                builder.append(p.getIndividuoMaisApto().getDistancia());
            }

            for (int i = 0; i < 5000; i++) {
                p = e.desenvolverPopulacao(p);
                if (escrever) {
                    builder.append(p.getIndividuoMaisApto().getDistancia()).append(" ");
                }
            }

            if (escrever) {
                arquivoDistancia.escrever(builder.toString());
                arquivoDistancia.quebraLinha();
                arquivoDistancia.salvar();
            }

            String gap = p.getGap(69853.0) + "";
            arquivoGap.escrever(gap);
            arquivoGap.quebraLinha();
            arquivoGap.salvar();
        }
        arquivoGap.fecharRecursos();
        arquivoDistancia.fecharRecursos();
    }

}
