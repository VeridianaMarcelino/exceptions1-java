package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number : ");
		int number = entrada.nextInt();
		System.out.print("Check in date dd/mm/yyy ");
		Date checkIn = sdf.parse(entrada.next());
		System.out.print("Check out date dd/mm/yyy ");
		Date checkOut = sdf.parse(entrada.next());

		if (!checkOut.after(checkIn)) {
			System.out.print("Error in reservation: Check-out date must be after check- in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Emter data to update the reservation: ");
			System.out.print("Check in date dd/mm/yyy ");
			checkIn = sdf.parse(entrada.next());
			System.out.print("Check out date dd/mm/yyy ");
			checkOut = sdf.parse(entrada.next());

			
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation:  " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
		}
		entrada.close();
	}

}

