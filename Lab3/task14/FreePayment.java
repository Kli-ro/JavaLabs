package task14;

public class FreePayment implements PaymentPolicy {
    @Override
    public String describe() {
        return "Free";
    }
}