public class ProductManager {
    private Repository repo;


    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }



}
