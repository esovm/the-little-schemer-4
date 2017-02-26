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
      true (or (= (first lat) a)
                (member? a (rest lat))))))
