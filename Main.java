package ru.geekbrains;

import ru.geekbrains.models.TableModel;
import ru.geekbrains.presenters.BookingPresenter;
import ru.geekbrains.views.BookingView;

import java.util.Date;

public class Main {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        bookingPresenter.loadTables();
        System.out.println("Свободные столики:");
        bookingPresenter.updateView();


        view.reservationTable(new Date(), 2, "Сергей");
        System.out.println("Оставшиеся свободные столики:");
        bookingPresenter.updateView();

        // view.changeReservationTable(1001, new Date(), 2, 3, "Сергей");
        view.changeReservationTable(new Date(), 2, 3, "Сергей");
        // System.out.println("Оставшиеся свободные столики:");
        // bookingPresenter.updateView();
        
    }

}