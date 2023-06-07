
package model;

public class Question {
    private String questionId;
    private String content;

    public Question() {
    }

    public Question(String questionId, String content) {
        this.questionId = questionId;
        this.content = content;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", content=" + content + '}';
    }
    
    
}
