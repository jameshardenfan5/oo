package hw13option;

public class StockQuoteObservable extends Observable<StockEvent>{
    public void changeQuote(String t,float q){

        setChanged();
        notifyObservers(new StockEvent(t,q));
    }
}
