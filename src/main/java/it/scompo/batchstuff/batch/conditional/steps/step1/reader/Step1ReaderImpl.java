package it.scompo.batchstuff.batch.conditional.steps.step1.reader;

import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.services.ConfigurationService;

import java.math.BigInteger;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Step1ReaderImpl implements Step1Reader {

	@Autowired
	private ConfigurationService configurationService;

	private Long count;

	private Long max;

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {

		Configuration conf = null;

		conf = configurationService.getLastConfiguration();

		max = conf.getNumbersToCreate();

		count = 0L;
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
	public BigInteger read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		BigInteger res = null;

		if (!finished()) {

			res = new BigInteger(count.toString());
			count++;
		}

		return res;
	}

	private boolean finished() {

		return max.compareTo(count) > 0;
	}

}
