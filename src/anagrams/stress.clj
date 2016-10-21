(ns anagrams.stress
  (:require [clojure.test :refer :all]
            [anagrams.core :refer :all]
            [criterium.core :refer [quick-bench bench]]))

(defn get-words [args]
  (clojure.string/split (slurp "/usr/share/dict/words") #"\n"))

(defn biggg-test [& args]
  (let [words (get-words args)]
    (println "Loading" (count words) "words...")
    (time (reduce anagrams {} words))))

(defn criterium [& args]
  (let [words (get-words args)]
    (println "Testing" (count words) "words...")
    (quick-bench (reduce anagrams {} words))))
