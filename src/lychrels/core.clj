(ns lychrels.core
  (:require [clojure.contrib.str-utils2 :as su])
  (:gen-class))

(defn reverse-int
  "returns an integer with its digits reversed, e.g. 123 returns 321"
  [x]
  (BigInteger. (su/reverse (pr-str x))))

(defn palindromic?
  "returns true if the number is palindromic, e.g. 121, 1234321"
  [x]
  (= x (reverse-int x))
  )

(defn lychrel?
  "returns true if the number recursively added to its reverse is not
   a palindrome after 50 iterations"
  ([x] (lychrel? x 50))
  ([x iterations]
     (let [reverse-sum (+ x (reverse-int x))]
       (cond (< iterations 1) true
             (palindromic? reverse-sum) false
             :default (lychrel? reverse-sum (dec iterations)))))
  )

(defn count-lychrels-to-10000
  "Counts the number of lychrels below 10000"
  []
  (count (filter lychrel? (range 1 10000)))
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -main
  []
  (time (println (count-lychrels-to-10000))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
