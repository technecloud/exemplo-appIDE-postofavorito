package app.test;

import java.io.IOException;

import app.services.ServiceFipe;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-07-31
 *
 */
 
public class MarcasTest {

	public static void main(String args[]) throws IOException {
	  
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceFipe.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		ServiceFipe marcasinterface = retrofit.create(ServiceFipe.class);
	//	Call<List<Marcas>> call = marcasinterface.marcas();
	//	List<Marcas> marcas = call.execute().body();

/*		for (Marcas marca : marcas) {
			System.out.println(marca.getOrder() + " (" + marca.getFipe_name() + ")");
		}
*/
	}
}
