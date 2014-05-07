package pl.kap11.rozliczator.engine.data.product;

import java.util.Map;

import pl.kap11.rozliczator.engine.Settlement;
import pl.kap11.rozliczator.engine.data.Settler;

public class DifferentWeightsProduct implements Product{
	
	private String name;
	private long value;
	private Float weightSum;
	private Map<Settler, Float> settlersWeights;
	
	private DifferentWeightsProduct(String name, long value, Map<Settler, Float> settlersWeight, Float weightsSum){
		this.name = name;
		this.value = value;
		this.settlersWeights = settlersWeight;
		this.weightSum = weightsSum;
	}
	
	public static DifferentWeightsProduct createProduct(String name, long value, Map<Settler, Float> settlersWeights){
		Float weightsSum = Float.valueOf(0.0f);
		for(Float v: settlersWeights.values()){
			weightsSum += v;
		}
		return new DifferentWeightsProduct(name, value,settlersWeights, weightsSum);
	}
	
	@Override
	public boolean equals(Object o){
		return false;
	}

	@Override
	public int hashCode(){
		return name.hashCode() + weightSum.hashCode();
	}

	@Override
	public String getName(){
		return name; 
	}

	@Override
	public long getValue(){
		return value;
	}

	@Override
	public long getSettlerShare(Settler settler, Settlement settlement){
		if(settlement.isSettlerInSettlement(settler) && settlersWeights.size() > 0 && settlersWeights.containsKey(settler)){
			return value * (long)(settlersWeights.get(settler) / weightSum);
		}else{
			return 0;
		}
	}
}
