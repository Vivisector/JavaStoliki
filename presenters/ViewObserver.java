package ru.geekbrains.presenters;

import java.util.Date;
// класс наблюдателя/слушателя "event listener"
public interface ViewObserver {

    void onReservationTable(Date reservationDate, int tableNo, String name);
    // void DeReservationTable(int old, Date reservationDate, int tableNo, String name);

}
