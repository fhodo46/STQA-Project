import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    public List<Product> products;
    public ProductCatalog() {
        products= new ArrayList<>();
    }

    public void addProduct(Product product) { products.add(product);}

    public void removeProduct(Product product) { products.remove(product);}

    public Product searchProduct(String productId)
    {
        for (Product product: products)
        {
            if(product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }

}