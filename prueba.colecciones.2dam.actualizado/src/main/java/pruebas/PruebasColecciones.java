package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
	import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import clases.Carrito;
import clases.Producto;
import clases.Usuario;

public class PruebasColecciones {
	
	public static void main(String[] args) {
		try {
			Producto televisor=new Producto("https://www.carrefour.es/tv-led-1397-cm-55-samsung-ue55bu8505-4k-uhd-smart-tv/VC4A-18968403/p");
			Producto rhinomer = new Producto("https://www.carrefour.es/supermercado/recambios-para-aspirador-nasal-rhinomer-narhinel-confort-10-ud/R-590504106/p");
			Producto filtroAgua = new Producto("https://www.carrefour.es/supermercado/set-3-filtros-de-agua-con-microparticulas-carrefour-home-blanco/R-787403889/p");
			Producto entrecot = new Producto("https://www.carrefour.es/supermercado/carne-de-anojo-troceada-para-guisar-circulo-de-calidad-600-g-aprox/R-prod1070042/p?ic_source=food&ic_medium=undefined&ic_content=cat20002-productos-frescos");
			Producto quesoRallado= new Producto("https://www.carrefour.es/supermercado/queso-en-polvo-especial-pasta-carrefour-sin-gluten-150-g/R-fprod1350064/p?ic_source=food&ic_medium=undefined&ic_content=cat20002-productos-frescos");
			Producto sacacorchos= new Producto("https://www.carrefour.es/supermercado/sacacorcho-de-vino-de-acero-tescoma-uno-vino-13cm-rojo/R-836506423/p");
			
			
			HashMap<String,Producto> resultadosBusqueda = new HashMap<String,Producto>();
			resultadosBusqueda.put(televisor.getNombre(),televisor);
			resultadosBusqueda.put(rhinomer.getNombre(),rhinomer);
			resultadosBusqueda.put(filtroAgua.getNombre(),filtroAgua);
			resultadosBusqueda.put(entrecot.getNombre(),entrecot);
			resultadosBusqueda.put(quesoRallado.getNombre(),quesoRallado);
			resultadosBusqueda.put(sacacorchos.getNombre(),sacacorchos);
			
			GsonBuilder builder=new GsonBuilder();
			builder.setPrettyPrinting();
			builder.setDateFormat("dd/MM/YYYY hh:mm:ss");
			Gson gson =builder.create();
			String jsonTelevisor=gson.toJson(televisor);
			FileWriter escritor=new FileWriter("./archivos/"+televisor.getNombre()+".json");
			escritor.write(jsonTelevisor);
			escritor.flush(); 
			escritor.close();
;			

			Carrito carrito = new Carrito();
			carrito.añadirProducto(televisor);
			carrito.añadirProducto(rhinomer);
			carrito.añadirProducto(filtroAgua);
			carrito.añadirProducto(entrecot);
			carrito.añadirProducto(quesoRallado);
			carrito.añadirProducto(sacacorchos);
			
			
			String carritoCadena=gson.toJson(carrito);
			FileWriter escritor2=
			new FileWriter("./archivos/carrito.json");
			escritor2.write(carritoCadena);
			escritor2.flush();
			escritor2.close();
			
			String hashMapCadena=gson.toJson(resultadosBusqueda);
			FileWriter escritor3=
					new FileWriter("./archivos/resultados.json");
			escritor3.write(hashMapCadena);
			escritor3.flush();
			escritor3.close();
			
			BufferedReader lector=new BufferedReader(
					new FileReader("./usuarios/mparamos.json"));
			Usuario mparamos=gson.fromJson(lector, Usuario.class);
			System.out.println(mparamos);
			
			/*
			
			System.out.println("Dime el producto que buscas");
			Scanner sc=new Scanner(System.in);
			String buscar=sc.nextLine();
			
			Iterator it=resultadosBusqueda.keySet().iterator();
			while(it.hasNext()) {
				String clave=(String)it.next();
				if(clave.contains(buscar)) {
					System.out.println(resultadosBusqueda.get(clave));
				}
				
			}
			System.out.println("--------------");
			Producto rimer=resultadosBusqueda.get("Recambios para aspirador nasal Rhinomer Narhinel Confort 10 ud.");
			System.out.println(rimer);
			

			System.out.println("--------------");
			System.out.println("Numero elementos: "+resultadosBusqueda.size());
			resultadosBusqueda.remove("Recambios para aspirador nasal Rhinomer Narhinel Confort 10 ud.");
			System.out.println("Numero elementos: "+resultadosBusqueda.size());
			*/
			
			
			
			/*Carrito c=new Carrito();
			
			c.añadirProducto(sacacorchos);
			c.añadirProducto(televisor);
			c.añadirProducto(rhinomer);
			c.añadirProducto(filtroAgua);
			c.añadirProducto(entrecot);
			c.añadirProducto(quesoRallado);
			
			PriorityQueue<Producto> productos=c.getCarrito();
			while(!productos.isEmpty()) {
				Producto actual=productos.poll();
				System.out.println(actual);
			}*/
			
			
		/*	URL prueba=new URL("https://www.educa.jcyl.es/educacyl/cm/gallery/Recursos%20Infinity/tematicas/webquijote/quijotepdf.html");
			HttpURLConnection conexion=(HttpURLConnection) prueba.openConnection();
			 System.out.println("El tipo de archivo es: "+prueba.openConnection().getContentType());
			System.out.println(conexion.getContent().getClass().getName());
			System.out.println(conexion.getContentLengthLong());
			System.out.println(new Timestamp(conexion.getLastModified()).toLocalDateTime());*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

