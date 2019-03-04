package Model;


import Model.Event;
import Model.RegisteredUser;

public class MainTest {

	public static void main (String args []) {

		Event event1= new Event ("Event1", 20.08, 100);
		Event event2= new Event ("Event2", 25, 200);
		Event event3= new Event ("Event3", 10.80, 50);


		RegisteredUser user= new RegisteredUser(12);
		user.searchByDate("John");
	}
}