package com.faltdor.recipe.domain.config;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class AbstractDomainClass implements IDomainObject{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Version
	private Integer version;
	
	private Date dateCreated;
    private Date lastUpdated;
    
	@Override
	public Integer getId() {
		 return this.id;
	}

	@Override
	public void setId(Integer id) {
		 this.id = id;
	}
	
	@PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }

}
