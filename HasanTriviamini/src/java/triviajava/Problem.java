/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviajava;

/**
 *
 * @author Student
 */


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

public class Problem implements Serializable {
     @EJB  // inject database from session bean
    
private String categories;
  private String question;
  private String answer;
   //private List<String> choices;
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    /*public List<String> getChoices() {
        return choices;
    }*/

   /* public void setChoices(List<String> choices) {
        this.choices = choices;
    }*/


  public Problem(String categories,String question,  String answer) {
    this.question = question;
    this.answer = answer;
    this.categories=categories;
    
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  // override for more sophisticated checking
  public boolean isCorrect(String response) {
    return response.trim().equalsIgnoreCase(answer);
  }

}
