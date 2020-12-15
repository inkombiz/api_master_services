package com.inkombizz.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkombizz.master.model.BankModel;

@Repository
public interface BankRepository extends JpaRepository<BankModel, String> {
		// filter search by bankname
	
//	List<BankModel> findByBankname(String bankname);
	
	BankModel findByBankname(String bankname);
	
	List<BankModel> findByBanknameContaining(String bankname);
	//untuk pencarian like by name cuma case sensitive
	
	List<BankModel> findByBanknameContainingIgnoreCase(String bankname);
	//untuk pencarian like by name yg tidak sensitive
	
//	@Query("select c from BankModel c "
//			+ " where c.email =:s_email: "
//			+ " or c.bankname=:s_bankname: ") 
	@Query("select c from BankModel c "
			+ "where c.email  like %:s_email% "
			+ "or c.bankname like %:s_bankname% ")
	List<BankModel> findByBanknameOrEmail(String s_bankname, String s_email);
	//untuk pencarian like by name yg tidak sensitive
}
