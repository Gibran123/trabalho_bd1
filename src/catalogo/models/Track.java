package catalogo.models;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class Track implements Serializable {

	private static final long serialVersionUID = 3554619839023144737L;
	@BDField(value = "cod")
	private Long number;
	@BDField(value = "descricao")
	private String description;
	@BDField(value = "cod_cd")
	private CD cd;
	@BDField(value = "cd_composicao")
	private Composition composition;
	private List<Songwriter> songwriters;
	
	public Track() { super(); }

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public List<Songwriter> getSongwriters() {
		return songwriters;
	}

	public void setSongwriters(List<Songwriter> songwriters) {
		this.songwriters = songwriters;
	}
	
}
