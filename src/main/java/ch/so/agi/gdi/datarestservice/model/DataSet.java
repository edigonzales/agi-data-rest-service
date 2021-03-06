package ch.so.agi.gdi.datarestservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "data_set")
@Table(schema = "gdi_knoten")
public class DataSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gdi_oid")
	private Long gdiOid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "data_set_name")
	private String dataSetName;

	public Long getGdiOid() {
		return gdiOid;
	}

	public void setGdiOid(Long gdiOid) {
		this.gdiOid = gdiOid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataSetName() {
		return dataSetName;
	}

	public void setDataSetName(String dataSetName) {
		this.dataSetName = dataSetName;
	}
	
	@ManyToOne
	@JoinColumn(name = "gdi_oid_data_source")
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}
	
	@OneToMany(mappedBy = "dataSet")
	private List<DataSetView> dataSetViews = new ArrayList<DataSetView>();
}