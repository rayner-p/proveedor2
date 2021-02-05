package examenProveedor2.examenProveedor2.servicio;

import java.util.List;

import javax.ejb.Local;

import examenProveedor2.examenProveedor2.modelo.Producto;
import examenProveedor2.examenProveedor2.modelo.Proveedor;

@Local
public interface GestionProveedorLocale {
	public void registrarProducto(Producto producto) throws Exception;
	public void registrarProveedor(Proveedor proveedor) throws Exception;
	public String actualizarStock(int stock, int nombre);
	public List<Producto> obtenerProductos() throws Exception;
	public List<Proveedor> obtenerProveedor() throws Exception;
	public List<Producto> listadoProductoCodigo(int codigo);
	public void solicitarProducto(int codigo);
}
