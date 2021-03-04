package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Book1", 100, "Author1");
    private Book second = new Book(2, "Book2", 200, "Author2");
    private Smartphone third = new Smartphone(3, "smartphone1", 1000, "Producer1");
    private Smartphone fourth = new Smartphone(4, "smartphone2", 2000, "Producer2");
    private Product fifth = new Product(5, "product", 3000);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldSearchBookName() {
        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAuthor() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneName() {
        Product[] actual = manager.searchBy("smartphone1");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneProducer() {
        Product[] actual = manager.searchBy("Producer2");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProduct() {
        Product[] actual = manager.searchBy("product");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }
}