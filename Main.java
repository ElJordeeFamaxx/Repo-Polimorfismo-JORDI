public class Main {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        Juego juego = new Juego(mazo);
        juego.agregarJugador(new Jugador("Jugador 1", 10));
        juego.agregarJugador(new Jugador("Jugador 2", 10));
        JuegoView vista = new JuegoView();
        JuegoController controller = new JuegoController(juego, vista);
        controller.iniciar();
    }
}