package it.scompo.batchstuff.batch.primes.steps.generation.listener;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.stereotype.Component;

@Component
public class PrimeGenerationStepExecutionListenerImpl implements
		PrimeGenerationStepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {

		Map<String, JobParameter> jobParameters = stepExecution
				.getJobParameters().getParameters();

		for (Entry<String, JobParameter> entry : jobParameters.entrySet()) {

			String key = entry.getKey();
			JobParameter value = entry.getValue();

			stepExecution.getExecutionContext().put(key, value.getValue());
		}
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		return stepExecution.getExitStatus();
	}

}
