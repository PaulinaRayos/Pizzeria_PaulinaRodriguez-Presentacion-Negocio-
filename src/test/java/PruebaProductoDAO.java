/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.ProductoDAO;
import interfaces.IConexion;
import objetos.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author pauli
 */
public class PruebaProductoDAO {
     public static void main(String[] args) {
        // Crear conexión a la base de datos
        IConexion conexion = new IConexion() {
            @Override
            public Connection crearConexion() {
                try {
                    
                    String url = "jdbc:mysql://127.0.0.1:3306/pizzeria";
                    String user = "Paulina";
                    String password = "leydemurphy";
                    return DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        // Instancia de ProductoDAO
        ProductoDAO productoDAO = new ProductoDAO(conexion);

       /*
        // 1. Agregar un producto
        Producto nuevoProducto = new Producto("Pizza Margherita", "Tomate, mozzarella y albahaca", 100.0f);
        boolean agregado = productoDAO.agregar(nuevoProducto);
        System.out.println("Producto agregado: " + agregado); 
        
        */////
/*
       // 2. Consultar un producto por ID
        Producto productoConsultado = productoDAO.consultar(5); // Cambia el ID según tu base de datos
        if (productoConsultado != null) {
            System.out.println("Producto consultado: " + productoConsultado.getNombre() + ", " + productoConsultado.getDescripcion() + ", $" + productoConsultado.getPrecio());
        } else {
            System.out.println("No se encontró el producto con el ID especificado.");
        }
        
*/
        // 3. Actualizar un producto
        Producto productoConsultado = productoDAO.consultar(5);
        if (productoConsultado != null) {
            productoConsultado.setDescripcion("Con todooooo");
            productoConsultado.setPrecio(120.0f);
            boolean actualizado = productoDAO.actualizar(productoConsultado);
            System.out.println("Producto actualizado: " + actualizado);
        }
        /***////
/*
        // 4. Consultar todos los productos
        List<Producto> listaProductos = productoDAO.consultar();
        System.out.println("Lista de productos:");
        for (Producto p : listaProductos) {
            System.out.println(p.getId() + " - " + p.getNombre() + ": " + p.getDescripcion() + " - $" + p.getPrecio());
        }
*/
        /*
        // 5. Eliminar un producto
        boolean eliminado = productoDAO.eliminar(4); 
        System.out.println("Producto eliminado: " + eliminado);
*/

    }
}
