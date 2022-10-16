import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Product product1 = new Product(1, " War and Peace 1", 300);
    Product product2 = new Product(2, " War and Peace 2", 300);
    Product product3 = new Product(3, "Xiomi", 1000);
    @Test
    public void removeByNotExistedId() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, ()-> repo.removeById(4));
    }
    @Test
    public void removeByExistedId() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addProducts() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findById() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.findById(1);
        Product actual = repo.findById(1);
        Product expected = product1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void findByNotExistedId() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.findById(4);
        Product actual = repo.findById(4);
        Product expected = null;
        Assertions.assertEquals(actual, expected);
    }

}