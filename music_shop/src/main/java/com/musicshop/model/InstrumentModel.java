package com.musicshop.model;

public class InstrumentModel {
	private int instrumentId;
	private String instrument_name;
	private String description;
	private double price;
	private int stock_quantity;

	public InstrumentModel() {
	}

	public InstrumentModel(String instrument_name, String description, double price, int stock_quantity) {
		super();
		this.instrument_name = instrument_name;
		this.description = description;
		this.price = price;
		this.stock_quantity = stock_quantity;
	}

	public InstrumentModel(String instrument_name) {
		this.instrument_name = instrument_name;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrument_Name() {
		return instrument_name;
	}

	public void setInstrument_Name(String instrument_name) {
		this.instrument_name = instrument_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStock_Quantity() {
		return stock_quantity;
	}

	public void setStock_Quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

}
