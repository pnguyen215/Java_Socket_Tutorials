package com.phuocnguyen002.Socket_V002_TCP;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) {
		try {
			CalculatorServer calculatorServer = new CalculatorServer(4444);
			calculatorServer.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
