package com.inkombizz.master.controller.v1;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.master.model.BankModel;
import com.inkombizz.master.model.dto.BankDto;
import com.inkombizz.master.repository.BankRepository;
import com.inkombizz.master.util.Response;

@RestController
@RequestMapping("v1/bank")
public class BankController {
	
	@Autowired
   BankRepository bankDao;
	
	@GetMapping("/")
    public ResponseEntity<?> alldata(@RequestParam String search, String name) {
    	try {
    		if (search.isEmpty()) {  			
    		List<BankModel> banks = bankDao.findAll();
    		List<BankDto> dtos = new ArrayList<>();
    		
    		for (BankModel m :banks) {
    			ModelMapper mapper = new ModelMapper();
        		BankDto dto = mapper.map(m, BankDto.class);
        		dtos.add(dto);
    		}
    			
    		return new Response().response_json(true,"Ok",dtos,HttpStatus.OK);		
//ini untuk nampilin data findata all by parameter    		
//    			return new Response().response_json(true,"Ok",bankDao.findAll(),HttpStatus.OK);	
    		}else
    			//return new Response().response_json(true,"Ok",bankDao.findByBankname(search),HttpStatus.OK);
//    		return new Response().response_json(true,"Ok",bankDao.findByBanknameContaining(search),HttpStatus.OK);
//    			return new Response().response_json(true,"Ok",bankDao.findByBanknameContainingIgnoreCase(search),HttpStatus.OK);
    		return new Response().response_json(true,"Ok",bankDao.findByBankCodeOrName(search,name),HttpStatus.OK);
    	}catch(Exception ex)
	{
		return new Response().response_json(true, "Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
    
    @GetMapping("/{code}")
    public ResponseEntity<?> getByID(@PathVariable String code) {
    	try {    		

    		//  ini digunakan untuk custome data yg di ambil  		
    		ModelMapper mapper = new ModelMapper();
    		BankModel model =bankDao.findById(code).get();
    		BankDto dto = mapper.map(model, BankDto.class);
    		
    		return new Response().response_json(true,"Ok",dto,HttpStatus.OK);
    		
// ini digunakan untuk menampilkan semua data dan relasi tabel nya schema scara menyeluruh    		
//  return new Response().response_json(true,"Ok",bankDao.findById(code),HttpStatus.OK);	
    	}catch(Exception ex) {
            return new Response().response_json(true,"Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);	
    	}
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody BankModel model) {
    	try {
    	//	model.setPassword(encoder.encode(model.getPassword()));
    		bankDao.save(model);	
            return new Response().response_json(true,"Save Success",model,HttpStatus.OK);
    	}catch(Exception ex) {
    		ex.printStackTrace();
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @PutMapping("/{code}")
	public ResponseEntity<?> update(@RequestBody BankModel model,@PathVariable String code) {
    	try {
    		bankDao.save(model);	
            return new Response().response_json(true,"Save Success",model,HttpStatus.OK);
    	}catch(Exception ex) {
    		ex.printStackTrace();
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
    	try {
    		bankDao.deleteById(code);	
            return new Response().response_json(true,"Save Success",null,HttpStatus.OK);
    	}catch(Exception ex) {
            return new Response().response_json(true,"Save Fail",null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
