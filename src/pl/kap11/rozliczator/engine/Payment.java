package pl.kap11.rozliczator.engine;

import pl.kap11.rozliczator.engine.data.Settler;

public class Payment {
	private Settler settler;
	private long value;
	
	private Payment(Settler settler, long value){
		this.settler = settler;
		this.value = value;
	}
	
	public static Payment createPayment(Settler settler, long value){
		return new Payment(settler, value);
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Product){
			Payment toCompare = (Payment)o;
			return toCompare.settler.equals(settler) && toCompare.value == value;
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return settler.hashCode();
	}
}
