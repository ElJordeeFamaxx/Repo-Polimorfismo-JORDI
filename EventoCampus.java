public class EventoCampus extends Carta {
    private String efecto;
    private int energia;

    public EventoCampus(int id, String nombre, int costo, String descripcion, String efecto, int energia) {
        super(id, nombre, costo, descripcion);
        this.efecto = efecto;
        this.energia = energia;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String jugarCarta(Juego juego, Jugador jugador) {
        jugador.modificarEnergia(energia);
        return "Evento " + efecto + ": cambio de energia " + energia + ".";
    }

    @Override
    public String toString() {
        return super.toString() + " [efecto =" + efecto + ", energia =" + energia + "]";
    }
}
