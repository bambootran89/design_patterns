/**
 * Abstract Class: Caffeine Beverage Template.
 *
 * <p>Defines the skeleton of the algorithm in the {@code prepareRecipe()} method.
 *
 * <p><b>Pattern Role:</b> Abstract Class.
 *
 * <p>In the Template Method Pattern, the Abstract Class defines the algorithm's
 * structure in a template method (marked {@code final} to prevent overriding). This
 * method calls: <ul> <li><b>Concrete methods</b> (boilWater, pourInCup) - implemented
 * here. <li><b>Abstract methods</b> (brew, addCondiments) - must be implemented by
 * subclasses. <li><b>Hook methods</b> (customerWantsCodiments) - optional override
 * points with default behavior.
 * </ul>
 *
 * <p>This structure enforces the overall algorithm while allowing subclasses to
 * customize specific steps.
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

  protected abstract void brew();

  protected abstract void addCondiments();

  private void boilWater() {
    System.out.println("Boiling water");
  }

  private void pourInCup() {
    System.out.println("Pouring into cup");
  }

  /**
   * Hook method to control condiment addition.
   *
   * @return true if the customer wants condiments, false otherwise.
   */
  protected boolean customerWantsCodiments() {
    return true;
  }
}
