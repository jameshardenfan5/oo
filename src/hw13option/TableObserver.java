package hw13option;

public class TableObserver implements Observer<DJIAEvent>{

	private float djia;
    public void update(Observable<DJIAEvent> source,DJIAEvent event){

		this.djia=event.getDJIA();
	
	}

	public float tabledisplaydjia(){

		return djia;
	}
}