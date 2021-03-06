(defproject anagrams "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :aliases {"stress"  ["run" "-m" "anagrams.stress/biggg-test"]
            "find-anagrams" ["run" "-m" "anagrams.stress/find-anagrams"]
            "criterium" ["run" "-m" "anagrams.stress/criterium"]}
  :plugins [[com.jakemccrary/lein-test-refresh "0.17.0"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [criterium "0.4.4"]])
