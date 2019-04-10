package com.phuocnguyen002.Socket_V2_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CalculatorServer extends Thread {
	private ServerSocket serverSocket;
	private String contents = "";
	private String operation;
	private float result;
	private int operand_st;
	private int operand_nd;

	public CalculatorServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}

	@Override
	public void run() {
		try {
			/*
			 * Establish the socket connection.
			 */
			Socket socket = serverSocket.accept();
			/*
			 * Processing the request.
			 */
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				/*
				 * wait for input
				 */
				contents = dataInputStream.readUTF();
				if (contents.equals("exit") || contents.equals("bye")) {
					break;
				}
				System.out.println("Equation received: " + contents);
				/*
				 * Use StringTokenizer to break the equation into operand and operation
				 */
				StringTokenizer stringTokenizer = new StringTokenizer(contents);
				/*
				 * handling
				 */
				operand_st = Integer.parseInt(stringTokenizer.nextToken());
				operation = stringTokenizer.nextToken();
				operand_nd = Integer.parseInt(stringTokenizer.nextToken());
				/*
				 * perform the required operation.
				 */
				if (operation.equals("+")) {
					result = operand_st + operand_nd;
				} else if (operation.equals("-")) {
					result = operand_st - operand_nd;
				} else if (operation.equals("*")) {
					result = operand_st * operand_nd;
				} else if (operation.equals("/")) {
					result = operand_st / operand_nd;
				} else if (operation.equals("^")) {
					result = (float) Math.pow(operand_st, operand_nd);
				}
				System.out.println("Sending the result...");
				/*
				 * send the result back to the client.
				 */
				dataOutputStream.writeUTF(Float.toString(result));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
