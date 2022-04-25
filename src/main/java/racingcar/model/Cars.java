package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final int CARS_SIZE_MIN = 2;

    private List<Car> cars;

    public Cars(String input) {
        validateCarNames(input);

        cars = new ArrayList<>();

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void validateCarNames(String input) {
        String[] carNames = input.split(",");
        if (carNames.length < CARS_SIZE_MIN) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public int getMaxMileage() {
        int max = 0;
        for (Car car : cars) {
            int mileage = car.getMileage();
            if (max <= mileage) {
                max = mileage;
            }
        }
        return max;
    }
}
