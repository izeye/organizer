package com.ctb.organizer.core.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by izeye on 15. 8. 12..
 */
@MappedSuperclass
@Data
public abstract class TimestampManaged {
	
	private Date createdTime;
	private Date modifiedTime;
	private Date deletedTime;

	@PrePersist
	private void onCreate() {
		setCreatedTime(new Date());
	}

	@PreUpdate
	private void onUpdate() {
		setModifiedTime(new Date());
	}
	
}
