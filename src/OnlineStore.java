import java.util.Scanner;

public class OnlineStore{
    private ProductController productController;
    private CustomerController customerController;
    private OrderManager orderManager;
    private Scanner scanner;
    private ProductCatalog productCatalog;
    private CustomerCatalog customerCatalog;
    public OnlineStore(){
        productCatalog= new ProductCatalog();
        customerCatalog = new CustomerCatalog();
        productController = new ProductController(productCatalog);
        customerController= new CustomerController(customerCatalog);
        orderManager= new OrderManager();
        scanner= new Scanner(System.in);
    }
    public ProductCatalog getProductCatalog(){ return productCatalog;}
    public void setProductCatalog(ProductCatalog productCatalog){ this.productCatalog= productCatalog;}
    public CustomerCatalog getCustomerCatalog(){ return customerCatalog;}


    public void setCustomerCatalog(CustomerCatalog customerCatalog){ this.customerCatalog= customerCatalog;}
}