package lessons;

public class MethodSelectionWithDuplicateName {
  public static void main(String[] args) {
    C x = new C();
    System.out.println(x.fun());
  }
}

abstract class A {
  int met(A a) { return 0;}
  int met(B b) { return 1;}
  int met(C c) { return 2;}
}
class B extends A {
  int met(A a) { return 3;}
  int met(B b) { return 4;}
  int met(C c) { return 5;}
}
class C extends B {
  int fun() {
    return this.met(this);
  }
}
