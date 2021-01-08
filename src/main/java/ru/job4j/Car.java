package ru.job4j;

public class Car {
    private String model;
    private Integer productionYear;
    private String manufacturer;
    private Integer enginePower;
    private String kp;
    private Integer weight;

    public static class BuilderCar {
        private String model;
        private Integer productionYear;
        private String manufacturer;
        private Integer enginePower;
        private String kp;
        private Integer weight;

        public BuilderCar buildModel(String model) {
            this.model = model;
            return this;
        }

        public BuilderCar buildProductionYear(Integer productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public BuilderCar buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public BuilderCar buildEnginePower(Integer enginePower) {
            this.enginePower = enginePower;
            return this;
        }

        public BuilderCar buildKP(String kp) {
            this.kp = kp;
            return this;
        }

        public BuilderCar buildWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.weight = weight;
            car.enginePower = enginePower;
            car.kp = kp;
            car.manufacturer = manufacturer;
            car.model = model;
            car.productionYear = productionYear;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='"
                + model
                + '\''
                + ", productionYear="
                + productionYear
                + ", manufacturer='"
                + manufacturer
                + '\''
                + ", enginePower="
                + enginePower
                + ", KP='"
                + kp
                + '\''
                + ", weight="
                + weight
                + '}';
    }

    public static void main(String[] args) {
        Car car = new BuilderCar()
                    .buildEnginePower(100)
                    .buildKP("Mehanika")
                    .buildManufacturer("Merceder")
                    .buildProductionYear(2020)
                    .buildWeight(2000)
                    .buildModel("Raketa")
                    .build();
        System.out.println(car.toString());
    }
}
