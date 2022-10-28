package spineApp.models.questionnairemodels;

import java.util.ArrayList;

public class Questionnaire {

    Integer ID;
    Integer accountID;
    String name;
    ArrayList<EmployedQuestion> questionlist = new ArrayList<EmployedQuestion>();
}
