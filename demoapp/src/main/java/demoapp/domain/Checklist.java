package demoapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Checklist")
public class Checklist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4350365833259734770L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Size(min=1, max=50)
	@Column(name="name")	
	private String name;
	
	@NotNull
	@Column(name="lastModified")
	private Date lastModified;
	
	@OneToMany
	@JoinColumn(name="checklistId")
	private Set<ChecklistItem> items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Set<ChecklistItem> getChecklistItems() {
		return items;
	}

	public void setChecchecklistItemsklistItems(Set<ChecklistItem> checklistItems) {
		this.items = checklistItems;
	}
	
	
	
}
