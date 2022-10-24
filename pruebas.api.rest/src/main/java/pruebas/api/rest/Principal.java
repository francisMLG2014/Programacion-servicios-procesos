package pruebas.api.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {

	public static void main(String[] args) {

		try {
			String apikeyVoice="02256779b8e44f908798ec909d607191";
			Scanner sc = new Scanner(System.in);
			System.out.println("Dime una frase que quieras decir");
			String frase = sc.nextLine();
			frase=frase.replace(" ","+");
			System.out.println("De qué país quieres a la persona(españa/mexico/rusia/francia/suecia)");
			String pais = sc.nextLine().toLowerCase();
			String idioma = "";
			System.out.println("Qué genero quieres para la persona (male/female)");
			String genero = sc.nextLine().toLowerCase();
			String generoPersona = genero;
			switch (pais) {
			case "españa":
				idioma = "es-es";
				pais = "es";
				if (genero.equals("female")) {
					genero = "Sofia";
				} else {
					genero = "Diego";
				}
				break;
			case "mexico":
				idioma = "es-mx";
				pais = "mx";
				if (genero.equals("female")) {
					genero = "Silvia";
				} else {
					genero = "Jose";
				}
				break;
			case "francia":
				idioma = "fr-fr";
				pais = "fr";
				if (genero.equals("female")) {
					genero = "Iva";
				} else {
					genero = "Axel";
				}
				break;
			case "suecia":
				idioma = "sv-se";
				pais = "fi";
				if (genero.equals("female")) {
					genero = "Molly";
				} else {
					genero = "Hugo";
				}
				break;
			case "rusia":
				idioma = "ru-ru";
				pais = "rs";
				if (genero.equals("female")) {
					genero = "Olga";
				} else {
					genero = "Peter";
				}
				break;
			}

			URL apiUser = new URL("https://randomuser.me/api/?nat="+pais+"&gender="+generoPersona);
			System.out.println("https://randomuser.me/api/?nat="+pais+"&gender="+generoPersona);
			BufferedReader lector = new BufferedReader(new InputStreamReader(apiUser.openStream()));
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting();
			Gson gson = builder.create();

			Usuario user = gson.fromJson(lector, Usuario.class);
			System.out.println(user);
			frase="Hola soy "+user.getDatos().get(0).getName().getFirst().toString()+". "+frase;
			frase=frase.replace(" ", "%20");
			URL audio= new URL("https://api.voicerss.org/?key="+apikeyVoice+"&src="+frase+"&hl="+idioma+"&v="+genero);
			
			
			AudioInputStream in= AudioSystem.getAudioInputStream(audio);
			Clip clip=AudioSystem.getClip();
			clip.open(in);
			clip.start();
			Thread.sleep(30000);
			clip.close();
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
