package hw13option;

public class PieChartObserver implements Observer<StockEvent>{

	private String stockticker;
	private float quote;

    public void update(Observable<StockEvent> source,StockEvent event){

        this.stockticker=event.getTicker();
        this.quote=event.getQuote();
	}

	public String piedisplayticker(){

		return stockticker;
	}


	public float piedisplayquote(){

		return quote;
	}
}