import java.util.ArrayList;
import java.io.*;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void actualizarCantidadProducto(String id, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.setCantidad(cantidad);
                return;
            }
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public void guardarEnArchivo(String nombreArchivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Producto producto : productos) {
                escritor.write(producto.getClass().getSimpleName() + "," + producto.getId() + "," + producto.getNombre() + "," + producto.getCantidad() + "," + producto.getPrecio());
                if (producto instanceof ProductoDevolucion) {
                    escritor.write("," + ((ProductoDevolucion) producto).getMotivoDevolucion());
                }
                escritor.newLine();
            }
        }
    }

    public void cargarDesdeArchivo(String nombreArchivo) throws IOException {
        productos.clear();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    if (partes[0].equals("ProductoNormal")) {
                        productos.add(new ProductoNormal(partes[1], partes[2], Integer.parseInt(partes[3]), Double.parseDouble(partes[4])));
                    } else if (partes[0].equals("ProductoDevolucion")) {
                        productos.add(new ProductoDevolucion(partes[1], partes[2], Integer.parseInt(partes[3]), Double.parseDouble(partes[4]), partes[5]));
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Inventario [productos=" + productos + "]";
    }
}
