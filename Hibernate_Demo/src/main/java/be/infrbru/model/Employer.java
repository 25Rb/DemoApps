package be.infrbru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_WERKGEVER")
public class Employer {

	@Id
	private String id;

	@Column(name = "WGR_NR")
	private String wgrNr;

	@Column(name = "NAAM")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWgrNr() {
		return wgrNr;
	}

	public void setWgrNr(String wgrNr) {
		this.wgrNr = wgrNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
