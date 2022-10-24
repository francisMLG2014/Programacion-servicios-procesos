package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import clases.ProductosConocidos;
import clases.Usuario;

public class PruebasColecciones {
	
	public static void main(String[] args) {
		ProductosConocidos pc=new ProductosConocidos();
		byte opcion=0;
		Scanner lector=new Scanner(System.in);
		
		while(opcion!=6) {
			try {
				System.out.println("1-Cargar urls del archivo al programa\n"
						+ "2-Guardar urls del programa al archivo\n"
						+ "3-Insertar producto nuevo en el programa\n"
						+ "4-Borrar todas las urls del programa\n"
						+ "5-Mostrar todos los productos del programa\n"
						+ "6-Salir del programa");
				opcion=Byte.parseByte(lector.nextLine());
				switch(opcion) {
				case 1:
					if(pc.cargar()) {
						System.out.println("Datos cargados");
					}else {
						System.out.println("El fichero no existe");
					}
					break;
				case 2:
					pc.guardar();
					break;
				case 3:
					System.out.println("Inserta la url:");
					pc.añadirURLs(lector.nextLine());
					break;
				case 4:
					pc.borrarTodo();
					break;
				case 5:
					System.out.println(pc);
				case 6:
					break;
				default:
					throw new NumberFormatException();
				}
				
				
			}catch(NumberFormatException e) {
				System.out.println("Opción no disponible");
			}
			
			
			
			System.out.println("----------------");
		}
		lector.close();
//			Producto banana=new Producto("https://www.dia.es/compra-online/frescos/frutas/platanos/p/42070");
//			Producto gelatina=new Producto("https://www.dia.es/compra-online/despensa/lacteos-y-huevos/postres/p/139596");
//			Producto uno=new Producto("https://www.dia.es/compra-online/despensa/desayunos-y-dulces/chocolates-y-bombones/p/45685");
//			Producto dos=new Producto("https://www.dia.es/compra-online/despensa/desayunos-y-dulces/chocolates-y-bombones/p/277442");
	}

}

