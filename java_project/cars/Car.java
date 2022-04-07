
package cars; // папка где лежит Car.java
import java.util.ArrayList; // импортируем коллекцию. java.util - встроенный пакет
import java.util.HashSet;
import java.util.HashMap;

public class Car { // Вроде как мы можем создать ток 1 публичный класс
    int speed; // int - натурально число 32-bit
    int maxSpeed;

    
    public Car(int speed, int maxSpeed){  // Конструктор
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        System.out.println("Объект готов");
    }

    void start(){// Функция
        System.out.println("Я начал ехать");
        System.out.println(speed);
    }
    
    void stop(){// Функция
        System.out.println("Я остановился");
        System.out.println(maxSpeed);
    }

    void setSpeed(int speed) { // Если привысим скорость, то выведет сообщение
        if (speed < maxSpeed) {
            this.speed = speed;
        }
        else {
            System.out.println("Вы передали слишком большую скорость");
        }
     }

    public static void main(String[] args){// то, что запускает наш код
        var myCar = new Car(100, 500);
        var myCar2 = new Car(10, 50);
        var myCar3 = new Car(300, 1000);
        

        //myCar.start();
        //myCar.stop();
        //myCar.setSpeed(700);



        /* //////////////////////////////////////////////////////////////////////// */
        var garage = new Car[2]; // Создадим гараж для машин размером 2. Работать с массивом не удобно, нужно знать зараннее точный размер
        garage[0] = myCar;
        garage[1] = myCar2;
        
        /* for (Car car : garage){ // car - наша переменная, которую мы инициализируем в цикле
            car.start();
        } */



        /* //////////////////////////////////////////////////////////////////////// */
        // Поэтому создадим коллекцию. Здесь мы говорим, что будем использовать коллекцию на основе массива и что в нашей коллекции будут лежать объекты типа Car.
        var garage2 = new ArrayList<Car>();
        garage2.add(myCar);
        garage2.add(myCar2);
        garage2.add(myCar); // можем добавить такой же автомобиль

        for (Car car : garage2){
            car.start();
        }



        /* //////////////////////////////////////////////////////////////////////// */
        // Коллекция типа HashSet (множество) не позволит положить в себя два одинаковых значения
        var garage3 = new HashSet<Car>();
        garage3.add(myCar);



        
        // Коллекция HashMap. Позволяет присваивать объектам ключи и потом получать эти объекты по уникальному ключу:
        var garage4 = new HashMap<String, Car>();
        garage4.put("Мой авто", myCar);
        garage4.put("Мой спорт кар", myCar3);

        garage4.get("Мой спорт кар").start();

        try {
            garage4.get("второй авто").start();
         }catch (NullPointerException exception){
            System.out.println("В словаре нет автомобиля с таким ключем");
         }
       
        



        /* //////////////////////////////////////////////////////////////////////// */
        var str = "сложение"; // строки работают как и в javaScript
        var str2 =  new String(" строк");
        System.out.println(str + str2);
    }
}



