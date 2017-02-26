(ns the-little-schemer.chapter-1
  (:require [the-little-schemer.utils :as utils]))


(utils/atom? ()) ;; false
(utils/atom? ()) ;; false

(utils/atom? "atom") ;; true

(list? ()) ;; true

;; xyz
;; (x y z)
;; are both S-expressions, as atoms are and lists are too

;; (((how) are) ((you) (doing so)) far)
;; has 3 S-expressions
;; ((how) are), ((you) (doing so)), far

(first '(a b c)) ;; a

(first '((a b c) x y z)) ;; (a b c) because it's the first S-expression

(first '(((hotdogs)) (and) (pickle) relish)) ;; ((hotdogs))

(first (first '(((hotdogs)) (and)))) ;; (hotdogs)

(rest '(a b c)) ;; # (b c)

(rest '(hambuger)) ;; ()

;; no car or cdr for atoms, only for non-empty lists

(first (rest '((b) (x y) ((c))))) ;; (x y)

(rest (rest '((b) (x y) ((c))))) ;; (((c)))

(cons 'peanut '(butter and jelly)) ;; (peanut butter and jelly)

(cons '(banana and) '(peanut butter and jelly)) ;; ((banana and) (peanut butter and jelly))

(cons '(a b (c)) ()) ;; ((a b (c)))

(cons 'a (first '((b) c d))) ;; (a b)

(cons 'a (rest '((b) c d))) ;; (a c d)

(utils/null? '()) ;; true

(utils/null? 'a) ;; false

(= 'a 'a) ;; true
