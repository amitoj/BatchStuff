package it.scompo.batchstuff.batch.conditional.steps.step3;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Step3Taskletmpl implements Step3Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
