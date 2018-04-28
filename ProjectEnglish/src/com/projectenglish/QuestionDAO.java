package com.projectenglish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;

public class QuestionDAO implements IQuestionDAO {
	
	private Activity act;
	
	private static QuestionDAO instance =null;
	
	private List<Question> questions;
	private List<Question> questionsPose;
	
	private QuestionDAO(Activity context) {
		this.act = context;
		questions = new ArrayList<Question>();
		questionsPose = new ArrayList<Question>();
	}
	
	public static QuestionDAO getInstance(Activity context)
	{
		if(instance == null)
			instance = new QuestionDAO(context);
		return instance;
	}
	/**
	 * retourne la liste des questions
	 */
	@Override
	public List<Question> getQuestions() {
		if(questions.isEmpty())
		{
			try{
				questions.addAll(AccessData.getInstance(act).loadQuestion());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			Collections.sort(questions);
		}
		return questions;
	}
	@Override
	public Question getQuestion(int position)
	{
		return this.questions.get(position);
	}
	
	@Override
	public Question getQuestionAlea(int level)
	{
		List<Question> questionsLevel = getListQuestionByLevel(level);
		if(questionsLevel.size() == 0){
			return null;
		}
		Random randomno = new Random();
		int position = randomno.nextInt(questionsLevel.size());
		Question quest = getQuestion(position);
		this.questionsPose.add(quest);
		this.questions.remove(quest);
		return quest;
	}
	
	@Override
	public void setQuestionAsk(List<Question> questionsPose){
		this.questionsPose = questionsPose;
	}
	
	
	@Override
	public List<Question> getListQuestionByLevel(int level)
	{
		List<Question> questionsLevel = new ArrayList<Question>();
		for(Question q: this.getQuestions()){
			if(q.getNiveau() == level){
				questionsLevel.add(q);
			}
		}
		return questionsLevel;
	}
	@Override
	public int getNumberOfQuestionAsk()
	{
		if(this.questionsPose.size() == 0){
			return 1;
		}
		else{
			return this.questionsPose.size();
		}
	}
	@Override
	public Question getLastQuestion() {
		this.questions = getQuestions();
		return questions.get(questions.size()-1);
	}
	
	public static void setInstance(Object object) {
		instance = null;
	}
	
	
}
