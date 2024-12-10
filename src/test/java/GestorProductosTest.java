import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorProductosTest {

  @Test
  public void testAgregarProductoValido() {
    // Arrange
    GestorProductos gestor = new GestorProductos();
    // Act
    gestor.agregarProducto("Laptop", 1500.0);
    // Assert
    assertEquals(1, gestor.obtenerProductos().size());
  }

  @Test
  public void testActualizarPrecioValido() {
    // Arrange
    GestorProductos gestor = new GestorProductos();
    gestor.agregarProducto("Mouse", 25.0);
    // Act
    gestor.actualizarPrecio("Mouse", 30.0);
    // Assert
    assertEquals(30.0, gestor.obtenerProductos().get(0).getPrecio());
  }

  @Test
  public void testEliminarProductoValido() {
    // Arrange
    GestorProductos gestor = new GestorProductos();
    gestor.agregarProducto("Teclado", 45.0);
    // Act
    gestor.eliminarProducto("Teclado");
    // Assert
    assertEquals(0, gestor.obtenerProductos().size());
  }

  @Test
  public void testAgregarProductoInvalido() {
    // Arrange
    GestorProductos gestor = new GestorProductos();
    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> gestor.agregarProducto("", 50.0));
    assertThrows(IllegalArgumentException.class, () -> gestor.agregarProducto("Monitor", -10.0));
  }

  @Test
  public void testActualizarProductoInexistente() {
    // Arrange
    GestorProductos gestor = new GestorProductos();
    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> gestor.actualizarPrecio("Impresora", 100.0));
  }
}
