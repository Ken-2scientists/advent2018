(ns advent2018.lib.utils
  (:require [clojure.java.io :as io]))

(defn puzzle-input
  [filename]
  (->> filename
       io/resource
       io/reader
       line-seq))

(defn fmap
  "Applies the function f to the values of the map m"
  [f m]
  (zipmap (keys m) (map f (vals m))))

(defn max-val
  "Returns the key in a map m for which the value is the greatest.
   If there are multiple such keys, the first is returned"
  [m]
  (key (apply max-key val m)))