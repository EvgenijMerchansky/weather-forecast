package com.company.weather.temperature;

public class Temperature {
	public static boolean isValid(String temperature) {
		try {
			double value = Double.parseDouble(temperature);
			if (value > 273.15) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
}
