package it.scompo.batchstuff.api.executions.services;

import it.scompo.batchstuff.api.executions.beans.Execution;

public interface ExecutionService {

	Execution save(Execution execution);

	Execution getLastExecution();

}
