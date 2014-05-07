package pl.kap11.rozliczator.engine.data.product;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import pl.kap11.rozliczator.engine.data.Settler;

public class ProductFactory {

	public static class ProductBuilder{
		
		private String name;
		private long value;
		
		private Collection<Settler> includedSettlers;
		
		private Map<Settler, Float> settlersWeights;
		
		private ProductBuilder(String name, long value){
			this.name = name;
			this.value = value;
			
			includedSettlers = new LinkedList<Settler>();
			settlersWeights = new HashMap<Settler, Float>();
		}
		
		public void addSettler(Settler settler){
			if(!includedSettlers.contains(settler)){
				includedSettlers.add(settler);
			}
		}
		
		public void addSettlerWithWeight(Settler settler, Float weight){
			settlersWeights.put(settler, weight);
		}
		
		public Product buildProduct(){
			Product result = null;
			if(includedSettlers.isEmpty() && settlersWeights.isEmpty()){
				result = AllEqualProduct.createProduct(name, value);
			}else if(settlersWeights.isEmpty()){
				
			}else{
				
			}
			return result;
		}
		
	}
	
	public static Product getSimpleProduct(String name, long value){
		return AllEqualProduct.createProduct(name, value);
	}
	
	public static ProductBuilder startBuildingProduct(String name, long value){
		return new ProductBuilder(name, value);
	}
	
}
