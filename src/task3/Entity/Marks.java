package task3.Entity;

import java.util.Objects;

public class Marks {
    private int id;
    private String mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marks marks = (Marks) o;
        return id == marks.id && Objects.equals(mark, marks.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark);
    }

    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                '}';
    }
}
