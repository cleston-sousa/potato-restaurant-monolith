package com.potatorestaurant.single.domain.enums;

public enum CustomerTableStatusEnum {
	AVAILABLE, OCCUPIED, PAYMENT;

	public static CustomerTableStatusEnum get(Integer ordinal) {
		for (CustomerTableStatusEnum item : CustomerTableStatusEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}
}
