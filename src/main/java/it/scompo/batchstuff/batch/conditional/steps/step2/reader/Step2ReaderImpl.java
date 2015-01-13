package it.scompo.batchstuff.batch.conditional.steps.step2.reader;

import java.math.BigInteger;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class Step2ReaderImpl implements Step2Reader {

	@Override
	public BigInteger read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
