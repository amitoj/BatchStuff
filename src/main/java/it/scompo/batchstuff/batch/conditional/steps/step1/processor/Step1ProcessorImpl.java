package it.scompo.batchstuff.batch.conditional.steps.step1.processor;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class Step1ProcessorImpl implements Step1Processor {

	@Override
	public BigInteger process(BigInteger item) throws Exception {
		
		return item;
	}

}
