
import java.util.ArrayList;

class Product{
    String name;
    int price;

    public Product(String name, int price){
          this.name=name;
          this.price=price;
    }    
}

class ShopingCart{

    private ArrayList<Product> products = new ArrayList<>();
  
    public void addProducts(Product p){
        products.add(p);
    }

    public ArrayList<Product> getProducts(){
         return  products;
    }
    //we are making three of the functions in same class which voilates the SRP
    public int calculateTotal(){
        int t = 0;
        for(Product p: products){
            t += p.price;
        }
        return  t;
    }
    
    public void getInvoice(){
        System.out.println(calculateTotal());
        System.out.println("get saved invoice");
    }

    public void saveToDB(){
        System.out.println("Save in database");
    }

}

public class Main{
    public static void main(String[] args) {
        ShopingCart cart = new ShopingCart();
        cart.addProducts(new Product("Laptop" , 10000));
        cart.addProducts(new Product("Mobile" , 12000));

        cart.getInvoice();
        cart.calculateTotal();
        cart.saveToDB();
    }
}