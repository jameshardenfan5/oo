package hw13option;

import java.util.ArrayList;

public class Observable<T>{

	private final ArrayList<Observer> observers=new ArrayList<Observer>();;

    public void addObserver(Observer<T> o){

        observers.add(o);
    }

	public void setChanged(){

		return;
	}

    public void notifyObservers(T t){

		for(int i=0;i<observers.size();i++){ 		      
				
			observers.get(i).update(this,t);
		}  
    }
}
