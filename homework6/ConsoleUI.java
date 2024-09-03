import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {

    private static int chooseItem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию для создания фитра поиска:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("==========================");
            try {
                int criterion = scanner.nextInt();
                if (criterion < 1 || criterion > 4) throw new Exception();
                return criterion;
            } catch (Exception e) {
                System.out.println("Некорректный ввод. Попробуйте снова...");
                scanner.nextLine();
            }
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String setBoundValue(int criterion) {
        Scanner scanner = new Scanner(System.in);
        String res;
        if (criterion == 1 || criterion == 2) {
            System.out.println("Введите минимальные значения для выбранного критерия фильтрации...");
            res = scanner.nextLine();
            while (!isInteger(res)) {
                System.out.println("Некорректный ввод. Введите числовое значение в мегабайтах...");
                res = scanner.nextLine();
            }
        }
        else {
            System.out.println("Введите значения для выбранного критерия фильтрации...");
            res = scanner.nextLine();
        }
        return res;
    }

    private static boolean isContinue(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg + " (Yy/Nn)");

        if (scanner.nextLine().equalsIgnoreCase("y")) return true;
        else return false;
    }

    private static Map<Integer, String> setCriteria() {
        Map<Integer, String> searchCriteria = new HashMap<>();

        do {
            int criterion = chooseItem();
            searchCriteria.put(criterion, setBoundValue(criterion));
        } while (isContinue("Хотите добавить или изменить критерий поиска?"));
        return searchCriteria;
    }

    public static void run() {
        Catalog catalog = new Catalog();

        catalog.addLaptop(new Laptop("ASUS", 16, 256, "Linux", "Black"));
        catalog.addLaptop(new Laptop("ASUS", 32, 256, "Linux", "Black"));
        catalog.addLaptop(new Laptop("Lenovo", 8, 256, "Windows10", "Silver"));
        catalog.addLaptop(new Laptop("Lenovo", 16, 512, "Windows11", "White"));
        catalog.addLaptop(new Laptop("Huawei", 64, 512, "Windows11", "Pink"));

        SearchLaptopService searchLaptopService = new SearchLaptopService(setCriteria(), catalog.getLaptopSet());
        System.out.println(searchLaptopService.getSearchResult());
    }

    public static void main(String[] args) {
        do {
            run();
        } while (isContinue("Хотите осуществить новый поиск в каталоге по другим критериям?"));
    }
}
