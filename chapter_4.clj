(ns the-little-schemer.chapter-4
  (:require [the-little-schemer.utils :as utils]))

(utils/+ 41 1) ;; 42

(utils/- 43 1) ;; 42

(utils/addtup '(1 2 3 36)) ;; 42

(utils/x 6 7) ;; 42

(utils/tup+ '(0 1 2 3) '(4 3 2 1)) ;; (4 4 4 4)

(utils/> 42 41) ;; true

(utils/< 41 42) ;; true

(utils/pow 2 3) ;; 8

(utils/length '(1 2 3 4 5 6)) ;; 6

(utils/pick 2 '(1 42 2)) ;; 42

(utils/rempick 3 '(hotdogs with hot mustard)) ;; (hotdogs with mustard)

(utils/no-nums '(hello 1 dear 2 Alberto 3)) ;; (hello dear Alberto)

(utils/all-nums '(hello 1 dear 2 Alberto 3)) ;; (1 2 3)

(utils/occur 'bacon '(I like bacon with eggs bacon is love))

(utils/one? 1) ;; true
(utils/one? 42) ;; false
