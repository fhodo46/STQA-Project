//The integration testing will be further extended with test cases; this is only the beginning

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.*; import static org.mockito.Mockito.*;



class ProductCatalogProductIntegration{



    @Test public void testProductProductCatalogIntegration(){
        Product product= new Product("P001", "Laptop", 999.99,10);
        ProductCatalog productCatalogMock= Mockito.mock(ProductCatalog.class);
        ProductController productController= new ProductController(productCatalogMock);
        productController.addToCatalog(product);
        Mockito.verify(productCatalogMock).addProduct(product);
    }
}





class CustomerCustomerCatalogIntegrationTesting {
    @Test public void testCustomerCustomerCatalogIntegration()
    {
        Customer customer= new Customer("C001", "John Doe","john@gmail.com", 1000.00);
        CustomerCatalog customerCatalogMock= Mockito.mock(CustomerCatalog.class);
        CustomerController customerController= new CustomerController(customerCatalogMock);
        customerController.addToCatalog(customer);

        Mockito.verify(customerCatalogMock).addCustomer(customer);
    } }
