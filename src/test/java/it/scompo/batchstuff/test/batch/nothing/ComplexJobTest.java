package it.scompo.batchstuff.test.batch.nothing;

import static org.junit.Assert.*;
import it.scompo.batchstuff.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ComplexJobTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}