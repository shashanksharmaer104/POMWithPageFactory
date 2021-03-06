package com.test.frameworks.POMWithPageFactory.utility;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.test.frameworks.POMWithPageFactory.base.TestBase;

public class Log {
	
	public static void startTestCase(String sTestCaseName){

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$         "+/*sTestCaseName*/ "-S---T---A---R---T-" + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		}
	
	public static void endTestCase(String sTestCaseName){

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");
		
		}
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void info(String message) {
		log.info(message);
		TestBase.logger.log(Status.INFO, message);
	}
	
	public static void error(String message) {
		log.info(message);
	}
	
	public static void warn(String message) {
		log.info(message);
	}
	
	public static void fatal(String message) {
		log.info(message);
	}
	
	public static void debug(String message) {
		log.info(message);
	}
	
}
