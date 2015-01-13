package it.scompo.batchstuff.batch.conditional.steps.step2.listener;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.stereotype.Component;

@Component
public class Step2ListenerImpl implements Step2Listener {

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
