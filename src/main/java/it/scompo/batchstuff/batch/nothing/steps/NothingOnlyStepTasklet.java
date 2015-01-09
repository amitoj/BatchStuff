package it.scompo.batchstuff.batch.nothing.steps;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class NothingOnlyStepTasklet  implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		
		System.err.println("doing nothing");
		return RepeatStatus.FINISHED;
	}

}
