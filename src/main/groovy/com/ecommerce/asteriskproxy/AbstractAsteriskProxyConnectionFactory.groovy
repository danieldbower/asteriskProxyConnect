package com.ecommerce.asteriskproxy

import org.asteriskjava.manager.*

/**
 * Base class for Creating Asterisk Proxy Connections
 * 
 * Just contains connection info and method for turning on a trace file in the local temp directory.
 */
abstract class AbstractAsteriskProxyConnectionFactory {
	def host = '192.168.56.101'
	def port = 5039
	def user = 'manager'
	def pass = 'password'
	
	abstract def createConnection()
	
	abstract def destroyConnection(mConn)
	
	static void createTraceFileInTempDir(){
		println("Turning on Trace File")
		Properties props= new Properties(System.getProperties());
		props.put("org.asteriskjava.trace", "true");
		Properties newprops = new Properties(props);
		System.setProperties(newprops);
	}
	
	def connectionFromMainArgs(AbstractAsteriskProxyConnectionFactory factory, args){
		if(args && args.size()==1){
			factory.host = args[0]
		}
		 
		factory.createConnection()
	}
}