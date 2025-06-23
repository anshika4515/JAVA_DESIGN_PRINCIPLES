import java.util.ArrayList;

class Product{
    int price;
    String name;
    
    public Product(int price , String name){
        this.price = price;
        this.name = name;
    }
}
//Separating the different functions in different classes
class ShopCart{
    ArrayList<Product> products = new ArrayList<>();

    public void addProducts(Product p){
        products.add(p);
    }

    public ArrayList<Product> getProducts(){
        return products;  
    }

    public int calculateTotal(){
        int t = 0;
        for(Product p: products){
            t += p.price;
        }
        return  t;
    }
}

class GetInvoice{
    
    private ShopCart cart;

    public  GetInvoice(ShopCart cart){
        this.cart = cart;
    } 
    public void getInvoice(){
        System.out.println(cart.calculateTotal());
        System.out.println("get saved invoice");
    }
}

class StoreInDB{
     public void saveToDB(){
        System.out.println("Save in database");
    }
}

public class Main{
    public static void main(String[] args){
       ShopCart cart = new ShopCart();
       cart.addProducts(new Product(10000, "Laptop"));
       cart.addProducts(new Product(12000 , "Mobile"));

       GetInvoice invoice = new GetInvoice(cart);
       invoice.getInvoice();

       StoreInDB db = new StoreInDB();
       db.saveToDB();
    } 
}