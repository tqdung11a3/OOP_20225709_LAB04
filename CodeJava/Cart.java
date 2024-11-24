import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Method to add a DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
        }
    	else {
    		itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
    	}
    }

    // Method to remove a DigitalVideoDisc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (itemsOrdered.length == 0) {
    		System.out.println("Cart is empty.");
    		return;
    	}
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;  // Clear the last item
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not found in the cart.");
        }
    }

    // Method to calculate the total cost of the cart
    public double totalCost() {
        double sum = 0.0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();  // Assuming getCost() method in DigitalVideoDisc
        }
        return sum;
    }

    // Method to search by title
    public void searchByTitle(String title) {
        System.out.println("Search results for title: " + title);
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(itemsOrdered[i].toString());
            }
        }
    }

    // Method to search by category
    public void searchByCategory(String category) {
        System.out.println("Search results for category: " + category);
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getCategory().equalsIgnoreCase(category)) {
                System.out.println(itemsOrdered[i].toString());
            }
        }
    }

    // Method to search by price range
    public void searchByPriceRange(float minPrice, float maxPrice) {
        System.out.println("Search results for price range: " + minPrice + " - " + maxPrice);
        for (int i = 0; i < qtyOrdered; i++) {
            float cost = itemsOrdered[i].getCost();
            if (cost >= minPrice && cost <= maxPrice) {
                System.out.println(itemsOrdered[i].toString());
            }
        }
    }

    // Method to sort DVDs by title
    public void sortByTitle() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered, new Comparator<DigitalVideoDisc>() {
            public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
                int titleComparison = dvd1.getTitle().compareTo(dvd2.getTitle());
                if (titleComparison == 0) {
                    return Float.compare(dvd2.getCost(), dvd1.getCost()); // Higher cost first
                }
                return titleComparison;
            }
        });
    }

    // Method to sort DVDs by cost
    public void sortByCost() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered, new Comparator<DigitalVideoDisc>() {
            public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
                int costComparison = Float.compare(dvd2.getCost(), dvd1.getCost()); // Higher cost first
                if (costComparison == 0) {
                    return dvd1.getTitle().compareTo(dvd2.getTitle()); // Alphabetical order if same cost
                }
                return costComparison;
            }
        });
    }

    // Method to get a random free item in the cart
    public DigitalVideoDisc getFreeItem() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
            return null;
        }
        int randomIndex = (int) (Math.random() * qtyOrdered);
        System.out.println("Free item: " + itemsOrdered[randomIndex].getTitle());
        return itemsOrdered[randomIndex];
    }

    // Method to filter DVDs in the cart by ID or title
    public void filterByIdOrTitle(String query) {
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc != null && disc.getTitle().equalsIgnoreCase(query)) {
                System.out.println("Found item: " + disc.toString());
                return;
            }
        }
        System.out.println("Item not found in the cart.");
    }
    
    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". Title: " + disc.getTitle() + 
                               ", Category: " + disc.getCategory() + 
                               ", Director: " + disc.getDirector() + 
                               ", Length: " + disc.getLength() + 
                               ", Cost: " + disc.getCost() + " $");
        }

        System.out.println("Total Cost: " + totalCost());
    }
}
