/*
 Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

find(String name): Поиск номеров телефона по имени в телефонной книге.
Если запись с именем name существует, возвращает список номеров телефона для этой записи.
Если запись с именем name не существует, возвращает пустой список.

getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров телефона.

Пример.

На входе:

add("Alice", 123456);   
add("Alice", 789012);   
add("Bob", 789012);   
На выходе:

Команды:

find("Alice")
getPhoneBook()
find("Me")
Результат:

[123456, 789012]. 
{Bob=[789012], Alice=[123456, 789012]} 
[]
 */

import java.util.ArrayList;
import java.util.HashMap;

public class task1 {
    public static void main(String[] args) {
        String name1 = "Ivanov";
        String name2 = "Petrov";
        int phone1 = 123456;
        int phone2 = 654321;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }
}

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        // Введите свое решение ниже
        if (phoneBook.containsKey(name))
            phoneBook.get(name).add(phoneNum);
        else {
            ArrayList<Integer> aL = new ArrayList<>();
            aL.add(phoneNum);
            phoneBook.put(name, aL);
        }
}

    public ArrayList<Integer> find(String name) {
// Введите свое решение ниже
        if (phoneBook.containsKey(name)) return phoneBook.get(name);
        else return new ArrayList<Integer>();
}

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
// Введите свое решение ниже
        return phoneBook;
    }
}
