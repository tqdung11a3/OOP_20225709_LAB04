import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<DigitalVideoDisc> dvdsInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc dvd) {
        dvdsInStore.add(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (dvdsInStore.contains(dvd)) {
            dvdsInStore.remove(dvd);
        } else {
            System.out.println("The DVD " + dvd.getTitle() + " is not found in the store.");
        }
    }

    public boolean checkDVD(String title) {
        for (DigitalVideoDisc dvd : dvdsInStore) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                System.out.println("The DVD " + title + " is available in the store.");
                return true;
            }
        }
        System.out.println("The DVD " + title + " is not available in the store.");
        return false;
    }

    public void print() {
        System.out.println("DVDs in the store:");
        for (int i = 0; i < dvdsInStore.size(); i++) {
            DigitalVideoDisc dvd = dvdsInStore.get(i);
            System.out.println((i + 1) + ". Title: " + dvd.getTitle() +
                               ", Category: " + dvd.getCategory() +
                               ", Director: " + dvd.getDirector() +
                               ", Length: " + dvd.getLength() +
                               ", Cost: " + dvd.getCost());
        }
    }
}
