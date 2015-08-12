package com.ctb.organizer.pilot.link.repository;

import com.ctb.organizer.Application;
import com.ctb.organizer.pilot.link.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 8. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("unit-test")
public class TagRepositoryTests {
	
	@Autowired
	TagRepository tagRepository;
	
	@Test
	@Transactional
	public void test() {
		Tag javaTag = new Tag("java");
		Tag springTag = new Tag("spring");
		Tag springBootTag = new Tag("spring-boot");
		List<Tag> tags = Arrays.asList(javaTag, springTag, springBootTag);
		tagRepository.save(tags);

		List<Tag> found = tagRepository.findAll();
		assertThat(found, is(tags));
		
		found.forEach(t -> System.out.println(t));
	}
	
}
