package kfc.Threads;

import kfc.Order;

import java.util.LinkedList;

class ThreadBase{

    volatile static LinkedList<Order> orders = new LinkedList<Order>();
}
