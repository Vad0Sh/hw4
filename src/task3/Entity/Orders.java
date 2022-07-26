package task3.Entity;

import java.util.Objects;

public class Orders {
 private int id;
 private int car_id;
 private int client_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && car_id == orders.car_id && client_id == orders.client_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car_id, client_id);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", car_id=" + car_id +
                ", client_id=" + client_id +
                '}';
    }
}
