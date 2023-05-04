package ru.geekbrains.views;

import ru.geekbrains.models.Table;
import ru.geekbrains.presenters.View;
import ru.geekbrains.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

import javax.swing.plaf.TreeUI;
import javax.swing.table.TableModel;

public class BookingView implements View {


    private ViewObserver observer; // наблюдатель

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    public void setObserver(ViewObserver observer){
        this.observer = observer;
    }


    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            if (!table.getBusy()){
            System.out.println(table);
            }
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * TODO: Доработать метод в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирования столика
     * @param oldReservation старый номер бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиета
     */
    // public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
    public void changeReservationTable(Date reservationDate, int tableOld, int tableNew, String name){
        System.out.printf("Резерв cтолика #%d отмемен\n", tableOld);
        // TableModel
        observer.onReservationTable(reservationDate, tableNew, name);
        
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     */
    public void showReservationTableStatus(int reservationId, int tableNo, String name){
        if (reservationId > 0){
            System.out.printf("Столик %d успешно забронировал %s (номер брони: #%d)\n",tableNo, name, reservationId);
        }
        else {
            System.out.println("Ошибка бронирования столика.\nПовторите попытку позже.");
        }
    }


    // @Override
    // public void showReservationTableStatus(int reservationId, int tableNo) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'showReservationTableStatus'");
    // }


}
