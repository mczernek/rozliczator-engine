package pl.kap11.rozliczator.engine.data.product;

import pl.kap11.rozliczator.engine.Settlement;
import pl.kap11.rozliczator.engine.data.Settler;

public class AllEqualProduct implements Product {

	private String name;
	private long value;
	
	private AllEqualProduct(String name, long value){
		this.name = name;
		this.value = value;
	}
	
	public static AllEqualProduct createProduct(String name, long value){
		return new AllEqualProduct(name, value);
	}
	
	/* (non-Javadoc)
	 * @see pl.kap11.rozliczator.engine.data.product.Product#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof AllEqualProduct){
			AllEqualProduct toCompare = (AllEqualProduct)o;
			return toCompare.name == name && toCompare.value == value;
		}else{
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see pl.kap11.rozliczator.engine.data.product.Product#hashCode()
	 */
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see pl.kap11.rozliczator.engine.data.product.Product#getName()
	 */
	@Override
	public String getName(){
		return name;
	}
	
	/* (non-Javadoc)
	 * @see pl.kap11.rozliczator.engine.data.product.Product#getValue()
	 */
	@Override
	public long getValue(){
		return value;
	}

	/* (non-Javadoc)
	 * @see pl.kap11.rozliczator.engine.data.product.Product#getSettlerShare(pl.kap11.rozliczator.engine.data.Settler, pl.kap11.rozliczator.engine.Settlement)
	 */
	@Override
	public long getSettlerShare(Settler settler, Settlement settlement) {
		return value/settlement.settlersCount();
	}
	
}
