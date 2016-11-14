package catalogo.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class Interpreter implements Serializable {

	private static final long serialVersionUID = 1682871588766110815L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "tipo")
	private String type;
	@BDField(value = "nome")
	private String name;
	
	public Interpreter() { super(); }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
