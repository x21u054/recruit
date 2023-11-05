package entity;

public class Thread {
	private int id;
	private String title;
	private int ownerId;
	public Thread() {
		super();
	}
	public Thread(String title) {
		super();
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "id: " + this.id + ", title: " + this.title +
				", ownerId: " + this.ownerId;
	}
}
