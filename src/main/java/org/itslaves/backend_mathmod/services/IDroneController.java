package org.itslaves.backend_mathmod.services;

import org.itslaves.backend_mathmod.utils.Point;

public interface IDroneController {
    // Взлет дрона с текущей точки
    void takeoff();

    // Полет дрона к заданной точке
    void flyTo(Point point);

    // Фото-съемка в текущей точке
    void takePhoto();

    // Запись видео в текущей точке
    void startRecord();

    // Остановка записи видео
    void stopRecord();

    // Посадка дрона в текущей точке
    void land();

    // Методы для получения информации о дроне и его статусе

    // Получение текущей широты и долготы дрона
    Point getCurrentPosition();

    // Получение высоты полета дрона
    float getCurrentAltitude();

    // Получение оставшейся продолжительности полета в секундах
    int getFlightTimeRemaining();

    // Получение уровня заряда батареи дрона (от 0 до 100%)
    int getBatteryLevel();

    // Получение статуса дрона (например, "взлетел", "в полете", "приземлился" и т. д.)
    String getStatus();
}