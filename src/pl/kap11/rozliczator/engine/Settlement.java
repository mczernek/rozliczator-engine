package pl.kap11.rozliczator.engine;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import pl.kap11.rozliczator.engine.data.Settler;
import pl.kap11.rozliczator.engine.exceptions.SettlerAlreadyInSettlementException;
import pl.kap11.rozliczator.engine.exceptions.UnknownSettlerException;

public class Settlement {

	Collection<Settler> settlers;
	Collection<Product> products;
	Collection<Payment> payments;

	private Settlement(Collection<Settler> settlers,
			Collection<Product> products, Collection<Payment> payments) {
		this.settlers = settlers;
		this.products = products;
		this.payments = payments;
	}

	public static SettlementBuilder getBuilder() {
		return new SettlementBuilder();
	}

	public int settlersCount() {
		return settlers.size();
	}
	
	public int productCount() {
		return products.size();
	};
	
	public int paymentsCount() {
		return payments.size();
	}

	public static class SettlementBuilder {

		List<Settler> settlers;
		List<Product> products;
		List<Payment> payments;

		public Settlement build() {
			return new Settlement(settlers, products, payments) {
			};
		}

		public SettlementBuilder() {
			settlers = new LinkedList<Settler>();
			products = new LinkedList<Product>();
			payments = new LinkedList<Payment>();
		}

		public void addSettler(Settler settler)
				throws SettlerAlreadyInSettlementException {
			if (settlers.contains(settler)) {
				throw new SettlerAlreadyInSettlementException();
			} else {
				settlers.add(settler);
			}
		}

		public void addProduct(String name, long value) {
			products.add(Product.createProduct(name, value));
		}

		public void addPayment(Settler settler, long value) throws UnknownSettlerException{
			if(settlers.contains(settler)){
				payments.add(Payment.createPayment(settler, value));
			}else{
				throw new UnknownSettlerException();
			}
			
		}

	}

}
