package com.inkombizz.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkombizz.master.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
		
//	List<BankModel> findByBankname(String bankname);
	
	Bank findByName(String name);
	
	List<Bank> findByNameContaining(String name);
	//untuk pencarian like by name cuma case sensitive
	
	List<Bank> findByNameContainingIgnoreCase(String name);
	//untuk pencarian like by name yg tidak sensitive
	
//	@Query("select c from BankModel c "
//			+ " where c.email =:s_email: "
//			+ " or c.bankname=:s_bankname: ") 
	@Query("select c from Bank c "
			+ "where c.code  like %:s_code% "
			+ "or c.name like %:s_name% ")
	List<Bank> findByBankCodeOrName(String s_code, String s_name);
	//untuk pencarian like by name yg tidak sensitive
}
