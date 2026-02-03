import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete Class: Tea with Hook.
 *
 * <p>Tea implementation with customer preference hook.
 *
 * <p><b>Pattern Role:</b> Concrete Class.
 */
public class TeaWithHook extends CaffeineBeverageWithHook {
  @Override
  protected void brew() {
    System.out.println("Brewing tea and wating for the strong staste");
  }

  @Override
  protected void addCondiments() {
    System.out.println("Adding suger and milk ...");
  }

  @Override
  protected boolean customerWantsCodiments() {
    String answer = getUserInput();
    return answer.toLowerCase().startsWith("y");
  }

  private String getUserInput() {
    String answer = null;
    System.out.println("Would you like milk or sugar with your tea (y/n)? ");
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
