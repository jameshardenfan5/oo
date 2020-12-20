package hw13m;

public class DJIAQuoteObservable{

	private DJIAQuoteObserver observers[]=new DJIAQuoteObserver[3];
	private int i=0;

	public void addObserver(DJIAQuoteObserver ob){

		observers[i]=ob;
		i++;
	}

	public void notifyObservers(DJIAEvent event){
		for(int j=0;j<=i;j++){

			observers[j].updateDJIA(event);
		}
	}
}
