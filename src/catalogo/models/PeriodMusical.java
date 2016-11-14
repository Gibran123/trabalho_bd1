package catalogo.models;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class PeriodMusical implements Serializable {

	
	private static final long serialVersionUID = 5570705003275128772L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "descricao")
	private String description;
	@BDField(value = "dt_inicio")
	private Date begin;
	@BDField(value = "dt_termino")
	private Date end;
	
	public PeriodMusical() { super(); }

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

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
}
