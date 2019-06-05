
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::example boolean?)
(println (s/valid? ::example 1)) ; false
(println (s/valid? ::example true)) ; true
