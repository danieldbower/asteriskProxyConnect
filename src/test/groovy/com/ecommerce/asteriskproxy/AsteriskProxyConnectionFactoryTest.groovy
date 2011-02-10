package com.ecommerce.asteriskproxy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class AsteriskProxyConnectionFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		AsteriskProxyConnectionFactory.createTraceFileInTempDir()
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testConnect() {
		def factory = new AsteriskProxyConnectionFactory()
		assert factory
		 
		def conn = factory.createConnection()
		assert conn
	}

}
