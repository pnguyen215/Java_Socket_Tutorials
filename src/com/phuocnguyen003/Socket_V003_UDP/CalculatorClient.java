package com.phuocnguyen003.Socket_V003_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {
	Scanner scanner = new Scanner(System.in);
	private DatagramSocket datagramSocket;
	private byte[] buffered = null;
	private String contents = "";

	public void methodCalculator(int port) throws IOException {

		datagramSocket = new DatagramSocket();
		InetAddress address = InetAddress.getLocalHost();
		while (true) {
			buffered = new byte[65535];

			System.out.print("Enter the equation in the format: ");

			contents = scanner.nextLine();
			/*
			 * convert the String input into the byte array.
			 */
			buffered = contents.getBytes();
			/*
			 * Create the datagramPacket for sending the data.
			 */
			DatagramPacket datagramPacketSend = new DatagramPacket(buffered, buffered.length, address, port);
			/*
			 * invoke the send call to actually send the data.
			 */
			datagramSocket.send(datagramPacketSend);

			if (contents.equals("exit") || contents.equals("bye")) {
				break;
			}
			buffered = new byte[65535];
			DatagramPacket datagramPacketReceive = new DatagramPacket(buffered, buffered.length);
			/* receive result from sever */
			datagramSocket.receive(datagramPacketReceive);

			System.out.println("Answer: " + new String(buffered, 0, buffered.length));

		}
	}
}
