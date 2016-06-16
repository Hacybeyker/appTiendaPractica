/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.contrato;

import c3_dominio.entidad.Marca;
import java.util.List;

/**
 *
 * @author Carlos Alfredo Osorio Perez <hacybeyker@hotmail.com>
 */
public interface IMarcaDAO {
    public void crear(Marca marca) throws Exception;
    public void modificar(Marca marca) throws Exception;
    public void eliminar(Marca marca) throws Exception;
    public List<Marca> buscar() throws Exception;
    public Marca buscarPorCodigo(int codigo) throws Exception;
    public List<Marca> buscarPorNombre(String nombre) throws Exception;
}
