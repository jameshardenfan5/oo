package hw05;

public class Car{

	private String model, make;
	private int year, mileage;
	private float price;

	public Car(float price, int year, int mileage, String make,String model) {

		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.model=model;
		this.make=make;
	}
	
	public float getPrice() {

		return price;
	}

	public int getYear() {

		return year;
	}

	public int getMileage() {

		return mileage;
	}

	public String getMake() {

		return make;
	}	

	public String getModel() {

		return model;
	}
}
