package com.phuocnguyen003.Socket_V003_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

public class CalculatorServer extends Thread {
	private DatagramSocket datagramSocket;
	DatagramPacket datagramPacketReceive = null;
	DatagramPacket datagramPacketSend = null;
	byte[] buffered = null;
	private String contents = "";
	private float result;
	private String result_send;
	private float operand_st;
	private float operand_nd;
	private String operation;

	/*
	 * Create a socket to listen at port
	 */
	public CalculatorServer(int port) throws SocketException {
		datagramSocket = new DatagramSocket(port);
		datagramSocket.setSoTimeout(10000);
	}

	@Override
	public void run() {
		buffered = new byte[65535];

		while (true) {
			/*
			 * create a DatgramPacket to receive the data.
			 */
			datagramPacketReceive = new DatagramPacket(buffered, buffered.length);
			try {
				/*
				 * receive the data in byte buffer.
				 */
				datagramSocket.receive(datagramPacketReceive);
				contents = new String(buffered, 0, buffered.length);
				/*
				 * trim string
				 */
				contents = contents.trim();
				System.out.println("Equation Received: " + contents);
				/*
				 * condition to exit
				 */
				if (contents.equals("exit") || contents.equals("bye")) {
					break;
				}
				/*
				 * Use StringTokenizer to break the equation into operand and operation
				 */
				StringTokenizer stringTokenizer = new StringTokenizer(contents);

				operand_st = Float.parseFloat(stringTokenizer.nextToken());
				operation = stringTokenizer.nextToken();
				operand_nd = Float.parseFloat(stringTokenizer.nextToken());

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

				result_send = Float.toString(result);
				/*
				 * Clear the buffer after every message.
				 */
				buffered = result_send.getBytes();
				/*
				 * get the port of client.
				 */
				int port = datagramPacketReceive.getPort();

				datagramPacketSend = new DatagramPacket(buffered, buffered.length, InetAddress.getLocalHost(), port);
				/*
				 * send result to client
				 */
				datagramSocket.send(datagramPacketSend);

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
