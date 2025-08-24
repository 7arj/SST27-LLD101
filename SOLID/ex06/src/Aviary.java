class Aviary {
    //release birds that can fly
    public void release(Bird bird) {
        if (bird instanceof Flyable) {
            ((Flyable) bird).fly();
            System.out.println("Released");
        } else {
            System.out.println("Cannot release - bird cannot fly");
        }
    }
    
    //general bird handling
    public void handleBird(Bird bird) {
        bird.makeSound();
        if (bird instanceof Flyable) {
            System.out.println("Flying bird - can be released");
        } else {
            System.out.println("Ground bird - keeping in habitat");
        }
    }
}