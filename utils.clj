(ns the-little-schemer.utils)

(def atom?
  "returns true if `a` is an atom"
  (fn [a]
    (not (seq? a))))

(def null?
  "returns true if `a` is nil of the empty list"
  (fn [a]
    (or
     (nil? a)
     (= () a))))

(def lat?
  "return true if `l` is a list of atoms"
  (fn [l]
    (cond
      (null? l) true
      (and (seq? l) (atom? (first l)))
      (lat? (rest l))
      true false)))

(def member?
  "returns true if `a` is in list `lat`"
  (fn [a lat]
    (cond
      (null? lat) false
      true (or (= (first lat) a) (member? a (rest lat))))))

(def rember
  "removes the first occurrence of `a` from `lat`"
  (fn [a lat]
    (cond
      (null? lat) '()
      (= (first lat) a) (rest lat)
      true (cons (first lat) (rember a (rest lat))))))

(def firsts
  "returns the first S-expression of each sub-list in `l`"
  (fn [l]
    (cond
      (null? l) '()
      true (cons (first (first l)) (firsts (rest l))))))

(def insertR
  "inserts `nu` on the right side of the first occurrence of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons old (cons nu (rest lat)))
      true (cons (first lat) (insertR nu old (rest lat))))))

(def insertL
  "inserts `nu` on the left side of the first occurrence of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons nu (cons old (rest lat)))
      true (cons (first lat) (insertL nu old (rest lat))))))

(def subst
  "substitutes `nu` in place of the first occurrence of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons nu (rest lat))
      true (cons (first lat) (subst nu old (rest lat))))))

(def subst2
  "substitutes `nu` in place of the first occurrence of `o1`or of `o2` in `lat`"
  (fn [nu o1 o2 lat]
    (cond
      (null? lat) '()
      (or (= o1 (first lat))
          (= o2 (first lat))) (cons nu (rest lat))
      (= o2 (first lat)) (cons nu (rest lat))
      true (cons (first lat) (subst nu o1 o2 (rest lat))))))

(def multirember
  "removes all occurrences of `a` from `lat`"
  (fn [a lat]
    (cond
      (null? lat) '()
      (= (first lat) a) (multirember a (rest lat))
      true (cons (first lat) (multirember a (rest lat))))))

(def multiinsertR
  "inserts `nu` on the right side of all occurrences of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons old (cons nu (multiinsertR nu old (rest lat))))
      true (cons (first lat) (multiinsertR nu old (rest lat))))))

(def multiinsertL
  "inserts `nu` on the left side of all occurrences of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons nu (cons old (multiinsertL nu old (rest lat))))
      true (cons (first lat) (multiinsertL nu old (rest lat))))))

(def multisubst
  "substitutes `nu` in place of the first occurrence of `old` in `lat`"
  (fn [nu old lat]
    (cond
      (null? lat) '()
      (= old (first lat)) (cons nu (multisubst nu old (rest lat)))
      true (cons (first lat) (multisubst nu old (rest lat))))))

;; dirty tricks just because I don't have "sum1" and "sub1" as in the book
(def sum +)
(def sub -)
(def sum1 #(sum % 1))
(def sub1 #(sub % 1))

(def +
  "adds to numbers"
  (fn [a b]
    (cond
      (zero? a) b
      true (+ (sub1 a) (sum1 b)))))

(def -
  "subtracts two numbers"
  (fn [a b]
    (cond
      (zero? a) b
      (zero? b) a
      true (- (sub1 a) (sub1 b)))))

(def addtup
  "adds all numbers in the tuple"
  (fn [tup]
    (cond
      (null? tup) 0
      true (+ (first tup) (addtup (rest tup))))))

(def x
  "multiplies two numbers"
  (fn [a b]
    (cond
      (zero? a) 0
      true (+ b (x (- a 1) b)))))

(def tup+
  "sums each nth number of tuple `a` and `b`
  returning a new tuple of the sums"
  (fn [a b]
    (cond
      (and (null? a) (null? b)) ()
      true (cons (+ (first a) (first b)) (tup+ (rest a) (rest b))))))

(def >
  "returns true if `a` is greater than `b`"
  (fn [a b]
    (cond
      (zero? b) true
      (zero? a) false
      true (> (- a 1) (- b 1)))))

(def <
  "returns true if `a` is less than `b`"
  (fn [a b]
    (cond
      (zero? b) false
      (zero? a) true
      true (< (- a 1) (- b 1)))))

(def pow
  "returns pow `a^b`"
  (fn [a b]
    (cond
      (zero? b) 1
      true (* a (pow a (- b 1))))))

(def length
  "returns the length of a lat"
  (fn [lat]
    (cond
      (null? lat) 0
      true (+ 1 (length (rest lat))))))

(def pick
  "returns the `n`th item in `lat`"
  (fn [n lat]
    (cond
      (zero? (- n 1)) (first lat)
      true (pick (- n 1) (rest lat)))))

(def rempick
  "removes the `n`th item from `lat`"
  (fn [n lat]
    (cond
      (= n 1) (rest lat)
      true (cons (first lat) (rempick (- n 1) (rest lat))))))

(def no-nums
  "removes all numbers from `lat`"
  (fn [lat]
    (cond
      (null? lat) ()
      (number? (first lat)) (no-nums (rest lat))
      true (cons (first lat) (no-nums (rest lat))))))

(def all-nums
  "returns a tuple with all numbers from `lat`"
  (fn [lat]
    (cond
      (null? lat) ()
      (not (number? (first lat))) (all-nums (rest lat))
      true (cons (first lat) (all-nums (rest lat))))))

(def occur
  "returns the number of occurrences of `a` in `lat`"
  (fn [a lat]
    (cond
      (null? lat) 0
      (= a (first lat)) (+ 1 (occur a (rest lat)))
      true (+ 0 (occur a (rest lat))))))

(def one?
  "returns true if `a` is 1"
  (fn [a]
    (= a 1))) 

