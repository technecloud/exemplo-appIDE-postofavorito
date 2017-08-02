package app.entity;

/**
 * Classe que representa ...
 * 
 * @author Rodrigo Gregorio Neri
 * @version 1.0
 * @since 2017-08-01
 *
 */

public class Veiculos {
	private String fipe_marca;
	private String name;
	private String marca;
	private String key;
	private String id;
	private String fipe_name;

	/**
	 * Construtor
	 **/
	public Veiculos(String fipe_marca, String name, String marca, String key, String id, String fipe_name) {
	   this.fipe_name = fipe_marca;
	   this.name = name;
	   this.marca = marca;
	   this.key = key;
	   this.id = id;
	   this.fipe_name = fipe_name;
	  
	}

	public String getFipe_marca() {
		return fipe_marca;
	}

	public void setFipe_marca(String fipe_marca) {
		this.fipe_marca = fipe_marca;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

}
