package hw13observe;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable{
    private float quote;
    public void changeQuote(float statistic){

        quote=statistic;
        setChanged();
        notifyObservers(new DJIAEvent(quote));
    }
}
