class Scratch {
    public static void main(String[] args) {

        Visitor visitor = new ShapeVisitor();
        Visitable circle = new Circle();
        Visitable sqare = new Square();
        System.out.println(circle.accept(visitor));
        System.out.println(sqare.accept(visitor));

    }

    interface Visitor<E, R> {
        String visit(E element);
    }

    interface Shape {
        String print();
    }

    interface Visitable<T> {
        default T accept(Visitor visitor) {
            return (T) visitor.visit(this);
        }
    }

    static class Circle implements Visitable, Shape {

        public String print() {
            return "this is a circle";
        }
    }

    static class Square implements Visitable, Shape {

        public String print() {
            return "this is a square";
        }
    }

    public static class ShapeVisitor implements Visitor<Shape, String> {

        @Override
        public String visit(Shape element) {
            return element.print();
        }
    }
}
