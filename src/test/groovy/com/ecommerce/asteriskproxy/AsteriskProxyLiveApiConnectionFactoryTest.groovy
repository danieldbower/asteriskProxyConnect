package com.ecommerce.asteriskproxy

import org.asteriskjava.live.AsteriskServer;
import org.junit.BeforeClass
import org.junit.Test

class AsteriskProxyLiveApiConnectionFactoryTest {
	
	@BeforeClass
	public static void setUpBeforeClass() {
		AsteriskProxyLiveApiConnectionFactory.createTraceFileInTempDir()
	}
	
	@Test
	public void testConnect() {
		def factory = new AsteriskProxyLiveApiConnectionFactory()
		assert factory
		 
		AsteriskServer server = factory.createConnection()
		assert server
		
		def result = server.getQueues()
		
		println result.toString()
		
		assert 0< result.size()
	}
}
