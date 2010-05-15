(ns lychrels.core-test
  (:use [lychrels.core] :reload-all)
  (:use [clojure.test]))

(deftest test-reverse-int
  (testing "integers are reversed correctly"
    (is (= 123 (reverse-int 321)))
    (is (= 123456789 (reverse-int 987654321)))))

(deftest test-palindromic
  (testing "palindromic numbers return true"
    (is (palindromic? 2))
    (is (palindromic? 11))
    (is (palindromic? 343)))
  (testing "non-palindromic numbers return false"
    (is (not (palindromic? 342)))
    (is (not (palindromic? 34)))))

(deftest test-lychrel-with-1-iter
  (testing "1 is not lychrel (1+1=1, palindromic)"
    (is (not (lychrel? 1 1))))
  (testing "5 is lychrel (5+5=10, not palindromic)"
    (is (lychrel? 5 1))))

(deftest test-lychrel-with-2-iters
  (testing "5 is not lychral (5+5=10, 10+01=11, palindromic)"
    (is (not (lychrel? 5 2))))
  (testing "196 is believed to be lychral, so must be for 2 iters"
    (is (lychrel? 196 2))))

(deftest test-lychrel-with-50-iters
  (testing "196 is believed to be lychral, so must be for 50 iters"
    (is (lychrel? 196 50))))
