public class Main {

    public static void main(String[] args) {
        TaxiService service = new TaxiService();

        int income = service.calculateWeekIncome();
        System.out.println("Доход таксопарка за неделю = " + income);

        int incomeWithDismissal = service.calculateWeekIncomeWithDismissal();
        System.out.println("Доход таксопарка за неделю (с увольнениями) = " + incomeWithDismissal);
    }
}