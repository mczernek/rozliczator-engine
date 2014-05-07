package pl.kap11.rozliczator.engine;

public class Product {

	private String name;
	private long value;
	
	private Product(String name, long value){
		this.name = name;
		this.value = value;
	}
	
	public static Product createProduct(String name, long value){
		return new Product(name, value);
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Product){
			Product toCompare = (Product)o;
			return toCompare.name == name && toCompare.value == value;
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	
}
