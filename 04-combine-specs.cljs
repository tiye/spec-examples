
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::boolean boolean?)

(s/def ::number number?)

(s/def ::example (s/or :as-number ::number :as-boolean ::boolean))

(if (s/valid? ::example 20)
  (println (s/conform ::example 20))
  (println (expound ::example 20)))