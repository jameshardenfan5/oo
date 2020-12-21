package hw13m;

public class TableObserver implements DJIAQuoteObserver,StockQuoteObserver{

	private String stockticker;
	private float djia,quote;

    public void updateDJIA(DJIAEvent x){

			this.djia=x.getDJIA();
	}

	public void updateStock(StockEvent y){

        this.stockticker=y.getTicker();
        this.quote=y.getQuote();
	}

	public String tabledisplayticker(){

		return stockticker;
	}

	public float tabledisplaydjia(){

		return djia;
	}
	public float tabledisplayquote(){

		return quote;
	}
}
