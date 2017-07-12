/*
Author: Tasdique Chowdhury
Description: Final Project for Java OOP Elective Course, Summer 2017, Hunter College

Overall objective: Learn basics of streams and lambdas in Java 8

Miniature Objectives:
Perform the following queries on the List of Invoice objects and display the results:
a. Use lambdas and streams to sort the Invoice objects by PartDescription , then display the results.
b. Use lambdas and streams to sort the Invoice objects by Price , then display the results.
c. Use lambdas and streams to map each Invoice to its PartDescription and Quantity , sort the
results by Quantity , then display the results.
d. Use lambdas and streams to map each Invoice to its PartDescription and the value of the
Invoice (i.e., Quantity * Price ). Order the results by Invoice value.
e. Modify Part (d) to select the Invoice values in the range $200 to $500.
 */

package com.Tas;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nWelcome to my practice for Java 8 in using lambda expressions and streams...");
        System.out.println("Basically, given a list of invoice objects, I will follow a few instructions, given below:\n");

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(83, "Electric sander", 7, 57.98));
        invoices.add(new Invoice(24, "Power saw", 18, 99.99));
        invoices.add(new Invoice(7, "Sledgehammer", 11, 21.50));
        invoices.add(new Invoice(77, "Hammer", 76, 11.99));
        invoices.add(new Invoice(39, "Lawnmower", 3, 79.50));
        invoices.add(new Invoice(68, "Screwdriver", 106, 6.99));
        invoices.add(new Invoice(56, "Jigsaw", 21, 11.00));
        invoices.add(new Invoice(3, "Wrench", 34, 7.50));

        System.out.println("Part A) Sort by part description:");
        invoices
                .stream()
                .sorted((invoice1, invoice2) -> invoice1.getPartDesc().compareTo(invoice2.getPartDesc()))
                .forEach(invoice1 -> System.out.println(invoice1));

        System.out.println("\nPart B) Sort by price:");
        invoices
                .stream()
                .sorted((invoice1, invoice2) -> Double.compare(invoice1.getPrice(), invoice2.getPrice()))
                .forEach(invoice1 -> System.out.println(invoice1));

        System.out.println("\nPart C) Sort by quantity, map invoice to part description and quantity:");
        invoices
                .stream()
                .sorted((invoice1, invoice2) -> Integer.compare(invoice1.getQuantity(), invoice2.getQuantity()))
                .map(invoice1 -> (invoice1.getPartDescAndQuantity()))
                .forEach(invoice1 -> System.out.println(invoice1));

        System.out.println("\nPart D) Sort by value (quantity * price), map to part description and value:");
        invoices
                .stream()
                .sorted((invoice1, invoice2) -> Double.compare(invoice1.getValue(), invoice2.getValue()))
                .map(invoice1 -> invoice1.getPartDescAndValue())
                .forEach(invoice1 -> System.out.println(invoice1));

        System.out.println("\nPart E) Filter prices in range $200-$500, then do part D:");
        invoices
                .stream()
                .sorted((invoice1, invoice2) -> Double.compare(invoice1.getValue(), invoice2.getValue()))
                .filter(
                        invoice1 -> invoice1.getValue() >= 200
                                && invoice1.getValue() <= 500
                )
                .map(invoice1 -> invoice1.getPartDescAndValue())
                .forEach(invoice1 -> System.out.println(invoice1));
    }
}


