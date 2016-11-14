package catalogo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class Composition implements Serializable {

	private static final long serialVersionUID = 3994883584423786762L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "descricao")
	private String description;
	
	public Composition() { super(); }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
