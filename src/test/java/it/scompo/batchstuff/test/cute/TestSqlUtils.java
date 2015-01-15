package it.scompo.batchstuff.test.cute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.api.cute.MyObjects;
import it.scompo.batchstuff.api.cute.MyOperations;
import it.scompo.batchstuff.api.cute.SqlUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestSqlUtils {

	private static final String TEST_SUFFIX = "123";

	private static final String EXPECTED_CREATE_TABLE = "create table test_terreno_123 (id bigint, data character varying)";

	@Autowired
	private SqlUtils sqlUtils;

	@Test
	public void testGetExistent() {

		String res = null;

		res = sqlUtils.getQueryFor(MyObjects.TERRENI, MyOperations.CREATE_TABLE,
				TEST_SUFFIX);
		
		assertNotNull(res);

		assertEquals(EXPECTED_CREATE_TABLE.toUpperCase(), res.toUpperCase());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNotExistent() {

		sqlUtils.getQueryFor(MyObjects.TERRENI, MyOperations.DELETE,
				TEST_SUFFIX);
	}

}
