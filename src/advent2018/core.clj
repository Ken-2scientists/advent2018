(ns advent2018.core
    (:require [advent2018.day03 :as day03]
              [advent2018.day03-input :as day03-input]))

(defn soln03
  []
  (let [swaths (map day03/parse-input-line day03-input/patch-ids)]
       (day03/soln03a swaths)))
