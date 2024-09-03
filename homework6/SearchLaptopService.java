import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SearchLaptopService {
    private final Set<Laptop> laptopSet;
    private final Map<Integer, String> searchCriteria;
    private ArrayList<Laptop> searchResult;

    public SearchLaptopService(Map<Integer, String> searchCriteria, Set<Laptop> laptopSet) {
        this.searchCriteria = searchCriteria;
        this.laptopSet = laptopSet;
    }

    private int search() {
        searchResult = new ArrayList<>();
        for (Laptop laptop : laptopSet) {
            boolean flag = true;
            for (var entry : searchCriteria.entrySet()) {
                switch (entry.getKey()) {
                    case 1:
                        if (laptop.getOZU() < Integer.parseInt(entry.getValue())) flag = false;
                        break;
                    case 2:
                        if (laptop.getPZU() < Integer.parseInt(entry.getValue())) flag = false;
                        break;
                    case 3:
                        if (!laptop.getOS().equalsIgnoreCase(entry.getValue())) flag = false;
                        break;
                    case 4:
                        if (!laptop.getColor().equalsIgnoreCase(entry.getValue())) flag = false;
                    default:
                        if (!flag) break;
                }
            }
            if (flag) searchResult.add(laptop);
        }
        return searchResult.size();
    }

    public ArrayList<Laptop> getSearchResult() {
        search();
        return searchResult;
    }


}
