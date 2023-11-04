package entity;

import java.sql.Timestamp;

public class Message {
	private int id;
	private String content;
	private int threadId;
	private int ownerId;
	private Timestamp timestamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String toString() {
		return "id: " + this.id + ", content: " + this.content + 
				", threadId: " + this.threadId + ", ownerId: " + this.ownerId + 
				", timestamp: " + this.timestamp;
	}
}
