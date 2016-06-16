/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion;

import c3_dominio.contrato.IMarcaDAO;
import c3_dominio.entidad.Marca;
import c4_persistencia.GestorJDBC;
import c4_persistencia.jdbcpostgre.ConexionPostgreSql;
import c4_persistencia.jdbcpostgre.MarcaDAOPostgreSql;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Alfredo Osorio Perez <hacybeyker@hotmail.com>
 */
public class GestionarMarcaServicio {
    
    GestorJDBC gestorJDBC;
    IMarcaDAO marcaDAO;

    public GestionarMarcaServicio() {
        gestorJDBC = new ConexionPostgreSql();
        marcaDAO = new MarcaDAOPostgreSql(gestorJDBC);
    }
    
    public void crear(Marca marca) throws Exception {
        try {
            gestorJDBC.abrirConexion();
            marcaDAO.crear(marca);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
    }
    
    public void modificar(Marca marca) throws Exception {
        try {
            gestorJDBC.abrirConexion();
            marcaDAO.modificar(marca);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminar(Marca marca) throws Exception {
        try {
            gestorJDBC.abrirConexion();
            marcaDAO.eliminar(marca);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
    }
    
    public List<Marca> buscar() throws Exception {
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            gestorJDBC.abrirConexion();
            marcas = marcaDAO.buscar();
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
        return marcas;
    }
    
    public Marca buscarPorCodigo(int codigo) throws Exception {
        Marca marca = new Marca();
        try {
            gestorJDBC.abrirConexion();
            marca = marcaDAO.buscarPorCodigo(codigo);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
        return marca;
    }
    
    public List<Marca> buscarPorNombre(String nombre) throws Exception {
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            gestorJDBC.abrirConexion();
            marcas = marcaDAO.buscarPorNombre(nombre);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            System.err.println(e.getMessage());
        }
        return marcas;
    }
}