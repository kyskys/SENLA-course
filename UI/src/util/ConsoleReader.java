package util;

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
	public static Long readLongByConsole() {
		Long i;
		try {
			i = Long.valueOf(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readLongByConsole();
		} catch (NoSuchElementException e) {
			System.out.println(ERR_EMPTY_INPUT);
			return readLongByConsole();
		}
		return i;
	}

	public static String readStringByConsole() {
		try {
			return in.nextLine();
		} catch (NoSuchElementException e) {
			System.out.println(ERR_EMPTY_INPUT);
			return readStringByConsole();
		}
	}

	public static Date readDateByConsole() {
		Date d = null;
		try {
			System.out.println("enter date, dd.mm.yyyy");
			String s = in.nextLine();
			SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
			d = f.parse(s);

		} catch (InputMismatchException e) {
			System.out.println(ERR_WRONG_INPUT);
			return readDateByConsole();
		} catch (ParseException e) {
			System.out.println(ERR_WRONG_FORMAT_INPUT);
			return readDateByConsole();
		}
		return d;
	}
}
