package it.scompo.batchstuff.api.cute;

import java.util.HashMap;
import java.util.Map;

public class TerreniSql extends AbstractCute implements Cute {

	private static final String TABLE_NAME = "test_terreno_%s";

	private static final String QUERY_CREATE = "create table %s (id bigint, data character varying)";

	private static final Map<MyOperations, String> terreniQueries = new HashMap<MyOperations, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(MyOperations.CREATE_TABLE, QUERY_CREATE);
		}

	};

	public TerreniSql() {

		super(TABLE_NAME, terreniQueries);
	}

}
