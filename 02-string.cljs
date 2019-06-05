
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::example string?)
(println (s/explain ::example 1))

(s/def ::example string?)
(println (expound ::example 1))
