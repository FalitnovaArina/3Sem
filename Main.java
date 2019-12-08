/*
  В следующих заданиях требуется создать суперкласс (абстрактный класс, интерфейс) и определить общие методы для
  данного класса. Создать подклассы, в которых добавить специфические свойства и методы. Часть методов переопределить.
  Создать массив объектов суперкласса и заполнить объектами подклассов. Объекты подклассов идентифицировать
  конструктором по имени или идентификационному номеру. Использовать объекты подклассов для моделирования реальных
  ситуаций и объектов
 */

import transports.Bicycle;
import transports.Car;
import transports.Cart;
import transports.TransportInterface;

import java.util.ArrayList;

/**
 * Создать суперкласс Транспортное средство и подклассы Автомобиль, Велосипед, Повозка.
 * Подсчитать время и стоимость перевозки пассажиров и грузов каждым транспортным средством.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<TransportInterface> arrayList = new ArrayList<>();

        TransportInterface car = new Car(1, 50);
        arrayList.add(car);
        TransportInterface bicycle = new Bicycle(2, 50);
        arrayList.add(bicycle);
        TransportInterface cart = new Cart(3, 50);
        arrayList.add(cart);

        arrayList.forEach(TransportInterface::calc);
    }
}
