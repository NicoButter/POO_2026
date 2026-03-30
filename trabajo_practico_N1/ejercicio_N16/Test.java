public class Test {
    public static void main(String[] args) {
        // Herencia
        PilaEntero pilaInt = new PilaEntero(5);
        pilaInt.push(10); pilaInt.push(20);
        System.out.println("PilaEntero pop: " + pilaInt.pop());

        PilaCaracter pilaChar = new PilaCaracter(5);
        pilaChar.push('a'); pilaChar.push('b');
        System.out.println("PilaCaracter pop: " + pilaChar.pop());

        PilaString pilaStr = new PilaString(5);
        pilaStr.push("hola"); pilaStr.push("mundo");
        System.out.println("PilaString pop: " + pilaStr.pop());

        // Polimorfismo con Object
        PilaObject pilaObj = new PilaObject(5);
        pilaObj.push(100);
        pilaObj.push("texto");
        pilaObj.push('z');
        System.out.println("PilaObject pop: " + pilaObj.pop());
        System.out.println("PilaObject pop: " + pilaObj.pop());
    }
}
