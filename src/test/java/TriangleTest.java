package java;

import src.main.java.Triangle;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Перенесены в параметризированные тесты")
public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeEach
    void setUp() {
        logger.error("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        logger.error("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        logger.error("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        logger.error("AfterAll");
    }

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 4, 5 должен быть равен 12")
    public void countPerimeterEgyptTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 5);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(12, perimeter);
    }


    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 4, 6 должен быть равен 13")
    public void countPerimeterGreater90TriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 6);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(13, perimeter);
    }

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 3, 3 должен быть равен 9")
    public void countPerimeterWithEqualSidesTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 3, 3);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(9, perimeter);
    }


    @Test
    @DisplayName("Одна сторона треугольника не может быть равной нулю \'0\'")
    public void countPerimeter1SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(0, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Одна сторона треугольника не может быть равной нулю \'0\'")
    public void countPerimeter2SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 0, 2);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Одна сторона треугольника не может быть равной нулю \'0\'")
    public void countPerimeter3SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 1, 0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }


    @Test
    @DisplayName("Одна сторона треугольника не может быть отрицательной длинны")
    public void countPerimeter1SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(-3, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Одна сторона треугольника не может быть отрицательной длинны")
    public void countPerimeter2SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, -1, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Одна сторона треугольника не может быть отрицательной длинны")
    public void countPerimeter3SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, 1, -1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Треугольник со сторонами 1, 1, 6 не существует")
    public void countPerimeterInvalidTriangleFailedTest() {
        Triangle triangle = new Triangle(1, 1, 6);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Треугольник со сторонами 1, 2, 1 не существует")
    public void countPerimeterInvalidTriangle2FailedTest() {
        Triangle triangle = new Triangle(1, 2, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника со сторонами 3, 3, 3 равна 2")
    public void countTriangleAreaPositive1Test() {
        Triangle triangle = new Triangle(3, 3, 3);   //Arrange
        double s = triangle.countArea();    //Act
        assertEquals(2.00, s);
    }

    @Test
    @DisplayName("Площадь треугольника со сторонами 3, 2, 3 равна 2.83")
    public void countTriangleAreaPositive2Test() {
        Triangle triangle = new Triangle(3, 2, 3);   //Arrange
        double s = triangle.countArea();    //Act
        assertEquals(2.83, s);
    }

    @Test
    @DisplayName("Площадь треугольника со сторонами 4, 5, 6 равна 6.48")
    public void countTriangleAreaPositive3Test() {
        Triangle triangle = new Triangle(4, 5, 6);   //Arrange
        double s = triangle.countArea();    //Act
        assertEquals(6.48, s);
    }

    @Test
    @DisplayName("Треугольник со сторонами 1, 2, 3 не существует")
    public void countTriangleAreaNegative1Test() {
        Triangle triangle = new Triangle(1, 2, 3);   //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countArea);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Треугольник со сторонами -1, 2, 3 не существует")
    public void countTriangleAreaNegative2Test() {
        Triangle triangle = new Triangle(-1, 2, 3);   //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countArea);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Треугольник со сторонами 6, 2, 3 не существует")
    public void countTriangleAreaNegative3Test() {
        Triangle triangle = new Triangle(6, 2, 3);   //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countArea);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }



}
