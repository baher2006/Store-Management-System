public class Customer {
        private  String customerName;
        private  String paymentMethod;
        private  double debt;

        public Customer(String customerName, String paymentMethod, double debt) {
            this.customerName = customerName;
            this.paymentMethod = paymentMethod;
            this.debt = debt;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public double getDebt() {
            return debt;
        }
}
