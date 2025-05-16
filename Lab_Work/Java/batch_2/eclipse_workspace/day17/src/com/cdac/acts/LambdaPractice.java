package com.cdac.acts;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPractice {

	public static void main(String[] args) {

		// String to LocalDate
		Function<String, LocalDate> converToDate = (str) -> LocalDate.parse(str);
		LocalDate d = converToDate.apply("1999-11-11");
		System.out.println(d.getYear());

		// LocalDate to String
		Function<LocalDate, String> converToString = (date) -> date.toString();
		String date = converToString.apply(LocalDate.of(1999, 11, 11));
		System.out.println(date.getClass().getSimpleName());

		// BiFunction Interface
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
		Integer sum = add.apply(10, 20);
		System.out.println(sum);

		// Predicate Interface
		Predicate<Integer> checkEven = (value) -> value % 2 == 0;
		System.out.println(checkEven.test(3));

		// List.of() and forEach()
		List<Integer> arrList = List.of(1, 2, 3);

		arrList.forEach((x) -> System.out.println(x));

	}

}
