import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete Class: Coffee.
 * <p>
 * Provides specific implementations of the abstract operations.
 * <p>
 * <b>Pattern Role:</b> Concrete Class.
 * <p>
 * This class implements the primitive operations (brew, addCondiments) required
 * by the template method. It also overrides the hook method
 * {@code customerWantsCodiments()}
 * to provide coffee-specific logic (prompting the user for input).
 * <p>
 * The Template Method pattern ensures that the overall recipe structure (boil,
 * brew, pour, conditionally add)
 * remains consistent while allowing Coffee and Tea to customize individual
 * steps.
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {

  @Override
  protected void addCondiments() {
    // TODO Auto-generated method stub
    System.out.println("Adding suger and milk ...");
  }

  @Override
  protected void brew() {
    // TODO Auto-generated method stub
    System.out.println("Dripping coffee through filter ...");
  }

  protected boolean customerWantsCodiments() {
    // TODO Auto-generated method stub
    String answer = getUserInput();
    if (answer.toLowerCase().startsWith("y")) {
      return true;
    } else {
      return false;
    }
  }

  private String getUserInput() {

    String answer = null;

    System.out.println("Would you like milk or sugar with your coffee (y/n)? ");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException ioe) {

      System.err.println("IO error trying to read your answer");
    }

    if (answer == null) {

      return "no";
    }
    return answer;
  }
}
