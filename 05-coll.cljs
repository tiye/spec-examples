
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::number number?)

(s/def ::example (s/coll-of ::number))

(let [data [1]]
  (if (s/valid? ::example data)
    (println (s/conform ::example data))
    (println (expound ::example data))))
