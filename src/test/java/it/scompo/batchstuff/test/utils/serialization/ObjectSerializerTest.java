package it.scompo.batchstuff.test.utils.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.scompo.batchstuff.utils.ObjectSerializationUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjectSerializerTest {

	private static final Long TEST_ID = 1L;
	private static final String TEST_NAME = "testName";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertObjectIntoString() {

		TestObjectSerializable objToSerialize = null;
		TestObjectSerializable deserialized = null;

		String res = null;

		objToSerialize = new TestObjectSerializable();
		objToSerialize.setId(TEST_ID);
		objToSerialize.setName(TEST_NAME);

		res = ObjectSerializationUtils.convertObjectIntoString(objToSerialize);

		assertNotNull(res);

		deserialized = ObjectSerializationUtils.deserialize(res,
				TestObjectSerializable.class);

		assertEquals(deserialized, objToSerialize);
	}

}
