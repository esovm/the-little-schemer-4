(define atom?
  (lambda (x)
    (and (not (pair? x)) (not (null? x)))))

(defun atom? (x)
  (not (listp x)))

;; ==============================================================================

(atom? ()) ;; #f

(atom? "atom") ;; #t

(list? ()) ;; #t

;; xyz 
;; (x y z)
;; are both S-expressions, as atoms are and lists are too

;; (((how) are) ((you) (doing so)) far)
;; has 3 S-expressions
;; ((how) are), ((you) (doing so)), far

(car '(a b c)) ;; a

(car '((a b c) x y z)) ;; (a b c) because it's the first S-expression

(car '(((hotdogs)) (and) (pickle) relish)) ;; ((hotdogs))

(car (car '(((hotdogs)) (and)))) ;; (hotdogs)

(cdr '(a b c)) ;; # (b c)

(cdr '(hambuger)) ;; ()

;; no car or cdr for atoms, only for non-empty lists

(car (cdr '((b) (x y) ((c))))) ;; (x y)

(cdr (cdr '((b) (x y) ((c)))))
     (cdr '((x y) ((c))))
          '(((c)))

(cons 'peanut '(butter and jelly)) ;; (peanut butter and jelly)

(cons '(banana and) '(peanut butter and jelly))
;; ((banana and) peanut butter and jelly)

(cons '(a b (c)) ()) ;; ((a b (c)))

(cons 'a (car '((b) c d))) ;; (a b)

(cons 'a (cdr '((b) c d))) ;; (a c d)

(null? '()) ;; #t

(null? 'a) ;; #f

(eq? 'a 'a) ;; #t



















