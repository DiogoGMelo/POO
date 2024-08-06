// Raphael Monteiro Consoni Bonaccorsi - 12563366
// Diogo Gianezi de Melo - 12563522

class A {
    private int m;
    private int n;
    public A(int mIn, int nIn) { // Constructor
        m = mIn;
        n = nIn;
    }
    public void m1() {
        m = m + n;
    }
    public int getM() { // Getter method for the M variable
        return m;
    }
    public int getN() {// Getter method for the N variable
        return n;
    }
    public void setM(int mIn) { // Setter method for the M variable
        m = mIn;
    }
    public String toString() {
        return "A = ("+ m + ", " + n +")";
    }
}

public class B extends A {
    public B(int mIn, int nIn) {
        super(mIn, nIn);
    }

    @Override
    public void m1() { // Overrides m1
        setM(getM() - getN());
    }
    public String toString() {
        return "B = ("+ getM() + ", " + getN() +")";
    }

    public static void main(String[] args) {
        A a = new A(1, 2);
        A b = new B(1, 2);
        System.out.println(a + " " + b);
        a.m1();
        b.m1();
        System.out.println(a + " " + b);
    }
}
   