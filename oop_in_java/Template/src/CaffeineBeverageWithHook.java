/**
 * Abstract Class: Caffeine Beverage Template.
 * <p>
 * Defines the skeleton of the algorithm in the {@code prepareRecipe()} method.
 * <p>
 * <b>Pattern Role:</b> Abstract Class.
 * <p>
 * In the Template Method Pattern, the Abstract Class defines the algorithm's
 * structure
 * in a template method (marked {@code final} to prevent overriding). This
 * method calls:
 * - <b>Concrete methods</b> (boilWater, pourInCup) - implemented here.
 * - <b>Abstract methods</b> (brew, addCondiments) - must be implemented by
 * subclasses.
 * - <b>Hook methods</b> (customerWantsCodiments) - optional override points
 * with default behavior.
 * <p>
 * This structure enforces the overall algorithm while allowing subclasses to
 * customize
 * specific steps.
 */
public abstract class CaffeineBeverageWithHook {
  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCodiments()) {
      addCondiments();
    }
  }

  private void pourInCup() {
    // TODO Auto-generated method stub
    System.out.println("Boiling water");
  }

  protected abstract void addCondiments();

  protected boolean customerWantsCodiments() {
    // TODO Auto-generated method stub
    return true;
  }

  protected abstract void brew();

  private void boilWater() {
    // TODO Auto-generated method stub
    System.out.println("Pouring into cup");
  }
}
