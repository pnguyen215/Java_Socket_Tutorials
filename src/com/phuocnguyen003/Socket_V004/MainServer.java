/**
 *
 */
package com.phuocnguyen003.Socket_V004;

import java.io.IOException;

/**
 * @author David Nguyen
 *
 */
public class MainServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Server server = new Server(6060);
		server.start();
	}

}
