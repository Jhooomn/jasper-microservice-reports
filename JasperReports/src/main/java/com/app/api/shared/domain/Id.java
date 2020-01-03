package com.app.api.shared.domain;

import com.app.api.exceptions.IdException;

public class Id {

	private final String value;

	public Id(String id) {

		try {
			this.value = id;
			if ((id.length() > 64) || (id.length() < 32)) {
				throw new IdException();
			}
		} catch (NullPointerException e) {
			throw new IdException();
		}

	}

	public String getValue() {
		return value;
	}

}
