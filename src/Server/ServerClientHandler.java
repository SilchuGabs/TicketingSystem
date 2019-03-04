package Server;

import Model.RegisteredUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// ClientHandler class
class ServerClientHandler extends Thread
{
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	final DataInputStream dis;
	final DataOutputStream dos;
	final Socket s;

	// Connect to Database

	// Constructor
	public ServerClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
	{
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void run()
	{
		String received;
		String toreturn;

		TicketingSystemOptions ticketOptions = new TicketingSystemOptions();
		RegisteredUser registeredUser= new RegisteredUser();
		while (true)
		{
			try {

				// Ask user what he wants
				dos.writeUTF("This is the Thread....(should do all the database operations for your project)...\nWhat do you want?[Date | Time| Book | Cancel]..\n"+
						"Type Exit to terminate connection.");

				// receive the answer from client
				received = dis.readUTF();

				if(received.equals("Exit"))
				{
					System.out.println("Client " + this.s + " sends exit...");
					System.out.println("Closing this connection.");
					this.s.close();
					System.out.println("Connection closed");
					break;
				}

				// creating Date object
				Date date = new Date();

				// write on output stream based on the
				// answer from the client
				switch (received) {

					case "Date" :
						toreturn = fordate.format(date);
						dos.writeUTF(toreturn);
						break;
					case "Book" :
						String message = ticketOptions.book();
						dos.writeUTF(message);
						break;

					case "Cancel" :
						String message1 = ticketOptions.cancel();
						dos.writeUTF(message1);
						break;

					/*case "Browse" :
						String message2 = registeredUser.searchByDate("John");
						dos.writeUTF(message2);
						break;	*/

					case "Time" :
						toreturn = fortime.format(date);
						dos.writeUTF(toreturn);
						break;

					default:
						dos.writeUTF("Invalid input");
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}