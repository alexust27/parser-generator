grammar Grammar;

@header {
    import main.java.writer.*;
    import main.java.grammar.*;
    import java.util.*;
}

start returns [MainGrammar v]
        : 'grammar' TERM NTERM        { $v = new MainGrammar($NTERM.text, $TERM.text); }
          (oneRule[$v]
          ';')+
        ;

oneRule[MainGrammar g]
        @init{
            NRule nr;
            List<Argument> lrets = null;
            List<Argument> largs = null;
            String name;
        }
        : TERM ':'  String      { $g.addTermRule(new TRule(false, $TERM.text, $String.text)); }
        | TERM '::'  String     { $g.addTermRule(new TRule(true, $TERM.text, $String.text)); }
        | 'skip' '->' String    { $g.addSkip($String.text); }
        | NTERM                 { name = $NTERM.text; }
            ('(' args           { largs = $args.v; }
            ')')?
            ('return' '[' args  { lrets = $args.v; }
            ']')?               { nr = new NRule(name, largs, lrets); }
          ':'  rulePart         { nr.addRule($rulePart.v); }
          ('|' rulePart         { nr.addRule($rulePart.v); }
          )*                    { $g.addNTermRule(nr); }
        ;

args returns [List<Argument> v]
        :  arg               { $v = new ArrayList(); }
                                { $v.add($arg.v); }
          (COMMA arg            { $v.add($arg.v); }
          )*
        ;

arg returns [Argument v]
        : NTERM ':' type    { $v = new Argument($type.v, $NTERM.text); }
        ;

rulePart returns [List<Terms> v]
        :               { $v = new ArrayList<>(); }
        (terms          { $v.add($terms.v); }
        )+
        ;

terms returns [Terms v]
        : TERM              { $v = new Term($TERM.text); }
        | NTERM             { NTerm t = new NTerm($NTERM.text); }
          ('(' param        { t.addParameter($param.v); }
            (COMMA param      { t.addParameter($param.v); }
            )*
          ')')?             { $v = t; }
        | Code              { $v = new Code($Code.text); }
        ;

param returns [String v]
        : type      { $v = $type.v; }
        | Code      { $v = $Code.text.substring(1, $Code.text.length() - 1); }
        ;

type returns [String v]
        : NTERM     { $v = $NTERM.text; }
        | TERM      { $v = $TERM.text; }
        ;

TERM    : ('A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
NTERM   : ('a'..'z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
//Type    : ('a'..'z'|'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;

String : '"' (~('"'))* '"';
Code   : '{' (~[{}]+ )* '}';

WS    : [ \t\r\n] -> skip ;

COMMA : ',';

//COMMENT
//   :   '/*' .*? '*/' -> skip;
//
//LINE_COMMENT
//   :   '//' (~[\r\n])* -> skip;
