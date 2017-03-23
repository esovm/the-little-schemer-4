(ns the-little-schemer.chapter-5
  (:require [the-little-schemer.utils :as utils]))

(utils/rember* 'cup '(((tea) cup))) ;;(((tea)))

(utils/rember* 'cup '((coffee) cup ((tea) cup) (and (hick)) cup))
;; ((coffee) ((tea)) (and (hick)))

(utils/insertR* 'roast 'chuck '((how much (wood))
                                could
                                ((a (wood) chuck))
                                (((chuck)))
                                (if (a) ((wood chuck)))
                                (could chuck wood)))
;; ((how much (wood))
;; could
;; ((a (wood) chuck roast))
;; (((chuck roast)))
;; (if (a) ((wood chuck roast)))
;; (could chuck roast wood))

(utils/occur* 'banana '((banana)
                        (split ((((banana ice)))
                                (cream (banana))
                                sherbet))
                        (banana)
                        (bread)
                        (banana brandy))) ;; 5

(utils/subst* 'orange 'banana '((banana)
                                (split ((((banana ice)))
                                        (cream (banana))
                                        sherbet))
                                (banana)
                                (bread)
                                (banana brandy)))
;; ((orange)
;;  (split ((((orange ice)))
;;          (cream (orange))
;;          sherbet))
;;  (orange)
;;  (bread)
;;  (orange brandy))


(utils/insertL* 'pecker 'chuck '((how much (wood))
                                could
                                ((a (wood) chuck))
                                (((chuck)))
                                (if (a) ((wood chuck)))
                                (could chuck wood)))
;; ((how much (wood))
;; could
;; ((a (wood) percker chuck))
;; (((pecker chuck)))
;; (if (a) ((wood pecker chuck)))
;; (could pecker chuck wood))

(utils/member* 'chips '((potato) (chips) ((with) fish) (chips))) ;; true
(utils/member* 'lemon '((potato) (chips) ((with) fish) (chips))) ;; false

(utils/leftmost* '((potato) (chips) ((with) fish) (chips))) ;; potato
(utils/leftmost* '(((hot) (tuna (and))) cheese)) ;; hot
(utils/leftmost* '(((() four)) 17 (seventeen))) ;; nil

(utils/eqlist* '((meh)) '()) ;;false
(utils/eqlist* '(beef ((sausage)) (and (soda)))
               '(beef ((sausage)) (and (soda)))) ;; true
(utils/eqlist* '(beef ((wurstel)) (and (soda)))
               '(beef ((sausage)) (and (soda)))) ;; false


