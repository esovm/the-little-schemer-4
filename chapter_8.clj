(ns the-little-schemer.chapter-8
  (:require [the-little-schemer.utils :as u]))

;; (lemonade and (cake))
(u/rember-f u/equal? '(pop corn) '(lemonade (pop corn) and (cake)))

((u/eq?-c 42) 42) ;; true

;; (lemonade and (cake))
((u/rember-f-c =) '(pop corn) '(lemonade (pop corn) and (cake)))

;; (My name is Alberto)
(u/insert-g u/insert-left 'My 'name '(name is Alberto))

;; (My name is Alberto)
(u/insert-g u/insert-right 'Alberto 'is '(My name is))



