class Test3{
    public static void main(String[] a){

        System.out.println(new BT().Start());
    }
}


// This class invokes the methods to create a tree,
// insert, delete and serach for  elements on it
class BT {

    public int Start(){
        Tree root ;
        boolean ntb ;
        int nti ;
        return 0 ;
    }

}

class Tree{
    Tree left ;
    Tree right;
    int key ;
    boolean has_left ;
    boolean has_right ;
    Tree my_null ;

    // Update the left child with ln
    public boolean SetLeft(Tree ln){
        left = ln ;
        return true ;
    }

    public Tree GetLeft(){
        return left;
    }

    public int GetKey(){
        return key ;
    }

    public boolean SetKey(int v_key){
        key = v_key ;
        return true ;
    }

    public boolean GetHas_Left(){
        return has_left ;
    }

    public boolean SetHas_Left(boolean val){
        has_left = val ;
        return true ;
    }


    // Copy the child key to the parent until a leaf is
    // found and remove the leaf. This is done with the
    // left subtree
    public boolean RemoveLeft(Tree p_node, Tree c_node){
        boolean ntb ;

//        while (c_node.GetHas_Left()){
            //auxtree01 = c_node.GetLeft() ;
            //auxint02 = auxtree01.GetKey();
            //ntb = c_node.SetKey(auxint02);
            ntb = c_node.SetKey((c_node.GetLeft()).GetKey());
//            p_node = c_node ;
//            c_node = c_node.GetLeft() ;
//        }
//        ntb = p_node.SetLeft(my_null);
//        ntb = p_node.SetHas_Left(false);
        return true ;
    }
}

