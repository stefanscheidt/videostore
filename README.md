# Videostore Refactoring Kata

Based on the introductory example from Martin Fowlers Book
[Refactoring](https://martinfowler.com/books/refactoring.html).

## The Starting Point

The sample program is very simple.
It is a program to calculate and print a statement of a customer's charges at a video store.
The program is told which movies a customer rented and for how long.
It then calculates the charges, which depend on how long the movie is rented, and identifies the type movie.
There are three kinds of movies: regular, children's, and new releases.
In addition to calculating charges, the statement also computes frequent renter points, which vary depending on whether the film is a new release.
Several classes represent various video elements:

```
+-------+         +--------+         +----------+
| Movie | <-1--*- | Rental | <-*--1- | Customer |
+-------+         +--------+         +----------+
```

See the package [`imaginary.videostore`](./src/main/java/imaginary/videostore).

In the [test sources](./src/test/java/imaginary/videostore) you'll find tests for the statement generation implemented in the class `Customer`.

## Your Task

Implement the capability to generate an HTML version of the statement.

Secondly, the users want to make changes to the way they classify movies, but they haven't yet decided on the change they are going to make.
They have a number of changes in mind.
These changes will affect both the way renters are charged for movies, and the way that frequent renter points are calculated.

Before extending the code, refactor it to make the changes easy.
For doing this:

*   Look out for [code smells](https://refactoring.guru/refactoring/smells) like [long method](https://refactoring.guru/smells/long-method) or [feature envy](https://refactoring.guru/smells/feature-envy) to guide your refactoring.
*   Try to make small refactoring steps and run the tests often.
*   Probably you can use automated refactorings provided by your IDE.

Check if you can also improve the tests after you did your refactorings of the production code.
