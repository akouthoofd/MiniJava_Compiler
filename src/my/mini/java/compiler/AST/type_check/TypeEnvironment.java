package my.mini.java.compiler.AST.type_check;

import my.mini.java.compiler.AST.nodes.classes.ClassNode;
import my.mini.java.compiler.AST.nodes.type.TypeNode;

import java.util.List;

/**
 * Created by alex on 11/30/2016.
 */
public class TypeEnvironment
{
    // types to Object Id
    // types to Methods
    // Name of current class

    public TypeNode objectIdType;
    public List<TypeNode> methodTypes;
    public ClassNode currentClass;

    public TypeEnvironment (TypeNode objectIdType, List<TypeNode> methodTypes, ClassNode currentClass)
    {
        this.objectIdType = objectIdType;
        this.methodTypes = methodTypes;
        this.currentClass = currentClass;
    }
}
