package demoapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="checklistItem")
public class ChecklistItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7170998058503845600L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Column(name="checklistId")
	private Integer checklistId;
	
	
	@NotNull
	@Size(min=1, max=50)
	@Column(name="name")	
	private String name;
	
	@NotNull
	@Column(name="lastModified")
	private Date lastModified;
	
	@Column(name="completed")
	private Date completed;

	
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

	public Integer getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	public Date getCompleted() {
		return completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}

	
}
