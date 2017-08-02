package app.business;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Ano;
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

@Service("AnoBusiness") 
public class AnoBusiness {

	public List<Ano> listarTodosVeiculosPorAno( ) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceFipe.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();
		List<Ano> anos = null;
	  ServiceFipe an = retrofit.create(ServiceFipe.class);
		
		Call<List<Ano>> call = an.precoCorrenteVeiculo();
		Call<List<Ano>> call2 = call.clone();
		Response<List<Ano>> response = null;
		try {
			response = call2.execute();
			anos = response.body();
			if (anos != null) {
			    System.out.println(anos);
					return anos;
			}
			return anos;
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return anos;
	}

}
