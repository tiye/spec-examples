
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::example (s/or :as-number number? :as-boolean boolean?))

(s/def ::number number?)

(let [data 0]
  (if (s/valid? ::example data)
    (println (s/conform ::example data))
    (println (expound ::example data))))
