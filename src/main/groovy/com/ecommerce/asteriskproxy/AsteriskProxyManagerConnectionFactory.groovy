package com.ecommerce.asteriskproxy

import org.asteriskjava.manager.*

class AsteriskProxyManagerConnectionFactory extends AbstractAsteriskProxyConnectionFactory{

	def createConnection(){
		println("Creating Manager Connection")
		def mConn = new ManagerConnectionFactory(host, port, user, pass).createManagerConnection()
		assert mConn

		println("Connection Created, attempting to login")
		mConn.login()
		
		println("Logged In")
		mConn
	}
	
	def destroyConnection(mConn){
		mConn.logoff()
	}
	
	static void main(String[] args){
		connectionFromMainArgs(new AsteriskProxyManagerConnectionFactory(), args)
	}
	
}
