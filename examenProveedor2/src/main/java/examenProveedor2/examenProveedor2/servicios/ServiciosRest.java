package examenProveedor2.examenProveedor2.servicios;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import examenProveedor2.examenProveedor2.modelo.Producto;
import examenProveedor2.examenProveedor2.modelo.Proveedor;
import examenProveedor2.examenProveedor2.servicio.GestionProveedorLocale;


@Path("transacciones")
public class ServiciosRest {
	@Inject
	private GestionProveedorLocale on;
	private Proveedor proveedor;
	private Producto produc;

	private int saldoNuevo;
	
	
	public ServiciosRest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo a enviar para solicitar pedidos
	 * @param transac
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Path("/solicitarProducto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  String  solicitar(@QueryParam("cantidad") int cantidad,@QueryParam("codigoProducto") int codigo) throws Exception {	
		produc = new Producto();
		try {
			System.out.println("entras?");
			if (codigo == 0) {
				System.out.println("error valor no existe");
			}else if(cantidad > produc.getStock()) {
				System.out.println("Cantidad es mayor al stock de los productos");
			}else {
				try {
					on.actualizarStock(cantidad, codigo);
					System.out.println("ACTUALIZADO");
				} catch (Exception e) {
					System.out.println("error");
				}
			}
		} catch (Exception e) {
			throw new Exception("Se ah producido un error"+e.getMessage());

		}
		return "ok";
	}
	@GET
	@Path("/listaProductos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> obtenerProductos() throws Exception{
		try {
		return on.obtenerProductos();
		}catch (Exception e) {
			throw new Exception("Se ah producido un error"+e.getMessage());

		}
	}
	
	@GET
	@Path("/listadoCompleto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> listarProductos(@QueryParam("codigoProveedor") int codigo) throws Exception{
		try {
		return on.listadoProductoCodigo(codigo);
		}catch (Exception e) {
			throw new Exception("Se ah producido un error"+e.getMessage());
		}
	}
	
}
