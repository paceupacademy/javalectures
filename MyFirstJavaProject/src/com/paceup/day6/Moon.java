package com.paceup.day6;
//Hybrid Inheritance
class SolarSystem {
}
class Earth extends SolarSystem {
}
class Mars extends SolarSystem {
}
public class Moon extends Earth {
    public static void main(String args[])
    {
        SolarSystem s = new SolarSystem();
        Earth e = new Earth();
        Mars m = new Mars();
        Moon m1 = new Moon();

        System.out.println(e instanceof SolarSystem); //this checks for object's type or inheritance at runtime
        System.out.println(e instanceof Moon);
        System.out.println(m instanceof SolarSystem);
        System.out.println(m1 instanceof Moon);
    }
}
