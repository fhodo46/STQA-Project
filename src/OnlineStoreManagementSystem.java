public class OnlineStoreManagementSystem{
    private final ProductController productController;
    private final CustomerController customerController;
    public OnlineStoreManagementSystem(ProductController productController, CustomerController customerController){
        this.productController= productController;
        this.customerController= customerController;
    }
    public void run(){

        Product laptop= new Product("P001", "Laptop", 999.99,10);
        productController.addToCatalog(laptop);
        System.out.println("Product Details:\n" + laptop.toString());
        Customer customer= new Customer("C001", "John Doe", "john@gmail.com", 1000.00);
        customerController.addToCatalog(customer);
        System.out.println("\nCustomer Details:\n" + customer.toString());
    }

    public static void main(String [] args){
        ProductCatalog productCatalog = new ProductCatalog();
        CustomerCatalog customerCatalog= new CustomerCatalog();
        ProductController productController = new ProductController(productCatalog);
        CustomerController customerController= new CustomerController(customerCatalog);
        OnlineStoreManagementSystem system= new OnlineStoreManagementSystem(productController, customerController);

        system.run();
    }
}