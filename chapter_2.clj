(ns the-little-schemer.chapter-2
  (:require [the-little-schemer.utils :as utils]))

(utils/lat? '(Jack Sprat could eat no chicken fat)) ;; true, every sexp is an atom

(utils/lat? '((Jack) Sprat could eat no chicken fat)) ;; false, one sexp is a list

(utils/lat? '()) ;; true

;; lat -> *l*ist of *at*oms


(utils/member? 'poached '(fried eggs and scrambled eggs)) ;; false

(utils/member? '(a) '((a) b c)) ;; true




