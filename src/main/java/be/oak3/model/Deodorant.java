package be.oak3.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deodorant extends Product {

	private DeoType deotype;

	public Deodorant(int number, String brandName, String name, int volume,
                     double price, DeoType deotype) {
		super(number, brandName, name, volume, price);
		this.deotype = deotype;
	}

    public Deodorant() {
    }

    @Override
	public String toString() {
		return super.toString() + "\t" + deotype.name();
	}

	// GENESTE ENUM
	public enum DeoType {
		VAPO, STICK;
	}

}
