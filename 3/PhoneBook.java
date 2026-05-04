import java.util.HashMap;

class Contact {
    private String name;
    private String email;
    private String additionalInfo;

    public Contact(String name, String email, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s | Email: %s | Инфо: %s", name, email, additionalInfo);
    }
}


public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Contact> phoneBook = new HashMap<>();

        System.out.println("--- Тестирование Телефонной Книги ---");

        phoneBook.put("89001112233", new Contact("Иван Петров", "ivan@example.com", "Мобильный"));
        phoneBook.put("89165554433", new Contact("Мария Сидорова", "masha@mail.ru", "Рабочий"));
        phoneBook.put("88007776655", new Contact("Техподдержка", "support@service.ru", "Дополнительный"));

        String searchNum = "89165554433";
        System.out.println("Поиск номера " + searchNum + ":");
        Contact found = phoneBook.get(searchNum);
        if (found != null) {
            System.out.println("Результат: " + found);
        } else {
            System.out.println("Контакт не найден.");
        }

        System.out.println("\nУдаление контакта 88007776655...");
        phoneBook.remove("88007776655");

        System.out.println("Всего контактов в книге: " + phoneBook.size());

        System.out.println("\n--- Тестирование HashTable (Задание 1) ---");
        HashTable<Integer, String> customTable = new HashTable<>();
        customTable.put(1, "Тестовое значение");
        System.out.println("Значение из HashTable: " + customTable.get(1));
    }
}
