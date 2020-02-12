package com.ds.datastructure.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="directory")
public class Directory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dir_id")
	private Long id;
	
	@Column(name = "dir_name")
	private String dirname;
	
	@Column(name = "sub_dir_id")
	private Long subDirId;
	
	@Column(name = "sub_dir_name")
	private String subDirName;
	
	@ManyToOne
    @JoinColumn(name="root_id", nullable=true)
    private Root root;
	
	@OneToMany(mappedBy="directory")
	private Set<Filelists> file;

	public Directory() {
		
	}
	
	public Directory(String dirname, Root root) {
		this.dirname = dirname;
		this.root = root;
	}
	
	public Directory(String dirname,Long subDirId,String subDirName, Root root) {
		this.dirname = dirname;
		this.subDirId = subDirId;
		this.subDirName = subDirName;
		this.root = root;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}

	public Long getSubDirId() {
		return subDirId;
	}

	public void setSub_dir_id(Long subDirId) {
		this.subDirId = subDirId;
	}

	public String getSubDirName() {
		return subDirName;
	}

	public void setSubDirName(String subDirName) {
		this.subDirName = subDirName;
	}
	
}
