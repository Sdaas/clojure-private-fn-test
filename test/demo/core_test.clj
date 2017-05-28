(ns demo.core-test
  (:require [clojure.test :refer :all]
            [demo.core :refer :all]))

(deftest testing-a-public-function
  (testing "test add function"
    (is (= 30 (add 10 20)))))

; The following code will lead to a compile error
;
;(deftest this-way-of-testing-private-function-with-not-work
;  (testing "test private-add function"
;    (is (= 10 (private-add 10 20)))))

; However, we can access this private function as shown in
; http://christophermaier.name/2011/04/30/not-so-private-clojure-functions/
(deftest one-way-to-test-private-functions
  (testing "test the private add function"
    (is (= 30 (#'demo.core/private-add 10 20)))))


; We can make the code a bit more readable by wrapping all private function
; tests in a macro, as shown in https://nakkaya.com/2009/11/18/unit-testing-in-clojure/

; For that, we first define the macro
(defmacro with-private-fns [[ns fns] & tests]
  "Refers private fns from ns and runs tests in context."
  `(let ~(reduce #(conj %1 %2 `(ns-resolve '~ns '~%2)) [] fns)
     ~@tests))

; And use it as follows ...
(with-private-fns [demo.core [private-add]]
                  (deftest testing-a-private-function
                    (testing "test the private add function"
                      (is (= 30 (private-add 10 20)))))
                  )