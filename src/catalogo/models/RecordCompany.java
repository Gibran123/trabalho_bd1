package catalogo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class RecordCompany implements Serializable {

	
	private static final long serialVersionUID = -8655600062470834833L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "site")
	private String site;
	@BDField(value = "rua")
	private String street;
	@BDField(value = "numero")
	private String number;
	@BDField(value = "cidade")
	private String city;
	@BDField(value = "cod_telefone")
	private String fone;
	
	public RecordCompany() { super(); }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
}
