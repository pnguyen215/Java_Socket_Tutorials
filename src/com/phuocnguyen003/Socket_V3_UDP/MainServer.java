package com.phuocnguyen003.Socket_V3_UDP;

import java.net.SocketException;

public class MainServer {

	public static void main(String[] args) {
		CalculatorServer calculatorServer;
		try {
			calculatorServer = new CalculatorServer(1234);
			calculatorServer.start();
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		}

	}

}
