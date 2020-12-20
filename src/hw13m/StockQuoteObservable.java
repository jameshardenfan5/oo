package hw13m;

public class StockQuoteObservable{

	private StockQuoteObserver observers[]=new StockQuoteObserver[3];
	private int i=0;

	public void addObserver(StockQuoteObserver ob){

		observers[i]=ob;
		i++;
	}

	public void notifyObservers(StockEvent event){
		for(int j=0;j<i;j++){

			observers[j].updateStock(event);
		}
	}
}
