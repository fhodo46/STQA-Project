public class ProductController
{
    private ProductCatalog productCatalog;
    public ProductController (ProductCatalog productCatalog) {
        this.productCatalog=productCatalog;
    }
    public void addToCatalog(Product product) {
        productCatalog.addProduct(product);

    }}