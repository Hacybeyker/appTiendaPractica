/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.jdbcpostgre;

import c4_persistencia.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Alfredo Osorio Perez <hacybeyker@hotmail.com>
 */
public class ConexionPostgreSql extends GestorJDBC{

    @Override
    public void abrirConexion() throws SQLException {        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { }
        String url = "jdbc:postgresql://localhost:5432/tiendapractica";
        conexion = DriverManager.getConnection(url, "postgres", "123"); 
    }
    
}
