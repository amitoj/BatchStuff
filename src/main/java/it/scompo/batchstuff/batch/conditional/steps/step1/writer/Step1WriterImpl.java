package it.scompo.batchstuff.batch.conditional.steps.step1.writer;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.stereotype.Component;

@Component
public class Step1WriterImpl implements Step1Writer {

	private static final Logger logger = LoggerFactory
			.getLogger(Step1WriterImpl.class);

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(List<? extends BigInteger> items) throws Exception {

		for (BigInteger bigInteger : items) {

			logger.debug("Step1WriterImpl" + bigInteger);
		}
	}

}
