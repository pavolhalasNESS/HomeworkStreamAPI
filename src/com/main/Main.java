package com.main;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		int sum = Stream.iterate(1, N -> N + 1)
				.limit(10000)
				.filter(N -> (N % 5 == 0) && (N % 3 == 0) && (N % 7 != 0))
				.mapToInt(N -> N).sum();

		System.out.println("=========Exercise 1===========");
		System.out.println("Sum of numbers is: " + sum);

		List<Integer> numbers = Stream.iterate(1, N -> N + 1)
				.limit(100)
				.filter(N -> (N % 2 == 0) && (N % 8 != 0))
				.collect(Collectors.toList());

		System.out.println("=========Exercise 2===========");
		System.out.println("First 100 numbers are: " + numbers);

		List<String> sorted_books = getBooks()
				.filter(N -> N.getPrice() < 100)
				.map(N -> N.getName())
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("=========Exercise 3.1===========");
		System.out.println("Sorted books are: " + sorted_books);

		int count_books = (int) (getBooks()
				.filter(N -> N.getName().length() < 5)
				.count());

		System.out.println("=========Exercise 3.2===========");
		System.out.println("Number of books: " + count_books);

		OptionalDouble price = getBooks()
				.mapToDouble(Book::getPrice)
				.average();

		double average_price = price.getAsDouble();

		System.out.println("=========Exercise 3.3===========");
		System.out.println("Average price of books: " + average_price);

		boolean cheaper_than = getBooks()
				.mapToInt(N -> N.getPrice())
				.allMatch(N -> N < 500);

		System.out.println("=========Exercise 3.4===========");
		System.out.println("All books are cheaper than 500: " + cheaper_than);

	}

	public static Stream<Book> getBooks() {
		return Stream.of(new Book("Harry Potter", 95), new Book("It", 350), new Book("Lord of rings", 82),
				new Book("RUR", 60), new Book("Wall", 300), new Book("Great Gatsby", 510), new Book("Hobbit", 72));
	}
}
