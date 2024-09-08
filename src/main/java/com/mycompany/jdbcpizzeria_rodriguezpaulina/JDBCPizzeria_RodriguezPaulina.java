/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcpizzeria_rodriguezpaulina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pauli
 */
public class JDBCPizzeria_RodriguezPaulina {

    public static void main(String[] args) {
        
        String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/pizzeria";
        String user = "Paulina";
        String pwd = "leydemurphy";
        
        String i = "INSERT INTO productos(nombre, precio, descripcion) VALUES (?, ?, ?)";
        String buscarProducto = "SELECT * FROM productos WHERE precio < ?";
        
        try{
        Connection c = DriverManager.getConnection(cadenaConexion, user, pwd);
        
        PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
        
        insert.setString(1, "Pizza de sencilla");
        insert.setFloat(2, (float)80.0);
        insert.setString(3, "Pizza sencilla con base de tomate y queso, sin topping");
        
        insert.executeUpdate();
        
        PreparedStatement busqueda = c.prepareStatement(buscarProducto);
        busqueda.setFloat(1,100);
        
        ResultSet resultados = busqueda.executeQuery();
        if(resultados.next()){
            String nombre = resultados.getString("nombre");
            float precio = resultados.getFloat("precio");
            String descripcion = resultados.getString("descripcion");
            
            System.out.println(nombre + " $" + precio);
            System.out.println("descripcion");
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
