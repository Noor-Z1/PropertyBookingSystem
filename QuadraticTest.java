
public class QuadraticTest {
    public static void main(String args[]){

        QuadraticEquation myeq = new QuadraticEquation(1,-4,5);

        if (myeq.getDiscriminant() <0 ){
            System.out.println("The equation has no root");
        } else if (myeq.getDiscriminant() == 0) {
            System.out.println(myeq.getRoot1());

        }
        else{
            System.out.println("Root 1 is " + myeq.getRoot1());
            System.out.println("Root 2 is " + myeq.getRoot2());
        }


    }

}
