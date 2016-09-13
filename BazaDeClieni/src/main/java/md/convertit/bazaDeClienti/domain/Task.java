package md.convertit.bazaDeClienti.domain;

import java.sql.Date;

public class Task {
	private String room;
	private long area;
	private Date data;
	private double price;
	public Task() {
		super();
	}
	public Task(String room, long area, Date data, double price) {
		super();
		this.room = room;
		this.area = area;
		this.data = data;
		this.price = price;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Task [room=" + room + ", area=" + area + ", data=" + data + ", price=" + price + "]";
	}
	
	

}
