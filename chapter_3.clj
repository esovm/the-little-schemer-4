(ns the-little-schemer.chapter-3
  (:require [the-little-schemer.utils :as utils]))


(utils/rember 'mint '(lamb chops and mint jelly)) ;; (lamb chops and jelly)

(utils/rember 'mint '(lamb chops and mint flavored mint jelly))
;; (lamb chops and flavored mint jelly)

(utils/firsts '(((1 6 7)) (2) (3 4 5))) ;; ((1 6 7) 2 3)

(utils/insertR 'jalapenho 'and '(tacos tamales and salsa))
;; (tacos tamales and jalapenho salsa)

(utils/insertL 'jalapenho 'and '(tacos tamales and salsa))
;; (tacos tamales jalapenho and salsa)


(utils/subst 'jalapenho 'salsa '(tacos tamales and salsa))
;; (tacos tamales and jalapenho)
(utils/subst 'tacos 'tamales '(tamales tamales and salsa))
;; (tacos tamales and salsa)

(utils/subst2 'vanilla 'chocolate 'banana
              '(banana ice cream with chocolate topping))
;; (vanilla ice cream with chocolate topping)

(utils/multirember 'cup '(coffee cup tea cup and hick cup))
;; (coffee tea and hick)

(utils/multiinsertR 'creamed 'and '(chocolate and vanilla and strawberries))
;; (chocolate and creamed vanilla and creamed strawberries)

(utils/multiinsertL 'cream 'and '(chocolate and vanilla and strawberries))
;; (chocolate cream and vanilla cream and strawberries)


(utils/multisubst 'y 'and '(tacos and tamales and salsa))
;; (tacos y tamales y salsa)
