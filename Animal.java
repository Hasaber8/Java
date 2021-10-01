public class Animal {
    int legs = 4;
    
    public void noise(){
        System.out.println("All animals make different noises");
    }

    public void food(){
        System.out.println("Either herbivores or carnivores");
    }

}

class Dog extends Animal{

    public void noise(){
        System.out.println("Barks");
    }

    public void food(){
        System.out.println("Carnivores");
    }
}

class Inheritance{
    public static void main(String[] args){
        Dog pug = new Dog();
        System.out.println("A pug has " + pug.legs + " legs");
        pug.noise();
        pug.food();
    }
}