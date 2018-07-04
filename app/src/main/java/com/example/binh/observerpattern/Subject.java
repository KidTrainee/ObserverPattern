package com.example.binh.observerpattern;


public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
