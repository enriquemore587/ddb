package com.persist.enums;

import java.util.ArrayList;
import java.util.List;

public enum StatusUsers {
	_SUCCESS(1, "SUCCESS"), 
	_THERE_IS_ALREADY_A_USER(2, "THERE IS ALREADY A USER"),
	_TYPE_USER_NOT_FOUND(3, "TYPE USER NOT FOUND"),
	_PROFILE_NOT_FOUND(4, "PROFILE NOT FOUND"),
	_CONSULTING_ROOMS_NOT_FOUND(5, "CONSULTING ROOMS NOT FOUND");
	private final int id;
	private final String descripcion;

	private StatusUsers(final int id, final String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static List<String> obtenerTodosDescripcion() {
		List<String> l = new ArrayList<String>();
		for (StatusUsers item : values()) {
			l.add(item.descripcion);
		}
		return l;
	}

	public static int obtenerIdentificador(String val) {
		int valor = 0;
		for (StatusUsers item : values()) {
			if (item.descripcion.equals(val)) {
				valor = item.id;
			}
		}
		return valor;
	}
}
