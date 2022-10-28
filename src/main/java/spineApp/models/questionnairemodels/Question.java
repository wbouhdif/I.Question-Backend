package spineApp.models.questionnairemodels;

public abstract class Question {
    Integer ID;
    String type;
    String question;
    String givenAnswer;
    Boolean isSkippable;
}
