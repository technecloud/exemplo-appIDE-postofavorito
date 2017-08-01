package app.business;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Modelo;
import app.services.ServiceFipe;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-08-01
 *
 */
 

@Service("ModelosBusiness")  
public class ModelosBusiness {

	public List<Modelo> listarTodosmodelos( ) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceFipe.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();
		List<Modelo> modelos = null;
	  ServiceFipe md = retrofit.create(ServiceFipe.class);
		
		Call<List<Modelo>> call = md.listatodosmodelo();
		Call<List<Modelo>> call2 = call.clone();
		Response<List<Modelo>> response = null;
		try {
			response = call2.execute();
			modelos = response.body();
			if (modelos != null) {
					return modelos;
			}
			return modelos;
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return modelos;
	}

}
