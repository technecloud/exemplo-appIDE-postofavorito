package app.fibeInterfaces;

import java.util.List;

import app.entity.Marcas;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Enumeração que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-07-20
 *
 */

public interface InterfaceMarcas  {

	public static final String API_URL = "http://fipeapi.appspot.com/api/1/carros/";

	@GET("marcas.json")
	Call<List<Marcas>> marcas();

}
