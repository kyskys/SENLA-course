package com.senla.ui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader {
	private static Scanner in = new Scanner(System.in);

	final private static String ERR_WRONG_INPUT = "wrong input, please repeat";
	final private static String ERR_EMPTY_INPUT = "empty input, please repeat";
	final private static String ERR_WRONG_FORMAT_INPUT = "wrong format of input, must be dd.mm.yyyy, please repeat";

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
		Date d = null;
		try {
			System.out.println("enter date, dd.mm.yyyy");
			String s = in.nextLine();
			SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
			d = f.parse(s);

		} catch (InputMismatchException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readDate();
		} catch (ParseException e) {
			System.out.println(ERR_WRONG_FORMAT_INPUT);
			return readDate();
		}
		return d;
	}
}
