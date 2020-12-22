package hw13observe;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable{

    public void changeQuote(float statistic){

        setChanged();
        notifyObservers(new DJIAEvent(statistic));
    }
}
