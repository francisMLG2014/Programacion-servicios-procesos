package pruebas.api.rest;

import java.util.ArrayList;

public class Usuario {
	private ArrayList<DatosUsuario> results;
	private Info info;
	public Usuario(ArrayList<DatosUsuario> datos, Info info) {
		super();
		this.results = datos;
		this.info = info;
	}
	public ArrayList<DatosUsuario> getDatos() {
		return results;
	}
	public void setDatos(ArrayList<DatosUsuario> datos) {
		this.results = datos;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return this.results+"\n---\n"+this.info;
	}

}
