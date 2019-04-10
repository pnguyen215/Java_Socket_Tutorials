package com.phuocnguyen002.Socket_V2_TCP;

import java.io.IOException;

public class MainClient {

	public static void main(String[] args) {
		CalculatorClient calculatorClient = new CalculatorClient();

		try {
			calculatorClient.methodCalculator(4444);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
