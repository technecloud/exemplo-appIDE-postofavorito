package app.business;

import java.io.IOException;
import java.util.List;

import app.entity.Marcas;
import app.services.ServiceMarcas;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-07-31
 *
 */

public class MarcasBusiness {

	ServiceMarcas service = new ServiceMarcas();

	public List<Marcas> listAllMarcas() throws IOException {
		return service.getListMarcas();
	}

}
