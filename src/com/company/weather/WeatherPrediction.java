package com.company.weather;

import java.util.List;

public class WeatherPrediction {
	final List<String> reports;

	private WeatherPrediction(List<String> reports) {
		this.reports = reports;
	}

	public List<String> getValue() {
		return this.reports;
	}

	public static WeatherPrediction basedOn(WeatherLog log) {
		List<String> reports = log.getReports();
		return new WeatherPrediction(reports);
	}
}
