(ns the-little-schemer.chapter-6
  (:require [the-little-schemer.utils :as utils]))

(utils/numbered? '(41 + 1)) ;; true

(utils/first-sub-exp '((* 2 41) + 1)) ;; +

(utils/second-sub-exp '((* 2 41) + 1)) ;; 1



