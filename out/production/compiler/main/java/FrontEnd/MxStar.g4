grammar MxStar;

code :
    (classDef | varDefStatement | functionDef)*
;

classDef :
    Class Identifier classBody
;

classBody :
    '{'
        (varDefStatementWithoutInit | functionDef)* constructionFunction? (varDefStatementWithoutInit | functionDef)*
    '}'
;

functionDef :
    typeName Identifier parameterList compoundStatement
;

constructionFunction :
    Identifier '('')' compoundStatement
;

parameterList :
    '(' (')' | parameter (',' parameter)* ')' )
;

parameter :
    typeName varName
;

statement :
    compoundStatement       #compStat
    | expressionStatement   #exprStat
    | selectionStatement    #seleStat
    | iterativeStatement    #iterStat
    | jumpStatement         #jumpStat
    | emptyStatement        #emptyStat
;

emptyStatement :
    ';'
;

compoundStatement :
    '{' (statement | varDefStatement)* '}'
;

expressionStatement :
    expression ';'
;

selectionStatement :
    If '(' expression ')' statement                 #IfStat
    |If '('expression ')' statement Else statement  #IfElseStat
;

iterativeStatement :
    whileStatement          #whileStat
    | forStatement          #forStat
;

whileStatement :
    While '(' expression ')' statement
;

forStatement :
    For '(' (forInitExpr = expression)? ';' (forCondExpr = expression)? ';' (forLoopExpr = expression)? ')' statement
;

jumpStatement :
    Return (expression)? ';'    # returnJump
    | Break ';'                 # breakJump
    | Continue ';'              # continueJump
;

varDefStatement :
    typeName varDef (',' varDef)* ';'
;

varDefStatementWithoutInit :
    typeName Identifier (',' Identifier)* ';'
;

varDef :
    Identifier                      #varWithoutInit
    | Identifier '=' expression     #varWithInit
;

literal :
    IntLiteral          #intLite
    | boolLiteral       #boolLite
    | StringLiteral     #stringLite
    | Null              #nullLite
;

expression :
    assignmentExpr
;

exprList :
    expression (',' expression)*
;

originExpr :
    literal                 # literalOriExpr
    | varName               # varOriExpr
    | '(' expression ')'    # sonOriExpr
;

primaryExpr :
    originExpr                          # oriPriExpr
    | primaryExpr '.' primaryExpr       # objPriExpr
    | Identifier '(' exprList? ')'      # funcPriExpr
    | primaryExpr '[' expression ']'    # arrPriExpr
;

rightUnaryExpr :
    primaryExpr                             # priRUExpr
    | rightUnaryExpr (op = ('++' | '--'))   # opRUExpr
;

unaryExpr :
    rightUnaryExpr              # rUExpr
    | (op = '++') unaryExpr     # lUExpr
    | (op = '--') unaryExpr     # lUExpr
    | (op = '~') unaryExpr      # lUExpr
    | (op = '!') unaryExpr      # lUExpr
    | (op = '-') unaryExpr      # lUExpr
    | (op = '+') unaryExpr      # lUExpr
    | New newCreator            # newUExpr
;

newCreator :
    basicTypeName (('['']')+ | ('['expression']')+ ('['']')*)
    | Identifier (('['']')* | ('['expression']')* ('['']')*)
    | Identifier '('')'
;

multiplicativeExpr :
    unaryExpr                                   # unaryMulExpr
    | multiplicativeExpr (op = '*') unaryExpr   # mulExpr
    | multiplicativeExpr (op = '/') unaryExpr   # mulExpr
    | multiplicativeExpr (op = '%') unaryExpr   # mulExpr
;

additiveExpr :
    multiplicativeExpr                              # mulAddExpr
    | additiveExpr (op = '+') multiplicativeExpr    # addExpr
    | additiveExpr (op = '-') multiplicativeExpr    # addExpr
;

shiftExpr :
    additiveExpr                            # addShiftExpr
    | shiftExpr (op = '<<') additiveExpr    # shftExpr
    | shiftExpr (op = '>>') additiveExpr    # shftExpr
;

relationExpr :
    shiftExpr                               # shiftRelExpr
    | relationExpr (op = '<') shiftExpr     # relExpr
    | relationExpr (op = '>') shiftExpr     # relExpr
    | relationExpr (op = '<=') shiftExpr    # relExpr
    | relationExpr (op = '>=') shiftExpr    # relExpr
;

equalityExpr :
    relationExpr                                # relaEqualExpr
    | equalityExpr (op = '==') relationExpr     # equalExpr
    | equalityExpr (op = '!=') relationExpr     # equalExpr
;

andExpr :
    equalityExpr                            # equalAndExpr
    | andExpr (op = '&') equalityExpr       # aExpr
;

xorExpr :
    andExpr                         # andXorExpr
    | xorExpr (op = '^') andExpr    # xExpr
;

orExpr :
    xorExpr                         # xorOrExpr
    | orExpr (op = '|') xorExpr     # oExpr
;

logicalAndExpr :
    orExpr                                  #orLogicAndExpr
    | logicalAndExpr (op = '&&') orExpr     #logicAndExpr
;

logicalOrExpr :
    logicalAndExpr                                  #andLogicOrExpr
    | logicalOrExpr (op = '||') logicalAndExpr      #logicOrExpr
;

assignmentExpr :
    logicalOrExpr                                   #orAssignEXpr
    | assignmentExpr (op = '=') logicalOrExpr       #assignExpr
;

varName :
    Identifier | This
;

typeName :
    (Identifier | basicTypeName) ('['']')*
;

basicTypeName :
    Bool
    | Int
    | String
    | Void
;

LineComment :
    '//' ~[\r\n]* -> skip
;

boolLiteral :
    True | False
;

StringLiteral :
    '"' (ESC | .)*? '"'
;

IntLiteral :
    (DIGIT | NONZERODIGIT DIGIT+)
;

Bool :
    'bool'
;

Int :
    'int'
;

String :
    'string'
;

Null :
    'null'
;

Void :
    'void'
;

True :
    'true'
;

False :
    'false'
;

If :
    'if'
;

For :
    'for'
;

While :
    'while'
;

Break :
    'break'
;

Continue :
    'continue'
;

Return :
    'return'
;

New :
    'new'
;

Class :
    'class'
;

This :
    'this'
;

Else :
    'else'
;

Identifier :
    NONDIGIT (NONDIGIT | DIGIT)*
;

WhiteSpace :
    [ \t]+ -> skip
;

NewLine :
    ('\r' '\n'? | '\n')-> skip
;

fragment ESC :
    '\\n' | '\\\\' | '\\"'
;

fragment DIGIT :
    [0-9]
;

fragment NONZERODIGIT :
    [1-9]
;

fragment NONDIGIT :
    [a-zA-Z_]
;

fragment ALPHABET :
    [a-zA-Z]
;
