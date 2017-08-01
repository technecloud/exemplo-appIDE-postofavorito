package app.services;

import java.util.List;

import app.entity.Marcas;
import app.entity.Veiculos;
import retrofit2.Call;
import retrofit2.http.GET;

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
	Call<List<Marcas>> listatodasmarcas();
	
	/**
	 *  Lista todos os veiculos
	 */		
	@GET("veiculos/21.json")
	Call<List<Veiculos>> listatodosveiculos();

	/**
	 *  Lista todos os modelos de acordo com a marca
	 */	
	@GET("veiculo/21/4828.json")
	Call<List<Marcas>> listatodosmodelo();
	
	
	/**
	 *  visualizar o preço corrente da Tabela FIPE para este veículo/modelo/ano. 
	 *  Continuando com o exemplo a cima para obter o valor de um veículo do ano 2013 a Gasolina utilizaremos o id 2013-1
	 */
	@GET("veiculo/21/4828/2013-1.json")
	Call<List<Marcas>> precoCorrenteVeiculo();
	
	

}
