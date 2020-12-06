(ns advent2018.day03
  (:require [clojure.string :as string]))

(defn parse-input-line
  [line]
  (let [vars (->> (string/split line #"[@\,\:x]")
                  (map string/trim))
        [id x y w h] vars]
    {:id id
     :x (read-string x)
     :y (read-string y)
     :w (read-string w)
     :h (read-string h)}))

(defn grid
  [w h]
  (for [x (range w)
        y (range h)]
       [x y]))

(defn initialize-map
  []
  (zipmap (grid 1000 1000) 0))

(defn swath-grid
  [{:keys [x y w h]}]
  (for [i (range x (+ x w))
        j (range y (+ y h))]
       [i j]))

(defn swath-grid-with-ids
  [{:keys [id x y w h]}]
  (into {} 
        (for [i (range x (+ x w))
              j (range y (+ y h))]
          [[i j] [id]])))

(defn soln03a
  [swaths]
  (->> swaths
       (mapcat swath-grid)
       frequencies
       (filter #(> (val %) 1))
       count))

(defn overlapping-swath-ids
  [swaths]
  (->> swaths
       (map swath-grid-with-ids)
       (apply merge-with into)
       vals
       (filter #(> (count %) 1))
       flatten
       (into #{})))

(defn all-swath-ids
  [swaths]
  (into #{} (map :id swaths)))

(defn soln03b
  [swaths]
  (let [all-ids (all-swath-ids swaths)
        overlap-ids (overlapping-swath-ids swaths)]
       (first (clojure.set/difference all-ids overlap-ids))))


