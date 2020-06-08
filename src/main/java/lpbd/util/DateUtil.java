package lpbd.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * Dias
	 */
	public static final int DAYS = 0;
	/**
	 * Meses
	 */
	public static final int MONTHS = 1;
	/**
	 * Anos
	 */
	public static final int YEARS = 2;

	public static int getDifferenceBetweenDates(Date initialDate, Date finalDate, int returnUnit) {
		// verificando se foi passada as data instanciadas
		if (initialDate == null) { // se nao foi
			// lancando excecao
			throw new IllegalArgumentException("initialDate cannot be null.");
		}

		// verificando se foi passada as data instanciadas
		if (finalDate == null) { // se nao foi
			// lancando excecao
			throw new IllegalArgumentException("finalDate cannot be null.");
		}

		if (returnUnit != DAYS && returnUnit != MONTHS && returnUnit != YEARS) {
			throw new IllegalArgumentException(
					"The value of unitReturn is invalid. The value must be 0 to Days, 1 to Months or 2 to Years.");
		}

		long millisInterval = finalDate.getTime() - initialDate.getTime();
		// Converte para dias milis / (1000 * 60 * 60 * 24 = 86400000)
		long daysInterval = millisInterval / 86400000;

		// Se o retorno e em dias, retorna
		if (returnUnit == DAYS) {
			return (int) daysInterval;
		}

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(initialDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(finalDate);
		int yearsInterval = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);

		// Se o mes da data de inicio for maior que o mes da data de fim, nao
		// completou o ano, entao subtrai.
		if (startCalendar.get(Calendar.MONTH) > endCalendar.get(Calendar.MONTH)) {
			yearsInterval--;
		}
		// Se o mes da data inicio for igual ao do fim, verifica se o dia do mes
		// da data inicio e maior que o do fim, se for, nao completou o ano,
		// subtrai.
		if (startCalendar.get(Calendar.MONTH) == endCalendar.get(Calendar.MONTH)
				&& startCalendar.get(Calendar.DAY_OF_MONTH) > endCalendar.get(Calendar.DAY_OF_MONTH)) {
			yearsInterval--;
		}
		// Se o retorno e em anos, retorna
		if (returnUnit == YEARS) {
			return yearsInterval;
		}

		int monthsInterval = yearsInterval * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		// Verifica se o dia da data inicial e maior que o dia da data final, se
		// for, nao completou o mes, entao subtrai.
		if (startCalendar.get(Calendar.DAY_OF_MONTH) > endCalendar.get(Calendar.DAY_OF_MONTH)) {
			monthsInterval--;
		}
		// Se o retorno e em meses, retorna
		return monthsInterval;
	}
}
