package com.simpz.bitcoder.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring.xml"})
@ActiveProfiles("test")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class BaseTest extends TestCase{
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	
    @BeforeTransaction
    public void verifyInitialDatabaseState() {
    	logger.info("BaseTest.verifyInitialDatabaseState",
    			"BaseTest.verifyInitialDatabaseState","beforeTransaction : verifyInitialDatabaseState");
    }

    @Before
    public void setUpTestDataWithinTransaction() {
        logger.info("BaseTest.setUpTestDataWithinTransaction",
    			"BaseTest.setUpTestDataWithinTransaction","Before : setuptestDataWithTransation");
    }

   
    @AfterTransaction
    public void verifyFinalDatabaseState() {
    	logger.info("BaseTest.verifyFinalDatabaseState",
    			"BaseTest.verifyFinalDatabaseState","afterTransaction : verifyFinalDatabaseState");
    }

	
   @After
    public void tearDownWithinTransaction() {
	   logger.info("BaseTest.tearDownWithinTransaction",
   			"BaseTest.tearDownWithinTransaction","after : tearDownWithinTransaction");
    }
   
   @Test
   public void test(){
       
   }
}