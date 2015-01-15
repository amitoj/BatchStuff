package it.scompo.batchstuff.api.cute;

public interface Cute {

	String getFullTableName(String suffix);

	String getQuery(MyOperations operation, String suffix);
}
