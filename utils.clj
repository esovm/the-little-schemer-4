(ns the-little-schemer.utils)

(def atom?
  (fn [a]
    (not (seq? a))))

(def null?
  (fn [a]
    (or
     (nil? a)
     (= () a))))

(def lat?
  (fn [l]
    (cond
      (null? l) true
      (and (seq? l) (atom? (first l)))
      (lat? (rest l))
      true false)))

(def member?
  (fn [a lat]
    (cond
      (null? lat) false
      true (or (= (first lat) a) (member? a (rest lat))))))

(def rember
  (fn [a lat]
    (cond
      (null? lat) '()
      (= (first lat) a) (rest lat)
      true (cons (first lat) (rember a (rest lat))))))

(def firsts
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
  (fn [nu o1 o2 lat]
    (cond
      (null? lat) '()
      (or (= o1 (first lat))
          (= o2 (first lat))) (cons nu (rest lat))
      (= o2 (first lat)) (cons nu (rest lat))
      true (cons (first lat) (subst nu o1 o2 (rest lat))))))

(def multirember
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

;; TODO add documentation to functions
