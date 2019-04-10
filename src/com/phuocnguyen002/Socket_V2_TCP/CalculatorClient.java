package com.phuocnguyen002.Socket_V2_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
	Scanner scanner = new Scanner(System.in);
	private String contents = "";
	private String result = "";

	public void methodCalculator(int port) throws IOException {

		InetAddress inetAddress = InetAddress.getLocalHost();
		/*
		 * open the socket connection
		 */
		Socket socket = new Socket(inetAddress, port);
		/*
		 * Communication-get the input and output stream
		 */
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		/*
		 * processing
		 */
		while (true) {
			System.out.print("Enter the equation in the form: ");
			contents = scanner.nextLine();
			if (contents.equals("bye") || contents.equals("exit")) {
				break;
			}
			/*
			 * send the equation to server
			 */
			dataOutputStream.writeUTF(contents);
			/*
			 * wait till request is processed and sent back to client
			 */
			result = dataInputStream.readUTF();
			System.out.println("Answer: " + result);
		}
		socket.close();
	}
}
