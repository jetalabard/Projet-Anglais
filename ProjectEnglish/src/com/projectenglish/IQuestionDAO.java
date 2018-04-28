package com.projectenglish;

import java.util.List;

public interface IQuestionDAO {

	public List<Question> getQuestions();

	Question getQuestion(int position);

	List<Question> getListQuestionByLevel(int level);

	Question getQuestionAlea(int level);

	int getNumberOfQuestionAsk();

	void setQuestionAsk(List<Question> questionsPose);

	Question getLastQuestion();

}
