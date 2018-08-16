package be.oak3.model;

public class AfterShave extends Product {

	// INSTANCE VARIABELEN
	private Type type;

	// CONSTRUCTOR VOOR AFTERSHAVE
	public AfterShave(int number, String brandName, String name, int volume,
					  double price, Type type) {
		super(number, brandName, name, volume, price);
		this.type = type;
	}

	// Overschrijven van toString methode.
	@Override
	public String toString() {
		return super.toString() + "\t" + type.name();
	}

	// GENESTE ENUM
	public enum Type {
		VAPO, GEL;
	}

}
