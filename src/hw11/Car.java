package hw11;

import java.util.ArrayList;

public class Car{

	private String model, make;
	private int year, mileage,domcount=0;
	private float price;

	public Car(float price, int year, int mileage, String make,String model){

		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.model=model;
		this.make=make;
	}
	
	public float getPrice(){

		return price;
	}

	public int getYear(){

		return year;
	}

	public int getMileage(){

		return mileage;
	}

	public String getMake(){

		return make;
	}	

	public String getModel(){

		return model;
	}
	
    public void setdomcount(ArrayList<Car> cars){

        for(int i=0;i<cars.size();i++){

			int bool = (this.year != cars.get(i).getYear() || this.price != cars.get(i).getPrice() || this.mileage != cars.get(i).getMileage()) ? 1 : 0;

            switch(bool){
				case 1:
					if(this.price >= cars.get(i).getPrice()){ 
						if(this.mileage >= cars.get(i).getMileage()){
							if(this.year <= cars.get(i).getYear()){
								this.domcount++;
							}
						}
					}
					break;
            }
        }
    }

    public int getdomcount(){

        return this.domcount;
    }
}
