package com.phuocnguyen000.Introduce;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try {
			Server thread = new Server(port);
			thread.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
