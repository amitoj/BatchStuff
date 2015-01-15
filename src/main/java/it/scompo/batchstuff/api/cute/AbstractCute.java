package it.scompo.batchstuff.api.cute;

import static it.scompo.batchstuff.utils.ValidationUtils.*;

import java.util.Map;

public abstract class AbstractCute implements Cute {

	private String tableName;

	private Map<MyOperations, String> queries;

	public AbstractCute(String tableName, Map<MyOperations, String> queries) {

		this.tableName = tableName;
		this.queries = queries;
	}

	public String getTableName() {

		return tableName;
	}

	public void setTableName(String tableName) {

		this.tableName = tableName;
	}

	@Override
	public String getFullTableName(String suffix) {

		String implementationTableName = null;

		validateNotNull(suffix, "null suffix");

		implementationTableName = getTableName();

		validateNotNull(implementationTableName, "null tableName");

		return String.format(implementationTableName, suffix);
	}

	@Override
	public String getQuery(MyOperations operation, String suffix) {

		String fullTableName = null;
		String queryToFormat = null;

		fullTableName = getFullTableName(suffix);

		queryToFormat = queries.get(operation);
		validateNotNull(queryToFormat, "query not found");

		return String.format(queryToFormat, fullTableName);
	}

}