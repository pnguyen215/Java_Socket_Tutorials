package com.phuocnguyen000.Introduce;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void greetingClient(String serverName, String portString) throws UnknownHostException, IOException {
		/*
		 * convert string to number port
		 */
		int port;
		port = Integer.parseInt(portString);
		/*
		 *
		 */
		System.out.println("Connecting to " + serverName + " on port " + port);
		/*
		 *
		 */
		Socket socket = new Socket(serverName, port);
		/*
		 *
		 */
		System.out.println("Just connected to " + socket.getRemoteSocketAddress());
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		/*
		 *
		 */
		dataOutputStream.writeUTF("Hello from " + socket.getLocalSocketAddress());
		InputStream inputStream = socket.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		/*
		 *
		 */
		System.out.println("Server says " + dataInputStream.readUTF());
		socket.close();

	}
}
