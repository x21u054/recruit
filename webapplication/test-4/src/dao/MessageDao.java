package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Message;
public class MessageDao {
	public List<Message> findMessageByThreadId(int threadId) {
		List<Message> messages = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "SELECT * FROM message WHERE thread_id = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setInt(1, threadId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Message message = new Message();
					message.setId(resultSet.getInt("id"));
					message.setContent(resultSet.getString("content"));
					message.setThreadId(resultSet.getInt("thread_id"));
					message.setOwnerId(resultSet.getInt("owner_id"));
					message.setTimestamp(resultSet.getTimestamp("timestamp"));
					messages.add(message);
				}
				return messages;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

    public boolean insert(Message message) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO message (content, thread_id, owner_id, timestamp) VALUES (?, ? ,?, ?);";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, message.getContent());
                preparedStatement.setInt(2, message.getThreadId());
                preparedStatement.setInt(3, message.getOwnerId());
                preparedStatement.setTimestamp(4, message.getTimestamp());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("行が挿入されました。");
                    return true;
                } else {
                    System.out.println("行は挿入されませんでした。");
                    return false;
                }
        	}
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
