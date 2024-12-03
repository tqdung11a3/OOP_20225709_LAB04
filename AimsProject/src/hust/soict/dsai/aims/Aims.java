package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void main(String[] args) {
		String author1 = "tqdung1", author2 = "tqdung2", author3 = "tqdung3";
		ArrayList<String> author = new ArrayList<>();
		author.add(author1);
		author.add(author2);
		author.add(author3);
		Book b1 = new Book(1, "Harry Potter", "Fantasy", 20.99f, author);
		Book b2 = new Book(2, "The Lord of the Rings", "Adventure", 15.50f);
		Book b3 = new Book(3, "To kill a MockingBird", "Classic Fiction", 10.99f, author);
		
		
		ArrayList<Track> track = new ArrayList<>();
		Track t1 = new Track("Boheim Raphody", 500);
		Track t2 = new Track("Stairway to Hraven", 142);
		Track t3 = new Track("Hotel California", 346);
		track.add(t1);
		track.add(t2);
		track.add(t3);
		CompactDisc cd = new CompactDisc(101, "Thriller", "Pop", 14.99f, 500, "John Lnadis", "Michael Jackson", track);
		
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(201, "The Godfather", "Drama", 19.99f, 239, "Coppola");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(202, "Titanic", "Drama", 17.99f, 314, "Cameron");
		
		Disc d1 = new Disc(301, "The Dark Knight", "Action", 24.99f, 232, "Nofan");
		Disc d2 = new Disc(302, "Inception", "Action", 22.99f, 228, "Nolan");
		
		ArrayList<Media> m = new ArrayList<>();
		m.add(b1);
		m.add(b2);
		m.add(b3);
		m.add(cd);
		m.add(dvd1);
		m.add(dvd2);
		m.add(d1);
		m.add(d2);
		
		Store s1 = new Store();
		s1.addMedia(d1);
		s1.addMedia(d2);
		s1.addMedia(dvd1);
		s1.addMedia(dvd2);
		s1.addMedia(cd);
		s1.addMedia(b1);
		s1.addMedia(b2);
		s1.addMedia(b3);
		
		Cart c = new Cart(m);
		Scanner sc = new Scanner(System.in);
		while (true) {
			Aims.showMenu();
			System.out.print("Enter number : ");
			int tt = sc.nextInt();
			if (tt == 0) {
				sc.close();
				System.exit(0);
				break;
			}
			else if (tt == 1) {
				Aims.storeMenu();
				System.out.print("Enter number : ");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.print("Enter title : ");
					sc.nextLine();
					String title = sc.nextLine();
					c.searchByTitle(title);
				}
				else if (n == 2) {
					System.out.println("Enter new media1 : ");
					Media m1 = new Book(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()));
					s1.addMedia(m1);
					System.out.println("Enter new media2 : ");
					Media m2 = new DigitalVideoDisc(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine());
					if (m2 instanceof DigitalVideoDisc || m2 instanceof CompactDisc) {
						Aims.mediaDetailsMenu();
						System.out.print("Enter number : ");
						int n1 = sc.nextInt();
						if (n1 == 1) {
							System.out.println("Add successfully");
						}
						else if (n1 == 2) {
							t1.play();
						}
					}
				}
				else if (n == 3) {
					t2.play();
				}
				else if (n == 4) {
					c.displayCart();
				}
			}
			else if (tt == 2) {
				System.out.println("Enter new media1 and media 2: ");
				Media m1 = new Book(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()));
				Media m2 = new Disc(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine());
				s1.addMedia(m1);
				s1.addMedia(m2);
			}
			else if (tt == 3) {
				Aims.cartMenu();
				System.out.print("Enter number: ");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.print("Enter title : ");
					sc.nextLine();
					String title = sc.nextLine();
					c.searchByTitle(title);
				}
				else if (n == 2) {
					c.displayCart();
				}
				else if (n == 3) {
					sc.nextLine();
					System.out.print("Enter title: ");
					String title = sc.nextLine();
					c.removeMedia(d2);
				}
				else if (n == 4) {
					t1.play();
				}
				else if (n == 5) {
					System.out.println("Place order successfully");
				}
			}
		}
	}




}
