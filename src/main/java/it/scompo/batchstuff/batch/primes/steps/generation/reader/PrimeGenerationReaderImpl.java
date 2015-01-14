package it.scompo.batchstuff.batch.primes.steps.generation.reader;

import static it.scompo.batchstuff.batch.primes.PrimeJobConfiguration.PRIME_GENERATION_START_NUMBER_PARAM_NAME;
import static it.scompo.batchstuff.batch.primes.PrimeJobConfiguration.PRIME_GENERATION_STOP_NUMBER_PARAM_NAME;

import java.math.BigInteger;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

public class PrimeGenerationReaderImpl implements PrimeGenerationReader {

	private BigInteger startNumber;
	private BigInteger stopNumber;

	private BigInteger currentNumber;

	public PrimeGenerationReaderImpl() {

	}

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {

		currentNumber = startNumber;
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {

	}

	@Override
	public void close() throws ItemStreamException {

	}

	@Override
	public BigInteger read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		if (currentNumber.compareTo(stopNumber) >= 0) {

			return null;

		} else {

			currentNumber = currentNumber.add(BigInteger.ONE);

			return currentNumber.subtract(BigInteger.ONE);
		}
	}

	public BigInteger getStartNumber() {
		return startNumber;
	}

	@Value(value = "#{jobParameters['" + PRIME_GENERATION_START_NUMBER_PARAM_NAME
			+ "']}")
	public void setStartNumber(BigInteger startNumber) {
		this.startNumber = startNumber;
	}

	public BigInteger getStopNumber() {
		return stopNumber;
	}

	@Value(value = "#{jobParameters['" + PRIME_GENERATION_STOP_NUMBER_PARAM_NAME
			+ "']}")
	public void setStopNumber(BigInteger stopNumber) {
		this.stopNumber = stopNumber;
	}

}
