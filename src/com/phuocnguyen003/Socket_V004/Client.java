package com.phuocnguyen003.Socket_V004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	/**
	 * * Runs the client as an application. First it displays a dialog * box asking
	 * for the IP address or host-name of a host running * the date server, then
	 * connects to it and displays the date that * it serves.
	 *
	 */
	public void greetingClient(int port) {
		String severAddress;
		String output;
		severAddress = JOptionPane.showInputDialog(
				"Enter IP Address of a machine that is\n" + "\"running the date service on port " + port);
		/*
		 * create new socket
		 */
		try {
			Socket socket = new Socket(severAddress, port);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = bufferedReader.readLine();
			JOptionPane.showMessageDialog(null, output);
			socket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
