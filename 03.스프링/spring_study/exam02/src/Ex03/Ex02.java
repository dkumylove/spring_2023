package Ex03;

public class Ex02 {
    public static void main(String[] args) {
//        Human[] animals = new Human[3];
//        animals[0] = new Human();
//        animals[1] = new Dog();
//        animals[2] = new Bird();

        Animal[] animals = new Animal[3];
        animals[0] = new Human();
        animals[1] = new Dog();
        animals[2] = new Bird();

        for(Animal animal : animals) {
            animal.move();


                // 명시적 형변환
                Human human = (Human)animal;
                human.readBook();

        }
    }
}
