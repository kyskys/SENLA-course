package com.senla.ui.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader {
	private static Scanner in = new Scanner(System.in);

	final private static String ERR_WRONG_INPUT = "wrong input, please repeat";
	final private static String ERR_EMPTY_INPUT = "empty input, please repeat";
	
	public static int readInt() {
		int i;
		try {
			i = Integer.valueOf(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readInt();
		} catch (NoSuchElementException e) {
			System.out.println(ERR_EMPTY_INPUT);
			return readInt();
		}
		return i;
	}

	public static int readIntWithBounds(int upperBound, int lowerBound) {
		int i;
		do {
			System.out.println(String.format("type integer between %s and %s", lowerBound, upperBound));
			i = readInt();
		} while (lowerBound > i || i > upperBound);
		return i;
	}

	public static long readLong() {
		long i;
		try {
			i = Long.valueOf(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readLong();
		} catch (NoSuchElementException e) {
			System.out.println(ERR_EMPTY_INPUT);
			return readLong();
		}
		return i;
	}

	public static String readString() {
		try {
			return in.nextLine();
		} catch (NoSuchElementException e) {
			System.out.println(ERR_EMPTY_INPUT);
			return readString();
		}
	}

	public static Date readDate() {
		try {
			System.out.println("enter year, yyyy");
			int year = readInt();
			System.out.println("enter month, mm");
			int month = readInt();
			System.out.println("enter day, dd");
			int day = readInt();
			LocalDate date = LocalDate.of(year, month, day);
			return Date.valueOf(date);
		} catch (DateTimeException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readDate();
		}
		
	}
}
