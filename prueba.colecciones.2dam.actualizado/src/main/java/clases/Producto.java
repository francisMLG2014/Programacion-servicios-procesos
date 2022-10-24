package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;

/**
 * Clase que representa un producto a la venta en un supermercado
 * @author Miguel
 *
 */

//MISIón 21/09 : Añadir variable interna private String imagen a producto, y con el web scrapping (solo para carrefour) sacar la url (.......png, jpg) de la imagen de producto, y almacenarla en la variable interna.
//Ej: De aqui: https://www.carrefour.es/supermercado/recambios-para-aspirador-nasal-rhinomer-narhinel-confort-10-ud/R-590504106/p , sacar: https://static.carrefour.es/hd_510x_/img_pim_food/257937_00_1.jpg
public class Producto implements Comparable<Producto>{
	/** El nombre del producto **/
	private String nombre;
	
	/** Supermercado en el que est� a la venta el producto al precio especificado **/
	private String supermercado;
	
	/** Precio de venta del producto en el supermercado comcreto **/
	private float precio;
	
	
	/** Fecha en la que se comprob� el precio por �ltima vez **/
	private Timestamp ultimaRevision;
	
	/** Url desde la que se hace el web scrapping para obtener el precio del producto **/
	private String url;
	


	/**
	 * Constructor que recibe y almacena la informaci�n de un prodcuto, le asigna como fecha de �ltima revisi�n el momento en que se llama a este constructor.
	 * @param nombre Nombre del producto
	 * @param supermercado Supermercado donde se encuentra este producto
	 * @param precio el precio de ese producto en el supermercado.
	 * @throws IOException 
	 */
	public Producto(String url) throws IOException {
		super();
		this.url = url;
		this.recargarInfo();
		this.ultimaRevision = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());;
	}
	
	/**
	 * Constructor temporal, que se eliminar�, para poder probar el tema de colecciones antes de hacer el web scrapping de los supermercados
	 * @deprecated
	 * @param n nombre del producto
	 * @param s supermercado donde estar� el producto
	 * @param p precio del producto en ese supermercado
	 */
	public Producto (String n,String s,float p) {
		this.ultimaRevision = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());;
		this.nombre=n;
		this.supermercado=s;
		this.precio=p;
	}
	
	
	/**
	 * obtiene la url desde la que se hace web scrapping a las dem�s propiedades del producto
	 * @return url desde la que se hace el scrapping al producto
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Cambia la url para hacer web scrapping al producto, y recarga toda su informaci�n.
	 * @param url nueva url desde la que hacer scrapping
	 * @throws IOException 
	 */
	public void setUrl(String url) throws IOException {
		this.url = url;
		this.recargarInfo();
	}

	/**
	 * obtiene el nombre del producto
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * obtiene el nombre del supermercado
	 * @return nombre del supermercado
	 */
	public String getSupermercado() {
		return supermercado;
	}
	
	/**
	 * obtiene el precio del producto
	 * @return precio del producto en euros
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * obtiene la fecha y hora en que por �ltima vez se hizo scrapping al producto
	 * @return fecha y hora del �ltimo scrapping
	 */
	public Timestamp getUltimaRevision() {
		return ultimaRevision;
	}

	/**
	 * Funci�n que a partir de una URL obtiene mediante web scrapping el nombre, supermercado y precio del producto.
	 * @throws IOException 
	 */
	public void recargarInfo() throws IOException {
		//Hacer el web scrapping a partir de la url seg�n el supermercado que sea.
		URL dirUrl=new URL(this.url);
		if(dirUrl.getAuthority().contains("carrefour")) {
			InputStream entrada=dirUrl.openStream();
			BufferedReader lector=new BufferedReader(new InputStreamReader(entrada));
			
			String linea="";
			String texto="";
			do {
				texto+=linea+"\n";
				linea=lector.readLine();
			}while(linea!=null);
			
			String textoParaNombre=texto;

			int posicionPrecio=-1;
			if(texto.contains("buybox__price--current")) {
				posicionPrecio=texto.indexOf("<span class=\"buybox__price--current\">");
				texto=texto.substring(posicionPrecio+37);
			}else {
				posicionPrecio=texto.indexOf("<span class=\"buybox__price\">");
				texto=texto.substring(posicionPrecio+28);
			}
			
			int posicionCierrePrecio=texto.indexOf("</span>");
			texto=texto.substring(0,posicionCierrePrecio);
			texto=texto.replace(".","").replace("€","").replace(",", ".").trim();
			this.precio=Float.parseFloat(texto);
			
			this.supermercado="Carrefour";
			this.ultimaRevision=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			
			int posicionNombre=textoParaNombre.indexOf("<h1 class=\"product-header__name\">");
			textoParaNombre=textoParaNombre.substring(posicionNombre+33);
			int posicionCierreNombre=textoParaNombre.indexOf("</h1>");
			textoParaNombre=textoParaNombre.substring(0,posicionCierreNombre);
			this.nombre=textoParaNombre.trim();
		}
	}

	@Override
	public String toString() {
		return this.nombre+" ("+this.supermercado+") : "+this.precio+" € . Revisado: "+this.ultimaRevision;
	}

	
	public int compareTo(Producto o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
	
	
	
}
