package pruebas.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlPrincipal {

	public static void main(String[] args) {

		try {
			URL direccion = new URL(
					"https://www.carrefour.es/supermercado/banana-a-granel-1-kg-aprox/R-529921745/p?ic_source=food&ic_medium=undefined&ic_content=cat20002-productos-frescos");

			System.out.println("Path: " + direccion.getPath());
			System.out.println("Puerto: " + direccion.getPort());
			System.out.println("Protocolo: " + direccion.getProtocol());
			System.out.println("Parámetros get: " + direccion.getQuery());
			System.out.println("Hash: " + direccion.getRef());
			System.out.println("Autorithy: " + direccion.getAuthority());

			InputStream flujoEntrante = direccion.openStream();// Se abre un flujo de datos
			BufferedReader lector = new BufferedReader(new InputStreamReader(flujoEntrante));// Lector de flujo de datos
																								// binarios.
																								// (Convertimos un flujo
																								// de datos en texto)

			String lineas = "";
			String texto = "";
			do {
				
				texto += lineas + "\n";
				lineas = lector.readLine();
			} while (lineas != null);
//			System.out.println(texto);
			String dato = "<span class=\"buybox__price\">";
			int posicionPrecio = texto.indexOf(dato);

			texto = texto.substring(posicionPrecio + dato.length());

			int posicionCierrePrecio = texto.indexOf("</span>");

			texto = texto.substring(0, posicionCierrePrecio);

			System.out.println(texto);

			// Misión: Que a partir del texto que queda aquí, en este caso 1,25 guardeis en
			// una variable
			// de tipo float el numero del precio (teneis que quitar espacios, saltos de
			// linea, y el simbolo €)
			// hacer un sysout de esa variable float

			
			
			
			//Francisco José Jiménez Díaz
			byte principioPrecio=0;
			byte finalPrecio=0;
			byte ayuda=0;
			byte avance=1;
			while(avance!=0) {
				if(!Character.isDigit(texto.charAt(ayuda))&&avance==1) {
					ayuda=(byte)(ayuda+avance);
					continue;
				}
				if(avance==1) {
					avance=-1;
					principioPrecio=ayuda;
					ayuda=(byte)texto.length();
				}
				ayuda=(byte)(ayuda+avance);
				if(Character.isDigit(texto.charAt(ayuda))) {
					avance=0;
					finalPrecio=(byte) (ayuda+1);
				}
				
			}
			texto=texto.substring(principioPrecio,finalPrecio).replace(',', '.');
			float numero=Float.parseFloat(texto);
			System.out.println("El precio: "+numero);
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
