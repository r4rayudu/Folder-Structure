package com.ds.datastructure.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class Filelists {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "file_id")
	private Long id;
	
	@Column(name = "file_name")
	private String filename;
	
	@ManyToOne
    @JoinColumn(name="dir_id", nullable=true)
    private Directory directory;
	
	public Filelists() {
		
	}
	
	public Filelists(String filename, Directory directory) {
		this.filename = filename;
		this.directory = directory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
}
