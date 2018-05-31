package com.company;

import com.company.weather.WeatherLog;
import com.company.weather.WeatherPrediction;
import com.company.weather.temperatureException.TemperatureFormatException;

class Application {
	private static final String PREDICT = "--predict";
	private static final String LOG = "--log";

	private Application() {
	}

	void run(String[] args) {
		if (args.length < 1) {
			System.exit(1);
		}
		for (String arg : args) {
			System.out.println(arg);
		}

		final String mode = args[0];
		final WeatherLog WeatherLogInstance = WeatherLog.instance();

		switch (mode) {
			case LOG:
				final String temperature = args[1];
				try {
					WeatherLogInstance.addReport(temperature);
				} catch (TemperatureFormatException e) {
					System.out.println("Invalid temperature!");
				}
				return;
			case PREDICT:
				final WeatherPrediction predict = WeatherPrediction.basedOn(WeatherLogInstance);
				System.out.println(predict.getValue());
				return;
			default:

		}
	}

	static Application instance() {
		return new Application();
	}
}
