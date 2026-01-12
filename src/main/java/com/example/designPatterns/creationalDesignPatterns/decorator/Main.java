package com.example.designPatterns.creationalDesignPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        // just a vanilla cone ice cream
        IceCream i1 = new VanillaCone();
        System.out.println("Description: " + i1.getDescription());
        System.out.println("Cost: " + i1.getCost());

        // vanilla cone with chocolate scoop ice cream
        IceCream i2 = new ChocolateScoop(
                new VanillaCone()
        );
        System.out.println("Description: " + i2.getDescription());
        System.out.println("Cost: " + i2.getCost());

        // vanilla cone, chocolate scoop, choco cone, vanilla scoop, choco chip
        IceCream i3 = new ChocolateChip(
                new VanillaScoop(
                        new ChocolateCone(
                                new ChocolateScoop(
                                        new VanillaCone()
                                )
                        )
                )
        );
        System.out.println("Description: " + i3.getDescription());
        System.out.println("Cost: " + i3.getCost());
    }
}
