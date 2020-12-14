package hw14;

import java.util.*;

public class Car{

	private String model, make;
	private int year, mileage,domcount=0;
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

    public void setdomcount(ArrayList<Car> cars){

        for(int i=0;i<cars.size();i++){

            if(this.year <= cars.get(i).getYear() && this.price >= cars.get(i).getPrice() && this.mileage >= cars.get(i).getMileage() && (this.year < cars.get(i).getYear() || this.price > cars.get(i).getPrice() || this.mileage > cars.get(i).getMileage())){

                    this.domcount++;
            }
        }
    }

    public int getdomcount(){

        return this.domcount;
    }

}
