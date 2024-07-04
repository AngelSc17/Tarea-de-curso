public class ProductoNormal extends Producto {

    public ProductoNormal(String id, String nombre, int cantidad, double precio) {
        super(id, nombre, cantidad, precio);
    }

    @Override
    public String getDetalles() {
        return "ProductoNormal [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
