import java.io.IOException;
import java.util.Scanner;

public class App {
    private static Inventario inventario = new Inventario();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarInventario();

        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    actualizarCantidadProducto();
                    break;
                case 3:
                    verInventario();
                    break;
                case 4:
                    guardarInventario();
                    break;   
                case 5:
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("1. Agregar producto");
        System.out.println("2. Actualizar cantidad de producto");
        System.out.println("3. Ver inventario");
        System.out.println("4. Guardar inventario");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarProducto() {
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1. Producto Normal");
        System.out.println("2. Producto Devolución");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 

        if (tipo == 1) {
            Producto producto = new ProductoNormal(id, nombre, cantidad, precio);
            inventario.agregarProducto(producto);
        } else if (tipo == 2) {
            System.out.print("Ingrese motivo de devolución: ");
            String motivoDevolucion = scanner.nextLine();
            Producto producto = new ProductoDevolucion(id, nombre, cantidad, precio, motivoDevolucion);
            inventario.agregarProducto(producto);
        } else {
            System.out.println("Tipo de producto no válido.");
        }
    }

    private static void actualizarCantidadProducto() {
        System.out.print("Ingrese ID del producto a actualizar: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nueva cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  

        inventario.actualizarCantidadProducto(id, cantidad);
    }

    private static void verInventario() {
        System.out.println(inventario);
    }

    private static void guardarInventario() {
        try {
            inventario.guardarEnArchivo("inventario.txt");
            System.out.println("Inventario guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error guardando el inventario: " + e.getMessage());
        }
    }

    private static void cargarInventario() {
        try {
            inventario.cargarDesdeArchivo("inventario.txt");
            System.out.println("Inventario cargado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error cargando el inventario: " + e.getMessage());
        }
    }
}
