package com.phuocnguyen000.Introduce;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	@Override
	public void run() {
		while (true) {

			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket socket = serverSocket.accept();
				/*
				 * Read content from client
				 */
				System.out.println("Just connected to " + socket.getRemoteSocketAddress());
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				/*
				 *
				 */
				System.out.println(dataInputStream.readUTF());
				/*
				 * Response to client
				 */
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF("Just thank for connecting to " + socket.getLocalSocketAddress());
				socket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
