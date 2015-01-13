package it.scompo.batchstuff.api.configurations.services;

import it.scompo.batchstuff.api.configurations.beans.Configuration;

public interface ConfigurationService {

	Configuration save(Configuration configuration);

	Configuration getLastConfiguration();

}
