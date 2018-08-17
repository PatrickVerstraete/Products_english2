package be.oak3.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parfum extends Product {

    public Parfum(int number, String brandName, String name, int volume,
                  double price) {
        super(number, brandName, name, volume, price);
    }

    public Parfum() {
        super();
    }
}
