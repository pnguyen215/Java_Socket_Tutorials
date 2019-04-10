package com.phuocnguyen003.Socket_V3_UDP;

import java.io.IOException;

public class MainClient {

	public static void main(String[] args) {

		CalculatorClient calculatorClient = new CalculatorClient();
		try {
			calculatorClient.methodCalculator(1234);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
