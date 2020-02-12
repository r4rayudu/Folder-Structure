package com.ds.datastructure.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ds.datastructure.model.Root;

@Repository
public interface RootRepository extends JpaRepository<Root, Long>{
	List<Root> findByRootName(String root_name);
}
