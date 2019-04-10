package com.phuocnguyen000.Introduce;

import java.io.IOException;
import java.net.UnknownHostException;

public class MainClient {

	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.greetingClient(args[0], args[1]);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
