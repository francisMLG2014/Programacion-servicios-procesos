package clases;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Usuario {
	private String nombreUsuario;
	private String nombre;
	private String apellidos;
	private String contrasenia;
	private String email;
	private short anioNacimiento;
	private boolean baneado;
	private TreeSet<Producto> productosDeseados;
	private LinkedHashMap<String,Producto> comprasAnteriores;
	
	public Usuario(String nombreUsuario, String nombre, String apellidos, String contrasenia, String email,
			short anioNacimiento, boolean baneado,
			TreeSet<Producto> productosDeseados,
			LinkedHashMap<String,Producto> ca) {
		super();
		this.comprasAnteriores=ca;
		this.productosDeseados=productosDeseados;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasenia = contrasenia;
		this.email = email;
		this.anioNacimiento = anioNacimiento;
		this.baneado = baneado;
	}
	
	
	public TreeSet<Producto> getProductosDeseados() {
		return productosDeseados;
	}


	


	public LinkedHashMap<String, Producto> getComprasAnteriores() {
		return comprasAnteriores;
	}


	public void setComprasAnteriores(LinkedHashMap<String, Producto> comprasAnteriores) {
		this.comprasAnteriores = comprasAnteriores;
	}


	public void setProductosDeseados(TreeSet<Producto> productosDeseados) {
		this.productosDeseados = productosDeseados;
	}




	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(short anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public boolean isBaneado() {
		return baneado;
	}

	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
	}

	@Override
	public String toString() {
		return nombreUsuario+"\n-------------------\n"
				+"Nombre: "+this.nombre+" "+this.apellidos+"\n"
				+"Contraseña: "+this.contrasenia+"\n"
				+"Año nacimiento: "+this.anioNacimiento+"\n"
				+"Baneado: "+this.baneado+"\n"
				+"Email: "+this.email+"\n"
				+"Deseados: "+this.productosDeseados+"\n"
				+"Anteriores: "+this.comprasAnteriores+"\n";
	}
	
	
	
	
	
}
