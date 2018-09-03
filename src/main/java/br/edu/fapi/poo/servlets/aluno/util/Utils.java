package br.edu.fapi.poo.servlets.aluno.util;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import br.edu.fapi.poo.servlets.aluno.model.Aluno;

public class Utils {

	public static String gerarMatriculaAluno(Aluno aluno) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);

		String iniciaisNome = StringUtils.substring(aluno.getNome(), 0, 2);
		StringBuilder stringBuilder = new StringBuilder(iniciaisNome);
		stringBuilder.append(year).append(month).append(day).append(hour).append(min).append(sec);

		return stringBuilder.toString();
	}

}
