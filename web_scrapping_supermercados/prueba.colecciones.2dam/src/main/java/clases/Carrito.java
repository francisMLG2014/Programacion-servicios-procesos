package clases;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Implementa una cesta de la compra al estilo carrefour: Sin buscador, inserta lo que vayas a comprar en orden alfab�tico
 * @author Miguel
 *
 */
public class Carrito {
	
	/** colecci�n que almacena alfab�ticamente todos los productos comprados **/
	private PriorityQueue<Producto> carrito;
	
	/**
	 * Constructor por defecto que inicializa un carrito vac�o
	 */
	public Carrito() {
		carrito=new PriorityQueue<Producto>();
	}

	/** getter del carrito, devuelve todos los productos alfab�ticamente */
	public PriorityQueue<Producto> getCarrito(){
		PriorityQueue<Producto> copia=new PriorityQueue<Producto>(); 
		copia.addAll(this.carrito);
		return carrito;
	}
	
	/**
	 * A�ade un producto al carrito
	 * @param p producto a a�adir
	 */
	public void añadirProducto(Producto p) {
		this.carrito.add(p);
	}
	
	
	/**
	 * Elimina un producto del carrito. TODO: Ver en documentaci�n que pasa si el producto est� repetido varias veces
	 * @param p producto a eliminar
	 */
	public void eliminarProducto(Producto p) {
		this.carrito.remove(p);
	}
	
}
