package hw13observe;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable{
    private Map<String, Float> stockinfo = new HashMap<String, Float>();

    public void changeQuote(String t,float q){

        stockinfo.put(t,q);
        setChanged();
        notifyObservers(new StockEvent(t,q));
    }
}
