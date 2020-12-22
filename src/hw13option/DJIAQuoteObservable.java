package hw13option;

public class DJIAQuoteObservable extends Observable<DJIAEvent>{
    public void changeQuote(float statistic){

        setChanged();
        notifyObservers(new DJIAEvent(statistic));
    }
}