package pl.kap11.rozliczator.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import pl.kap11.rozliczator.engine.data.Settler;
import pl.kap11.rozliczator.engine.data.product.AllEqualProduct;
import pl.kap11.rozliczator.engine.exceptions.SettlerAlreadyInSettlementException;
import pl.kap11.rozliczator.engine.exceptions.UnknownSettlerException;

public class Settlement {

	Collection<Settler> settlers;
	Collection<AllEqualProduct> products;
	Collection<Payment> payments;

	private Settlement(Collection<Settler> settlers,
			Collection<AllEqualProduct> products, Collection<Payment> payments) {
		this.settlers = settlers;
		this.products = products;
		this.payments = payments;
	}
	
	public static Settlement createSettlement(){
		LinkedList<Settler> settlers = new LinkedList<Settler>();
		LinkedList<AllEqualProduct> products = new LinkedList<AllEqualProduct>();
		LinkedList<Payment> payments = new LinkedList<Payment>();
		return new Settlement(settlers, products, payments);
	}
	
	public static Settlement createSettlement(int settlersCount, int productsCount,int paymentsCount){
		ArrayList<Settler> settlers = new ArrayList<Settler>();
		ArrayList<AllEqualProduct> products = new ArrayList<AllEqualProduct>();
		ArrayList<Payment> payments = new ArrayList<Payment>();
		return new Settlement(settlers, products, payments);
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

	public void addSettler(Settler settler)
			throws SettlerAlreadyInSettlementException {
		if (settlers.contains(settler)) {
			throw new SettlerAlreadyInSettlementException();
		} else {
			settlers.add(settler);
		}
	}

	public void addProduct(String name, long value) {
		products.add(AllEqualProduct.createProduct(name, value));
	}

	public void addPayment(Settler settler, long value)
			throws UnknownSettlerException {
		if (settlers.contains(settler)) {
			payments.add(Payment.createPayment(settler, value));
		} else {
			throw new UnknownSettlerException();
		}
	}
	
	public boolean isSettlerInSettlement(Settler settler){
		return settlers.contains(settler);
	}

}
