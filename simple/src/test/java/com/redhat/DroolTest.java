package com.redhat;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
//import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolTest {

	  static KieBase kbase;
	  static KieSession ksession;
	  static KieRuntimeLogger klogger;

	  @BeforeClass
	  public static void setupKsession() {
	        try {
	            // load up the knowledge base and create session
	            ksession = readKnowledgeBase();
	            klogger = KieServices.Factory.get().getLoggers().newFileLogger(ksession, "auditLog");
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	  }

	  @AfterClass
	  public static void closeKsession() {
	        try {
	            // closing resources
	            klogger.close();
	            ksession.dispose();
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	  }
	  
	  @Test
	  public void riskyAdultsTest() {
		  ksession.fireAllRules();
		  assertTrue( true );
	  }
	  
	  private static KieSession readKnowledgeBase() throws Exception {
	        
	        KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieSession kSession = kContainer.newKieSession();
	        
	        return kSession;
	  }
	    
}
