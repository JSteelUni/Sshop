package Model;

//template for in store items
//TODO make description?
public class ItemTemplate {

    public int id;
    public String name;
    public double price;
    public String imagePath;

    public ItemTemplate(int id, String name, double price, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }
}