public class JuegoController {
    private final Juego juego;
    private final JuegoView vista;

    public JuegoController(Juego juego, JuegoView vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void iniciar() {
        juego.iniciarJuego();
        boolean activo = true;
        while (activo) {
            vista.mostrarMensaje("\nJugador actual: " + juego.getJugadorActual().getNombre());
            vista.mostrarMenu();
            int opcion = vista.leerEntero("Opcion: ");
            switch (opcion) {
                case 1:
                    listarCartas();
                    break;
                case 2:
                    buscarCarta(vista.leerEntero("ID: "));
                    break;
                case 3:
                    buscarCarta(vista.leerTexto("Nombre exacto: "));
                    break;
                case 4:
                    ordenarMazo();
                    break;
                case 5:
                    vista.mostrarEstado(juego.getJugadorActual());
                    break;
                case 6:
                    jugarCarta(vista.leerEntero("ID de carta en mano: "));
                    break;
                case 7:
                    tomarCarta();
                    break;
                case 8:
                    pasarTurno();
                    break;
                case 0:
                    activo = false;
                    break;
                default:
                    vista.mostrarMensaje("Opcion invalida.");
            }
        }
        vista.mostrarMensaje("Gracias por jugar.");
    }

    public void listarCartas() {
        vista.mostrarCartas(juego.getMazo().getCartas());
    }

    public void buscarCarta(int id) {
        vista.mostrarCarta(juego.getMazo().buscarCarta(id));
    }

    public void buscarCarta(String nombre) {
        vista.mostrarCarta(juego.getMazo().buscarCarta(nombre));
    }

    public void ordenarMazo() {
        juego.getMazo().ordenarPorEnergia();
        vista.mostrarMensaje("Mazo ordenado de menor a mayor costo.");
        listarCartas();
    }

    public void jugarCarta(int id) {
        vista.mostrarMensaje(juego.jugarCarta(id));
    }

    public void tomarCarta() {
        vista.mostrarMensaje(juego.tomarCarta());
    }

    public void pasarTurno() {
        vista.mostrarMensaje(juego.pasarTurno());
    }
}
