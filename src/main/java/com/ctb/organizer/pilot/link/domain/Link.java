package com.ctb.organizer.pilot.link.domain;

import com.ctb.organizer.core.domain.OrganizingTarget;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by izeye on 15. 8. 12..
 */
@Entity
@Data
@ToString(callSuper = true)
public class Link extends OrganizingTarget {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String url;
	
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Tag> tags;
	
	public Link() {
	}
	
	public Link(String url, String title, List<Tag> tags) {
		this.url = url;
		this.title = title;
		this.tags = tags;
	}
	
}
