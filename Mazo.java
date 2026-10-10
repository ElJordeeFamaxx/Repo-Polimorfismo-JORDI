import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Mazo {
    // Unica lista de polimorfismo para catalogar mazo.
    private final ArrayList<Carta> cartas = new ArrayList<>();

    public void agregarCarta(Carta carta) {
        if (carta == null || buscarCarta(carta.getId()) != null)
            throw new IllegalArgumentException("Carta nula o ID repetido");
        cartas.add(carta);
    }

    // Overloading: buscar por ID o por nombre.
    public Carta buscarCarta(int id) {
        for (Carta carta : cartas)
            if (carta.getId() == id)
                return carta;
        return null;
    }

    public Carta buscarCarta(String nombre) {
        for (Carta carta : cartas)
            if (carta.getNombre().equalsIgnoreCase(nombre.trim()))
                return carta;
        return null;
    }

    public void ordenarPorEnergia() {
        cartas.sort(Comparator.comparingInt(Carta::getCostoEnergia));
    }

    public List<Carta> getCartas() {
        return Collections.unmodifiableList(cartas);
    }

    public Carta tomarCarta() {
        if (cartas.isEmpty())
            return null;
        return cartas.remove(0);
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }

    public int cantidad() {
        return cartas.size();
    }

    public void cargarInicial() {
        Random r = new Random();
        for (int i = 1; i <= 12; i++) {
            int costo = r.nextInt(4) + 1;
            switch (r.nextInt(3)) {
                case 0:
                    agregarCarta(new Catedratico(i, "Catedratico " + i, costo,
                            "Asesoria academica", "Computacion", r.nextInt(3), r.nextInt(5) + 1));
                    break;
                case 1:
                    agregarCarta(new Curso(i, "Curso " + i, costo,
                            "Materia universitaria", r.nextInt(5) + 1, r.nextInt(4) + 1));
                    break;
                default:
                    int cambio = r.nextInt(7) - 3;
                    agregarCarta(new EventoCampus(i, "Evento " + i, costo,
                            "Actividad del campus", "Cambio de energia", cambio));
            }
        }
        mezclar();
    }
}
