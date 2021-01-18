package com.inkombizz.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkombizz.master.model.AssetCategory;

@Repository
public interface AssetCategoryRepository extends JpaRepository<AssetCategory, String>{
AssetCategory findByName(String name);
	
	List<AssetCategory> findByNameContaining(String name);
	//untuk pencarian like by name cuma case sensitive
	
	List<AssetCategory> findByNameContainingIgnoreCase(String name);
	//untuk pencarian like by name yg tidak sensitive
	
//	@Query("select c from AssetCategoryModel c "
//			+ " where c.email =:s_email: "
//			+ " or c.bankname=:s_bankname: ") 
	@Query("select c from AssetCategoryModel c "
			+ "where c.code  like %:s_code% "
			+ "or c.name like %:s_name% ")
	List<AssetCategory> findByAssetCategoryCodeOrName(String s_code, String s_name);
	//untuk pencarian like by name yg tidak sensitive
}
