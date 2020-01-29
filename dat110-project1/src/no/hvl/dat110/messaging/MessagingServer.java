package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MessagingServer {

	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public Connection accept() {

		Connection connection = null;

<<<<<<< HEAD
		// TODO
		// accept TCP connection on welcome socket and create messaging connection
		try {
			connection = new Connection(welcomeSocket.accept());
		} catch (IOException ex) {
			ex.printStackTrace();
=======
		
		try {
			connection = new Connection(welcomeSocket.accept());
		} catch (IOException e) {
			e.printStackTrace();
>>>>>>> a901265824bb39cc543512373769ef7eb90de4eb
		}

		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
