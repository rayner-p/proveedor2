package examenProveedor2.examenProveedor2.vista;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import examenProveedor2.examenProveedor2.modelo.Proveedor;
import examenProveedor2.examenProveedor2.servicio.GestionProveedorLocale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProveedorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProveedorLocale on;
	private Proveedor proveedor;
	private List<Proveedor> lstProveedor;
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public List<Proveedor> getLstProveedor() {
		return lstProveedor;
	}
	public void setLstProveedor(List<Proveedor> lstProveedor) {
		this.lstProveedor = lstProveedor;
	}
	@PostConstruct
	public void init() {
		proveedor = new Proveedor();
		lstProveedor = new ArrayList<Proveedor>();
	}
	
	public void registrarProveedor() throws Exception {
		try {
			on.registrarProveedor(proveedor);
			System.out.println("REGISTRADO");
		} catch (Exception e) {
			throw new Exception("Erro al insertar proveedor on" + e.getLocalizedMessage());
		}
	}
	
	public void obtenerDatosProveedor() throws Exception {
		try {
			
			if (on.obtenerProveedor()==null) {
				System.out.println("LISTA NULA");
			}else {
				lstProveedor = on.obtenerProveedor();
			}
		} catch (Exception e) {
			throw new Exception("Erro al listar proveedor on" + e.getLocalizedMessage());

		}
	}
	
}
