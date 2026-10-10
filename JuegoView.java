import java.util.List;
import java.util.Scanner;

public class JuegoView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n------------- UVG GUERRA DE CARTAS -------------------");
        System.out.println("1. Listar mazo");
        System.out.println("2. Buscar carta por ID");
        System.out.println("3. Buscar carta por nombre");
        System.out.println("4. Ordenar mazo por energia");
        System.out.println("5. Ver estado y mano");
        System.out.println("6. Jugar carta de la mano");
        System.out.println("7. Tomar carta");
        System.out.println("8. Pasar turno");
        System.out.println("0. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                mostrarMensaje("Ingresa un numero valido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void mostrarCarta(Carta carta) {
        System.out.println(carta == null ? "No se encontro la carta." : carta);
    }

    public void mostrarCartas(List<Carta> cartas) {
        if (cartas.isEmpty()) {
            mostrarMensaje("No hay cartas.");
            return;
        }
        for (Carta carta : cartas)
            mostrarCarta(carta);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstado(Jugador jugador) {
        System.out.println("Turno: " + jugador.getNombre() + " | Energia: " + jugador.getEnergia());
        System.out.println("Cartas en mano:");
        mostrarCartas(jugador.getMano());
    }
}
