package ru.geekbrains.presenters;

import ru.geekbrains.models.Table;
import ru.geekbrains.models.TableModel;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Collection<Table> tables;

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список всех столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    public void updateReservationTableStatus(int reservationId, int tableNo, String name){
        view.showReservationTableStatus(reservationId, tableNo, name);
    }
    // public void updateDeReservationTableStatus(int oldReservation, int reservationId, int tableNo, String name){
    //     view.showReservationTableStatus(oldReservation, tableNo, name);
    // }
    // @Override
    // public void DeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
    //     int reservationId = model.reservationTable(reservationDate, tableNo, name);
    //     updateDeReservationTableStatus(oldReservation, reservationId, tableNo, name);
    // }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationId = model.reservationTable(reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId, tableNo, name);
        //  // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'noReservationTable'");
    }
}
