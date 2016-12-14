class Test4
{
    public static void main(String[] args)
    {
        System.out.println(new Tree().accept(new MyVisitor()));
        System.out.println(50);
    }
}

class Tree
{
    public int accept(Visitor v){
        int nti ;

        System.out.println(333);
//	nti = v.visit(this) ;
        return 0 ;
    }
}

class Visitor {
    Tree l ;
    Tree r ;

    public int visit(Tree n){
        int nti ;

        l = new Tree();
        r = new Tree();
	    nti = r.accept(this) ;
	    nti = l.accept(this) ;

        return 0;
    }

}


class MyVisitor extends Visitor {

    public int visit(Tree n){
        int nti ;

        l = new Tree();
        r = new Tree();
	    nti = r.accept(this) ;
	    nti =l.accept(this) ;

        return 0;
    }

}