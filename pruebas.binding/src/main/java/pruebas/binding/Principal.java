package pruebas.binding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {

	public static void main(String[] args) {
		/*1 Crear constructores, getter y setters,
		 *2 Declarar un coche y una casa y asignar la casa al coche con datos inventados
		 *3 Hacer marshalling (.toJson) al objeto de forma que la informacion del objeto se guarde en un fichero .json en la raiz del proyecto
		 *4 Hacer unmarshalling (.fromJson) al json que acabamos de crear, e imprimir el string  resultante de ese unmarshalling.*/
		
		
		//Primero importamos la libreria en el pom y creamos las variables
		
		Casa casa=new Casa("Volkswagen",(short)1937,"Wolfsburgo");
		
		Coche coche1=new Coche("Polo","Negro",(byte)5,true,(short)2020,casa);
		System.out.println("El coche antes de hacer el json:\n"+coche1);
		
		File carpeta=new File("./archivosJson");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		GsonBuilder constructor=new GsonBuilder();//Clase fábrica para la clase Gson
		constructor.setPrettyPrinting();//Facilidad para leer 
		Gson gson=constructor.create(); //Mediante este objeto podemos crear jsons
		String elCocheJson=gson.toJson(coche1);//Ya tenemos el json de este objeto creado en un String
		try {
			FileWriter escritor=new FileWriter("./archivosJson/coche.json");
			escritor.write(elCocheJson);
			escritor.flush();
			escritor.close();
		
		System.out.println("Ya está creado el json");
		
		
		
			BufferedReader lector=new BufferedReader(new FileReader("./archivosJson/coche.json"));
		
		Coche coche2=gson.fromJson(lector, Coche.class);
		System.out.println("Coche 2 desde el json:\n"+coche2);
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
