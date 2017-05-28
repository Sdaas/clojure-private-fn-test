(ns demo.core
  (:gen-class))


(defn- private-add
  "A private function that provides the implementation"
  [x y]
  (+ x y))

(defn add
  "The public function"
  [x y]
  (private-add x y))

