import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaxiService {

    private List<Car> cars = new ArrayList<>();
    private Random rand = new Random();

    TaxiService() {
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                cars.add(new BusinessCar());
            } else {
                cars.add(new EconomCar());
            }
        }
    }

    // Основная задача — доход за рабочую неделю (5 дней по 8 часов)
    int calculateWeekIncome() {
        int total = 0;
        for (int day = 1; day <= 5; day++) {
            for (Car car : cars) {
                int hours = rand.nextInt(8) + 1; // от 1 до 8
                total = total + car.calculate(hours);
            }
        }
        return total;
    }

    // Дополнительная задача — каждый день увольняем таксиста с самым низким доходом
    int calculateWeekIncomeWithDismissal() {
        List<Car> currentCars = new ArrayList<>(cars);
        int total = 0;

        for (int day = 1; day <= 5; day++) {
            Car worstCar = null;
            int worstIncome = Integer.MAX_VALUE;

            for (Car car : currentCars) {
                int hours = rand.nextInt(8) + 1;
                int income = car.calculate(hours);
                total = total + income;

                if (income < worstIncome) {
                    worstIncome = income;
                    worstCar = car;
                }
            }

            if (worstCar != null && currentCars.size() > 1) {
                currentCars.remove(worstCar);
            }
        }
        return total;
    }
}