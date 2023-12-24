public class CustomerController
{
    private CustomerCatalog customerCatalog;
    public CustomerController(CustomerCatalog customerCatalog){
        this.customerCatalog= customerCatalog;
    }
    public void addToCatalog(Customer customer){
        customerCatalog.addCustomer(customer);
    }
}