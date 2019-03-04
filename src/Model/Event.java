package Model;

public class Event {

	private  String nameEvent;
	private  double price;
	private int capacity;


	public Event(String nameEvent, double price, int capacity) {
		this.nameEvent = nameEvent;
		this.price = price;
		this.capacity = capacity;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Event{" +
				"nameEvent='" + nameEvent + '\'' +
				", price=" + price +
				", capacity=" + capacity +
				'}';
	}
}
