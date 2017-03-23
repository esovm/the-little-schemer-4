## Law and commander

### Laws

#### The law of `car`

The primitive `car` is defined only for non-empty lists.

#### The law of `cdr`

The primitive `cdr` is defined only for non-empty lists. The `cdr` of any
non-empty list is always another list.

#### The law of `cons`

The primitive `cons` takes two arguments. The second argument to `cons` must 
be a list. The result is a list.

#### The law of `null?`

The primitive `null?` is defined only for lists.

#### The law of `eq?`

The primitive `eq?` takes two arguments. Each must be a non-numeric argument.


### Commandments

#### The first commandment

When recurring on a list of atoms, `lat`, ask two questions about it: 
`(null? lat)` and `else`.<br />
When recurring on a number, `n`, ask two questions about it: `(zero? n)` and
`else`.<br />
When recurring on a list of S-expressions, `l`, ask three questions about it:
`(null? l)`, `(atom? (car l))`, and `else`.

#### The second commandment

Use `cons` to build lists.

#### The third commandment

When building a list, describe the first typical element, and then `cons` it
onto the natural recursion.

#### The fourth commandment

Always change at least one argument while recurring.<br />
When recurring on a list of atoms, `lat` use `(cdr lat)`.<br />
When recurring on a number, `n`, use `(sub1 n)`.<br />
When recurring on a list of S-expressions, `l`, use `(car l)` and `(cdr l)`, if
neither `(null? l)` nor `(atom? (car l))` are true.

It must be changed closer to termination. The changing argument must be tested
in the termination condition: when using `cdr`, test termination with `null?`,
when using `sub1`, test termination with `zero?`.

#### The fifth commandment

When building a value with `+`, always use 0 for the value of the terminating 
line, for adding 0 does not change the value of an addition.

When building a value with `*`, always use 1 for the value of the terminating 
line, for multiplying 1 does not change the value of a multiplication.

When building a value with `cons`, always consider `()` for the value of the 
terminating line.

#### The sixth commandment

Simplify only after the function is correct.


