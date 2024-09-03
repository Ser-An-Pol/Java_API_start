import java.util.HashSet;
import java.util.Set;

public class Catalog {
    private Set<Laptop> laptopSet;

    public Catalog() {
        this.laptopSet = new HashSet<>();
    }

    public boolean addLaptop(Laptop laptop) {
        return laptopSet.add(laptop);
    }

    public Set<Laptop> getLaptopSet() {
        return laptopSet;
    }
}
