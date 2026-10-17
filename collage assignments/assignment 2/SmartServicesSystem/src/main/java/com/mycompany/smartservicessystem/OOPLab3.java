package com.mycompany.smartservicessystem;

public class OOPLab3 {

    // ---------- helpers (they only compare results; no business rules) ----------

    private static int passed = 0;
    private static int failed = 0;

    // Records and reports one test result.
    private static void check(String testName, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("PASS: " + testName);
        } else {
            failed++;
            System.out.println("FAIL: " + testName);
        }
    }

    // Compares two doubles with a small tolerance.
    private static boolean sameValue(double a, double b) {
        return Math.abs(a - b) < 0.001;
    }

    // Runs an action and returns true if it threw an exception.
    private static boolean throwsException(Runnable action) {
        try {
            action.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    // ---------- main: creates the objects and tests them ----------

    public static void main(String[] args) {

        // =====================================================
        // PART 1: MovieTicket
        // =====================================================

        // 1. A normal ticket
        MovieTicket t1 = new MovieTicket("T001", "Inception", "Ahmed", "A1", 200);
        check("Normal ticket: id stored", t1.getTicketId().equals("T001"));
        check("Normal ticket: starts not booked", !t1.isBooked());
        check("Normal ticket: starts with 0% discount", sameValue(t1.getDiscountPercentage(), 0));
        check("Normal ticket: price stored", sameValue(t1.getPrice(), 200));
        check("Normal ticket: final price equals price", sameValue(t1.calculateFinalPrice(), 200));

        // 2. A negative price
        check("Negative price in constructor is rejected",
                throwsException(() -> new MovieTicket("T002", "Inception", "Sara", "A2", -50)));
        check("Negative price in setter is rejected",
                throwsException(() -> t1.setPrice(-10)));
        check("Rejected setter leaves the price unchanged", sameValue(t1.getPrice(), 200));

        // 3. A zero-price ticket
        MovieTicket tZero = new MovieTicket("T003", "Inception", "Omar", "A3", 0);
        check("Zero-price ticket can be created", sameValue(tZero.getPrice(), 0));
        check("Zero-price ticket cannot be booked", throwsException(() -> tZero.bookTicket()));
        check("Failed booking leaves zero-price ticket not booked", !tZero.isBooked());

        // 4. A valid discount
        t1.applyDiscount(10);
        check("Valid discount is stored", sameValue(t1.getDiscountPercentage(), 10));
        check("Discount does not change the stored price", sameValue(t1.getPrice(), 200));
        check("0% discount boundary is accepted", !throwsException(() -> tZero.applyDiscount(0)));
        check("100% discount boundary is accepted", !throwsException(() -> tZero.applyDiscount(100)));

        // 5. An invalid discount
        check("Discount above 100 is rejected", throwsException(() -> t1.applyDiscount(150)));
        check("Negative discount is rejected", throwsException(() -> t1.applyDiscount(-5)));
        check("Rejected discounts leave the old discount", sameValue(t1.getDiscountPercentage(), 10));

        // 6. Final price before booking (discount only, no fee)
        check("Final price before booking = 180", sameValue(t1.calculateFinalPrice(), 180));

        // 7. Successful booking
        check("Booking an unbooked ticket succeeds", !throwsException(() -> t1.bookTicket()));
        check("Ticket is booked after booking", t1.isBooked());

        // 8. Final-price calculation (discount first, then 10% fee)
        check("Final price after booking = 198", sameValue(t1.calculateFinalPrice(), 198));
        check("Calling it again gives the same result", sameValue(t1.calculateFinalPrice(), 198));
        check("Stored price is still 200", sameValue(t1.getPrice(), 200));

        // 9. Repeated booking
        check("Booking an already booked ticket is rejected", throwsException(() -> t1.bookTicket()));
        check("Ticket is still booked", t1.isBooked());

        // 10. Changing seats while booked
        check("Changing seat while booked is rejected", throwsException(() -> t1.setSeatNumber("B2")));
        check("Seat is unchanged", t1.getSeatNumber().equals("A1"));

        // 11. Cancelling a booking
        check("Cancelling a booked ticket succeeds", !throwsException(() -> t1.cancelTicket()));
        check("Ticket is not booked after cancelling", !t1.isBooked());
        check("Cancelling an unbooked ticket is rejected", throwsException(() -> t1.cancelTicket()));
        check("Fee is removed after cancelling (final = 180)", sameValue(t1.calculateFinalPrice(), 180));

        // 12. Changing the seat after cancellation
        check("Changing seat after cancelling succeeds", !throwsException(() -> t1.setSeatNumber("B2")));
        check("Seat is now B2", t1.getSeatNumber().equals("B2"));

        // 13. A cancelled ticket can be booked again
        check("Cancelled ticket can be booked again", !throwsException(() -> t1.bookTicket()));
        check("Final price is 198 again", sameValue(t1.calculateFinalPrice(), 198));

        // =====================================================
        // PART 2: DigitalWallet
        // =====================================================

        // Creation
        DigitalWallet a = new DigitalWallet("W001", "Ahmed", 2000);
        DigitalWallet b = new DigitalWallet("W002", "Sara", 100);
        check("Wallet: starts with the given balance", sameValue(a.getBalance(), 2000));
        check("Wallet: starts with 0 transactions", a.getTransactionCount() == 0);
        check("Wallet: negative starting balance is rejected",
                throwsException(() -> new DigitalWallet("W003", "Omar", -100)));
        check("Wallet: zero starting balance is allowed",
                !throwsException(() -> new DigitalWallet("W004", "Omar", 0)));
        check("Wallet: blank owner name is rejected",
                throwsException(() -> new DigitalWallet("W005", "  ", 100)));
        check("Wallet: blank owner name in setter is rejected", !a.setOwnerName(""));
        check("Wallet: owner name unchanged after rejected setter", a.getOwnerName().equals("Ahmed"));

        // Valid deposit
        check("Valid deposit succeeds", a.deposit(500));
        check("Valid deposit increases balance (2500)", sameValue(a.getBalance(), 2500));
        check("Valid deposit increases count (1)", a.getTransactionCount() == 1);

        // Invalid deposit
        check("Deposit of 0 is rejected", !a.deposit(0));
        check("Negative deposit is rejected", !a.deposit(-50));
        check("Invalid deposits leave balance unchanged", sameValue(a.getBalance(), 2500));
        check("Invalid deposits leave count unchanged", a.getTransactionCount() == 1);

        // Valid withdrawal
        check("Valid withdrawal succeeds", a.withdraw(300));
        check("Valid withdrawal decreases balance (2200)", sameValue(a.getBalance(), 2200));
        check("Valid withdrawal increases count (2)", a.getTransactionCount() == 2);

        // Invalid withdrawal
        check("Withdrawal of 0 is rejected", !a.withdraw(0));
        check("Negative withdrawal is rejected", !a.withdraw(-10));
        check("Invalid withdrawals leave balance unchanged", sameValue(a.getBalance(), 2200));
        check("Invalid withdrawals leave count unchanged", a.getTransactionCount() == 2);

        // Insufficient balance
        check("Withdrawal above the balance is rejected", !a.withdraw(5000));
        check("Insufficient withdrawal leaves balance unchanged", sameValue(a.getBalance(), 2200));
        check("Insufficient withdrawal leaves count unchanged", a.getTransactionCount() == 2);
        DigitalWallet exact = new DigitalWallet("W006", "Mona", 100);
        check("Withdrawing the exact balance succeeds", exact.withdraw(100));
        check("Balance is 0 after withdrawing everything", sameValue(exact.getBalance(), 0));
        check("Nothing left to withdraw", !exact.withdraw(1));

        // Successful transfer (500 -> fee 10)
        check("Successful transfer returns true", a.transfer(b, 500));
        check("Sender pays amount + fee (2200 - 510 = 1690)", sameValue(a.getBalance(), 1690));
        check("Receiver gets the full amount (100 + 500 = 600)", sameValue(b.getBalance(), 600));
        check("Sender count increased (3)", a.getTransactionCount() == 3);
        check("Receiver count increased (1)", b.getTransactionCount() == 1);

        // Failed transfer: not enough for amount + fee (1000 + 15 > 600)
        check("Transfer with insufficient funds fails", !b.transfer(a, 1000));
        check("Failed transfer leaves sender balance", sameValue(b.getBalance(), 600));
        check("Failed transfer leaves receiver balance", sameValue(a.getBalance(), 1690));
        check("Failed transfer leaves both counts", b.getTransactionCount() == 1 && a.getTransactionCount() == 3);

        // Transfer to null
        check("Transfer to null fails", !a.transfer(null, 100));
        check("Null transfer leaves balance and count", sameValue(a.getBalance(), 1690) && a.getTransactionCount() == 3);

        // Transfer to the same wallet
        check("Transfer to the same wallet fails", !a.transfer(a, 100));
        check("Same-wallet transfer leaves balance and count", sameValue(a.getBalance(), 1690) && a.getTransactionCount() == 3);

        // Invalid transfer amounts
        check("Transfer of 0 fails", !a.transfer(b, 0));
        check("Negative transfer fails", !a.transfer(b, -5));
        check("Invalid amounts leave both wallets unchanged",
                sameValue(a.getBalance(), 1690) && sameValue(b.getBalance(), 600)
                && a.getTransactionCount() == 3 && b.getTransactionCount() == 1);

        // Transaction-fee boundary values: one big sender, compare balances before and after
        DigitalWallet feeSender = new DigitalWallet("S", "Sender", 100000);
        DigitalWallet feeReceiver = new DigitalWallet("R", "Receiver", 0);
        double senderBefore;
        double receiverBefore;

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 100);
        check("Fee: 100 -> 5",
                sameValue(senderBefore - feeSender.getBalance(), 105)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 100));

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 499.99);
        check("Fee: 499.99 -> 5",
                sameValue(senderBefore - feeSender.getBalance(), 504.99)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 499.99));

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 500);
        check("Fee: 500 -> 10",
                sameValue(senderBefore - feeSender.getBalance(), 510)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 500));

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 999.99);
        check("Fee: 999.99 -> 10",
                sameValue(senderBefore - feeSender.getBalance(), 1009.99)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 999.99));

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 1000);
        check("Fee: 1000 -> 15",
                sameValue(senderBefore - feeSender.getBalance(), 1015)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 1000));

        senderBefore = feeSender.getBalance();
        receiverBefore = feeReceiver.getBalance();
        feeSender.transfer(feeReceiver, 2000);
        check("Fee: 2000 -> 15",
                sameValue(senderBefore - feeSender.getBalance(), 2015)
                && sameValue(feeReceiver.getBalance() - receiverBefore, 2000));

        // Boundary: the sender must cover amount + fee exactly
        DigitalWallet exactSender = new DigitalWallet("W007", "Nour", 1015);
        DigitalWallet target1 = new DigitalWallet("W008", "Hana", 0);
        check("Transfer succeeds when balance = amount + fee", exactSender.transfer(target1, 1000));
        check("Sender is left with 0", sameValue(exactSender.getBalance(), 0));

        DigitalWallet shortSender = new DigitalWallet("W009", "Ali", 1014.99);
        DigitalWallet target2 = new DigitalWallet("W010", "Lina", 0);
        check("Transfer fails when 1 piastre short", !shortSender.transfer(target2, 1000));
        check("Short sender keeps its balance", sameValue(shortSender.getBalance(), 1014.99));
        check("Target is untouched", sameValue(target2.getBalance(), 0) && target2.getTransactionCount() == 0);

        // Transaction counts across a mix of successes and failures
        DigitalWallet x = new DigitalWallet("W011", "Khaled", 1000);
        DigitalWallet y = new DigitalWallet("W012", "Dina", 0);
        x.deposit(100);       // success -> x: 1
        x.deposit(-1);        // fail
        x.withdraw(50);       // success -> x: 2
        x.withdraw(99999);    // fail
        check("Counts after deposits/withdrawals: x = 2", x.getTransactionCount() == 2);
        x.transfer(y, 100);   // success -> x: 3, y: 1
        x.transfer(null, 10); // fail
        x.transfer(x, 10);    // fail
        x.transfer(y, 99999); // fail
        check("Counts after mixed operations: x = 3", x.getTransactionCount() == 3);
        check("Counts after mixed operations: y = 1", y.getTransactionCount() == 1);
        check("Final balances are consistent (x = 1000+100-50-100-5 = 945, y = 100)",
                sameValue(x.getBalance(), 945) && sameValue(y.getBalance(), 100));

        // =====================================================
        // PART 3: DeliveryOrder
        // =====================================================

        // Creation (cash order)
        DeliveryOrder o1 = new DeliveryOrder("O001", "Ahmed", "12 Nile St", 3, 400);
        check("Order: cash payment method", o1.getPaymentMethod().equals("cash"));
        check("Order: starts unpaid", !o1.orderPaymentStatus());
        check("Order: starts undelivered", !o1.orderDeliveryStatus());
        check("Order: total = subtotal + delivery (400 + 50 = 450)", sameValue(o1.calculateTotal(), 450));

        // Invalid constructor data
        check("Order: item count 0 is rejected",
                throwsException(() -> new DeliveryOrder("O2", "Sara", "Addr", 0, 100)));
        check("Order: negative item count is rejected",
                throwsException(() -> new DeliveryOrder("O3", "Sara", "Addr", -2, 100)));
        check("Order: negative subtotal is rejected",
                throwsException(() -> new DeliveryOrder("O4", "Sara", "Addr", 1, -1)));
        check("Order: zero subtotal is allowed",
                !throwsException(() -> new DeliveryOrder("O5", "Sara", "Addr", 1, 0)));
        check("Order: blank customer name is rejected",
                throwsException(() -> new DeliveryOrder("O6", " ", "Addr", 1, 100)));
        check("Order: blank address is rejected",
                throwsException(() -> new DeliveryOrder("O7", "Sara", "", 1, 100)));
        check("Order: blank order id is rejected",
                throwsException(() -> new DeliveryOrder("", "Sara", "Addr", 1, 100)));
        check("Order: null wallet is rejected for a wallet order",
                throwsException(() -> new DeliveryOrder("O8", "Sara", "Addr", 1, 100, null)));

        // Setters validate before storing
        check("Setter: item count 0 is rejected", !o1.setItemCount(0));
        check("Setter: negative subtotal is rejected", !o1.setSubTotal(-1));
        check("Setter: blank name is rejected", !o1.setCustomerName(""));
        check("Setter: blank address is rejected", !o1.setDeliveryAddress("  "));
        check("Rejected setters leave the data unchanged",
                o1.getItemCount() == 3 && sameValue(o1.getSubTotal(), 400)
                && o1.getCustomerName().equals("Ahmed") && o1.getDeliveryAddress().equals("12 Nile St"));
        check("Setter: valid item count is accepted", o1.setItemCount(5));
        check("Setter: item count updated", o1.getItemCount() == 5);

        // Delivery-cost boundaries (the cost method is private, so check the total)
        check("Delivery cost: 0 -> 50",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 0).calculateTotal(), 50));
        check("Delivery cost: 499.99 -> 50",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 499.99).calculateTotal(), 549.99));
        check("Delivery cost: 500 -> 30",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 500).calculateTotal(), 530));
        check("Delivery cost: 999.99 -> 30",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 999.99).calculateTotal(), 1029.99));
        check("Delivery cost: 1000 -> 10",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 1000).calculateTotal(), 1010));
        check("Delivery cost: 2000 -> 10",
                sameValue(new DeliveryOrder("O", "Customer", "Address", 1, 2000).calculateTotal(), 2010));

        // Cash order flow
        check("Unpaid order cannot be delivered", !o1.deliverOrder());
        check("Failed delivery leaves the order undelivered", !o1.orderDeliveryStatus());
        check("Cash order can be paid", o1.payOrder());
        check("Order is paid after payment", o1.orderPaymentStatus());
        check("Paying twice is rejected", !o1.payOrder());
        check("Paid order cannot change item count", !o1.setItemCount(1));
        check("Paid order cannot change subtotal", !o1.setSubTotal(100));
        check("Paid order data unchanged", o1.getItemCount() == 5 && sameValue(o1.getSubTotal(), 400));
        check("Paid order can be delivered", o1.deliverOrder());
        check("Order is delivered", o1.orderDeliveryStatus());
        check("Delivering twice is rejected", !o1.deliverOrder());

        // Wallet order with enough money
        DigitalWallet w1 = new DigitalWallet("W100", "Sara", 1000);
        DeliveryOrder o2 = new DeliveryOrder("O009", "Sara", "5 Palm Rd", 2, 400, w1);
        check("Order: wallet payment method", o2.getPaymentMethod().equals("wallet"));
        check("Wallet order starts unpaid", !o2.orderPaymentStatus());
        check("Wallet order can be paid", o2.payOrder());
        check("Wallet is charged exactly the total (1000 - 450 = 550)", sameValue(w1.getBalance(), 550));
        check("Wallet transaction count increased by 1", w1.getTransactionCount() == 1);
        check("Wallet order is paid", o2.orderPaymentStatus());
        check("Second payment is rejected", !o2.payOrder());
        check("Second payment does not charge the wallet again",
                sameValue(w1.getBalance(), 550) && w1.getTransactionCount() == 1);
        check("Paid wallet order can be delivered", o2.deliverOrder());

        // Wallet order without enough money
        DigitalWallet w2 = new DigitalWallet("W101", "Omar", 100);
        DeliveryOrder o3 = new DeliveryOrder("O010", "Omar", "9 Sea St", 1, 400, w2);
        check("Payment fails when the wallet is too low", !o3.payOrder());
        check("Failed payment leaves the order unpaid", !o3.orderPaymentStatus());
        check("Failed payment leaves the wallet unchanged",
                sameValue(w2.getBalance(), 100) && w2.getTransactionCount() == 0);
        check("Unpaid wallet order cannot be delivered", !o3.deliverOrder());
        w2.deposit(400);
        check("After topping up, the same order can be paid", o3.payOrder());
        check("Wallet is charged after the retry (500 - 450 = 50)", sameValue(w2.getBalance(), 50));

        // Wallet holding exactly the total
        DigitalWallet w3 = new DigitalWallet("W102", "Mona", 450);
        DeliveryOrder o4 = new DeliveryOrder("O011", "Mona", "3 Park Ave", 1, 400, w3);
        check("Wallet with exactly the total can pay", o4.payOrder());
        check("Wallet is left with 0", sameValue(w3.getBalance(), 0));

        // =====================================================
        // Summary
        // =====================================================
        check("All tests passed (failed count is 0)", failed == 0);
    }
}