import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private String nombre;
    private int energia;
    private final ArrayList<Carta> mano = new ArrayList<>();

    public Jugador(String nombre, int energiaInicial) {
        this.nombre = nombre;
        setEnergia(energiaInicial);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, energia);
    }

    public void modificarEnergia(int valor) {
        setEnergia(energia + valor);
    }

    public List<Carta> getMano() {
        return Collections.unmodifiableList(mano);
    }

    public void tomarCarta(Carta carta) {
        if (carta != null)
            mano.add(carta);
    }

    public Carta buscarEnMano(int id) {
        for (Carta carta : mano)
            if (carta.getId() == id)
                return carta;
        return null;
    }

    public void quitarCarta(Carta carta) {
        mano.remove(carta);
    }

    public void pasarTurno() {
        /* El cambio de jugador corresponde a Juego. */ }
}
