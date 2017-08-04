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

	public Ano listarTodosVeiculosPorAno(String idDoVeiculo, String idDoVeiculosMarcas, String idDoAno ) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceFipe.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();
		Ano anos = null;
	  ServiceFipe an = retrofit.create(ServiceFipe.class);
		
		Call<Ano> call = an.precoCorrenteVeiculo(idDoVeiculo,idDoVeiculosMarcas,idDoAno);
		Call<Ano> call2 = call.clone();
		Response response = null;
		try {
			response = call2.execute();
			anos = (Ano) response.body();
			System.out.println("entrou1");
			if (anos != null) {
			    System.out.println("entrou2");
					return anos;
			}
			System.out.println("entrou3");
			return anos;
		} catch (Exception e) {
			  e.printStackTrace();
		}
		return anos;
	}

}
