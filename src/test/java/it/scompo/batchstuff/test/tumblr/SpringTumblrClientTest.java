package it.scompo.batchstuff.test.tumblr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.api.tumblr.client.SpringTumblrClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tumblr.jumblr.types.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Ignore("not sharing my data so it would not work on ci..")
public class SpringTumblrClientTest {

	private static final String EXPECTED_USER = "scompo";
	
	@Autowired
	private SpringTumblrClient springTumblrClient;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser() {

		User res = springTumblrClient.user();

		assertNotNull(res);

		assertEquals(EXPECTED_USER, res.getName());
	}

}
