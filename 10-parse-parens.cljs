
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [clojure.string :as string]
           [expound.alpha :refer [expound]]))

(s/def ::left-paren #(= % "("))

(s/def ::right-paren #(= % ")"))

(s/def ::space (fn [x] (and (string? x) (pos? (count x)) (string/blank? x))))

(s/def ::token (fn [x] (contains? #{"a" "b" "c"} x)))

(s/def
 ::example
 (s/cat
  :left-paren ::left-paren
  :expr (s/+ (s/alt :token ::token :space ::space :child ::example))
  :right-paren ::right-paren))

(let [data (seq "(aa b (a (b)))")]
  (if (s/valid? ::example data)
    (println (pr-str (s/conform ::example data)))
    (println (s/explain ::example data))))
