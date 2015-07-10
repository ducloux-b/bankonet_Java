package com.bankonet.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestI18N
	{

	public static void main(String[] args)
		{
		Locale localeFr = new Locale("fr", "FR");
		ResourceBundle bundleFr = ResourceBundle.getBundle("com.bankonet.i18n.resources", localeFr);
		
		System.out.println(bundleFr.getString("WELCOME"));
		
		NumberFormat numberFormat = NumberFormat.getIntegerInstance(localeFr);
		System.out.println(numberFormat.format(new Double(102310.05)));
		
		DateFormat dFormat = DateFormat.getDateInstance(DateFormat.DEFAULT,localeFr);
		Date today = new Date();
		System.out.println(dFormat.format(today));
		
		System.out.println();
		
		Locale localeEn = new Locale("en", "US");
		ResourceBundle bundleEn = ResourceBundle.getBundle("com.bankonet.i18n.resources", localeEn);
		
		System.out.println(bundleEn.getString("WELCOME"));
		
		NumberFormat numberFormatEn = NumberFormat.getIntegerInstance(localeEn);
		System.out.println(numberFormatEn.format(new Double(102310.05)));
		
		DateFormat dFormatEn = DateFormat.getDateInstance(DateFormat.DEFAULT,localeEn);
		System.out.println(dFormatEn.format(today));
		}

	}
