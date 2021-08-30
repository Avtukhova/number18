package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Main;
import ru.netology.domain.Smartphone;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Product bk1 = new Book(1, "Мастер и Маргарита", 300, "М. Булгаков");
    Product bk2 = new Book(2, "Драма на охоте", 200, "А. Чехов");
    Product bk3 = new Book(3, "Раковый корпус", 300, "А. Солженицын");
    Product bk4 = new Book(8, "Архипелаг ГУЛАГ", 300, "А. Солженицын");
    Product sm1 = new Smartphone(4, "iphone12", 2000, "Apple");
    Product sm2 = new Smartphone(5, "Galaxy", 1500, "Samsung");
    Product sm4 = new Smartphone(7, "Galaxy5", 1500, "Samsung");
    Product sm3 = new Smartphone(6, "P40", 1000, "Huawei");
    Product mn2 = new Main(7,"RRR",100,"BBC");

    @BeforeEach
    public void setUp() {
        manager.add(bk1);
        manager.add(bk2);
        manager.add(bk3);
        manager.add(bk4);
        manager.add(sm1);
        manager.add(sm2);
        manager.add(sm3);
        manager.add(sm4);
        manager.add(mn2);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] expected = new Product[]{bk1};
        Product[] actual = manager.searchBy("Мастер и Маргарита");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBook2() {
        Product[] expected = new Product[]{bk2};
        Product[] actual = manager.searchBy("Драма на охоте");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBookIfNoName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Гроза");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameAuthor() {
        Product[] expected = new Product[]{bk2};
        Product[] actual = manager.searchBy("А. Чехов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameAuthor2() {
        Product[] expected = new Product[]{bk3, bk4};
        Product[] actual = manager.searchBy("А. Солженицын");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameAuthorIfNoName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Л. Толстой");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product[] expected = new Product[]{sm3};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphoneIfNoName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("NNN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameManufacturer() {
        Product[] expected = new Product[]{sm1};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameManufacturer2() {
        Product[] expected = new Product[]{sm2, sm4};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameManufacturerIfNoName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Russia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameManufacturerIfNoName2() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("RSS");
        assertArrayEquals(expected, actual);
    }




}