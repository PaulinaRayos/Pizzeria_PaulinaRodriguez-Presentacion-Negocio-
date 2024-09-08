/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pauli
 */
public class Conexion implements IConexion {

    String cadena = "jdbc:mysql://127.0.0.1:3306/pizzeria";
    String usuario = "Paulina";
    String pwd = "leydemurphy";

    @Override
    public Connection crearConexion() {
    try{
        Connection c = DriverManager.getConnection(cadena, usuario, pwd);  
        return c;
    }catch (SQLException e){
        System.out.println("Hubo un error de conexion");
    }
    return null;
    }

}
