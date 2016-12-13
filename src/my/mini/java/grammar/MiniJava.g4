grammar MiniJava;

prog :  mainClass classDecl*
       ;
mainClass
  :   'class' className=ID '{' 'public' 'static' 'void' 'main'
                '(' str='String' '[' ']' paramName=ID ')' '{' varDecl* statement* '}' '}' #Main
  ;
classDecl
  :   'class' className=ID '{' varDecl* methodDecl* operatorDecl* '}' #Class
  |   'class' className=ID 'extends' parentName=ID '{' varDecl* methodDecl* operatorDecl* '}' #ChildClass
        ;
varDecl : type ID ';'
        ;
methodDecl
  :   'public' type methodName=ID '(' (formalList (',' formalList+)*)? ')'
                '{' varDecl* statement* retn='return' expr ';' '}'
        ;
operatorDecl
  :   'public' type '$operator' operator=('+' | '-' | '*' | '&&' | '<') '(' formalList ')'
                '{' varDecl* statement* retn='return' expr ';' '}'
        ;
        catch [RecognitionException e] {

            //Custom handling of an exception. Any java code is allowed.
            if (getCurrentToken().getText().equals(","))
            System.err.println("Only one parameter is allowed for operator overloading.");
            throw e;

        }
        catch [ParseCancellationException e] {

            //Custom handling of an exception. Any java code is allowed.
            if (getCurrentToken().getText().equals(")"))
            throw new ParseCancellationException(e.getMessage() + "\nA single parameter with a name is required.");
            else if (getCurrentToken().getText().equals("("))
            throw new ParseCancellationException(e.getMessage() + "\nAfter 'operator' one of the above symbols is required.");
            else if (getCurrentToken().getText().equals("operator"))
            throw new ParseCancellationException(e.getMessage() + "\n[+, -, *, &&, <] are the possible choices. The above mentioned is not one of them. :/");
            else if (getCurrentToken().getText().equals("{"))
            throw new ParseCancellationException(e.getMessage() + "\nAdd a ')' after your parameter.");
            else
            throw e;

        }
formalList
  :   type ID
        ;

type  :   'int'
  |   'int' '[' ']'
  |   'boolean'
  |   ID
  ;

statement
  :   '{' statement* '}' #Scoped
  |   'System.out.println' '(' expr ')' ';' #Print
  |   varName=ID '=' assignee=expr ';' #Assignment
  |   varName=ID '[' (element=INT | element=ID) ']' '=' assignee=expr ';' #ArrayAssignment
  |   'while' '(' condition=condExpr ')' statement #Loop
  |   'if' '(' condition=condExpr ')' stm1=statement ('else' stm2=statement)? #If
  ;
condExpr
  :   '(' condExpr ')' #NestedCondition
  |   '!' condExpr #Not
  |   cond1=condExpr '<' cond2=condExpr #LessThan
  |   cond1=condExpr '&&' cond2=condExpr #And
  |   expr #Exp
  ;
expr
  :   math #Calculation
  |   (operator='+' | operator='-') atom #Trailing
  |   atom '[' expr ']' #ArrayAccess
  |   atom '.' 'length' #ArrayLength
  |   atom '.' methodName=ID '(' ( expr ( ',' expr )* )? ')' #MethodCall
  ;
math
  : left=math '*' right=math #Mult
  | left=math '-' right=math #Minus
  | left=math '+' right=math #Plus
  | atom #Atm
  ;
atom : INT #Number
  | BOOLEAN #Bool
  | (varName=ID | varName='this') ('.' methodName=ID '(' expr ')')? #ObjectReference
  | 'new' className=ID '(' ')' #Instatiate
  | 'this' #ReferenceThis
  | 'new' 'int' '[' size=expr ']' #NewIntArray
  | '(' expr ')' #ParenthesizedExpr
  ;

ID        :   [a-zA-Z_][a-zA-Z0-9_]*;
INT       :   '0'..'9'+ ;
BOOLEAN   :   ('true' | 'false') ;
WS        :   [ \t\r\n]+ -> skip ;
COMMENT   : '/*' .*? '*/' -> skip ;
LINE_COMMENT  
          : '//' .*? '\r'? '\n' -> skip;

