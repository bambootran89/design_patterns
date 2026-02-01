/**
 * Builder Interface.
 * <p>
 * Defines the construction steps for building a Car object.
 * <p>
 * <b>Pattern Role:</b> Builder.
 * <p>
 * The Builder pattern separates the construction of a complex object from its
 * representation.
 * Clients use this interface to set individual properties (colour, wheels) and
 * then retrieve
 * the fully constructed product via {@code getResult()}.
 * <p>
 * This allows for step-by-step construction and can support multiple
 * representations
 * of the same product by implementing different builders.
 */
public interface ICarBuilder {
  void setColour(String colour);

  void setWheels(int count);

  Car getResult();
}
