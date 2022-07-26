package task3.Entity;

import java.util.Objects;

public class Cars {
    private int id;
    private int mark_id;
    private String model;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id && mark_id == cars.mark_id && price == cars.price && Objects.equals(model, cars.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark_id, model, price);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", mark_id=" + mark_id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
