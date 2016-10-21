(ns anagrams.core-test
  (:require [clojure.test :refer :all]
            [anagrams.core :refer :all]))

(defn anagrams-test
  "Builds a test scenario for a group of anagrams words usage. It will run
  one by one and test the expected outcome."
  [desc coll]
  (testing desc
    (reduce (fn [context [word expected]]
              (let [result (anagrams context word)]
                (is (= expected (:matches result)) (str "Expected with word '" word "' to match " expected " but got " (:matches result)))
                result))
            {}
            coll)))

(deftest anagrams-spec
  (anagrams-test "first run"
                 [["open" []]])

  (anagrams-test "finding nope"
                 [["open" []]
                  ["nope" ["open"]]])

  (anagrams-test "not returning duplicates"
                 [["open" []]
                  ["open" ["open"]]
                  ["open" ["open"]]
                  ["nope" ["open"]]])

  (anagrams-test "finding words with zero length"
                 [["" []]
                  ["" []]])

  (anagrams-test "finding words with one char"
                 [["a" []]
                  ["a" ["a"]]])

  (anagrams-test "not returning words with different length"
                 [["a" []]
                  ["aa" []]
                  ["a" ["a"]]])

  (anagrams-test "different character cases"
                 [["open" []]
                  ["Nope" ["open"]]]))

