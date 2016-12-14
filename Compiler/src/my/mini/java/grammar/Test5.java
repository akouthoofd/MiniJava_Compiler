class Test5
{
    public static void main(String[] args)
    {
        System.out.println(new LL().Start());
    }
}

class Element {
    int Age ;
    int Salary ;
    boolean Married ;

    // Initialize some class variables
    public boolean Init(int v_Age, int v_Salary, boolean v_Married){
        Age = v_Age ;
        Salary = v_Salary ;
        Married = v_Married ;
        return true ;
    }
}


// this class invokes the methods to insert, delete,
// search and print the linked list
class LL{

    public int Start(){
        boolean aux01 ;
        Element el01 ;
        // inserting first element
        el01 = new Element();
        aux01 = el01.Init(25,37000,false);
        return 0 ;


    }

}
