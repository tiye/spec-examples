
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::left-paren #{"("})

(s/def ::right-paren #{")"})

(s/def ::space (s/and string? (s/conformer seq) (s/+ #{" "})))

(s/def ::token (s/and string? (s/conformer seq) (s/+ #{"a" "b" "c"})))

(s/def
 ::example
 (s/cat
  :left-paren
  ::left-paren
  :expr
  (s/+ (s/or :token ::token :space ::space))
  :right-paren
  ::right-paren))

(let [data (seq "(a b)")]
  (if (s/valid? ::example data)
    (println (pr-str (s/conform ::example data)))
    (println (s/explain ::example data))))
