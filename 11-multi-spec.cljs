
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [expound.alpha :refer [expound]]))

(s/def ::type #{:local :stranger})

(s/def ::name string?)

(s/def ::address string?)

(defmulti person :type)

(defmethod person :local [_]
 (s/keys :req-un [::type ::name ::address]))

(defmethod person :stranger [_]
 (s/keys :req-un [::type ::name]))

(s/def ::example (s/multi-spec person :type))

(let [data {:type :local :name "chen" :address "Shanghai"}]
  (if (s/valid? ::example data)
    (println (s/conform ::example data))
    (println (expound ::example data))))

(let [data {:type :stranger :name "chen"}]
  (if (s/valid? ::example data)
    (println (s/conform ::example data))
    (println (expound ::example data))))
