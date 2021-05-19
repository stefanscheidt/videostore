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

## Your task

Implement the capability to generate an HTML version of the statement.
Before doing that, refactor the existing code to make the change easy.
Look out for [code smells](https://refactoring.guru/refactoring/smells) like [long method](https://refactoring.guru/smells/long-method) or [feature envy](https://refactoring.guru/smells/feature-envy) to guide your refactoring.
