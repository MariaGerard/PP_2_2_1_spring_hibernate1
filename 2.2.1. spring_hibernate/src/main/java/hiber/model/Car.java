package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    public Car() {
    }

    public Car( String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        if ((series != car.series) || (Objects.equals(id, car.id))) {
            return false;
        }
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = id !=null ? id.hashCode() : 0;
        int a = result * 31;
        result = a + series;
        result = a + (model !=null ? model.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
