public class Catedratico extends Carta {
    private String departamento;
    private int llamadasAtencion;
    private int tiempoAtencion;

    public Catedratico(int id, String nombre, int costo, String descripcion,
            String departamento, int llamadasAtencion, int tiempoAtencion) {
        super(id, nombre, costo, descripcion);
        this.departamento = departamento;
        this.llamadasAtencion = llamadasAtencion;
        this.tiempoAtencion = tiempoAtencion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getLlamadasAtencion() {
        return llamadasAtencion;
    }

    public void setLlamadasAtencion(int llamadasAtencion) {
        this.llamadasAtencion = llamadasAtencion;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    @Override
    public String jugarCarta(Juego juego, Jugador jugador) {
        int bono = Math.max(0, tiempoAtencion - llamadasAtencion);
        jugador.modificarEnergia(bono);
        return "Catedratico: recuperas " + bono + " puntos de energia.";
    }

    @Override
    public String toString() {
        return super.toString() + " [departamento =" + departamento + ", llamadasAtencion ="
                + llamadasAtencion + ", tiempoAtencion =" + tiempoAtencion + "]";
    }
}