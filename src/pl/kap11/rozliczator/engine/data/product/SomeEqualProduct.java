package pl.kap11.rozliczator.engine.data.product;

import java.util.Collection;

import pl.kap11.rozliczator.engine.Settlement;
import pl.kap11.rozliczator.engine.data.Settler;

public class SomeEqualProduct implements Product {

	private String name;
	private long value;

	private Collection<Settler> settlersInvolved;

	private SomeEqualProduct(String name, long value,
			Collection<Settler> settlersInvolved) {
		this.name = name;
		this.value = value;
		this.settlersInvolved = settlersInvolved;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public long getValue() {
		return value;
	}

	@Override
	public long getSettlerShare(Settler settler, Settlement settlement) {
		if (willSettlerPayForThisProduct(settler, settlement))
			return (long) value / settlersInvolved.size();
		else
			return 0;
	}

	private boolean willSettlerPayForThisProduct(Settler settler,
			Settlement settlement) {
		return settlement.isSettlerInSettlement(settler)
				&& settlersInvolved.size() > 0
				&& settlersInvolved.contains(settler);
	}

}
