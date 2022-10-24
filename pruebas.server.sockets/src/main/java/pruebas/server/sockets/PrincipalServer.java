package pruebas.server.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PrincipalServer {

	public static void main(String[] args) {
		ServerSocket servidor=null;
		try {
			servidor = new ServerSocket(0);
			System.out.println("puerto: "+servidor.getLocalPort());
		} catch (IOException e) {
			System.err.println("No pude conectar con el cliente");
			System.exit(0);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//Se queda parado esperando conexiones
			
			while(true) {
			Socket miCliente=null;
			try {
				miCliente = servidor.accept();
			
			//El cliente ya ha conectado
			System.out.println("Conectado correctamente con cliente en: "+miCliente.getInetAddress()+" : "+miCliente.getPort());
			//Creamos el objeto entrada para leer mensajes del cliente
			DataInputStream entrada=new DataInputStream(miCliente.getInputStream());
			//Creamos el objeto salida para escribir al cliente
			DataOutputStream salida=new DataOutputStream(miCliente.getOutputStream());
			
			//podemos mandar tildes y ñ
			salida.writeUTF("Bienvenido cliente, ya estás conectado.");
			
			System.out.println("Se ha conectado: "+entrada.readUTF());

			
			
			
			
			} catch(Exception e) {
				System.err.println("un cliente ha reventado");
				try {
					miCliente.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		
		

	}

}
