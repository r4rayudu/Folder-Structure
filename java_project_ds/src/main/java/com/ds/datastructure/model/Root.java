package com.ds.datastructure.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="root")
public class Root {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "root_id")
	private Long id;
	
	@Column(name = "root_name")
	private String rootName;
	
	@OneToMany(mappedBy="root")
	private Set<Directory> directory;
	
	public Root() {
		
	}
	
	public Root(String rootName) {
		this.rootName = rootName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public Set<Directory> getDirectory() {
		return directory;
	}

	public void setDirectory(Set<Directory> directory) {
		this.directory = directory;
	}

	@Override
	public String toString() {
		return "Root [id=" + id + ", rootName=" + rootName + ", directory=" + directory + "]";
	}
	
}
