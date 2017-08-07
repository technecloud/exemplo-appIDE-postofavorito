package app.services;

import java.util.List;

import app.entity.Ano;
import app.entity.Marca;
import app.entity.Modelo;
import app.entity.Veiculos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-07-20
 *
 */

public interface ServiceFipe {

	public static final String API_URL = "http://fipeapi.appspot.com/api/1/carros/";

	/**
	 *  Lista todas as marcas
	 */	
	@GET("marcas.json")
	Call<List<Marca>> listatodasmarcas();
	
	/**
	 *  Lista todos os veiculos
	 */		
	@GET("veiculos/{veiculos}.json")
	Call<List<Veiculos>> listatodosveiculos(@Path("veiculos") String veiculos);

	/**
	 *  Lista todos os modelos de acordo com a marca
	 */	
	@GET("veiculo/{idveiculos}/{idVeiculosMarcas}.json")
	Call<List<Modelo>> listatodosmodelo(@Path("idveiculos") String idveiculos, @Path("idVeiculosMarcas") String idVeiculosMarcas);
	
	
	/**
	 *  visualizar o preço corrente da Tabela FIPE para este veículo/modelo/ano. 
	 *  Continuando com o exemplo a cima para obter o valor de um veículo do ano 2013 a Gasolina utilizaremos o id 2013-1
	 */
	@GET("veiculo/{idDoVeiculo}/{idDoVeiculosMarcas}/{idDoAno}.json")
	Call<Ano> precoCorrenteVeiculo(@Path("idDoVeiculo") String idDoVeiculo, @Path("idDoVeiculosMarcas") String idDoVeiculosMarcas,@Path("idDoAno") String idDoAno);
	

	

}
