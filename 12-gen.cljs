
(ns example.core
 (:require [cljs.spec.alpha :as s]
           [clojure.test.check.generators]
           [clojure.spec.gen.alpha :as gen]
           [expound.alpha :refer [expound]]))

(s/def ::age number?)

(s/def ::name string?)

(s/def ::example (s/keys :req-un [::age] :opt-un [::name]))

(println (pr-str (gen/generate (s/gen ::example))))

(println)

(println (pr-str (gen/sample (s/gen ::example) 2)))

(println)

(println (pr-str (s/exercise ::example)))
