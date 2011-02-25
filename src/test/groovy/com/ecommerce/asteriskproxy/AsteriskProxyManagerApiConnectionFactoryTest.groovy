package com.ecommerce.asteriskproxy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.asteriskjava.manager.action.*
import org.asteriskjava.manager.event.*;
import org.asteriskjava.manager.response.*

class AsteriskProxyManagerApiConnectionFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		AsteriskProxyManagerApiConnectionFactory.createTraceFileInTempDir()
	}

	@Test
	public void testConnect() {
		def factory = new AsteriskProxyManagerApiConnectionFactory()
		assert factory
		 
		def conn = factory.createConnection()
		assert conn
		
		def result = listCommands(conn)
		
		println result.toString()
		
		assert 0< result.size()
	}
	
	/**
	 * Get the possible Actions from Asterisk as a way to test the connection is *REALLY* up.
	 */
	def listCommands(mConn){
		def commands = []
		def action = new ListCommandsAction()
		def response = mConn.sendAction(action, 10000L)
		response.getAttributes().each{
			commands << it.toString()
		}
		commands
	}

}
