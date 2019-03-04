package Model;

import java.util.*;
public class Ticket {

	private List <Event> events;
	private List <Ticket> tickets;
	private List <User> users;

	private int quantity;
	private String seat;
	private int ticketID;
	private int barCode;


	public Ticket( int quantity, String seat, int ticketID,
				   int barCode) {
		this.quantity = quantity;
		this.seat = seat;
		this.ticketID = ticketID;
		this.barCode = barCode;
	}
	List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getBarCode() {
		return barCode;
	}
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}



}
