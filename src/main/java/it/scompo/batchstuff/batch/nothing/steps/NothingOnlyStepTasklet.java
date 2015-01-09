package it.scompo.batchstuff.batch.nothing.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class NothingOnlyStepTasklet  implements Tasklet{
	
	private static final Logger logger = LoggerFactory.getLogger(NothingOnlyStepTasklet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		
		doNothing();
		
		return RepeatStatus.FINISHED;
	}
	
	public static void doNothing(){
		
		logger.info("doing nothing..");
	}

}
