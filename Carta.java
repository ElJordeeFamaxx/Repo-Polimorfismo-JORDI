import java.util.Objects;

public abstract class Carta {
    private final int id;
    private String nombre;
    private int costoEnergia;
    private String descripcion;

    public Carta(int id, String nombre, int costoEnergia, String descripcion) {
        if (id <= 0 || costoEnergia < 0)
            throw new IllegalArgumentException("ID o costo invalido");
        this.id = id;
        setNombre(nombre);
        this.costoEnergia = costoEnergia;
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public void setCostoEnergia(int costoEnergia) {
        if (costoEnergia < 0)
            throw new IllegalArgumentException("Costo negativo");
        this.costoEnergia = costoEnergia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    // Polimorfismo: cada tipo implementa su propio efecto.
    public abstract String jugarCarta(Juego juego, Jugador jugador);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id =" + id + ", nombre =" + nombre
                + ", costo =" + costoEnergia + ", descripcion =" + descripcion + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Carta))
            return false;
        return id == ((Carta) obj).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}