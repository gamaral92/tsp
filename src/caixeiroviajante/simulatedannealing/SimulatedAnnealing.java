package caixeiroviajante.simulatedannealing;

import caixeiroviajante.Caminho;
import caixeiroviajante.Cidade;
import caixeiroviajante.Individuo;

/**
 *
 * @author a11030
 */
public class SimulatedAnnealing {

    private double temperatura;
    private final double taxaEsfriamento;
    private Individuo individuoAtual;
    private Individuo melhorIndividuo;

    public SimulatedAnnealing(double temperatura, double taxaEsfriamento, Caminho caminho) {
        this.temperatura = temperatura;
        this.taxaEsfriamento = taxaEsfriamento;
        this.individuoAtual = new Individuo(caminho.getNumeroDeCidades());
        this.individuoAtual.gerarIndividuo(caminho);
        this.melhorIndividuo = new Individuo(this.individuoAtual.getRota());
    }

    public Individuo getMelhorIndividuo() {
        return melhorIndividuo;
    }

    private double probabilidadeAceitacao(double energia, double novaEnergia, double temperatura) {
        if (novaEnergia < energia) {
            return 1.0;
        }
        return Math.exp((energia - novaEnergia) / temperatura);
    }

    public void resfriar() {
        while (temperatura > 1.0) {

            Individuo novoIndividuo = new Individuo(this.individuoAtual.getRota());

            swap(novoIndividuo);

            double energiaAtual = individuoAtual.getDistancia();
            double energiaVizinho = novoIndividuo.getDistancia();

            if (probabilidadeAceitacao(energiaAtual, energiaVizinho, temperatura) > Math.random()) {
                individuoAtual = new Individuo(novoIndividuo.getRota());
            }

            if (individuoAtual.getDistancia() < melhorIndividuo.getDistancia()) {
                melhorIndividuo = new Individuo(individuoAtual.getRota());
            }

            temperatura *= 1.0 - taxaEsfriamento;

        }
    }

    private void swap(Individuo individuo) {
        int indiceOrigem = (int) (individuo.tamanhoDaRota() * Math.random());
        int indiceDestino = (int) (individuo.tamanhoDaRota() * Math.random());

        Cidade cidade1 = individuo.getCidade(indiceOrigem);
        Cidade cidade2 = individuo.getCidade(indiceDestino);

        individuo.setCidade(indiceOrigem, cidade2);
        individuo.setCidade(indiceDestino, cidade1);
    }
    
    public double getGap(double valor) {
        return (1.0 - (valor / (melhorIndividuo.getDistancia())));
    }

}
