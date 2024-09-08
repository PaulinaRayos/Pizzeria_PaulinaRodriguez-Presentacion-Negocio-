/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.ProductoDAO;
import interfaces.IConexion;
import interfaces.IProductoDAO;
import interfaces.IProductoNegocio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Producto;

/**
 * Clase que implementa la lógica de negocio para la gestión de productos. Esta
 * clase interactúa con la capa de acceso a datos (DAO) para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los productos.
 *
 * @author pauli
 */
public class ProductoNegocio implements IProductoNegocio {
    // Interfaz para la conexión a la base de datos
    private IConexion conexion;
    // DAO para la gestión de productos
    IProductoDAO productoDAO;

    /**
     * Constructor de la clase ProductoNegocio. Inicializa la conexión y crea
     * una instancia del DAO de productos.
     *
     * @param conexion Una implementación de la interfaz IConexion para
     * gestionar la conexión a la base de datos.
     */
    public ProductoNegocio(IConexion conexion) {
        this.conexion = conexion;
        productoDAO = new ProductoDAO(this.conexion);
    }
    
     /**
     * Agrega un nuevo producto a la base de datos.
     *
     * @param producto El objeto Producto a agregar.
     * @return true si el producto fue agregado con éxito, false en caso contrario.
     */
    public boolean agregar(Producto producto) {
        return productoDAO.agregar(producto);
    }
    
    /**
     * Elimina un producto de la base de datos basado en su ID.
     *
     * @param id El ID del producto a eliminar.
     * @return true si el producto fue eliminado con éxito, false en caso contrario.
     */
    public boolean eliminar(int id) {
        return productoDAO.eliminar(id);
    }
    
    /**
     * Actualiza los detalles de un producto existente en la base de datos.
     *
     * @param producto El objeto Producto con los detalles actualizados.
     * @return true si el producto fue actualizado con éxito, false en caso contrario.
     */
    public boolean actualizar(Producto producto) {
        return productoDAO.actualizar(producto);
    }
    
    /**
     * Consulta un producto específico en la base de datos basado en su ID.
     *
     * @param id El ID del producto a consultar.
     * @return El objeto Producto correspondiente al ID, o null si no se encuentra.
     */
    public Producto consultar(int id) {
        return productoDAO.consultar(id);
    }
    
    /**
     * Consulta todos los productos almacenados en la base de datos.
     *
     * @return Una lista de todos los productos.
     */
    public List<Producto> consultar() {
        return productoDAO.consultar();

    }
}
