package pruebas.cliente.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PrincipalCliente {

	public static void main(String[] args) {
		try {
		System.out.println("Dime el puerto al cual conectar");
		Scanner lector=new Scanner(System.in);
		int puerto=Integer.parseInt(lector.nextLine());
		//Establecemos conexion con el servidor. Lanza excepcion si no se conecta
		Socket miServidor=new Socket("127.0.0.1",puerto);
			
		//Crea el objeto que nos permite leer mensajes del servidor
		DataInputStream entrada=new DataInputStream(miServidor.getInputStream());
		//Crea el objeto que nos permite mandar mensajes al servidor
		DataOutputStream salida=new DataOutputStream(miServidor.getOutputStream());
			
			
		System.out.println(entrada.readUTF());
			
			
		salida.writeUTF(lector.nextLine());
			
			
		miServidor.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
