package it.scompo.batchstuff.batch.conditional.steps.step3;

import it.scompo.batchstuff.batch.commons.CopyStepExecutionListener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Step3Taskletmpl implements Step3Tasklet {

	private CopyStepExecutionListener stepExecutionCopyListener = new CopyStepExecutionListener();

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {

		stepExecutionCopyListener.beforeStep(stepExecution);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		return stepExecutionCopyListener.afterStep(stepExecution);
	}

}
