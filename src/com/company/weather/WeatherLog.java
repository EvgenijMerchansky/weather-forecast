package com.company.weather;

import com.company.weather.temperatureException.TemperatureFormatException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.company.weather.temperature.Temperature.isValid;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class WeatherLog {
	private static final String FILENAME = "/Users/admin/Desktop/weather-forecast/weather_log.txt";

	private WeatherLog() {
	}

	public void addReport(String temperature) throws TemperatureFormatException {
		if (isValid(temperature)) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
				writer.newLine();
				writer.write(temperature);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new TemperatureFormatException();
		}
	}

	public List<String> getReports() {
		try {
			return readAllLines(get(FILENAME));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static WeatherLog instance() {
		return new WeatherLog();
	}
}
