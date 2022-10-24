package clasesProductos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.TreeSet;

public class ProductosConocidos {
	private TreeSet<String> urls;

	public ProductosConocidos() {
		urls=new TreeSet<String>();
	}
	
	public TreeSet<String> getUrls(){
		return this.urls;
	}

	@Override
	public String toString() {
		return "ProductosConocidos [urls=" + urls + "]";
	}
	
	
	public void guardar() {
		
	}
	
	public boolean cargar() {
		File archivo=new File("./productos.json");
		if(!archivo.exists()) {
			return false;
		}
		try {
			BufferedReader lector=new BufferedReader(new FileReader(archivo));
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return true;
	}
	
	public void borrarTodo() {
		this.urls=new TreeSet<String>();
	}
	
	public void añadirURLs() {
		
	}
}
