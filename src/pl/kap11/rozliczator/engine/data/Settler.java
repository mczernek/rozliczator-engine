package pl.kap11.rozliczator.engine.data;

public class Settler {

	private String name;
	
	private Settler(String name){
		this.name = name;
	}
	
	public static Settler createSettler(String name){
		return new Settler(name);
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Settler){
			return name.equals(((Settler)other).name);
		}else{
			return false;
		}
	}
	
}
