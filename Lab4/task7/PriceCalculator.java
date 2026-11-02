package Lab4.task7;

public class PriceCalculator {
    public int calculatePrice(int price) {
        if (price < 0) {
            throw new CalculationException("Цена меньше нуля");
        }
        return price;
    }
}
