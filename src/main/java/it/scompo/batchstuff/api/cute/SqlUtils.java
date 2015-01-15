package it.scompo.batchstuff.api.cute;

import java.util.HashMap;
import java.util.Map;

public class SqlUtils {

	private static Map<MyObjects, Cute> implementations = new HashMap<MyObjects, Cute>() {

		private static final long serialVersionUID = -8590470597041172139L;

		{
			put(MyObjects.TERRENI, new TerreniSql());
		}
	};

	public static Map<MyObjects, Cute> getImplementations() {
		return implementations;
	}

	public static void setImplementations(Map<MyObjects, Cute> implementations) {
		SqlUtils.implementations = implementations;
	}

	public String getQueryFor(MyObjects object, MyOperations operation,
			String suffix) {

		String res = null;

		res = implementations.get(object).getQuery(operation, suffix);

		return res;
	}

}
