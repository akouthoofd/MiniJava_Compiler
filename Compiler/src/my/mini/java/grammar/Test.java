class Test {
    public static void main(String[] args)
    {
        Other s;
        Other o;
        Thing t;
        int size;
//        int[] arr;
//        int count;
//        int num;
//        boolean b;
//        t = new Thing();
//        b = true;
//        num = 0;
//        count = 0;
//        size = 10;
        s = new Other();
        o = new Other();
        size = s.setNumb(5);
        size = o.setNumb(2);
        size = s * o + 3;
        if (s && o)
            System.out.println(size);
//        while (true)
//            System.out.println(500);
//        arr = new int[size];
//        while (true && (count < size))
//        {
//            num = 0;
//            while (num < count)
//            {
//                num = num + 1;
//                System.out.println(200);
//            }
//            arr[count] = count+1;
//            if (true && !(count < (size - 7)))
//                System.out.println((arr[count])*2);
//            count = count + 1;
//        }
//        System.out.println(s.getNumb());
//        System.out.println(s.random(b, arr));
//        System.out.println(s.setNumb(5));
//        System.out.println(o.setNumb(15));
//        System.out.println((s.getOther(o)).getNumb());
//        arr[0] = 5;
//        System.out.println((s.stuff(arr))[0]);
//        System.out.println(s.getNumb());
//        System.out.println(s.getNumb());
//        System.out.println(o.getNumb());
//        System.out.println(5);
//        System.out.println((new Thing()).init(50));
//        System.out.println(t.doStuff2());
//        System.out.println(t.more());
//        if (t.Compare(1, 1))
//            System.out.println(100);
//        System.out.println(5);
//        if (t.Search(15))
//            System.out.println(20);
//        System.out.println(500);
    }
}

class Thing
{
    int[] number ;
    int size ;
    int s ;

    // Search for a specific value (num) using
    // binary search
    public boolean Search(int num){
        boolean bs01 ;
        int right ;
        int left ;
        boolean var_cont ;
        int medium ;
        int aux01 ;
        int nt ;

        number = new int[20];
        number[4] = 15;
        aux01 = 0 ;
        bs01 = false ;
        right = number.length ;
        right = right - 1 ;
        left = 0 ;
        var_cont = true ;
        while (var_cont){
            medium = left + right ;
            medium = this.Div(medium);
            aux01 = number[medium] ;
            if (num < aux01) right = medium - 1 ;
            else left = medium + 1 ;
            if (this.Compare(aux01,num)) var_cont = false ;
            else var_cont = true ;
            if (right < left) var_cont = false ;
            else nt = 0 ;
        }

        if (this.Compare(aux01,num)) bs01 = true ;
        else bs01 = false ;
        return bs01 ;
    }

    // This method computes and returns the
    // integer division of a number (num) by 2
    public int Div(int num){
        int count01 ;
        int count02 ;
        int aux03 ;

        count01 = 0 ;
        count02 = 0 ;
        aux03 = num - 1 ;
        while (count02 < aux03) {
            count01 = count01 + 1 ;
            count02 = count02 + 2 ;
        }
        return count01 ;
    }
    //
//
//    // This method compares two integers and
//    // returns true if they are equal and false
//    // otherwise
    public boolean Compare(int num1 , int num2){
        boolean retval ;
        int aux02 ;

        retval = false ;
        aux02 = num2 + 1 ;
        if (num1 < num2) retval = false ;
        else if (!(num1 < aux02)) retval = false ;
        else retval = true ;
        return retval ;
    }

    public int init(int s)
    {
        int temp;
        Some some;
        some = new Some();
        temp = this.doStuff(s);
        return 0;
    }

    public int doStuff(int s)
    {
        int a;
        a = 1;
        while (a < (size))
            a = a + 1;
        a = size + 1;
        size = s;
        number = new int[size];
        System.out.println((size));
        return 1;
    }

    public int doStuff2()
    {
        s = 5;
        return 1;
    }

    public int more()
    {
        return s;
    }
}

class Some {
    int numb;
    public int getNumb()
    {
        return this.getNum();
    }

    public int getNum()
    {
        return numb;
    }

    public int[] stuff(int[] arr)
    {
        return arr;
    }

    public int setNumb(int a)
    {
        numb = a;
//        System.out.println(a);
//        System.out.println(1000000);
        return a;
    }

    public Other getOther(Other o)
    {
        return o;
    }

    public int $operator *(Other o)
    {
        return ((this.getNum()) * (o.getNum()));
    }
}

class Other extends Some {
    public int random(boolean arr, int[] a)
    {
        return 5;
    }

    public boolean getTrue()
    {
        return true;
    }

    public int $operator +(Other o)
    {
        return 2;
    }

    public int $operator -(Other o)
    {
        return 3;
    }

    public boolean $operator <(Other o)
    {
        return true;
    }

    public boolean $operator &&(Other o)
    {
        return o.getTrue();
    }
}
