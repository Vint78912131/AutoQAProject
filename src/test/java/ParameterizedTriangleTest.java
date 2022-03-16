package java;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(TimerTestExtension.class)
public class ParameterizedTriangleTest {
    private static Logger logger = LoggerFactory.getLogger(ParameterizedTriangleTest.class);

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

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: позитивный сценарий, периметр треугольника {0} == {1}")
    @MethodSource("triangles")
    void countPerimeterPositiveTest(Triangle triangle, int expectedResult) {
        int perimeter = triangle.countPerimeter();
        assertEquals(expectedResult, perimeter);
    }

    public static Stream<Arguments> negativeTriangles() {
        return Stream.of(Arguments.of(new Triangle(0, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, -1), "Sides must be positive"),
                Arguments.of(new Triangle(3, -1, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(6, 1, 1), "One side can't be greater than sum of others"),
                Arguments.of(new Triangle(1, 2, 1), "One side can't be greater than sum of others")
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: негативный сценарий (треугольника {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countPerimeterNegativeTest(Triangle triangle, String errorText) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals(errorText, illegalArgumentException.getMessage());
    }




    @ParameterizedTest
    @CsvSource(value = {"BLUE,RED", "RED,WHITE", "GREY,BLUE"})
    void paintTriangleTest(Color oldColor, Color newColor) {
        Triangle triangle = new Triangle(3, 3, 3, oldColor);
        triangle.paint(newColor);
        Assertions.assertEquals(newColor, triangle.getColor());
    }

    @Nested
    public class TriangleCreatingBeforeTest {
        Triangle triangle;

        @BeforeEach
        void setUp() {
            triangle = new Triangle(3, 3, 3);
        }

        @ParameterizedTest
        @EnumSource(Color.class)
        void paintTriangleTest(Color color) {
            Assumptions.assumeFalse(triangle.getColor().equals(color));
            triangle.paint(color);
            Assertions.assertEquals(color, triangle.getColor());
        }

        @ParameterizedTest
        @ValueSource(strings = {"BLUE", "RED", "GREY"})
        void paintTriangleTest(String color) {
            triangle.paint(color);
            Assertions.assertEquals(color, triangle.getColor().toString());
        }
    }
}
