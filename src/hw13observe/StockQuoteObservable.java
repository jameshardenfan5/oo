package hw13observe;

import java.util.Observable;

public class StockQuoteObservable extends Observable{
    public void changeQuote(String t,float q){
        
        setChanged();
        notifyObservers(new StockEvent(t,q));
    }
}
