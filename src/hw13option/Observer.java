package hw13option;

public interface Observer<T>{
	public void update(Observable<T> source,T event);

}