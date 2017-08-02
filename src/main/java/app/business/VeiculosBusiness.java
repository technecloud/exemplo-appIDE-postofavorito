package app.business;


import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Veiculos;
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

@Service("VeiculosBusiness") 
public class VeiculosBusiness {

	public List<Veiculos> listarTodosveiculos(String marca) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceFipe.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();
		List<Veiculos> veiculos = null;
	  ServiceFipe mc = retrofit.create(ServiceFipe.class);
		
		Call<List<Veiculos>> call = mc.listatodosveiculos(marca);
		Call<List<Veiculos>> call2 = call.clone();
		Response<List<Veiculos>> response = null;
		try {
			response = call2.execute();
			veiculos = response.body();
			if (veiculos != null) {
					return veiculos;
			}
			return veiculos;
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return veiculos;
	}

}
