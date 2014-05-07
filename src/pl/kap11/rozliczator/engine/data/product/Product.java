package pl.kap11.rozliczator.engine.data.product;

import pl.kap11.rozliczator.engine.Settlement;
import pl.kap11.rozliczator.engine.data.Settler;

public interface Product {

	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public abstract String getName();

	public abstract long getValue();

	public abstract long getSettlerShare(Settler settler, Settlement settlement);

}