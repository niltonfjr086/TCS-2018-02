package component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnect {

	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}

	// bairro
	// cidade
	// logradouro
	// estado

	// bairro "José Mendes"
	// cidade "Florianópolis"
	// logradouro "Rua Professora Maria Júlia Franco"
	// estado_info
	// area_km2 "95.737,895"
	// codigo_ibge "42"
	// nome "Santa Catarina"
	// cep "88020280"
	// cidade_info
	// area_km2 "675,409"
	// codigo_ibge "4205407"
	// estado "SC"

}
