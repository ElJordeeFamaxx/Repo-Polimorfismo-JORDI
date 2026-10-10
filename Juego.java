import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private final Mazo mazo;
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private int jugadorActual = 0;

    public Juego(Mazo mazo) {
        this.mazo = mazo;
    }

    public void agregarJugador(Jugador jugador) {
        if (jugador == null)
            throw new IllegalArgumentException("Jugador nulo");
        jugadores.add(jugador);
    }

    public void iniciarJuego() {
        if (jugadores.isEmpty())
            throw new IllegalStateException("No hay jugadores");
        if (mazo.cantidad() == 0)
            mazo.cargarInicial();
        jugadorActual = 0;
        // Repartir hasta 2 cartas a cada jugador, si hay suficientes.
        for (int vuelta = 0; vuelta < 2; vuelta++)
            for (Jugador j : jugadores)
                j.tomarCarta(mazo.tomarCarta());
    }

    public Mazo getMazo() {
        return mazo;
    }

    public List<Jugador> getJugadores() {
        return Collections.unmodifiableList(jugadores);
    }

    public Jugador getJugadorActual() {
        return jugadores.get(jugadorActual);
    }

    public void siguienteTurno() {
        jugadorActual = (jugadorActual + 1) % jugadores.size();
    }

    public String jugarCarta(int id) {
        Jugador jugador = getJugadorActual();
        Carta carta = jugador.buscarEnMano(id);
        if (carta == null)
            return "La carta no esta en tu mano.";
        if (jugador.getEnergia() < carta.getCostoEnergia())
            return "Energia insuficiente.";
        jugador.modificarEnergia(-carta.getCostoEnergia());
        String resultado = carta.jugarCarta(this, jugador);
        jugador.quitarCarta(carta);
        siguienteTurno();
        return resultado;
    }

    public String tomarCarta() {
        Carta carta = mazo.tomarCarta();
        if (carta == null)
            return "El mazo esta vacio.";
        getJugadorActual().tomarCarta(carta);
        String mensaje = "Tomaste: " + carta.getNombre();
        siguienteTurno();
        return mensaje;
    }

    public String pasarTurno() {
        String nombre = getJugadorActual().getNombre();
        getJugadorActual().pasarTurno();
        siguienteTurno();
        return nombre + " paso su turno.";
    }
}