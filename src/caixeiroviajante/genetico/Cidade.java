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

    public double distanciaEUCAte(Cidade cidade) {
        double xDistancia = Math.abs(getX() - cidade.getX());
        double yDistancia = Math.abs(getY() - cidade.getY());
        double distancia = Math.sqrt((xDistancia * xDistancia) + (yDistancia * yDistancia));
        return distancia;
    }

    public double distanciaGEOAte(Cidade cidade) {
        //converting coordinate input to longitude and latitude in radian:
        double deg = Math.floor(getX());
        double min = getX() - deg;
        double latitudeI = Math.PI * (deg + 5.0 * min / 3.0) / 180.0;

        deg = Math.floor(getY());
        min = getY() - deg;
        double longitudeI = Math.PI * (deg + 5.0 * min / 3.0) / 180.0;

        deg = Math.floor(cidade.getX());
        min = cidade.getX() - deg;
        double latitudeJ = Math.PI * (deg + 5.0 * min / 3.0) / 180.0;

        deg = Math.floor(cidade.getY());
        min = cidade.getY() - deg;
        double longitudeJ = Math.PI * (deg + 5.0 * min / 3.0) / 180.0;

        //For computing the geographical distance:
        double RRR = 6378.388;
        double q1 = Math.cos(longitudeI - longitudeJ);
        double q2 = Math.cos(latitudeI - latitudeJ);
        double q3 = Math.cos(latitudeI + latitudeJ);

        double distancia = (int)(RRR * Math.acos(0.5 * ((1.0 + q1) * q2 - (1.0 - q1) * q3)) + 1.0);
        return distancia;
    }

    @Override
    public String toString() {
        return getId() + "";
    }
}
