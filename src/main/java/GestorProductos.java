import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String nombre, double precio) {
        if (nombre == null || nombre.isEmpty() || precio <= 0) {
            throw new IllegalArgumentException("Nombre no puede ser vacío y el precio debe ser mayor a 0.");
        }
        productos.add(new Producto(nombre, precio));
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        if (nuevoPrecio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                productos.add(new Producto(nombre, nuevoPrecio));
                return;
            }
        }
        throw new IllegalArgumentException("Producto no encontrado.");
    }

    public void eliminarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                return;
            }
        }
        throw new IllegalArgumentException("Producto no encontrado.");
    }
}