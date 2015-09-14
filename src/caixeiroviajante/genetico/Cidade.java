package caixeiroviajante.genetico;

/**
 *
 * @author gabrielamaral
 */
public class Cidade {

    private final int id;
    private final double x;
    private final double y;

    public Cidade(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanciaAte(Cidade cidade) {
        double xDistancia = Math.abs(getX() - cidade.getX());
        double yDistancia = Math.abs(getY() - cidade.getY());
        double distancia = Math.sqrt((xDistancia * xDistancia) + (yDistancia * yDistancia));
        return distancia;
    }

    @Override
    public String toString() {
        return getId() + "";
    }
}
