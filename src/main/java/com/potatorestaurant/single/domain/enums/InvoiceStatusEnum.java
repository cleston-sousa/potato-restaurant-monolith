package com.potatorestaurant.single.domain.enums;

public enum InvoiceStatusEnum {
	PENDING, PAID;

	public static InvoiceStatusEnum get(int ordinal) {
		for (InvoiceStatusEnum item : InvoiceStatusEnum.values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}
		return null;
	}

}
