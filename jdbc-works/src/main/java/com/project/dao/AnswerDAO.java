package com.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.entity.Answer;
import com.project.entity.Question;
import com.project.interfaces.IAnswerDAO;
import com.project.interfaces.IQuestionDAO;
import com.project.utils.DbConnect;

public class AnswerDAO implements IAnswerDAO {

	@Override
	public boolean insertAnswer(Answer answer) {
		// TODO Auto-generated method stub

		String sql ="insert into answer (Description,Votes,ModifiedAt,QuestionID,UserID,Reliability) values(?,?,?,?,?,?)";
		try {
			
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, answer.getDescription());
			ps.setInt(2, answer.getVotes());
			ps.setString(3, answer.getModifiedAt());
			ps.setInt(4, answer.getQuestionID());
			ps.setInt(5, answer.getUserID());
			ps.setInt(6,answer.getReliability() );
	
			
			return ps.executeUpdate()>0;   // DML statement	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Answer> getAllAnswersASC(int QuestionID) {
String sql = "select * from answer where QuestionID= ? order by Votes ASC"; 
		
		List<Answer> list;
		list = new ArrayList<Answer>(); 
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, QuestionID);
			ResultSet rs = ps.executeQuery();  // DQL statement
			
	            while(rs.next()) {
				
				Answer answer=new Answer();
				answer.setAnswerID(rs.getInt(1));
				answer.setDescription(rs.getString(2));
				answer.setVotes(rs.getInt(3));
				answer.setModifiedAt(rs.getString(4));
				answer.setQuestionID(rs.getInt(5));
				answer.setUserID(rs.getInt(6));
				answer.setReliability(rs.getInt(7));
				
				
				list.add(answer); 
				
			}
		} 	
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
		
	
	}

	@Override
	public List<Answer> getAllAnswersDESC(int QuestionID) {
		// TODO Auto-generated method stub
String sql = "select * from answer where QuestionID= ? order by Votes DESC"; 
		
		List<Answer> list;
		list = new ArrayList<Answer>(); 
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, QuestionID);
			ResultSet rs = ps.executeQuery();  // DQL statement
			
	            while(rs.next()) {
				
				Answer answer=new Answer();
				answer.setAnswerID(rs.getInt(1));
				answer.setDescription(rs.getString(2));
				answer.setVotes(rs.getInt(3));
				answer.setModifiedAt(rs.getString(4));
				answer.setQuestionID(rs.getInt(5));
				answer.setUserID(rs.getInt(6));
				answer.setReliability(rs.getInt(7));
				
				
				list.add(answer); 
				
			}
		} 	
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}

	@Override
	public boolean deleteAnswer(int AnswerID) {
		// TODO Auto-generated method stub
		
		try {
		String sql = "DELETE from answer where AnswerID= ? "; 
		PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
		ps.setInt(1,AnswerID);
		
		return ps.executeUpdate()>0;   // DML statement	
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean deleteAnswersByQuestionID(int QuestionID) {
		// TODO Auto-generated method stub
		
		
		try {
			String sql = "DELETE from answer where QuestionID= ? "; 
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1,QuestionID);
			
			return ps.executeUpdate()>0;   // DML statement	
			
			
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return false;
		
	}

	@Override
	public boolean updateAnswerByAnswerID(Answer answer) {
		// TODO Auto-generated method stub
		String sql = "UPDATE answer SET Description=?,Votes=?,ModifiedAt=?,QuestionID=?,UserID=?,Reliability=? WHERE AnswerID=?";
		
		try {
		PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
		ps.setString(1, answer.getDescription());
		ps.setInt(2, answer.getVotes());
		ps.setString(3, answer.getModifiedAt());
		ps.setInt(4, answer.getQuestionID());
		ps.setInt(5, answer.getUserID());
		ps.setInt(6,answer.getReliability() );
		ps.setInt(7,answer.getAnswerID());
		
		return ps.executeUpdate()>0; 
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	
	
	
}
