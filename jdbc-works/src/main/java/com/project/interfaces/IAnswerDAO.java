package com.project.interfaces;

import java.util.List;

import com.project.entity.Answer;


// contracts 
public interface IAnswerDAO {
	
	public boolean insertAnswer(Answer answer); 
	public List<Answer> getAllAnswersASC(int QuestionID); 
	public List<Answer> getAllAnswersDESC(int QuestionID); 
	public boolean deleteAnswer(int AnswerID);
	public boolean deleteAnswersByQuestionID(int QuestionID);
	public boolean updateAnswerByAnswerID(Answer answer);
	
	
	
}
