package com.ecommerce.asteriskproxy

import org.asteriskjava.live.*;

class AsteriskProxyLiveApiConnectionFactory extends AbstractAsteriskProxyConnectionFactory{
	def createConnection(){
		println("Creating Manager Connection")
		def server = new DefaultAsteriskServer(host, port, user, pass)
		assert server
		
		println("Connection Created")
		server
	}
	
	def destroyConnection(server){
		server.shutdown()
	}
	
	static void main(String[] args){
		connectionFromMainArgs(new AsteriskProxyLiveApiConnectionFactory(), args)
	}
}
