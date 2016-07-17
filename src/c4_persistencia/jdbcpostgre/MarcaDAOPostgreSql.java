/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.jdbcpostgre;

import c3_dominio.contrato.IMarcaDAO;
import c3_dominio.entidad.Marca;
import c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Alfredo Osorio Perez <hacybeyker@hotmail.com>
 */
public class MarcaDAOPostgreSql implements IMarcaDAO{

    GestorJDBC gestorJDBC;

    public MarcaDAOPostgreSql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(Marca marca) throws Exception {
        try {
            String consulta = "insert into marca(nombremarca) values(?) ";
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setString(1, marca.getNombre());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void modificar(Marca marca) throws Exception {
        try {
            String consulta = "Update marca set nombremarca = ? where codigomarca= ?";
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setString(1, marca.getNombre());
            sentencia.setInt(2, marca.getCodigo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(Marca marca) throws Exception {
        try {
            String consulta = "Delete From marca where codigomarca = ?";
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setInt(1, marca.getCodigo());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Marca> buscar() throws Exception {
        List<Marca> marcas = new ArrayList<Marca>() ;
        try {
            String consulta ="select codigomarca, nombremarca from marca";
            ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
            while (resultado.next()) {                
                 Marca marca = new Marca();
                 marca.setCodigo(resultado.getInt(1));
                 marca.setNombre(resultado.getString(2));
                 marcas.add(marca);
            }
        } catch (Exception e) {
        }
        return marcas;
    }

    @Override
    public Marca buscarPorCodigo(int codigo) throws Exception {
        Marca marca = new Marca();
        try {
            String consulta = "select codigomarca, nombremarca from marca where codigomarca="+codigo;
            ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
            while (resultado.next()) {
                marca.setCodigo(resultado.getInt(1));
                marca.setNombre(resultado.getString(2));
            }
        } catch (Exception e) {
        }
        return marca;
    }

    @Override
    public List<Marca> buscarPorNombre(String nombre) throws Exception {
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            String consulta = "Select codigomarca,nombremarca From marca where nombremarca like '%"+nombre+"%'";
            ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
            while (resultado.next()) {                
                Marca marca = new Marca();
                marca.setCodigo(resultado.getInt(1));
                marca.setNombre(resultado.getString(2));
                marcas.add(marca);
            }
        } catch (Exception e) {
        }
        return marcas;
    }    
}
