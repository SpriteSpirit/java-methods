import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    /* Task #1
    Реализуйте метод, который получает в качестве параметра год, а затем проверяет, является ли он високосным,
    и выводит результат в консоль. Эту проверку вы уже реализовывали в задании по условным операторам.
    Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
    Результат программы выведите в консоль.
    Если год високосный, то должно быть выведено “*номер года —* високосный год”.
    Если год не високосный, то, соответственно: “*номер года —* не **високосный год”.
     */
    public static void leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " - is a leap year");
        } else {
            System.out.println(year + " - isn't a leap year");
        }
    }

    /* Task #2
     Напишите метод, куда подаются два параметра: тип операционной системы (ОС)
     (0 — iOS или 1 — Android) и год выпуска устройства. Если устройство старше текущего года,
     предложите ему установить lite-версию (облегченную версию).
     Текущий год можно получить таким способом: int currentYear = LocalDate.now().getYear();
     Или самим задать значение вручную, введя в переменную числовое значение.
     В результате программа должна выводить в консоль в зависимости от исходных данных,
     какую версию приложения (обычную или lite) и для какой ОС (Android или iOS) нужно установить пользователю.
      */
    public static int getClientOS() {
        Scanner os = new Scanner(System.in);
        System.out.print("Input Device OS: ");
        String name = os.nextLine();

        if (name.equals("iOS")) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void clientDeviceYear() {
        int currentYear = LocalDate.now().getYear();
        int clientOs = getClientOS();

        Scanner deviceYear = new Scanner(System.in);
        System.out.print("Input Device Year: ");
        int DeviceYear = deviceYear.nextInt();

        boolean okDeviceYear = DeviceYear >= 2015 && DeviceYear <= currentYear;

        if (okDeviceYear) {
            if (clientOs == 1) {
                System.out.println("Application will work correctly for Android");
            } else if (clientOs == 0) {
                System.out.println("Application will work correctly for IOS");
            }
        } else {
            if (clientOs == 1) {
                System.out.println("Install light version for Android from link");
            } else if (clientOs == 0) {
                System.out.println("Install light version for IOS from link");
            }
        }
    }

    /* Task #3
    Написать метод, который на вход принимает дистанцию и возвращает итоговое количество дней доставки.
     */
    public static void deliveryDistance() {
        int deliveryDay = 1;

        Scanner distance = new Scanner(System.in);
        System.out.print("Input distance: ");
        int deliveryDistance = distance.nextInt();

        boolean zone1 = deliveryDistance <= 20;
        boolean zone2 = deliveryDistance > 20 && deliveryDistance < 60;
        boolean zone3 = deliveryDistance >= 60 && deliveryDistance <= 100;

        if (zone1) {
            System.out.println("It will takes: " + deliveryDay + " day");
        } else if (zone2) {
            deliveryDay += 1;
            System.out.println("Delivery takes: " + deliveryDay + " days");
        } else if (zone3) {
            deliveryDay += 2;
            System.out.println("Delivery takes: " + deliveryDay + " days");
        }
    }
    /* Task #4
       Напишите метод, который в виде параметра принимает отсортированную строку.
       Например, aabccddefgghiijjkk.
       С помощью цикла проверьте, что в строке нет дублей, и выведите в консоль сообщение об этом.
       Если дубль найден, нужно прервать поиск по остальным символам и вывести сообщение о присутствии дубля,
       причем с указанием, какой именно символ задублирован. Затем сразу же прервать выполнение метода.
       Сам метод ничего возвращать не должен (void).
    */

    public static void getRepeatingLetter() {
        String line = "aabccddefgghiijjkk";
        for (int index = 0; true; index++) {
            if (line.lastIndexOf(line.charAt(index)) != index) {
                System.out.println("Repeating letter is " + line.charAt(index));
                break;
            }
        }
    }

    /* Task #5
       Напишите метод, который получает на вход массив и переставляет все его элементы в обратном порядке
    */
    public static void reverseFullName() {
        char[] fullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int n = fullName.length - 1; n >= 0; n--) {
            System.out.print(fullName[n]);
        }
    }


    public static void main(String[] args) {
        // Task #1
        Scanner inputYear = new Scanner(System.in);
        System.out.print("Input the Year: ");
        leapYear(inputYear.nextInt());

        System.out.println(); // empty line

        // Task #2
        clientDeviceYear();

        // Task #3
        deliveryDistance();

        // Task #4
        getRepeatingLetter();

        // Task #5
        reverseFullName();
    }
}