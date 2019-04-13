package com.phuocnguyen003.Socket_V004;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Thread {
	/**
	 * * A TCP server that runs on 'port'. When a client connects, it * sends the
	 * client the current date and time, then closes the * connection with that
	 * client. Arguably just about the simplest * server you can write.
	 */
	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
			try {
				Socket socket = serverSocket.accept();
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				/*
				 * print out
				 */
				printWriter.print(new Date().toString());
				socket.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
