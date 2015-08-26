package com.redhat;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StatelessDecisionServiceImpl implements StatelessDecisionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatelessDecisionServiceImpl.class);
	private static KieBase kbase;
    private static KieSession ksession;
    private static KieRuntimeLogger klogger;
    
    private static void setupKsession() {
        try {
            // load up the knowledge base and create session
            ksession = readKnowledgeBase();
            klogger = KieServices.Factory.get().getLoggers().newFileLogger(ksession, "audit");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
    private static void closeKsession() {
        try {
            // closing resources
            klogger.close();
            ksession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
	public void runRules(Collection<Object> facts, String processId) {
		LOGGER.info("hi!");
		// TODO write code
	}

	private static KieSession readKnowledgeBase() throws Exception {
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();
        
        return kSession;
    }
}
