import java.util.ArrayList;
import java.util.List;

public class CustomerCatalog{
    private List <Customer> customers;

    public CustomerCatalog(){ customers= new ArrayList<>();}


    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }


    public Customer searchCustomer(String customerId){
        for(Customer customer: customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null; }
}