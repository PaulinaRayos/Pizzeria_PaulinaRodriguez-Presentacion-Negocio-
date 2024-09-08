/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexion;
import interfaces.IProductoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Producto;

/**
 *
 * @author pauli
 */
public class ProductoDAO implements IProductoDAO {

    private IConexion conexion;

    public ProductoDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Producto producto) {
        try {
            Connection bd = conexion.crearConexion();
            String insertar = "INSERT INTO productos(nombre,descripcion,precio)VALUES (?, ?, ?)";
            PreparedStatement agregar = bd.prepareStatement(insertar);

            agregar.setString(1, producto.getNombre());
            agregar.setString(2, producto.getDescripcion());
            agregar.setFloat(3, producto.getPrecio());

            agregar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        String eliminarProducto = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection bd = conexion.crearConexion(); PreparedStatement eliminar = bd.prepareStatement(eliminarProducto)) {

            eliminar.setInt(1, id);
            eliminar.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean actualizar(Producto producto) {
        String actualizarProducto = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ? WHERE id_producto = ?";
        try (Connection bd = conexion.crearConexion(); PreparedStatement actualizar = bd.prepareStatement(actualizarProducto)) {

            actualizar.setString(1, producto.getNombre());
            actualizar.setString(2, producto.getDescripcion());
            actualizar.setFloat(3, producto.getPrecio());
            actualizar.setInt(4, producto.getId());

            actualizar.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public Producto consultar(int id) {
        try {
            Connection bd = conexion.crearConexion();
            String buscarProducto = "SELECT * FROM productos WHERE id_producto=?";
            PreparedStatement busqueda = bd.prepareStatement(buscarProducto);
            busqueda.setInt(1, id);
            ResultSet resultado = busqueda.executeQuery();

            if (resultado.next()) {
                Producto p = new Producto();
                p.setId(resultado.getInt("id_producto"));
                p.setNombre(resultado.getString("nombre"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setPrecio(resultado.getFloat("precio"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Producto> consultar() {
        String consultarProductos = "SELECT * FROM productos";
    List<Producto> listaProductos = new ArrayList<>();

    try (Connection bd = conexion.crearConexion();
         PreparedStatement consulta = bd.prepareStatement(consultarProductos);
         ResultSet resultados = consulta.executeQuery()) {

        while (resultados.next()) {
            Producto p = new Producto();
            p.setId(resultados.getInt("id_producto"));
            p.setNombre(resultados.getString("nombre"));
            p.setDescripcion(resultados.getString("descripcion"));
            p.setPrecio(resultados.getFloat("precio"));
            listaProductos.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        
    }

    return listaProductos; 
        
    }

}
