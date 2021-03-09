package Lab2;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import Lab2.Interfaces.*;
public class main extends Student {

    public main(int age, String name) {
        super(age, name);
    }
    //region------Task 35----------
    public static int[] Func35(int[]array,FuncConverting convertion){
        Set<Integer> items = new HashSet<Integer>();
        for(int item:array){
            item= convertion.convert(item);
            items.add(item);
        }
        return items.stream().mapToInt(Integer::intValue).toArray();
    }
    //endregion
    //region ------Task 36-------
    public static void Func36(Student[]students,BubbleSort bbsort){
           bbsort.bubbleSort(students);
         for(Student s:students){
             System.out.println(s);
         }
    }
    //endregion
    public static void main(String[] args) {

        FuncConverting convertion=(x)->3*x*x+5*x-21;
        Predicate isPositive = x -> x > 0;
        int[]array={1,3,-3,6,2,-6};
        //region ------Task 31-------

        //Створіть метод, який дозволяє фільтрувати елементи будь якого масиву
        // int та виводити ці елементи на консоль.
        // Умови фільтрації повинні передаватися в метод,
        // як параметр. Використовуйте функціональні інтерфейси та анонімні класи.

        Filter filtering = new  Filter() {
            @Override
            public int[] Func31(int[]array, Predicate filter){
                Set<Integer> items = new HashSet<Integer>();
                for(int item:array){
                    if(filter.test(item)) {
                        items.add(item);
                    }

                }
               return items.stream().mapToInt(Integer::intValue).toArray();

            }
        };
        int[] resultArray31=filtering.Func31(array,isPositive);
        for(int item:resultArray31){
            System.out.println(item);
        }
        System.out.println("--------------------");
        int[] resultArray35=Func35(array,convertion);
        for(int item:resultArray35){
            System.out.println(item);
        }
        //endregion
        //region ------Task 36-------

        //Створіть метод, який дозволяє сортувати масив Студентів у відповідності
        // до критерію сортування (за віком, за прізвищем та інше).
        // Масив та критерій сортування передаються як критерії методу.
        // Сортування реалізувати методом бульбашки.

        Student[]students={new Student(22,"Carlyle"),
                new Student(19,"Edward"),
                new Student(20,"Jacob")};

        BubbleSort bbsort=(Student[]students1)-> {for (int a = 1; a < students.length; a++) {
            for (int b = 0; b < students.length - a; b++) {
                if (((students[b].getName())
                        .compareTo((students[b + 1].getName()))) > 0) {
                    Student temp = students[b];
                    students[b] = students[b + 1];
                    students[b + 1] = temp;
                }
            }
        }
        };
        System.out.println("-------после сортировки-----");
        Func36(students,bbsort);
        System.out.println("--------------------");
        //endregion
        //region------Task 44-------

        //Створіть тестовий приклад, який демонструє використання
        // інтерфейсу у якості локальної змінної, параметра методу,
        // у якості значення, що повертається.

        Printable printable = createPrintable("Foreign Affairs",false);
        printable.print();
        read(new Book("Java for impatients", "Cay Horstmann"));
        read(new Journal("Java Dayly News"));
//endregion
        //region------Task 46-------

        //Створіть просту  ієрархію спадкування, яка відповідає сутностям Користувач
        // (властивості: логін, пароль, емейл, телефон) та Покупець (рахунок, адреса доставки),
        // Продавець (№ підрозділу, дата прийняття на роботу,
        // загальна сума торгових бонусів).
        // Продемонструйте перевантаження конструкторів та методів,
        // перевизначення методів, особливості роботи конструкторів при спадкуванні.

        User newUser=new User("j345j36b",
                "484dfg8265Pin",
                "smth.com",+50243);
        System.out.println(newUser);
        Seller seller=new Seller("6sdfhsdghs","89257njsdg",
                "smthsfh",50274,
                44, LocalDate.of(2002,03,22),
                5000);
        System.out.println(seller);
        System.out.println("-------перегрузка методов----");
        seller.Add("@gmail.com");
        seller.Add(38000);
        //endregion

    }

    static void read(Printable p){
        p.print();
    }
    static Printable createPrintable(String name, boolean option) {

        if (option)
            return new Book(name, "Undefined");
        else
            return new Journal(name);
    }
}




