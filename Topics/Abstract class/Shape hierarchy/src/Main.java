
abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}


class Triangle extends Shape {

    double sideA;
    double sideB;
    double sideC;

    Triangle(double sideA, double sideB, double sideC) {
        super();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    double getArea() {
        double sideS = (sideA + sideB + sideC) / 2;
        return Math.sqrt(sideS * (sideS - sideA) * (sideS - sideB) * (sideS - sideC));
    }
}

class Rectangle extends Shape {

    double sideA;
    double sideB;

    Rectangle(double sideA, double sideB) {
        super();
        this.sideA = sideA;
        this.sideB = sideB;
    }

    double getPerimeter() {
        return sideA * 2 + sideB * 2;
    }

    double getArea() {
        return sideA * sideB;
    }
}

class Circle extends Shape {

    double radius;

    Circle(double radius) {
        super();
        this.radius = radius;
    }

    double getPerimeter() {
        return Math.PI * radius * 2;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}