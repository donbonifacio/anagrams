(ns anagrams.core)

(defn anagrams [context word]
  (if (empty? word)
    {:store (:store context) :matches []}
    (let [word-index (clojure.string/join "" (sort (clojure.string/lower-case word)))
          current-values (get-in context [:store word-index])
          new-values (distinct (conj current-values word))]
      (-> context
          (assoc-in [:store word-index] new-values)
          (assoc :matches (cond
                            (zero? (count current-values))
                              []
                            (= 1 (count new-values))
                              new-values
                            :else
                            (remove #(= % word) new-values)))))))
