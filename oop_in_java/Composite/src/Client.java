/** Client demonstration code for the pattern. */
public class Client {
  public static void main(String[] args) {
    LeafGraphic[] leafs = new LeafGraphic[4];

    leafs[0] = new LeafGraphic("Button 1");
    leafs[1] = new LeafGraphic("Text ");
    leafs[2] = new LeafGraphic("checked ");
    leafs[3] = new LeafGraphic("contents ");

    CompositeGraphic graphic = new CompositeGraphic("Main");
    CompositeGraphic graphic1 = new CompositeGraphic("Left");
    CompositeGraphic graphic2 = new CompositeGraphic("Right");

    graphic1.add(leafs[1]);
    graphic1.add(leafs[0]);

    graphic2.add(leafs[3]);
    graphic2.add(leafs[2]);

    graphic.add(graphic2);
    graphic.add(graphic1);

    graphic.print();
  }
}
