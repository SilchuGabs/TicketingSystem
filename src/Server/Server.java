package Server;

// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Server class
public class Server
{
	public static void main(String[] args) throws IOException
	{
		// server is listening on port 5056
		// free port
		ServerSocket serverSocket = new ServerSocket(4444);

		System.out.println("Ticketing System Server running...");
		// running infinite loop for getting
		// client request
		while (true)
		{
			Socket socketConnection = null;

			try
			{
				// socket object to receive incoming client requests
				socketConnection = serverSocket.accept();

				System.out.println("A new client is connected : " + socketConnection);

				// obtaining input and out streams
				DataInputStream dis = new DataInputStream(socketConnection.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketConnection.getOutputStream());

				System.out.println("Assigning new thread for this client");

				// create a new thread object
				Thread t = new ServerClientHandler(socketConnection, dis, dos);

				// Invoking the start() method
				t.start();

			}
			catch (Exception e){
				socketConnection.close();
				e.printStackTrace();
			}
		}
	}
}