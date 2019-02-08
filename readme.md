Упрощенный аналог генератора трансляторов
===
Реализация генератора трансляторов LL(1)-грамматики (нисходящий разбор)
Поддерживаются синтезируемые и наследуемые аргументы.
### Грамматика
В первой строке название грамматики с заглавной буквы.
Во второй стартовый нетерминал.
Терминалы начинаются с большой буквы,
нетерминалы - с маленькой.
### Терминалы
```
<терминал> : "<строка>";
<терминал> :: "<регулярное выражение>";
skip -> "[(<символы который нужно пропустить>)]+";
```
### Нетерминалы
```
<нетерминал>(аргументы) return[аргументы] 
    : ( <нетерминал> | <терминал> | <код>) 
   ('|' <нетерминал> | <терминал> | <код>)*
    ;
```
### Пример 
```
grammar PlusMinus
addSub

addSub return [v : int]
            : unary addSub2({unary.v})
              {$v = addSub2.v;}
            ;

addSub2 (left : int) return [v : int]
            : ADD unary     {int next = left + unary.v;}
              addSub2(next) {$v = addSub2.v;}
            | SUB unary     {int next = left - unary.v;}
              addSub2(next) {$v = addSub2.v;}
            | {$v = left;}
            ;

unary return [v : int]
            : OP addSub CP {$v = addSub.v;}
            | NUM          {$v = Integer.valueOf(NUM);}
            ;
            
```
