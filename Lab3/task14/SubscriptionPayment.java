package task14;

public class SubscriptionPayment implements PaymentPolicy {
    private final String plan;

    public SubscriptionPayment(String plan) {
        this.plan = plan;
    }

    @Override
    public String describe() {
        return "Subscribe: " + plan;
    }
}