package component;

/**
 * 
 * @author https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		JSONObject json = readJsonFromUrl("https://api.postmon.com.br/v1/cep/88020-280");
		System.out.println(json.toString());
//		System.out.println(json.get("bairro"));
//		System.out.println(json.get("logradouro"));
//		System.out.println(json.get("estado"));
		System.out.println(json.get("cidade"));
//		System.out.println(json.get("complemento") != null ? json.get("complemento") : "");
		
		
		
	}
}
