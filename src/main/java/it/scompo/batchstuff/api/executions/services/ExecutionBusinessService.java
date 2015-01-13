package it.scompo.batchstuff.api.executions.services;

import it.scompo.batchstuff.api.executions.beans.Execution;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExecutionBusinessService extends HashMap<Long, Execution>
		implements ExecutionService {

	private static final long serialVersionUID = -4347406677091435969L;

	private AtomicLong idGenerator = new AtomicLong();

	public ExecutionBusinessService() {
		super();
	}

	@Override
	public Execution save(Execution execution) {

		execution.setId(idGenerator.getAndIncrement());

		put(execution.getId(), execution);
		return execution;
	}

	@Override
	public Execution getLastExecution() {

		return get(idGenerator.get() - 1);
	}

}
