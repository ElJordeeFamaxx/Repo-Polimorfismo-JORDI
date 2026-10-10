public class Curso extends Carta {
    private int creditos;
    private int dificultad;

    public Curso(int id, String nombre, int costo, String descripcion, int creditos, int dificultad) {
        super(id, nombre, costo, descripcion);
        this.creditos = creditos;
        this.dificultad = dificultad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String jugarCarta(Juego juego, Jugador jugador) {
        int bono = Math.max(0, creditos - dificultad);
        jugador.modificarEnergia(bono);
        return "Curso aprobado: recuperas " + bono + " puntos de energia.";
    }

    @Override
    public String toString() {
        return super.toString() + " [creditos =" + creditos + ", dificultad =" + dificultad + "]";
    }
}
