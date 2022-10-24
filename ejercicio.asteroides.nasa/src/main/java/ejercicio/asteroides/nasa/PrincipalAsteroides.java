package ejercicio.asteroides.nasa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import clases.CentroUniverso;

public class PrincipalAsteroides {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte dias = 0;
		LocalDate hoy = LocalDate.now();
		LocalDate fechaFinal = null;
		String apiKey = "DEMO_KEY";

		System.out.println("--ASTEROIDES--\nDame un número del 1-7. Desde hoy (" + hoy
				+ "), hasta el número de dias indicado\nbuscaremos los asteroides existentes.");
		do {
			try {
				dias = Byte.parseByte(sc.nextLine());
				if (dias > 7 || dias < 1) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada no valida");
				dias = 0;
			}
		} while (dias > 7 || dias < 1);
		fechaFinal = hoy.plusDays(dias);

		URL api = null;
		try {
			api = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + hoy + "&end_date=" + fechaFinal
					+ "&api_key=" + apiKey);

			BufferedReader lectorFlujo = new BufferedReader(new InputStreamReader(api.openStream()));
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting();
			Gson gson = builder.create();

			CentroUniverso universo=gson.fromJson(lectorFlujo, CentroUniverso.class);

			System.out.println(universo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
