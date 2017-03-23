package fr.pizzeria.admin.event;

import java.time.LocalTime;

public class SupprimerPizzaEvent {

	private String code;
	private LocalTime date;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalTime getDate() {
		return date;
	}

	public void setDate(LocalTime date) {
		this.date = date;
	}

}
