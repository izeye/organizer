package com.ctb.organizer.pilot.link.domain;

import com.ctb.organizer.core.domain.TimestampManaged;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 15. 8. 12..
 */
@Entity
@Data
@ToString(callSuper = true)
public class Tag extends TimestampManaged {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String name;
	
	public Tag() {
	}
	
	public Tag(String name) {
		this.name = name;
	}
	
}
