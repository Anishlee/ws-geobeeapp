package com.fbla.objects;

public class CapitalsObject {
	
	
	@Override
	public String toString() {
		return "CapitalsObject [questionId=" + questionId + ", question=" + question + ", choice1=" + choice1
				+ ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4=" + choice4 + ", answer=" + answer
				+ ", questionType=" + questionType + ", questionSubType=" + questionSubType + ", answerOption="
				+ answerOption + ", questionId2=" + questionId2 + ", userOption=" + userOption + "]";
	}
	public CapitalsObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	int questionId;
	String question;
	String choice1;
	String choice2;
	String choice3;
	String choice4;
	String answer;
	String questionType;
	String questionSubType;
	String answerOption;
	String questionId2;
	String userOption;
	
	public String getUserOption() {
		return userOption;
	}
	public void setUserOption(String userOption) {
		this.userOption = userOption;
	}
	public String getQuestionId2() {
		return questionId2;
	}
	public void setQuestionId2(String questionId2) {
		this.questionId2 = questionId2;
	}
	public String getAnswerOption() {
		return answerOption;
	}
	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}
	public String getQuestionSubType() {
		return questionSubType;
	}
	public void setQuestionSubType(String questionSubType) {
		this.questionSubType = questionSubType;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public CapitalsObject( String question, String choice1, String choice2, String choice3,
			String choice4, String answer) {
		super();
	//	this.questionId = questionId;
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.answer = answer;
	//	this.questionType = questionType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
}
