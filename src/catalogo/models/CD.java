package catalogo.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import catalogo.annotation.BDField;

@XmlRootElement
public class CD implements Serializable {

	private static final long serialVersionUID = -4256988186343764750L;
	@BDField(value = "cod")
	private Long id;
	@BDField(value = "descricao")
	private String description;
	@BDField(value = "preco_compra")
	private Double purchasePrice;
	@BDField(value = "dt_compra")
	private Date dateOfPurchase;
	@BDField(value = "dt_gravacao")
	private Date recordingDate;
	@BDField(value = "cod_gravadora")
	private RecordCompany rc;
	private List<Track> tracks;
	
	public CD() { super(); }
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Date getRecordingDate() {
		return recordingDate;
	}

	public void setRecordingDate(Date recordingDate) {
		this.recordingDate = recordingDate;
	}

	public RecordCompany getRc() {
		return rc;
	}

	public void setRc(RecordCompany rc) {
		this.rc = rc;
	}
	
}
