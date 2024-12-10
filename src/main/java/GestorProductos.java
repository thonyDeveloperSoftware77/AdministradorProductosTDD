import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String nombre, double precio) {
        if (nombre == null || nombre.isEmpty() || precio <= 0) {
            throw new IllegalArgumentException("Nombre no puede ser vacío y el precio debe ser mayor a 0.");
        }
        productos.add(new Producto(nombre, precio));
    }

    // Método modificado para devolver una lista inmutable
    public List<Producto> obtenerProductos() {
        return Collections.unmodifiableList(new ArrayList<>(productos));
    }

    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        if (nuevoPrecio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }

        boolean productoEncontrado = false;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equals(nombre)) {
                productos.set(i, new Producto(nombre, nuevoPrecio)); // Actualiza el producto en la misma posición
                productoEncontrado = true;
                break;
            }
        }

        if (!productoEncontrado) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
    }

    public void eliminarProducto(String nombre) {
        boolean productoEncontrado = productos.removeIf(producto -> producto.getNombre().equals(nombre));

        if (!productoEncontrado) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
    }
}
