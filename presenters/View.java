package ru.geekbrains.presenters;

import ru.geekbrains.models.Table;

import java.util.Collection;

public interface View {

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    void showTables(Collection<Table> tables);

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     * @param tableNo номер столика
     */
    void showReservationTableStatus(int reservationId, int tableNo, String name);
    // void setReservationTableStatus(int oldReservation, int tableNo, String name);

}
