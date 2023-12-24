import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    public List<Product> cartItems;
    public ShoppingCart(){
        cartItems= new ArrayList<>();}


    public void addItem(Product product)
    { cartItems.add(product);
    }


    public void removeItem(Product product)
    {
        cartItems.remove(product);}
    public List<Product> getCartItems(){ return cartItems;}  }