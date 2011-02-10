package com.ecommerce.asteriskproxy

import org.asteriskjava.manager.*

class AsteriskProxyConnectionFactory {
	static def host = '192.168.56.101'
	static def port = 5039
	static def user = 'manager'
	static def pass = 'password'

	static void main(){
		def factory = new AsteriskProxyConnectionFactory() 
		factory.createConnection()
	}
	
	def createConnection(){
		println("Creating Manager Connection")
		def mConn = new ManagerConnectionFactory(host, port, user, pass).createManagerConnection()
		assert mConn

		println("Connection Created, attempting to login")
		mConn.login()
		
		println("Logged In")
		mConn
	}

	static void createTraceFileInTempDir(){
		println("Turning on Trace File")
		Properties props= new Properties(System.getProperties());
		props.put("org.asteriskjava.trace", "true");
		Properties newprops = new Properties(props);
		System.setProperties(newprops);
	}
}