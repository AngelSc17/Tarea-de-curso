public abstract class Producto {
    protected String id;
    protected String nombre;
    protected int cantidad;
    protected double precio;

    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract String getDetalles();

    @Override
    public String toString() {
        return getDetalles();
    }
}


