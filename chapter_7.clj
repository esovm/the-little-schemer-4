(ns the-little-schemer.chapter-7
  (:require [the-little-schemer.utils :as utils]))

(utils/set? '(apple peaches apple plum)) ;; false
(utils/set? ()) ;; true
(utils/set? '(apple peaches pears plum)) ;; true

(utils/makeset '(apple peaches apple plum)) ;; false

(utils/subset? '(5 chicken wings) '(5 hambugers
                                      2 pieces friend chicken and
                                      light duckling wings)) ;; true

(utils/eqset? '(5 chicken wings) '(5 chicken wings)) ;; true

(utils/intersect? '(5 chicken wings) '(redbull gives you wings))

(utils/intersect '(5 chicken wings) '(redbull gives you wings))

(utils/union '(stewed tomatoes and macaroni casserole)
             '(macaroni and cheese))

(utils/a-pair? '(1 2)) ;; true
(utils/a-pair? '((1) 2)) ;; true
(utils/a-pair? '(1 (2))) ;; true
(utils/a-pair? '((1) ((2)))) ;; true

(utils/fun? '((a 1) (1 2) (c 3))) ;; true

(utils/revrel '((a 1) (1 2) (c 3))) ;; ((1 a) (2 1) (3 c))

(utils/revpair '(a 1)) ;; (1 a)

(utils/seconds '((1 everything) (2 is) (3 fine))) ;; (everything is fine)

(utils/one-to-one? '((chocolate chip) (doughy cookie))) ;; true
(utils/one-to-one? '((chocolate chip) (doughy chip))) ;; false
(utils/one-to-one? '((chocolate chip) (chocolate cookie))) ;; true

