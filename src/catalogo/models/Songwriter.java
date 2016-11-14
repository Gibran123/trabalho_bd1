package catalogo.models;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class Songwriter implements Serializable {
	
	private static final long serialVersionUID = 641309235664626874L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "nome")
	private String name;
	@BDField(value = "dt_nascimento")
	private Date dateOfBirth;
	@BDField(value = "dt_morte")
	private Date dateOfDeath;
	@BDField(value = "cidade_nascimento")
	private Date hometown;
	@BDField(value = "cod_pm")
	private PeriodMusical period;
	
	public Songwriter() { super(); }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public Date getHometown() {
		return hometown;
	}

	public void setHometown(Date hometown) {
		this.hometown = hometown;
	}

	public PeriodMusical getPeriod() {
		return period;
	}

	public void setPeriod(PeriodMusical period) {
		this.period = period;
	}
	
}
