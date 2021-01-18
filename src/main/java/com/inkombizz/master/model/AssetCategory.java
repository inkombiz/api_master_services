package com.inkombizz.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inkombizz.master.util.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mst_asset_category")
public class AssetCategory {
	
	@Id
    @Column(name = "Code")
    private String code;

    @NotBlank(message = "ASset Category Name tidak boleh kosong")
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Remark")
    private String remark;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ActiveStatus")
    private StatusEnum activeStatus;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @JsonIgnore
    @CreatedDate
    private Date createdDate;
    
    @Column(name = "CreatedBy")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    @DateTimeFormat
    private Date inActiveDate;
    
    @Column(name = "InActiveBy")
    private String InActiveBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column()
    @LastModifiedDate
    private Date updatedDate;
    
    @Column(name = "UpdatedBy")
    private String updatedBy;
}
