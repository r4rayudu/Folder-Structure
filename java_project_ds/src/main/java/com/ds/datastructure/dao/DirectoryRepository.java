package com.ds.datastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ds.datastructure.model.Directory;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long>, DirectoryRepositoryCustom {

}
