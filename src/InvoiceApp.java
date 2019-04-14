import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        // initialize variables for use in calculating averages invoice and average discount
        double invoiceTotal = 0.0;
        double discountTotal = 0.0;
        int invoiceCount = 0;

        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        // application ends only if user enters "n" or "N"
        while (!choice.equalsIgnoreCase("n")) {
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 500) {
                discountPercent = .25;
            } else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0.0;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // accumulate invoice count and invoice total
            invoiceTotal += total;
            discountTotal += discountAmount;
            invoiceCount += 1;

            // display the discount amount and total
            String message1 = "Discount percent: " + discountPercent + "\n"
                            + "Discount amount:  " + discountAmount + "\n"
                            + "Invoice total:    " + total + "\n";
            System.out.println(message1);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

        // calculate average invoice total
        double averageInvoice = invoiceTotal / invoiceCount;
        // calculate average discount
        double averageDiscount = discountTotal / invoiceCount;
        // calculate and display Number of invoices (invoiceCount)

        String message = "Number of invoices: " + invoiceCount + "\n"
                        + "Average invoice: " + averageInvoice + "\n"
                        + "Average discount: " + averageDiscount + "\n";
        System.out.println(message);
    }
}