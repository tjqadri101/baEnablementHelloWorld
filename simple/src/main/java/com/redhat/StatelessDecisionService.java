package com.redhat;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface StatelessDecisionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StatelessDecisionServiceImpl.class);
	
	public void runRules(Collection<Object> facts, String processId) {
		LOGGER.info("hi!");
		// TODO write code
	}

}
