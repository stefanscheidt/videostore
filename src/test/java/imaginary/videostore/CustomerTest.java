package imaginary.videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Movie regularMovie1;
    private Movie regularMovie2;
    private Movie childrenMovie;
    private Movie newReleaseMovie;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        regularMovie1 = new Movie("Regular 1", Movie.REGULAR);
        regularMovie2 = new Movie("Regular 2", Movie.REGULAR);
        childrenMovie = new Movie("Children", Movie.CHILDRENS);
        newReleaseMovie = new Movie("New Release", Movie.NEW_RELEASE);
        customer = new Customer("Customer");
    }

    @Test
    public void statement_NoRentals() {
        String expectedStatement = """
                Rental Record for Customer
                Amount owed is 0.0
                You earned 0 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneRegularMovieTwoDays() {
        customer.addRental(new Rental(regularMovie1, 2));
        String expectedStatement = """
                Rental Record for Customer
                \tRegular 1\t2.0
                Amount owed is 2.0
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneRegularMovieThreeDays() {
        customer.addRental(new Rental(regularMovie1, 3));
        String expectedStatement = """
                Rental Record for Customer
                \tRegular 1\t3.5
                Amount owed is 3.5
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneRegularMovieFourDays() {
        customer.addRental(new Rental(regularMovie1, 4));
        String expectedStatement = """
                Rental Record for Customer
                \tRegular 1\t5.0
                Amount owed is 5.0
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_TwoRegularMovies() {
        customer.addRental(new Rental(regularMovie1, 2));
        customer.addRental(new Rental(regularMovie2, 3));
        String expectedStatement = """
                Rental Record for Customer
                \tRegular 1\t2.0
                \tRegular 2\t3.5
                Amount owed is 5.5
                You earned 2 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneNewReleaseOneDay() {
        customer.addRental(new Rental(newReleaseMovie, 1));
        String expectedStatement = """
                Rental Record for Customer
                \tNew Release\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneNewReleaseTwoDays() {
        customer.addRental(new Rental(newReleaseMovie, 2));
        String expectedStatement = """
                Rental Record for Customer
                \tNew Release\t6.0
                Amount owed is 6.0
                You earned 2 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneChildrenThreeDays() {
        customer.addRental(new Rental(childrenMovie, 3));
        String expectedStatement = """
                Rental Record for Customer
                \tChildren\t1.5
                Amount owed is 1.5
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneChildrenFourDays() {
        customer.addRental(new Rental(childrenMovie, 4));
        String expectedStatement = """
                Rental Record for Customer
                \tChildren\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_OneChildrenFiveDays() {
        customer.addRental(new Rental(childrenMovie, 5));
        String expectedStatement = """
                Rental Record for Customer
                \tChildren\t4.5
                Amount owed is 4.5
                You earned 1 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

    @Test
    public void statement_someRentals() {
        customer.addRental(new Rental(regularMovie1, 2));
        customer.addRental(new Rental(regularMovie2, 3));
        customer.addRental(new Rental(newReleaseMovie, 3));
        customer.addRental(new Rental(childrenMovie, 5));
        String expectedStatement = """
                Rental Record for Customer
                \tRegular 1\t2.0
                \tRegular 2\t3.5
                \tNew Release\t9.0
                \tChildren\t4.5
                Amount owed is 19.0
                You earned 5 frequent renter points""";
        assertThat(customer.statement()).isEqualTo(expectedStatement);
    }

}
