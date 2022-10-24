package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductosConocidos {
	private TreeSet<String> urls;

	public ProductosConocidos() {
		urls = new TreeSet<String>();
	}

	public TreeSet<String> getUrls() {
		return this.urls;
	}

	public void guardar() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String texto = gson.toJson(this.urls);
		try {
			FileWriter escritor = new FileWriter("./productos.json");
			escritor.write(texto);
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean cargar() {
		File archivo = new File("./productos.json");
		if (!archivo.exists()) {
			return false;
		}
		try {
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			GsonBuilder builder=new GsonBuilder();
			builder.setPrettyPrinting();
			Gson gson=builder.create();
			String[] cadena=gson.fromJson(lector,String[].class);
			
			for(short i=0;i<cadena.length;i++) {
				this.urls.add(cadena[i]);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public void borrarTodo() {
		this.urls = new TreeSet<String>();
	}

	public void añadirURLs(String url) {
		this.urls.add(url);
	}

	@Override
	public String toString() {
		String ret="";
		Iterator<String> it=this.urls.iterator();
		while(it.hasNext()) {
			try {
				String urlProducto=it.next();
				if(urlProducto.equals("[]")) {
					return "Nada que devolver";
				}
				Producto p=new Producto(urlProducto);
				ret=ret+p+"\n";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(ret.equals("")) {
			return "Nada que devolver";
		}
		return ret;
	}
	
}
