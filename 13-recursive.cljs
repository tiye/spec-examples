
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::leaf string?)

(s/def ::example (s/coll-of (s/or :leaf ::leaf :expr ::example)))

(let [data [["def" "f" ["a" "b"] ["+" "a" "b"]]]]
  (if (s/valid? ::example data)
    (println (pr-str (s/conform ::example data)))
    (println (s/explain ::example data))))
