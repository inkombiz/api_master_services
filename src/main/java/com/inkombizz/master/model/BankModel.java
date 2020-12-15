package com.inkombizz.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mst_bank")
public class BankModel {
	@Id
    @Column(name = "Code")
    private String code;

    @NotBlank(message = "username tidak boleh kosong")
    @Column(name = "Name")
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @JsonIgnore
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column()
    @LastModifiedDate
    private Date updatedDate;
    
// 		@Digits UNTUUK number
// 		@CreditCardNumber untuk check cc
//		@Min(18) untuk check minimal umur atau minimal number
    
//    	@Past untuk check tanggal d masa lalu
//    	date tanggal lahir;
    
//		@Future untuk check tanggal dari hari ini sampai kedepannya    
// 		Date tglsometing
}
