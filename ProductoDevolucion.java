public class ProductoDevolucion extends Producto {
    private String motivoDevolucion;

    public ProductoDevolucion(String id, String nombre, int cantidad, double precio, String motivoDevolucion) {
        super(id, nombre, cantidad, precio);
        this.motivoDevolucion = motivoDevolucion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    @Override
    public String getDetalles() {
        return "ProductoDevolucion [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", motivoDevolucion=" + motivoDevolucion + "]";
    }
}
