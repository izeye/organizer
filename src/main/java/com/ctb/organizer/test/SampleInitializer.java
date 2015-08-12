package com.ctb.organizer.test;

import com.ctb.organizer.pilot.link.domain.Link;
import com.ctb.organizer.pilot.link.domain.Tag;
import com.ctb.organizer.pilot.link.repository.LinkRepository;
import com.ctb.organizer.pilot.link.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by izeye on 15. 8. 12..
 */
@Component
@Profile("!unit-test")
public class SampleInitializer {

	@Autowired
	LinkRepository linkRepository;

	@Autowired
	TagRepository tagRepository;

	@PostConstruct
	public void loadSamples() {
		Tag javaTag = new Tag("java");
		Tag springTag = new Tag("spring");
		Tag springBootTag = new Tag("spring-boot");
		List<Tag> tags = Arrays.asList(javaTag, springTag, springBootTag);
		tagRepository.save(tags);

		Link javaLink = new Link("https://www.oracle.com/", "Java",
				Arrays.asList(javaTag));
		Link springLink = new Link("https://spring.io/", "Spring",
				Arrays.asList(springTag, javaTag));
		Link springBootLink = new Link("http://projects.spring.io/spring-boot/", "Spring Boot",
				Arrays.asList(springBootTag, springTag, javaTag));
		List<Link> links = Arrays.asList(javaLink, springLink, springBootLink);
		linkRepository.save(links);
	}
	
}
