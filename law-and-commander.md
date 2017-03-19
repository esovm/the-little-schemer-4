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

Always ask `null?` as the first question in expressing any function.

#### The second commandment

Use `cons` to build lists.

#### The third commandment

When building a list, describe the first typical element, and then `cons` it
onto the natural recursion.

#### The fourth commandment

Always change at least one argument while recurring. It must be changed closer
to termination. The changing argument must be tested in the termination 
condition: when using `cdr`, test termination with `null?`.
